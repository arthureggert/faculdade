#include "N2Exercise5.hpp"

N2Exercise5::N2Exercise5() : N2BaseExercise(5){
	isMouseOK = false;
	pontoSelecionado = 1;
	qtdPontosSpline = 10;
}
N2Exercise5::~N2Exercise5(){}

void N2Exercise5::desenha() {
	N2BaseExercise::desenha();
	glColor3f(0.0, 1.0, 1.0);
	glLineWidth(4.0f);

	// Desenha as Linhas do poliedro.
	glBegin(GL_LINE_STRIP);
	glVertex2f(p1.X, p1.Y);
	glVertex2f(p2.X, p2.Y);
	glVertex2f(p3.X, p3.Y);
	glVertex2f(p4.X, p4.Y);
	glEnd();

	desenhaSpline(qtdPontosSpline , p1 , p2 , p3 , p4);

	glColor3f(1.0, 0.0, 0.0);
	glPointSize(7.0F);

	// Desenha o ponto na extremidade da linha.
	glBegin(GL_POINTS);
	glVertex2f(pSelecionado.X, pSelecionado.Y);
	glEnd();

	glutSwapBuffers();
}

void N2Exercise5::keyboard(unsigned char key , int mousePositionX , int mousePositionY){

	switch (key) {
	case KEY_ESCAPE:
		exit(0);
		break;

	case '1':
		pSelecionado.X = p1.X;
		pSelecionado.Y = p1.Y;
		pontoSelecionado = 1;
		glutPostRedisplay();

		break;

	case '2':
		pSelecionado.X = p2.X;
		pSelecionado.Y = p2.Y;
		pontoSelecionado = 2;
		glutPostRedisplay();
		break;

	case '3':
		pSelecionado.X = p3.X;
		pSelecionado.Y = p3.Y;
		pontoSelecionado = 3;
		glutPostRedisplay();
		break;

	case '4':
		pSelecionado.X = p4.X;
		pSelecionado.Y = p4.Y;
		pontoSelecionado = 4;
		glutPostRedisplay();
		break;

	case 'Q':
	case 'q':
		if(qtdPontosSpline > 1)
		{
			qtdPontosSpline -= 1;
			glutPostRedisplay();
		}
		break;

	case 'W':
	case 'w':
		qtdPontosSpline += 1;
		glutPostRedisplay();
		break;

	default:
		break;
	}
}

void N2Exercise5::initialize() {
	N2BaseExercise::initialize(1.0f , 1.0f , 1.0f , 1.0f);
}

void N2Exercise5::motion(int x, int y) {
	if (!isMouseOK) return;

	switch (pontoSelecionado) {
	case 1:
		p1.X = (x * 2) - getWidth();
		pSelecionado.X = p1.X;
		p1.Y = (y * -2) + getHeight();
		pSelecionado.Y = p1.Y;
		break;

	case 2:
		p2.X = (x * 2) - getWidth();
		pSelecionado.X = p2.X;
		p2.Y = (y * -2) + getHeight();
		pSelecionado.Y = p2.Y;
		break;

	case 3:
		p3.X = (x * 2) - getWidth();
		pSelecionado.X = p3.X;
		p3.Y = (y * -2) + getHeight();
		pSelecionado.Y = p3.Y;
		break;

	case 4:
		p4.X = (x * 2) - getWidth();
		pSelecionado.X = p4.X;
		p4.Y = (y * -2) + getHeight();
		pSelecionado.Y = p4.Y;
		break;

	default:
		break;
	}

	glutPostRedisplay();
}

void N2Exercise5::mouse(int button, int state, int x, int y) {
	isMouseOK = button == GLUT_LEFT_BUTTON && state == GLUT_DOWN;
}

