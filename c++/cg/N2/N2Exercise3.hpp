/*
 * N2Exercise3.hpp
 *
 *  Created on: 28/08/2014
 *      Author: aheggert
 */

#ifndef N2EXERCISE3_HPP_
#define N2EXERCISE3_HPP_

#include "N2ExerciseBase.hpp"

class N2Exercise3: public N2BaseExercise {
public:
	N2Exercise3();
	virtual ~N2Exercise3();
	void desenha() override;
	void initialize();
};

#endif /* N2EXERCISE3_HPP_ */
