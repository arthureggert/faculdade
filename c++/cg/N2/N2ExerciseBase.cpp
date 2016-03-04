#include "N2ExerciseBase.hpp"
#include <GL/gl.h>
#include <GL/glut.h>
#include <iostream>
#include "N2Utils.hpp"

N2BaseExercise::N2BaseExercise(int exerciseNumber) {
	this->exerciseNumber = exerciseNumber;
	this->minX = -400.0f;
	this->maxX =  400.0f;
	this->minY = -400.0f;
	this->maxY =  400.0f;
	this->width = 400;
	this->height = 400;
	this->zoom = 100;
}

N2BaseExercise::~N2BaseExercise() {

}

void N2BaseExercise::setMinX(GLfloat minX) {
	this->minX = minX;
}

void N2BaseExercise::setMaxX(GLfloat maxX) {
	this->maxX = maxX;
}

void N2BaseExercise::setMinY(GLfloat minY) {
	this->minY = minY;
}

void N2BaseExercise::setMaxY(GLfloat maxY) {
	this->maxY = maxY;
}

GLint N2BaseExercise::getHeight() {
	return height;
}

GLint N2BaseExercise::getWidth() {
	return width;
}

GLfloat N2BaseExercise::getMaxX() {
	return maxX;
}

GLfloat N2BaseExercise::getMinX() {
	return minY;
}

GLfloat N2BaseExercise::getMaxY() {
	return maxY;
}

GLfloat N2BaseExercise::getMinY() {
	return minY;
}

int N2BaseExercise::getExerciseNumber(){
	return exerciseNumber;
}

int N2BaseExercise::getZoom() {
	return zoom;
}

void N2BaseExercise::zoomIn() {
    zoom = zoom + 5 * 100 / 400;
}

void N2BaseExercise::zoomOut() {
	zoom = zoom - 5 * 100 / 400;
}

void N2BaseExercise::display() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    gluOrtho2D(minX, maxX, minY, maxY);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    desenha();

    glutSwapBuffers();
}

void N2BaseExercise::initialize(GLfloat red, GLfloat green, GLfloat blue, GLfloat alpha ) {
    glDisable(GL_TEXTURE_2D);
    glDisableClientState(GL_TEXTURE_COORD_ARRAY);
    glDisable(GL_LIGHTING);

    glClearColor(red , green , blue , alpha);
}

void N2BaseExercise::desenha() {
	desenhaEixoXeEixoY(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
}

