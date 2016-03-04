#ifndef N2EXERCISE4_H_
#define N2EXERCISE4_H_

#include "N2ExerciseBase.hpp"
#include "N2Utils.hpp"

class N2Exercise4: public N2BaseExercise {
public:
	N2Exercise4();
	virtual ~N2Exercise4();
	void desenha() override;
	void keyboard(unsigned char key, int mousePositionX , int mousePositionY);
	void initialize();	
private:
	int GL_PRIMITIVES[10] = {
		GL_POINTS,
		GL_LINES,
		GL_LINE_LOOP,
		GL_TRIANGLES,
		GL_TRIANGLE_FAN,
		GL_TRIANGLE_STRIP,
		GL_QUADS,
		GL_QUAD_STRIP,
		GL_POLYGON
	};

	int GL_PRIMITIVE = 0;
};
#endif
