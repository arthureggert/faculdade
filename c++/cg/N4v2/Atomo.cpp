#include "Atomo.hpp"

Atomo::Atomo(int protons, int neutrons, int eletrons) {
	camadaK = Camada(eletrons, 2, 10);
	camadaL = Camada(eletrons, 8, 20);
	camadaM = Camada(eletrons, 5, 40);
	nucleo = Nucleo(protons, neutrons);
}

void Atomo::anima() {
	camadaK.moveEletrons();
	camadaL.moveEletrons();
	camadaM.moveEletrons();
}

void Atomo::desenha() {
	camadaK.desenha();
	camadaL.desenha();
	camadaM.desenha();
	nucleo.desenha();
}
