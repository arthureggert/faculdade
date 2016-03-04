/**
 * @file BBox.hpp
 * @brief Definição da BBox.
 */

#ifndef BBOX_HPP
#define BBOX_HPP

#include "Ponto.hpp"

#include <vector>

using namespace std;

/**
 * @brief Uma BoundingBox usada para delimitar um objeto gáfico
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 **/
class BBox {
public:

	Ponto min, max;

	/**
	 * O centro da BBox
	 **/
	Ponto centro() const;

	/**
	 * Altera a bbox para que a mesma se ajuste ao pontos passados via parametro
	 */
	void redesenha(const vector<Ponto>& pontos);

	/**
	 * Checa se o ponto esta dentro da BBox
	 */
	bool contem(const Ponto& ponto) const;
};

/**
 * Compara 2 BBox.
 */
bool operator ==(const BBox& essa, const BBox& outra);


#endif
