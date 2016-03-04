/*
 * N2Exercise7.hpp
 *
 *  Created on: 02/09/2014
 *      Author: aheggert
 */

#ifndef N2EXERCISE7_HPP_
#define N2EXERCISE7_HPP_

#include "N2ExerciseBase.hpp"
#include "N2Utils.hpp"

class N2Exercise7: public N2BaseExercise {
public:
	N2Exercise7();
	virtual ~N2Exercise7();
	void initialize();
	void desenha() override;
	void keyboard(unsigned char key , int mousePositionX , int mousePositionY);
private:
	GLfloat angulo,
	        raio;
	Ponto pontoSuperior,
		  pontoInferior;
	void calculaPossicao();
};

#endif /* N2EXERCISE7_HPP_ */
