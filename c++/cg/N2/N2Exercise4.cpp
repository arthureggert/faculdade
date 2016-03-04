#include "N2Exercise4.hpp"

N2Exercise4::N2Exercise4() : N2BaseExercise(4) {}
N2Exercise4::~N2Exercise4(){}

void N2Exercise4::desenha() {
	N2BaseExercise::desenha();

	glLineWidth(2.0f);
	glPointSize(2.0f);

	glBegin(GL_PRIMITIVES[GL_PRIMITIVE]);
	glColor3f(0.0f , 0.0f, 1.0f);
	glVertex2f(200.0f, -200.0f);
	glColor3f(1.0f, 0.0f, 0.0f);
	glVertex2f(200.0f,  200.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex2f(-200.0f,  200.0f);
	glColor3f(1.0f, 0.078f, 0.576f);
	glVertex2f(-200.0f, -200.0f);
	glEnd();

	glutSwapBuffers();

}

void N2Exercise4::keyboard(unsigned char key , int mousePositionX , int mousePositionY) {
	switch (key) {
	case KEY_ESCAPE:
		exit(0);
		break;
	case KEY_SPACE:
		GL_PRIMITIVE++;
		if (GL_PRIMITIVE >= 10) {
			GL_PRIMITIVE = 0;
		}
		glutPostRedisplay();
		break;
	}
}

void N2Exercise4::initialize() {
	N2BaseExercise::initialize(1.0f , 1.0f , 1.0f , 1.0f);
}
