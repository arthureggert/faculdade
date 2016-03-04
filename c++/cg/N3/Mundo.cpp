#include "Mundo.hpp"
#include "Utils.hpp"

#include <vector>

#include <GL/gl.h>
#include <GL/glut.h>

#include <algorithm>

Mundo::Mundo() {
	rascunho = nullptr;
	camera = obtemCamera();
	eixosReferencia = eixosReferenciaAsObjetoGrafico();
}

void Mundo::render() const {

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(camera.minX, camera.maxX, camera.minY, camera.maxY);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	eixosReferencia.renderizar();

	for(auto it = begin(objetosGraficos); it != end(objetosGraficos); ++it) {
		it->renderizar();
	}

	if(rascunho != nullptr) {
		rascunho->renderizar();
	}

	glutSwapBuffers();
}

double Mundo::altura() const {
	return camera.altura();
}

double Mundo::largura() const {
	return camera.largura();
}

Camera Mundo::getCamera() {
	return camera;
}

Ponto Mundo::normalizar(int xx, int yy) {
	double x = camera.minX + (xx / static_cast<double>(camera.canvasW)) * camera.largura();
	double y = camera.minY + (yy / static_cast<double>(camera.canvasH)) * camera.altura();

	return Ponto(x, -y);
}

ObjetoGrafico* Mundo::criaObjetoGrafico() {
	rascunho = new ObjetoGrafico();
	return rascunho;
}

void Mundo::adicionaObjetoGrafico() {
	ObjetoGrafico* pai = nullptr;
	for(auto it = begin(objetosGraficos); it != end(objetosGraficos); ++it) {
		ObjetoGrafico* obj = it->objetoSelecionado();

		if (obj != nullptr) {
			pai = obj;
			break;
		}
	}

	if (pai != nullptr) {
		pai->adicionaObjetoFilho(*rascunho);
	} else {
		objetosGraficos.push_back(*rascunho);
	}

	delete rascunho;
	rascunho = nullptr;
}

ObjetoGrafico* Mundo::objetoGraficoNoPonto(const Ponto& ponto) {
	for(auto it = begin(objetosGraficos); it != end(objetosGraficos); ++it) {
		ObjetoGrafico* obj = it->contem(ponto);
		if (obj != nullptr) {
			return obj;
		}
	}
	return nullptr;
}

void Mundo::removerObjetoGrafico(const ObjetoGrafico& objeto) {
	for(auto it = begin(objetosGraficos); it != end(objetosGraficos); ++it) {
		it->removeFilho(objeto);
	}

	objetosGraficos.erase( remove(begin(objetosGraficos), end(objetosGraficos), objeto), end(objetosGraficos));
}
