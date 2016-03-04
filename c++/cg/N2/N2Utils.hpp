/*
 * N2Utils.hpp
 *
 *  Created on: 27/08/2014
 *      Author: aheggert
 */

#include "math.h"
#include <GL/gl.h>
#include <GL/glut.h>
#ifndef N2UTILS_HPP_

#define N2UTILS_HPP_
#define KEY_ESCAPE 27
#define KEY_SPACE 32

struct Ponto {
	GLfloat X , Y;
};

struct BBox
{
	float minX, maxX, minY, maxY;
};

inline double distanciaEuclidiana(float x1, float y1, float x2, float y2){
	double x = x1 - x2;
	double y = y1 - y2;
	double distancia = pow(x, 2) + pow(y, 2);
	return abs(distancia);
}

inline double distanciaEuclidiana(Ponto p1 , Ponto p2){
	double x = p1.X - p2.X;
	double y = p1.Y - p2.Y;
	double distancia = pow(x, 2) + pow(y, 2);
	return distancia;
}

inline double calculaX(double angle, double radius){
	return (radius * cos(M_PI * angle / 180.0));
}

inline double calculaY(double angle, double radius) {
	return (radius * sin(M_PI * angle / 180.0));
}

inline void desenhaCirculo(float cx, float cy, float raio, int qtdPontos, GLenum primitive = GL_LINE_LOOP) {
	glBegin(primitive);

	for(int i = 0; i < qtdPontos; i++) {
		float angle = 2.0f * M_PI * float(i) / float(qtdPontos);

		float x = raio * cos(angle);
		float y = raio * sin(angle);

		glVertex2f(x + cx, y + cy);
	}

	glEnd();
}

inline void desenhaEixoXeEixoY(GLfloat rx, GLfloat gx,GLfloat bx, GLfloat ry, GLfloat gy , GLfloat by ){

	glLineWidth(1.0f);
	glBegin(GL_LINES);
	// Eixo X.
	glColor3f(rx,gx,bx);
	glVertex2f(-200.0f, 0.0f);
	glVertex2f(200.0f, 0.0f);
	// Eixo Y.
	glColor3f(ry,gy,by);
	glVertex2f(0.0f, -200.0f);
	glVertex2f(0.0f, 200.0f);
	glEnd();
}

inline void desenhaTriangulo(Ponto p1 , Ponto p2 , Ponto p3 , GLenum primitive = GL_LINE_LOOP) {
	glBegin(primitive);
	glVertex2f(p1.X , p1.Y);
	glVertex2f(p2.X , p2.Y);
	glVertex2f(p3.X , p3.Y);
	glEnd();
}

inline Ponto SplineIterator(Ponto a , Ponto b, float t) {
	Ponto p;
	p.X = a.X + (b.X - a.X) * t;
	p.Y = a.Y + (b.Y - a.Y) * t;
	return p;
}

inline void desenhaSpline(int qtdPontosSpline, Ponto p1 , Ponto p2 , Ponto p3 , Ponto p4) {
	float incT = 1.0f / qtdPontosSpline;
	float t;
	Ponto p1p2, p2p3, p3p4, p1p2p3, p2p3p4, p1p2p3p4, p0;

	glColor3f(1.0, 1.0, 0.0);
	glLineWidth(4.0f);

	for(t = 0; t <= 1.000001; t += incT) {
		p1p2     = SplineIterator(p1, p2, t);
		p2p3     = SplineIterator(p2, p3, t);
		p3p4     = SplineIterator(p3, p4, t);
		p1p2p3   = SplineIterator(p1p2, p2p3, t);
		p2p3p4   = SplineIterator(p2p3, p3p4, t);
		p1p2p3p4 = SplineIterator(p1p2p3, p2p3p4, t);

		// A primeira vez nao desenha, pois preciso definir o segundo ponto ainda.
		if(t != 0) {
			glBegin(GL_LINES);
			glVertex2f(p0.X, p0.Y);
			glVertex2f(p1p2p3p4.X, p1p2p3p4.Y);
			glEnd();
		}

		p0.X = p1p2p3p4.X;
		p0.Y = p1p2p3p4.Y;
	}
}


inline void desenhaRetangulo(BBox bbox) {
	glBegin(GL_LINE_LOOP);
	// Linha inferior.
	glVertex2f(bbox.minX , bbox.minY);
	// Linha lateral esquerda.
	glVertex2f(bbox.minX, bbox.maxY);
	// Linha superior.
	glVertex2f(bbox.maxX, bbox.maxY);
	// Linha lateral direita.
	glVertex2f(bbox.maxX , bbox.minY);
	glEnd();
}

#endif /* N2UTILS_HPP_ */
