/*
 * N2Exercise1.h
 *
 *  Created on: 27/08/2014
 *      Author: aheggert
 */

#ifndef N2EXERCISE1_H_
#define N2EXERCISE1_H_

#include "N2ExerciseBase.hpp"
#include "N2Utils.hpp"

class N2Exercise1: public N2BaseExercise {
public:
	N2Exercise1();
	virtual ~N2Exercise1();
	void desenha() override;
	void initialize();
};

#endif /* N2EXERCISE1_H_ */
