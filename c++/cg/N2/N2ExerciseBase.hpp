
#ifndef N2EXERCICIO1_HPP_
#define N2EXERCISEBASE_HPP_

#include <GL/gl.h>
#include <GL/glut.h>

class N2BaseExercise {

public:

	N2BaseExercise(int exerciseNumber);
	virtual ~N2BaseExercise();


	void setMinX(GLfloat minX);
	void setMaxX(GLfloat maxX);
	void setMinY(GLfloat minY);
	void setMaxY(GLfloat maxY);
	GLfloat getMinX();
	GLfloat getMaxX();
	GLfloat getMinY();
	GLfloat getMaxY();

	void initialize(GLfloat red, GLfloat green, GLfloat blue, GLfloat alpha);
	void display();

	GLint getHeight();
	GLint getWidth();

	int getExerciseNumber();

	int getZoom();

	void zoomIn();

	void zoomOut();

	int zoom;

	GLfloat minX , maxX , minY , maxY;

	virtual void desenha();

private:

	int exerciseNumber;


	GLint width , height;




};

#endif
