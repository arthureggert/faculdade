/*
 * N2Exercicise6.hpp
 *
 *  Created on: 02/09/2014
 *      Author: aheggert
 */

#ifndef N2EXERCICISE6_HPP_
#define N2EXERCICISE6_HPP_

#include "N2ExerciseBase.hpp"
#include "N2Utils.hpp"

class N2Exercise6: public N2BaseExercise {
public:
	N2Exercise6();
	virtual ~N2Exercise6();
	void initialize();
	void desenha() override;
	void motion(int x , int y);
	void mouse(int button, int state, int x, int y);
	void keyboard(unsigned char key , int mousePositionX , int mousePositionY);

private:
	float bboxColorRGB[3];
	Ponto centroCirculoGrande,
		  centroCirculoPequeno;
	GLfloat raioCirculoGrande,
			raioCirculoPequeno;
	BBox bbox;
	bool isMouseOK;
	bool isCirculoPequenoDentroGrande();
};

#endif /* N2EXERCICISE6_HPP_ */
