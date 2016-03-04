/*
 * N2Exercise3.cpp
 *
 *  Created on: 28/08/2014
 *      Author: aheggert
 */

#include "N2Exercise3.hpp"
#include "N2Utils.hpp"

N2Exercise3::N2Exercise3() : N2BaseExercise(3) {
}

N2Exercise3::~N2Exercise3() {
}

void N2Exercise3::desenha() {
	N2BaseExercise::desenha();
    glColor3f(0.0, 0.0, 0.0);
    glLineWidth(1.5f);
    desenhaCirculo(100,100,100,200,GL_LINE_LOOP);
    desenhaCirculo(-100,100,100,200,GL_LINE_LOOP);
    desenhaCirculo(100,100,100,200,GL_LINE_LOOP);
    desenhaCirculo(0,-100,100,200,GL_LINE_LOOP);
    glLineWidth(5.0f);

    Ponto p1, p2, p3;
    // Ponto esquerdo.
    p1.X = -100.0f;
    p1.Y = 100.0f;
    // Ponto direito.
    p2.X = 100.0f;
    p2.Y = 100.0f;
    // Ponto inferior.
    p3.X = 0.0f;
    p3.Y = -100.0f;

    desenhaTriangulo(p1,p2,p3,GL_LINE_LOOP);


}

void N2Exercise3::initialize() {
	N2BaseExercise::initialize(1.0f , 1.0f , 1.0f , 1.0f);
}
