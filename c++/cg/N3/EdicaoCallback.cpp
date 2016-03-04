#include "EdicaoCallback.hpp"

#include "Cor.hpp"
#include "Mundo.hpp"

const double TRANSLACAO = 2.0;
const double ESCALA = 1.1;
const double ROTACAO = 0.1;

EdicaoCallback::EdicaoCallback(Mundo& mundo) : base(mundo), objetoCorrente(nullptr), pontoCorrente(nullptr) , transformacao('t') { }

void EdicaoCallback::keyboard(unsigned char key, const Ponto& point) {
	switch (key) {
	case 'c':
		if (objetoCorrente != nullptr) {
			objetoCorrente->setCor(Cor::random());
		}
		break;

	case 'd':
		if (pontoCorrente != nullptr) {
			objetoCorrente->removePonto(*pontoCorrente);
			pontoCorrente = nullptr;
		}
		break;

	case 't':
	case 'r':
	case 's':
		transformacao = key;
		break;

	case '\b':
		if (objetoCorrente != nullptr) {
			mundo.removerObjetoGrafico(*objetoCorrente);
			objetoCorrente = nullptr;
			pontoCorrente = nullptr;
		}
		break;

	case ' ':
		if (objetoCorrente != nullptr) {
			objetoCorrente->mudaPoligonoAbertoOuFechado();
		}
		break;

	case '\033': // esc
		if (objetoCorrente != nullptr) {
			pontoCorrente = nullptr;
			objetoCorrente->redesenhaBBox();
			objetoCorrente->deseleciona();
			objetoCorrente = nullptr;
		}
		break;

	default:
		base::keyboard(key, point);
		break;
	}
}

void EdicaoCallback::mouse(int button, int state, const Ponto& ponto) {
	if (state != GLUT_DOWN) {
		return;
	}

	if (button == GLUT_LEFT_BUTTON && pontoCorrente == nullptr) {
		if (objetoCorrente != nullptr) {
			objetoCorrente->seleciona();
		}

		objetoCorrente = mundo.objetoGraficoNoPonto(ponto);
		if (objetoCorrente != nullptr) {
			objetoCorrente->seleciona();
			pontoCorrente = objetoCorrente->pontoProximo(ponto);
		}
	} else if (button == GLUT_RIGHT_BUTTON) {
		if (pontoCorrente != nullptr) {
			objetoCorrente->redesenhaBBox();
			pontoCorrente = nullptr;
		}
	}
}

void EdicaoCallback::movimentoMouse(const Ponto& point) {
	if (pontoCorrente != nullptr) {
		*pontoCorrente = point;
	}
}

void EdicaoCallback::special(int key, const Ponto& point) {
	if (objetoCorrente == nullptr || pontoCorrente != nullptr) {
		return;
	}

	if (key == GLUT_KEY_HOME) {
		objetoCorrente->resetaTransformacao();
	}

	switch(transformacao) {
	case 't':
		translate(key);
		break;
	case 'r':
		rotate(key);
		break;
	case 's':
		scale(key);
		break;
	}
}

void EdicaoCallback::translate(int key) {
	switch(key) {
	case GLUT_KEY_UP:
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(Ponto(0, TRANSLACAO)));
		break;

	case GLUT_KEY_RIGHT:
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(Ponto(TRANSLACAO, 0)));
		break;

	case GLUT_KEY_DOWN:
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(Ponto(0, -TRANSLACAO)));
		break;

	case GLUT_KEY_LEFT:
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(Ponto(-TRANSLACAO, 0)));
		break;
	}
}

void EdicaoCallback::rotate(int key) {
	switch(key) {
	case GLUT_KEY_RIGHT:
	{
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico() ));
		objetoCorrente->aplicaTransformacao(Transformacao::zRotacao(-ROTACAO));
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(-objetoCorrente->centroObjetoGrafico() ));
	}
	break;

	case GLUT_KEY_LEFT:
	{
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico() ));
		objetoCorrente->aplicaTransformacao(Transformacao::zRotacao(ROTACAO));
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(-objetoCorrente->centroObjetoGrafico() ));
	}
	break;
	}
}

void EdicaoCallback::scale(int key) {
	switch(key) {
	case GLUT_KEY_UP:
	{
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico() ));
		objetoCorrente->aplicaTransformacao(Transformacao::escala(1, ESCALA, 1));
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico() ));
	}
	break;

	case GLUT_KEY_RIGHT:
	{
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico()));
		objetoCorrente->aplicaTransformacao(Transformacao::escala(ESCALA, 1, 1));
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(-objetoCorrente->centroObjetoGrafico()));
	}
	break;

	case GLUT_KEY_DOWN:
	{
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico()));
		objetoCorrente->aplicaTransformacao(Transformacao::escala(1, 1/ESCALA, 1));
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(-objetoCorrente->centroObjetoGrafico()));
	}
	break;

	case GLUT_KEY_LEFT:
	{
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(objetoCorrente->centroObjetoGrafico()));
		objetoCorrente->aplicaTransformacao(Transformacao::escala(1/ESCALA, 1, 1));
		objetoCorrente->aplicaTransformacao(Transformacao::translacao(-objetoCorrente->centroObjetoGrafico()));
	}
	break;
	}
}
