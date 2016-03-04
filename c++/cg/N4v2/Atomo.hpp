#include "Camada.hpp"
#include "Nucleo.hpp"

class Atomo {

private:
	Camada camadaK;
	Camada camadaL;
	Camada camadaM;
	Nucleo nucleo;

public:
	Atomo(int protons, int neutrons, int eletrons);
	void desenha();
	void anima();
};
