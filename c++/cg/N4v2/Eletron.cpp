#include "Eletron.hpp"

void Eletron::movimenta(Transformacao matrizTranslacao) {
	matrix = matrizTranslacao;
	anguloRotacao = (int)(anguloRotacao + 5) % 360;
}

double Eletron::getAnguloRotacao() {
	return anguloRotacao;
}

double Eletron::getAnguloOrbita() {
	return anguloOrbita;
}

void Eletron::desenha() {
	glPushMatrix();
	GLfloat BLUE[] = {0, 0, 1};
	glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, BLUE);
	glColor3ub(0,0,255);
	glMultMatrixd(matrix.getData());
	glutSolidSphere(1, 12, 24);
	glPopMatrix();
}
