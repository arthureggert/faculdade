#include "Utils.hpp"

ObjetoGrafico bboxToObjeto(const BBox& bbox) {
	ObjetoGrafico obj;

	obj.adicionaPonto(bbox.min);
	obj.adicionaPonto(Ponto(bbox.min.x, bbox.max.y));
	obj.adicionaPonto(bbox.max);
	obj.adicionaPonto(Ponto(bbox.max.x, bbox.min.y));
	obj.adicionaPonto(bbox.min);

	obj.setCor(AMARELO);

	return obj;
}

ObjetoGrafico eixosReferenciaAsObjetoGrafico() {
	ObjetoGrafico eixoX, eixoY;

	eixoX.adicionaPonto(Ponto(-100, 0));
	eixoX.adicionaPonto(Ponto(100, 0));
	eixoX.setCor(VERMELHO);

	eixoY.adicionaPonto(Ponto(0, -100));
	eixoY.adicionaPonto(Ponto(0, 100));
	eixoY.setCor(VERDE);

	ObjetoGrafico eixos;
	eixos.adicionaObjetoFilho(eixoY);
	eixos.adicionaObjetoFilho(eixoX);

	return eixos;
}

Camera obtemCamera() {
	return Camera();
}

double dist(const Ponto& lhs, const Ponto& rhs) {
	double x = lhs.x - rhs.x;
	double y = lhs.y - rhs.y;
	double z = lhs.z - rhs.z;

	return x*x + y*y + z*z;
}

