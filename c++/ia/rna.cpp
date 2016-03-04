#include "NNFpp.h"
#include <iostream>
#include <opencv/cv.h>
#include <opencv/highgui.h>
#include <fstream>

int mh = 50;
int mw = 50;

bool sortPontos(CvPoint p1, CvPoint p2) {

    return (sqrt(pow(p1.x, 2) + pow(p1.y, 2))
            < sqrt(pow(p2.x, 2) + pow(p2.y, 2)));

}

CvPoint getInterpolado(CvPoint A, CvPoint B) {
    CvPoint ret;
    ret.x = A.x + (B.x - A.x) * 0.5;
    ret.y = A.y + (B.y - A.y) * 0.5;
    return ret;
}

IplImage *preImg(std::string caminho) {

    int quadratico = 200;
    CvSize tamanho = cvSize(quadratico, quadratico);

    IplImage *in = cvLoadImage(caminho.c_str(), CV_LOAD_IMAGE_GRAYSCALE);

    IplImage *src = cvCreateImage(tamanho, in->depth, in->nChannels);
    IplImage *dst = cvCreateImage(tamanho, in->depth, in->nChannels);
    IplImage *fn = cvCreateImage(cvSize(mh, mw), in->depth, in->nChannels);

    cvResize(in, src);

    cvThreshold(src, src, 220, 255, CV_THRESH_BINARY);

    cvShowImage("tresh", src);

    cvCanny(src, src, 100, 120, 3);

    //cvShowImage("canny", src);

    cvMorphologyEx(src, src, 0, cvCreateStructuringElementEx(4, 4, 0, 0, CV_SHAPE_RECT), cv::MORPH_DILATE, 1);

    //cvShowImage("Dilatacao", src);

    std::vector<CvPoint> pontos;

    for (int y = 0; y < src->height; y++) {
        for (int x = 0; x < src->width; x++) {

            if (cvGet2D(src, x, y).val[0] == 255) {

                //inversão dos eixos
                pontos.push_back(cvPoint(y, x));
            }

        }
    }

    std::sort(pontos.begin(), pontos.end(), sortPontos);

    CvPoint interpol = getInterpolado(pontos[0], pontos[pontos.size() - 1]);

//	CvScalar color = cvScalar(255, 255, 255);
//	int radius = 6;
//	int thickness = 2;
//
//	cvCircle(src, pontos[0], radius, color, thickness);
//
//	cvCircle(src, pontos[pontos.size() - 1], radius, color, thickness);

//cvCircle(src, interpol, radius, color, thickness);

//	std::cout << cvGetReal2D(src, pontos.begin()->x, pontos.begin()->y)
//			<< std::endl;

//	cvShowImage("teste", src);

//-----------------------------

    cvLogPolar(src, dst, cvPoint2D32f(interpol.x, interpol.y), 40,
               CV_INTER_LINEAR + CV_WARP_FILL_OUTLIERS);

    //cvNamedWindow("log-polar", 1);

    //cvShowImage("log-polar", dst);

    //cvShowImage("LogPolar",dst);

    cvResize(dst, fn);

    //cvShowImage("teste saida", fn);

    return fn;

}

float *pegaVetorImg(std::string caminho) {

    IplImage *fn = preImg(caminho);

    std::vector<int64> vetor;
    int count = 0;

    for (int h = 0; h < mh; ++h) {
        for (int w = 0; w < mw; ++w) {

            if (cvGetReal2D(fn, h, w) > 0) {

                vetor.push_back(w);
                break;
            }
        }
    }

    std::vector<int64> vetorSort(vetor);

    sort(vetorSort.begin(), vetorSort.end());

    float max = vetorSort[vetorSort.size() - 1];
    float min = vetorSort[0];
    float base = max - min;

    float *vetorSaida = new float[vetor.size()];

    int i = 0;
    for (std::vector<int64>::iterator it = vetor.begin(); it != vetor.end(); ++it) {

        float teste = 100 * (max - (*it)) / base;
        vetorSaida[i] = round(teste);

        i++;
    }

    return vetorSaida;
}

void geraVetores(std::string tipo, std::string caminho, std::string dst) {

    float *vetor = pegaVetorImg(caminho);

    FILE *out;

    out = fopen(dst.c_str(), "a");

    for (int var = 0; var < mw; ++var) {

        std::fprintf(out, "%f", vetor[var]);
        std::fputc((' '), out);
    }

    std::fputc('\n', out);
    std::fputs((tipo.c_str()), out);
    std::fputc('\n', out);
    std::fputc('\n', out);

    fclose(out);

}

