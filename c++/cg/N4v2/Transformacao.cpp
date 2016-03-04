#include "Transformacao.hpp"

#include "Ponto.hpp"

#include <cmath>

Transformacao::Transformacao() {
	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			matrix[i][j] = 0.0;
		}
	}

	matrix[0][0] = matrix[1][1] = matrix[2][2] = matrix[3][3] = 1.0;
}

const double* Transformacao::getData() const {
	return reinterpret_cast<const double*>(matrix);
}

Ponto Transformacao::operator *(const Ponto& ponto) const {
	double x = ponto.x * matrix[0][0]
	                             + ponto.y * matrix[0][1]
	                                                 + ponto.z * matrix[0][2]
	                                                                     + ponto.w * matrix[0][3];

	double y = ponto.x * matrix[1][0]
	                             + ponto.y * matrix[1][1]
	                                                 + ponto.z * matrix[1][2]
	                                                                     + ponto.w * matrix[1][3];

	double z = ponto.x * matrix[2][0]
	                             + ponto.y * matrix[2][1]
	                                                 + ponto.z * matrix[2][2]
	                                                                     + ponto.w * matrix[2][3];

	double w = ponto.x * matrix[3][0]
	                             + ponto.y * matrix[3][1]
	                                                 + ponto.z * matrix[3][2]
	                                                                     + ponto.w * matrix[3][3];

	return Ponto(x, y, z, w);
}

Transformacao Transformacao::operator *(const Transformacao& r) const {
	const Transformacao& l = *this;

	Transformacao t;

	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			double sum = 0.0;

			for(int k = 0; k < 4; k++) {
				sum += l.matrix[i][k] * r.matrix[k][j];
			}

			t.matrix[i][j] = sum;
		}
	}

	return t;
}

Transformacao Transformacao::translacao(const Ponto& ponto) {
	Transformacao t;

	t.matrix[3][0] = ponto.x;
	t.matrix[3][1] = ponto.y;
	t.matrix[3][2] = ponto.z;

	return t;
}

Transformacao Transformacao::escala(double xfactor, double yfactor, double zfactor) {
	Transformacao t;

	t.matrix[0][0] = xfactor;
	t.matrix[1][1] = yfactor;
	t.matrix[2][2] = zfactor;

	return t;
}

Transformacao Transformacao::xRotacao(double rad) {
	Transformacao t;

	t.matrix[1][1] = std::cos(rad);
	t.matrix[2][1] = -1 * std::sin(rad);
	t.matrix[1][2] = std::sin(rad);
	t.matrix[2][2] = std::cos(rad);

	return t;
}

Transformacao Transformacao::yRotacao(double rad) {
	Transformacao t;

	t.matrix[0][0] = std::cos(rad);
	t.matrix[2][0] = std::sin(rad);
	t.matrix[0][2] = -1 * std::sin(rad);
	t.matrix[2][2] = std::cos(rad);

	return t;
}

Transformacao Transformacao::zRotacao(double rad) {
	Transformacao t;

	t.matrix[0][0] = std::cos(rad);
	t.matrix[1][0] = -1 * std::sin(rad);
	t.matrix[0][1] = std::sin(rad);
	t.matrix[1][1] = std::cos(rad);

	return t;
}
