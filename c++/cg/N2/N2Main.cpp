#include <iostream>
#include <sstream>
#include <string>
//#include "N2Exercise1.hpp"
//#include "N2Exercise2.hpp"
//#include "N2Exercise3.hpp"
//#include "N2Exercise4.hpp"
//#include "N2Exercise5.hpp"
//#include "N2Exercise6.hpp"
#include "N2Exercise7.hpp"
//N2Exercise1 n2;
//N2Exercise2 n2;
//N2Exercise3 n2;
//N2Exercise4 n2;
//N2Exercise5 n2;
//N2Exercise6 n2;
N2Exercise7 n2;
using namespace std;

void display();

void initialize();

void keyboard(unsigned char key, int x, int y);

void mouse(int button , int state , int x , int y);

void motion(int x , int y);

int main(int argc, char **argv) {

	try {
		glutInit(&argc, argv);
		glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE | GLUT_DEPTH);

		glutInitWindowPosition(300, 250);

		glutInitWindowSize(n2.getWidth() , n2.getHeight());

		std::stringstream sstm;
		sstm << "CG - N2 by AHEggert [Exercise " << n2.getExerciseNumber() << "]";
		std::string title = sstm.str();

		glutCreateWindow(title.c_str());
		glutDisplayFunc(display);
		glutKeyboardFunc(keyboard);
		glutMotionFunc(motion);
		glutMouseFunc(mouse);
		initialize();

		glutMainLoop();
	} catch (...) {
		cout << "EXCEPTION" << endl;
	}


	return 0;
}


void display() {
	n2.display();
}

void initialize() {
	n2.initialize();
}

void keyboard(unsigned char key, int x, int y) {
	n2.keyboard(key,x,y);
}

void mouse(int button , int state , int x , int y) {
	//n2.mouse(button , state , x , y);
}

void motion(int x , int y) {
	//n2.motion(x , y);
}