void carregarImagens(std::string dst) {

    std::string ext = ".jpg";
    std::string tipo = "img/qd";

    FILE *out;

    out = fopen(dst.c_str(), "w");

    std::fputs("NNF - Neural Net Framework", out);
    std::fputc('\n', out);
    std::fputc('\n', out);

    std::fputs("__neural net training set file__", out);
    std::fputc('\n', out);
    std::fputc('\n', out);

    std::fputs("SET", out);
    std::fputc('\n', out);

    std::fputs("in: ", out);
    std::stringstream s;
    s << (mw);
    std::fputs(s.str().c_str(), out);
    std::fputc('\n', out);

    std::fputs("out: 2", out);
    std::fputc('\n', out);

    std::fputs("examples: 10", out);
    std::fputc('\n', out);
    std::fputc('\n', out);

    std::fclose(out);

    for (int var = 1; var < 6; ++var) {
        geraVetores("1 0", tipo + std::to_string(var) + ext, dst);

    }

    tipo = "img/el";

    for (int var = 1; var < 6; ++var) {
        geraVetores("0 1", tipo + std::to_string(var) + ext, dst);

    }

}

void testaRNA(NNFpp *net) {
    float *out;

    out = net->Execute(pegaVetorImg("img/qd1.jpg"));
    printf("\nqd1 -> 1 0: %f - %f ", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/qd2.jpg"));
    printf("\nqd2 -> 1 0: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/qd3.jpg"));
    printf("\nqd3 -> 1 0: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/qd4.jpg"));
    printf("\nqd4 -> 1 0: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/qd5.jpg"));
    printf("\nqd5 -> 1 0: %f - %f", out[0], out[1]);

    printf("\n--------------------");

    out = net->Execute(pegaVetorImg("img/el1.jpg"));
    printf("\nel1 -> 0 1: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/el2.jpg"));
    printf("\nel2 -> 0 1: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/el3.jpg"));
    printf("\nel3 -> 0 1: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/el4.jpg"));
    printf("\nel4 -> 0 1: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/el5.jpg"));
    printf("\nel5 -> 0 1: %f - %f", out[0], out[1]);

    printf("\n-------------------------");

    out = net->Execute(pegaVetorImg("img/tqd1.jpg"));
    printf("\ntqd1 -> 1 0: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/tel1.jpg"));
    printf("\ntel1 -> 0 1: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/tel2.jpg"));
    printf("\ntel2 -> 0 1: %f - %f", out[0], out[1]);

    printf("\n-------------------------");

    out = net->Execute(pegaVetorImg("img/telout1.png"));
    printf("\ntel_out1 -> 0 1: %f - %f", out[0], out[1]);

    out = net->Execute(pegaVetorImg("img/tqdout1.jpg"));
    printf("\ntqd_out1 -> 1 0 : %f - %f", out[0], out[1]);

    printf("\n-------------------------");

}

void saveRna(NNFpp net) {

    std::ofstream of("testegrv.rna", of.binary);

    of.binary;

    of.write((char *) &(net), sizeof(net));

    of.close();
}

void executaRna(std::string arqAprend) {

//	FILE* netIn;
//
//	netIn = fopen(arqAprend.c_str(), "r");
//	NNFpp *net = new NNFpp(netIn);
//
    NNFpp *net;
//	//net->LoadNet(netIn);

    std::ifstream ifs("testegrv.rna", ifs.binary);
    ifs.read((char *) &net, sizeof(net));

    testaRNA(net);

}

void treinaRna(std::string arqAprend) {

    int Neurons[3] = {mw, 300, 2};
    NNFpp *net;
    net = new NNFpp(3, Neurons, 1, NNF_SIGMA_LOGISTIC, 0.4);

    FILE *f;
    f = fopen(arqAprend.c_str(), "r");

    int Epoch = 0;
    float Acc = 0;
    int count = 0;
    do {
        net->Errors->CumulativeError = 0;
        net->Errors->CumulativeAccuracy = 0;

        net->TrainingSetFromFile(f);
        Epoch++;

        Acc = 100 * net->Errors->CumulativeAccuracy / 10;
        printf("Epocas: %d Erros: %f Precisao: %f%\n", Epoch,
               net->Errors->CumulativeError, Acc);
    } while ((net->Errors->CumulativeError > 0.01) && (Acc <= 98));

    //} while (count < 500);
    fclose(f);
    printf("\nAprendizado efetuado em %d epocas.\n", Epoch);
    printf("\nTestes: \n");

    testaRNA(net);

    saveRna(*net);

    FILE *save;

    save = fopen("rede_grv.rna", "w");

    net->SaveNet(save);

    delete net;

}

int main(void) {

    //carregarImagens("teste50x203.ts");

    //treinaRna("teste50x203.ts");

    //executaRna("rede_bala.rna");

    float *vetor = pegaVetorImg("el1.jpg");

    for (int var = 0; var < mw; ++var) {

        std::cout << vetor[var] << ' ';
    }
}
