/*
 * N2Exercise7.cpp
 *
 *  Created on: 02/09/2014
 *      Author: aheggert
 */

#include "N2Exercise7.hpp"

N2Exercise7::N2Exercise7() : N2BaseExercise(7){
	angulo = 45;
	raio = 100;
}

N2Exercise7::~N2Exercise7() {
}

void N2Exercise7::calculaPossicao(){
	pontoInferior.X = pontoSuperior.X + calculaX(angulo, raio);
	pontoInferior.Y = pontoSuperior.Y + calculaY(angulo, raio);
}

void N2Exercise7::desenha() {
	N2BaseExercise::desenha();
	calculaPossicao();
	glColor3f(0.0, 0.0, 0.0);
	// Reta.
	// Linha
	glLineWidth(2.0f);
	glBegin(GL_LINES);
	glVertex2f(pontoSuperior.X, pontoSuperior.Y);
	glVertex2f(pontoInferior.X, pontoInferior.Y);
	glEnd();
	// Pontos na extremidade da linha.
	glPointSize(4.0F);
	glBegin(GL_POINTS);
	glVertex2f(pontoSuperior.X, pontoSuperior.Y);
	glVertex2f(pontoInferior.X, pontoInferior.Y);
	glEnd();
}

void N2Exercise7::initialize() {
	N2BaseExercise::initialize(1.0f , 1.0f , 1.0f , 1.0f);
}

void N2Exercise7::keyboard(unsigned char key , int mousePositionX , int mousePositionY){
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

	case 'Q':
	case 'q':
		pontoSuperior.X--;
		glutPostRedisplay();
		break;

	case 'W':
	case 'w':
		pontoSuperior.X++;
		glutPostRedisplay();
		break;

	case 'A':
	case 'a':
		raio--;
		if (raio < 0) {
			raio = 0;
		}
		glutPostRedisplay();
		break;

	case 'S':
	case 's':
		raio++;
		glutPostRedisplay();
		break;

	case 'Z':
	case 'z':
		angulo--;
		glutPostRedisplay();
		break;

	case 'X':
	case 'x':
		angulo++;
		glutPostRedisplay();
		break;

	default:
		break;
	}

}
