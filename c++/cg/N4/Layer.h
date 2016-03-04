#define _USE_MATH_DEFINES

#include <math.h>
#include <vector>
#include "Electron.h"
#include "Transformer.h"
#include "point4d.h"

using namespace std;

class Layer {
private:
	vector<Electron> electrons;
	Transformer transformer;
	Point4D getPositionInOrbit(double rotationAngle, double raio, double orbitAngle);

	double radius;
	int electronsCount;
	int electronsInAtom;
	void drawOrbit(double orbitAngle);
	double toRadians(double angle);

public:

	Layer(){
		radius = 0;
		electronsInAtom = 0;
		electronsCount = 0;
	}

	Layer(int electronsInAtom, int electronsCount, double radius)
	{
		this->electronsInAtom = electronsInAtom;
		this-> radius = radius;

		for (int i = 0; i < electronsCount; i++)
			addElectron();
	}

	void addElectron();
	void draw();
	void moveElectrons();
};
