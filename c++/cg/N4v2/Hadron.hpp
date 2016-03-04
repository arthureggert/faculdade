#include <GL/glut.h>
#include <GL/glu.h>
#include <GL/gl.h>
#include "Transformacao.hpp"

class Hadron {
private:
	Hadron() {
	}

	Hadron(GLfloat* cor) {
		this->cor[0] = cor[0];
		this->cor[1] = cor[1];
		this->cor[2] = cor[2];
	}

	GLfloat cor[3];
	Transformacao matriz;

public:

	static Hadron criaNeutron() {
		GLfloat VERDE[] = {0.0, 1.0, 0.0};
		return Hadron(VERDE);
	}

	static Hadron criaProton() {
		GLfloat ROXO[] = {1.0, 0.0, 1.0};
		return Hadron(ROXO);
	}

	Transformacao getMatriz() {
		return matriz;
	}

	void setMatriz(Transformacao matrix) {
		this->matriz = matrix;
	}

	void desenha()	{
		glPushMatrix();

		glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, cor);

		glMultMatrixd(getMatriz().getData());
		glutSolidSphere(1, 12, 24);

		glPopMatrix();
	}
};
