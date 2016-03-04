/*
 * N2Exercise2.cpp
 *
 *  Created on: 27/08/2014
 *      Author: aheggert
 */

#include <iostream>
#include "N2Exercise2.hpp"
#include "N2Utils.hpp"

N2Exercise2::N2Exercise2() : N2BaseExercise(2){
}

N2Exercise2::~N2Exercise2() {
}

void N2Exercise2::desenha() {
	N2BaseExercise::desenha();
    glColor3f(0.0, 0.0, 0.0);
    desenhaCirculo(0,0,100,72,GL_POINTS);
}

void N2Exercise2::initialize() {
	N2BaseExercise::initialize(1.0f , 1.0f , 1.0f , 1.0f);
}

void N2Exercise2::keyboard(unsigned char key, int mousePositionX, int mousePositionY){

    switch (key) {
        case KEY_ESCAPE:
            exit(0);
        break;

        case 'I':
        case 'i':
            if (zoom < 180) {
                minX += 5.0f;
                maxX -= 5.0f;
                minY += 5.0f;
                maxY -= 5.0f;
                zoomIn();
                glutPostRedisplay();
            }
        break;

        case 'O':
        case 'o':
            if (zoom > 0) {
                minX -= 5.0f;
                maxX += 5.0f;
                minY -= 5.0f;
                maxY += 5.0f;
                zoomOut();
                glutPostRedisplay();
            }
        break;

        case 'E':
        case 'e':
            minX += 5.0f;
            maxX += 5.0f;
            glutPostRedisplay();
        break;

        case 'D':
        case 'd':
            minX -= 5.0f;
            maxX -= 5.0f;
            glutPostRedisplay();
        break;

        case 'C':
        case 'c':
            minY -= 5.0f;
            maxY -= 5.0f;
            glutPostRedisplay();
        break;

        case 'B':
        case 'b':
            minY += 5.0f;
            maxY += 5.0f;
            glutPostRedisplay();
        break;

        default:
        break;
    }
}
