#include "ObjetoGrafico.hpp"
#include "Utils.hpp"

#include <GL/gl.h>
#include <GL/glut.h>

#include <algorithm>

using namespace std;

const double SELECTION_DISTANCE = 5 * 5;

ObjetoGrafico::ObjetoGrafico() {
	selecionado = false;
	primitivaGrafica = GL_LINE_STRIP;
}

void ObjetoGrafico::renderizar() const {
	glPushMatrix();
	glMultMatrixd(transformacao.getData());

	if (selecionado) {
		ObjetoGrafico bboxObjetoGrafico = bboxToObjeto(bbox);
		bboxObjetoGrafico.renderizar();
	}

	glColor3fv(cor.getData());
	glLineWidth(1);
	glBegin(primitivaGrafica);
		for(auto it = begin(pontos) ; it != end(pontos) ; ++it) {
			glVertex3d(it->x, it->y, it->z);
		}
	glEnd();

	for(auto it = begin(filhos); it != end(filhos) ; ++it) {
		it->renderizar();
	}

	glPopMatrix();
}

void ObjetoGrafico::adicionaPonto(const Ponto& ponto) {
	pontos.push_back(ponto);

	if (pontos.size() == 1) {
		pontos.push_back(ponto);
	}

	redesenhaBBox();
}

void ObjetoGrafico::adicionaPontoFalso(const Ponto& ponto) {
	if (pontos.size() == 0) {
		return;
	}

	Ponto& p = pontos.back();

	p.x = ponto.x;
	p.y = ponto.y;
}

void ObjetoGrafico::removePontoFalso() {
	pontos.pop_back();
}

void ObjetoGrafico::adicionaObjetoFilho(const ObjetoGrafico& filho) {
	filhos.push_back(filho);
}

void ObjetoGrafico::setCor(const Cor& cor) {
	this->cor = cor;
}

void ObjetoGrafico::seleciona() {
	selecionado = true;
}

void ObjetoGrafico::deseleciona() {
	selecionado = false;
}

ObjetoGrafico* ObjetoGrafico::objetoSelecionado() {
	if (selecionado) {
		return this;
	}

	for(auto it = begin(filhos); it != end(filhos); ++it) {
		ObjetoGrafico* obj = it->objetoSelecionado();

		if (obj != nullptr) {
			return obj;
		}
	}

	return nullptr;
}

void ObjetoGrafico::resetaTransformacao() {
	transformacao = Transformacao();
}

void ObjetoGrafico::aplicaTransformacao(const Transformacao& transformacao) {
	this->transformacao = transformacao * this->transformacao;
}

void ObjetoGrafico::mudaPoligonoAbertoOuFechado() {
	if (primitivaGrafica == GL_LINE_STRIP) {
		primitivaGrafica = GL_LINE_LOOP;
	} else {
		primitivaGrafica = GL_LINE_STRIP;
	}
}

void ObjetoGrafico::removePonto(const Ponto& ponto) {
	pontos.erase(std::remove(std::begin(pontos), std::end(pontos), ponto),
			std::end(pontos));
	redesenhaBBox();
}

void ObjetoGrafico::removeFilho(const ObjetoGrafico& filho) {
	for(auto it = begin(filhos); it != end(filhos); ++it) {
		it->removeFilho(filho);
	}

	filhos.erase(
			remove(begin(filhos), end(filhos), filho),
			end(filhos) );
}

Ponto* ObjetoGrafico::pontoProximo(const Ponto& ponto) {

	for(auto it = begin(pontos); it != end(pontos); ++it) {
		if (dist(*it, ponto) <= SELECTION_DISTANCE) {
			return &(*it);
		}
	}

	return nullptr;
}

void ObjetoGrafico::redesenhaBBox() {
	bbox.redesenha(pontos);
}

ObjetoGrafico* ObjetoGrafico::contem(const Ponto& ponto) {
	for(auto it = begin(filhos); it != end(filhos); ++it) {
		ObjetoGrafico* obj = it->contem(ponto);

		if(obj != nullptr) {
			return obj;
		}
	}

	if (!bbox.contem(ponto)) {
		return nullptr;
	}

	int intersections = 0;
	for(size_t i = 0; i < pontos.size(); ++i) {
		Ponto objPontoA = pontos[i];
		Ponto objPontoB = pontos[(i + 1) % pontos.size()];

		if (objPontoA.y != objPontoB.y) {
			double t = (ponto.y - objPontoA.y)
                            		/ (objPontoB.y - objPontoA.y);
			Ponto intersect(objPontoA.x + ((objPontoB.x - objPontoA.x) * t),
					ponto.y);

			if (intersect.x == ponto.x) {
				return this;
			} else if (intersect.x > ponto.x && t >= 0 && t <= 1) {
				++intersections;
			}
		} else if (objPontoA.y == ponto.y
				&& ponto.x >= std::min(objPontoA.x, objPontoB.x)
		&& ponto.x <= std::max(objPontoA.x, objPontoB.x)) {
			return this;
		}
	}

	return intersections % 2 != 0 ? this : nullptr;
}

bool ObjetoGrafico::operator ==(const ObjetoGrafico& rhs) {
	return bbox == rhs.bbox;
}

Ponto ObjetoGrafico::centroObjetoGrafico() const {
	return bbox.centro();
}
