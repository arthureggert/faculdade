
#include "N2Exercise1.hpp"
#include "N2Utils.hpp"
#include "math.h"

using namespace std;

N2Exercise1::N2Exercise1() : N2BaseExercise(1){
}

N2Exercise1::~N2Exercise1() {
}

void N2Exercise1::desenha() {

	N2BaseExercise::desenha();

	glColor3f(0.0f, 0.3f, 1.0f);
    glPointSize(1.5f);
    desenhaCirculo(0,0,100,72,GL_POINTS);
}

void N2Exercise1::initialize() {
	N2BaseExercise::initialize(0.8f , 0.8f , 0.8f , 1.0f);
}
