/*
 * N2Exercise2.hpp
 *
 *  Created on: 27/08/2014
 *      Author: aheggert
 */

#ifndef N2EXERCISE2_HPP_
#define N2EXERCISE2_HPP_

#include "N2ExerciseBase.hpp"

class N2Exercise2: public N2BaseExercise {
public:
	N2Exercise2();
	virtual ~N2Exercise2();
	void desenha() override;
	void keyboard(unsigned char key, int mousePositionX, int mousePositionY);
	void initialize();
};

#endif /* N2EXERCISE2_HPP_ */
