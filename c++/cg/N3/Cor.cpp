#include "Cor.hpp"
#include <random>
#include <iostream>

using namespace std;

static random_device rd;
static mt19937 gen(rd());
static uniform_real_distribution<double> dist;

Cor::Cor() {
	r = 0;
	g = 0;
	b = 0;
}

Cor::Cor(float r, float g, float b){
	this->r = r;
	this->g = g;
	this->b = b;
}

const float* Cor::getData() const {
	return reinterpret_cast<const float*>(this);
}

Cor Cor::random() {
	return Cor(dist(gen), dist(gen), dist(gen));
}
