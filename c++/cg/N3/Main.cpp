/**
 * @file main.cpp
 * @brief Ponto de Entrada
 * @author Arthur Henrique Eggert
 * @date 2014-10-03
 */

#include "AdicaoCallback.hpp"
#include "EdicaoCallback.hpp"
#include "Mundo.hpp"

#include <ctype.h>

using namespace std;

Mundo mundo;

AdicaoCallback adicaoCallback(mundo);

EdicaoCallback edicaoCallback(mundo);

AbstractCallback* callbackAtual;

/**
 * Function called by GLUT to render the scene.
 */
void display();

/**
 * Function called by GLUT to handle keypresses
 */
void keyboard(unsigned char key, int x, int y);

/**
 * Function called by GLUT when a mouse button is pressed.
 */
void mouse(int button, int state, int x, int y);

/*
 * Function called by GLUT when the mouse pointer moves.
 */
void passiveMotion(int x, int y);

/*
 * Function called by GLUT when the window is resized.
 */
void reshape(int width, int height);

/*
 * Function called by GLUT when a special key is pressed.
 */
void special(int key, int x, int y);

int main(int argc, char* argv[]) {
	callbackAtual = &adicaoCallback;

	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowPosition(300, 250);
	glutInitWindowSize(mundo.largura() , mundo.altura());
	glutCreateWindow("Arthur Henrique Eggert - N3");

	glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

	glutDisplayFunc(display);
	glutKeyboardFunc(keyboard);
	glutMouseFunc(mouse);
	glutPassiveMotionFunc(passiveMotion);
	glutReshapeFunc(reshape);
	glutSpecialFunc(special);

	glutMainLoop();

	return 0;
}

void display() {
	callbackAtual->display();
}

void keyboard(unsigned char key, int x, int y) {
	key = tolower(key);
	Ponto ponto = mundo.normalizar(x, y);

	switch (key) {
	case 'e':
		callbackAtual = &edicaoCallback;
		break;

	case 'a':
		callbackAtual = &adicaoCallback;
		break;
	default:
		callbackAtual->keyboard(key, ponto);
		break;
	}

	glutPostRedisplay();
}

void mouse(int button, int state, int x, int y) {
	Ponto ponto = mundo.normalizar(x, y);

	callbackAtual->mouse(button, state, ponto);
	glutPostRedisplay();
}

void passiveMotion(int x, int y) {
	Ponto ponto = mundo.normalizar(x, y);

	callbackAtual->movimentoMouse(ponto);
	glutPostRedisplay();
}

void reshape(int width, int height) {
	callbackAtual->reshape(width, height);
	glutPostRedisplay();
}

void special(int key, int x, int y) {
	Ponto ponto = mundo.normalizar(x, y);

	callbackAtual->special(key, ponto);
	glutPostRedisplay();
}
