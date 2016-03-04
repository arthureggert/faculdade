#include "AdicaoCallback.hpp"

#include "Mundo.hpp"
#include "Cor.hpp"

#include <GL/gl.h>
#include <GL/glut.h>
#include <iostream>

using namespace std;

AdicaoCallback::AdicaoCallback(Mundo& mundo) :base(mundo) , objetoCorrente(nullptr) { }

void AdicaoCallback::keyboard(unsigned char key, const Ponto& point) {
	switch (key) {
	case 'c':
	if (objetoCorrente != nullptr) {
		objetoCorrente->setCor(Cor::random());
	}
	break;

	case ' ':
		if (objetoCorrente != nullptr) {
			objetoCorrente -> mudaPoligonoAbertoOuFechado();
		}
		break;

	default:
		base::keyboard(key, point);
		break;
	}
}

void AdicaoCallback::mouse(int button, int state, const Ponto& point) {
	if (state != GLUT_DOWN) {
		return;
	}

	if (button == GLUT_LEFT_BUTTON) {
		if (objetoCorrente == nullptr) {
			objetoCorrente = mundo.criaObjetoGrafico();
		}

		objetoCorrente->adicionaPonto(point);
	} else if (button == GLUT_RIGHT_BUTTON) {

		if (objetoCorrente != nullptr) {
			objetoCorrente->removePontoFalso();
			mundo.adicionaObjetoGrafico();
			objetoCorrente = nullptr;
		}
	}
}

void AdicaoCallback::movimentoMouse(const Ponto& point) {
	if (objetoCorrente != nullptr) {
		objetoCorrente->adicionaPontoFalso(point);
	}
}

void AdicaoCallback::special(int key, const Ponto& point) {
	cout << key << point.x << endl;
}

