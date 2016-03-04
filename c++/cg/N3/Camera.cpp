#include "Camera.hpp"

Camera::Camera() {
	minX = -250;
	minY = -250;
	maxX = 250;
	maxY = 250;
	canvasW = 500;
	canvasH = 500;
}

void Camera::zoomIn() {
	if (largura() > 20) {
		minX += 2.5;
		minY += 2.5;

		maxX -= 2.5;
		maxY -= 2.5;
	}
}

void Camera::zoomOut() {
	minX -= 2.5;
	minY -= 2.5;

	maxX += 2.5;
	maxY += 2.5;
}

double Camera::altura() const {
	return maxY - minY;
}

double Camera::largura() const {
	return maxX - minX;
}



