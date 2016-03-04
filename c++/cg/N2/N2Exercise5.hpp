#ifndef N2EXERCISE5_H_
#define N2EXERCISE5_H_

#include "N2ExerciseBase.hpp"
#include "N2Utils.hpp"

using namespace std;

class N2Exercise5: public N2BaseExercise {
public:
	N2Exercise5();
	virtual ~N2Exercise5();
	void initialize();
	void desenha() override;
	void motion(int x , int y);
	void mouse(int button, int state, int x, int y);
	void keyboard(unsigned char key , int mousePositionX , int mousePositionY);
private:
	Ponto p1, p2, p3, p4, pSelecionado;
	int pontoSelecionado;
	int qtdPontosSpline;
	bool isMouseOK;
#endif
};
