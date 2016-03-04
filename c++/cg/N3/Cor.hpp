/**
 * @file Cor.hpp
 * @brief Definição de Cor
 */

#ifndef COR_HPP
#define COR_HPP

/**
 * @brief Uma cor RGB
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 *
 * Representa um cor RGB
 */
class Cor {
public:
	float r, g, b;

	/**
	 * Cria um objeto de Cor (0,0,0 - Preto)
	 **/
	Cor();

	/**
	 * Cria um objeto com com os valores passados
	 **/
	Cor(float r, float g, float b);

	/**
	 * Retona as cores em um array de float
	 **/
	const float* getData() const;

	/**
	 * Cria um cor randomica.
	 */
	static Cor random();
};

const Cor PRETO(0.0f, 0.0f, 0.0f);
const Cor BRANCO(1.0f, 1.0f, 1.0f);

const Cor VERMELHO(1.0f, 0.0f, 0.0f);
const Cor VERDE(0.0f, 1.0f, 0.0f);
const Cor AZUL(0.0f, 0.0f, 1.0f);

const Cor AMARELO(1.0f, 1.0f, 0.0f);
const Cor ROSA(1.0f, 0.0f, 1.0f);
const Cor CYAN(0.0f, 1.0f, 1.0f);

#endif
