#include <math.h>
#include <vector>
#include "Eletron.hpp"
#include "Ponto.hpp"

using namespace std;

class Camada {

private:
	vector<Eletron> eletrons;
	Transformacao transformacao;
	Ponto getPossicaoNaOrbita(double anguloRotacao, double raio, double anguloOrbita);

	double raio;
	int contadorEletrons;
	int eletronsNoAtomo;

	void desenhaOrbita(double anguloOrbita);
	double paraRadianos(double angulo);

public:

	Camada(){
		raio = 0;
		eletronsNoAtomo = 0;
		contadorEletrons = 0;
	}

	Camada(int eletronsNoAtomo, int contadorEletrons, double raio) {
		this->eletronsNoAtomo = eletronsNoAtomo;
		this->raio = raio;

		for (int i = 0; i < contadorEletrons; i++) {
			adicionaEletron();
		}
	}

	void adicionaEletron();
	void desenha();
	void moveEletrons();

};
