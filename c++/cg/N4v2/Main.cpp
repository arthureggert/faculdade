#define _USE_MATH_DEFINES

#include <cctype> 

#include "Atomo.hpp"

#include <math.h>
#include <list>
#include <GL/glut.h>
#include <GL/glu.h>
#include <GL/gl.h>
#include <string>

#ifndef RAS_DEG_TO_RAD
    #define RAS_DEG_TO_RAD 0.017453292519943295769236907684886
#endif

GLint mainWindow = 0;

GLint windowWidth  = 500, windowHeight = 500;

double xEye, yEye, zEye;
double xCenter, yCenter, zCenter;

const double xUp = 0.0f, yUp = 1.0f, zUp = 0.0f;

static GLfloat WHITE[] = { 1.0f, 1.0f, 1.0f};

Atomo atom = Atomo(15, 16, 15);

void init(void) {
	glClearColor(0.0f,0.0f,0.0f,1.0);

	xEye = 90.0f;
	yEye = 50.0f;
	zEye = 20.0f;

	xCenter = 0.0f;
	yCenter = 0.0f;
	zCenter = 0.0f;

  glEnable(GL_DEPTH_TEST);
  glLightfv(GL_LIGHT0, GL_DIFFUSE, WHITE);
  glLightfv(GL_LIGHT0, GL_SPECULAR, WHITE);
  glMaterialfv(GL_FRONT, GL_SPECULAR, WHITE);
  glMaterialf(GL_FRONT, GL_SHININESS, 30);
  glEnable(GL_LIGHTING);
  glEnable(GL_LIGHT0);
}

void resize(int w, int h) {
	glutPostRedisplay();
}

void setCamera() {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(60, 1, 0.1, 300);

	gluLookAt(xEye, yEye, zEye, xCenter, yCenter, zCenter, xUp, yUp, zUp);
	glMatrixMode(GL_MODELVIEW);
}

void keyPressed(unsigned char key, GLint x, GLint y) {

	key = toupper(key);

	switch (key) {
	case 27:
		exit(EXIT_SUCCESS);
		break;
	case 'W':
		xEye++;
		break;

	case 'Q':
		xEye--;
		break;

	case 'E':
		yEye++;
		break;
	case 'D':
		yEye--;
		break;

	case 'Z':
		zEye++;
		break;

	case 'X':
		zEye--;
		break;

	default:
		printf("erro");
		break;
	}
	glutPostRedisplay();    
}

void animate(void) {
	atom.anima();

	glutPostRedisplay();    
}

void draw(void) {

	setCamera();
	glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glLoadIdentity ();

	atom.desenha();

	glFlush();
	glutSwapBuffers();
}

int main (int argc, const char * argv[]) {
	glutInit(&argc, (char **)argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowPosition (300, 250);
	glutInitWindowSize (windowWidth, windowHeight);
	mainWindow = glutCreateWindow("CG N4 - Arthur");
	init();

	glutReshapeFunc(resize);
	glutDisplayFunc(draw);
	glutKeyboardFunc(keyPressed);
	glutIdleFunc(animate);
	glutMainLoop();

	return 0;
}
