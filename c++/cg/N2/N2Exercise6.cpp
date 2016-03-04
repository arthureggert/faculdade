/*
 * N2Exercicise6.cpp
 *
 *  Created on: 02/09/2014
 *      Author: aheggert
 */

#include "N2Exercise6.hpp"

N2Exercise6::N2Exercise6() : N2BaseExercise(6) {
	bboxColorRGB[0] = 0.0f;
	bboxColorRGB[1] = 1.0f;
	bboxColorRGB[2] = 0.0f;
	centroCirculoGrande.X = 150;
	centroCirculoGrande.Y = 150;
	centroCirculoPequeno.X = 150;
	centroCirculoPequeno.Y = 150;
	raioCirculoGrande = 150.0f;
	raioCirculoPequeno = 50.0f;
	bbox.minX = centroCirculoGrande.X + calculaX(315, raioCirculoGrande);
	bbox.maxX = centroCirculoGrande.X + calculaX(225, raioCirculoGrande);
	bbox.minY = centroCirculoGrande.Y + calculaY(225, raioCirculoGrande);
	bbox.maxY = centroCirculoGrande.Y + calculaY(135, raioCirculoGrande);
	isMouseOK = false;

}

N2Exercise6::~N2Exercise6() {

}

void N2Exercise6::desenha(){
	N2BaseExercise::desenha();

	//circula maior
	glColor3f(0.0, 0.0, 0.0);
	glLineWidth(1.5f);
	desenhaCirculo(centroCirculoGrande.X , centroCirculoGrande.Y , raioCirculoGrande , 1000);

	glColor3f(bboxColorRGB[0], bboxColorRGB[1], bboxColorRGB[2]);
	glLineWidth(1.0f);
	desenhaRetangulo(bbox);

	glColor3f(0.0, 0.0, 0.0);
	// Circulo menor.
	desenhaCirculo(centroCirculoPequeno.X , centroCirculoPequeno.Y, raioCirculoPequeno, 1000);
	// Ponto no centro do circulo menor.
	glPointSize(4.0f);
	glBegin(GL_POINTS);
	glVertex2f(centroCirculoPequeno.X , centroCirculoPequeno.Y);
	glEnd();
	glutSwapBuffers();

}

void N2Exercise6::initialize() {
	N2BaseExercise::initialize(1.0f , 1.0f , 1.0f , 1.0f);
}

void N2Exercise6::keyboard(unsigned char key , int mouseX , int mouseY) {
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

void N2Exercise6::mouse(int button, int state, int x, int y){
	// Release mouse button.
	if (state == GLUT_UP) {
		//volta para o estado inicial
		centroCirculoPequeno.X = 150;
		centroCirculoPequeno.Y = 150;

		bboxColorRGB[0] = 0.0f;
		bboxColorRGB[1] = 1.0f;
		bboxColorRGB[2] = 0.0f;
		glutPostRedisplay();
	} else if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN) {
		isMouseOK = true;
	}
}

void N2Exercise6::motion(int x , int y){
	if (!isMouseOK) return;

	float oldX = centroCirculoPequeno.X,
			oldY = centroCirculoPequeno.Y;

	centroCirculoPequeno.X = (x * 2) - getWidth();
	centroCirculoPequeno.Y = (y * -2) + getHeight();

	if (!isCirculoPequenoDentroGrande()) {
		centroCirculoPequeno.X = oldX;
		centroCirculoPequeno.Y = oldY;
	}

	glutPostRedisplay();
}

bool N2Exercise6::isCirculoPequenoDentroGrande() {
	if (centroCirculoPequeno.X < bbox.minX &&  centroCirculoPequeno.X > bbox.maxX &&
			centroCirculoPequeno.Y > bbox.minY && centroCirculoPequeno.Y < bbox.maxY) {
		bboxColorRGB[0] = 0.0f;
		bboxColorRGB[1] = 1.0f;
		bboxColorRGB[2] = 0.0f;

		return true;
	} else {

		double distancia = distanciaEuclidiana(centroCirculoGrande , centroCirculoPequeno);
		bool outRadius = distancia <= raioCirculoGrande * raioCirculoGrande;

		// Fora da BBox e Dentro do raio.
		if (outRadius) {
			bboxColorRGB[0] = 1.0f;
			bboxColorRGB[1] = 1.0f;
			bboxColorRGB[2] = 0.0f;
		} else {
			bboxColorRGB[0] = 1.0f;
			bboxColorRGB[1] = 0.0f;
			bboxColorRGB[2] = 0.0f;
		}
		return outRadius;
	}

}
