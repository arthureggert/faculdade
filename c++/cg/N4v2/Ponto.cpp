#include "Ponto.hpp"

Ponto::Ponto() {
	x = 0;
	y = 0;
	z = 0;
	w = 1;
}

Ponto::Ponto(double x, double y) {
	this->x = x;
	this->y = y;
	this->z = 0;
	this->w = 1;
}

Ponto::Ponto(double x, double y, double z) {
	this->x = x;
	this->y = y;
	this->z = z;
	this->w = 1;
}

Ponto::Ponto(double x, double y, double z, double w) {
	this->x = x;
	this->y = y;
	this->z = z;
	this->w = w;
}

bool operator == (const Ponto& este, const Ponto& outro) {
	return este.x == outro.x && este.y == outro.y && este.z == outro.z;
}

Ponto operator -(const Ponto& ponto) {
	return Ponto(-1 * ponto.x, -1 * ponto.y, -1 * ponto.z);
}
