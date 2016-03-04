#include <math.h>
#include "Nucleo.hpp"
#include "Transformacao.hpp"

void Nucleo::adicionaHadron(Hadron hadron) {
	hadrons.push_back(hadron);
}

void Nucleo::desenha() {
	for(auto it = hadrons.begin(); it != hadrons.end(); it++)
		(*it).desenha();
}

Ponto randomPositionForHadron(){
    double x, y,z;
    
    x = (rand() % 4) - 2;
    y = (rand() % 4) - 2;
    z = (rand() % 4) - 2;
    
    return Ponto(x, y, z);
}

Nucleo::Nucleo(int protons, int neutrons) {
	Transformacao transformacao;

	for(int i = 0; i < protons; i++) {
		Hadron proton = Hadron::criaProton();

		//adicionado para que não fiquem todos os protons nas mesma possicao
		proton.setMatriz(transformacao.translacao(randomPositionForHadron()));

		adicionaHadron(proton);
	}

	for(int i = 0; i < neutrons; i++) {
		Hadron neutron = Hadron::criaNeutron();

		//adicionado para que não fiquem todos os neutrons nas mesma possicao
		neutron.setMatriz(transformacao.translacao(randomPositionForHadron()));

		adicionaHadron(neutron);
	}

}

Nucleo::Nucleo(){
}
