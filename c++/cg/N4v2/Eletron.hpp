#include "Transformacao.hpp"
#include <GL/glut.h>
#include <GL/glu.h>
#include <GL/gl.h>

class Eletron {
private:
	Transformacao matrix;
	double anguloOrbita;
	double anguloRotacao;

public:

	Eletron(double anguloOrbita)	{
		this->anguloOrbita = anguloOrbita;
		anguloRotacao = rand() % 360;
	}

	void desenha();
	double getAnguloOrbita();
	double getAnguloRotacao();
	void movimenta(Transformacao translationMatrix);
};
