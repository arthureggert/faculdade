#include "AbstractCallback.hpp"

#include "Ponto.hpp"
#include "Mundo.hpp"

#include <iostream>

using namespace std;

AbstractCallback::AbstractCallback(Mundo& mundo) : mundo(mundo) { }

AbstractCallback::~AbstractCallback() { }

void AbstractCallback::reshape(int width, int height) {
	cout << width << endl;
	cout << height << endl;

}

void AbstractCallback::display() {
	mundo.render();
}

void AbstractCallback::keyboard(unsigned char key, const Ponto& ponto) {
	cout << ponto.x << endl;

	switch (key) {
	case '-':
		mundo.getCamera().zoomOut();
		break;

	case '+':
		mundo.getCamera().zoomIn();
		break;
	}
}
