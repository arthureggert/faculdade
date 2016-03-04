#include <vector>
#include "Hadron.hpp"

using namespace std;

class Nucleo {

private:
	vector<Hadron> hadrons;

public:
	void desenha();
	void adicionaHadron(Hadron hadron);

	Nucleo();
	Nucleo(int protons, int neutrons);
};
