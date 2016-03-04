/**
 * @file Camera.hpp
 * @brief Definição de Camera
 */

#ifndef CAMERA_HPP
#define CAMERA_HPP

/**
 * @brief A camera da cena grafica
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 */

class Camera {
public:
	double minX, minY, maxX, maxY;

	int canvasW , canvasH;

	/**
	 * Cria um novo Mundo gráfico
	 */
	Camera();

	/**
	 * Aplica o zoomIn na camera
	 **/
	void zoomIn();

	/**
	 * Aplica o zoomOut na camera
	 **/
	void zoomOut();

	/**
	 * A altura do mundo
	 **/
	double altura() const;

	/**
	 * A largura do mundo
	 **/
	double largura() const;


};


#endif
