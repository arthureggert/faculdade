#include "Camada.hpp"

void Camada::adicionaEletron() {
	double anguloOrbita = ((M_PI * (eletrons.size() + 2))/eletronsNoAtomo) * (180/M_PI);

	Eletron eletron = Eletron(anguloOrbita);

	eletrons.push_back(eletron);
}

void Camada::desenha() {
	Eletron* eletron;
	for (auto it = eletrons.begin(); it != eletrons.end(); it++) {
		eletron = &(*it);
		desenhaOrbita(eletron->getAnguloOrbita());

		eletron->desenha();
	}
}

void Camada::moveEletrons() {
	Eletron* eletron;
	Transformacao matrizTranslacao;

	for (auto it = eletrons.begin(); it != eletrons.end(); it++) {
		eletron = &(*it);
		matrizTranslacao =
				transformacao.translacao(
						getPossicaoNaOrbita(eletron->getAnguloRotacao(),
											raio, eletron->getAnguloOrbita()));
		eletron->movimenta(matrizTranslacao);
	}
}

double Camada::paraRadianos(double angulo) {
	return (M_PI/180) * angulo;
}

/** Função kibada da internet :) **/
Ponto Camada::getPossicaoNaOrbita(double anguloRotacao, double raio, double anguloOrbita) {
	double x = (raio * cos(paraRadianos(anguloRotacao)) * cos(paraRadianos(anguloOrbita)));
	double y = (raio * sin(paraRadianos(anguloRotacao)) * cos(paraRadianos(anguloOrbita)));
	double z = (raio * sin(paraRadianos(anguloRotacao)));
	return Ponto(x,y,z);
}

void Camada::desenhaOrbita(double anguloOrbita) {
	GLfloat WHITE [] = {1.0, 0.0, 1.0};

	glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, WHITE);
	glPointSize(1);
	for(int i = 0; i < 360; i+=5) {
		glBegin(GL_POINTS);
		Ponto possicaoNaOrbita = getPossicaoNaOrbita(i, raio, anguloOrbita);
		glVertex3d(possicaoNaOrbita.x, possicaoNaOrbita.y, possicaoNaOrbita.z);
		glEnd();
	}
}
