/**
 * @file Ponto.hpp
 * @brief Definicao de Ponto
 */

#ifndef AHE_PONTO_HPP
#define AHE_PONTO_HPP

/**
 * @brief Ponto 3D
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 *
 * Representa um ponto com 3 dimensões X, Y e Z, onde Z é sempre 1
 */
class Ponto {
public:
	double x, y, z, w;

	/**
	 * Creates a new point with coordinates (0, 0, 0, 1).
	 */
	Ponto();

	/**
	 * Creates a new point with coordinates (x, y, 0, 1).
	 */
	Ponto(double x, double y);

	/**
	 * Creates a new point with coordinates (x, y, z, 1).
	 */
	Ponto(double x, double y, double z);

    /**
     * Creates a new point with coordinates (x, y, z, w).
     */
	Ponto(double x, double y, double z, double w);
};

/**
 * Compara se dois pontos são iguais
 */
bool operator ==(const Ponto& este, const Ponto& outro);

/**
 * Inverte um ponto.
 */
Ponto operator -(const Ponto& ponto);

#endif
