/**
 * @file Transformacao.hpp
 * @brief Definição de Transformacao.
 */

#ifndef TRANSFORMACAO_HPP
#define TRANSFORMACAO_HPP

#include "Ponto.hpp"

/**
 * @brief Uma transformação linear
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 *
 * Uma transformacao linear usada para transladar, rotacioar ou escalar um objeto grafico.
 **/
class Transformacao {
private:
	double matrix[4][4];

public:
	/**
	 * Cria uma transformação
	 **/
	Transformacao();

	/**
	 * Retorna os dados da trnaforação como um array de double
	 **/
	const double* getData() const;

	/**
	 * Aplica a transofmração em um ponto.
	 **/
	Ponto operator *(const Ponto& ponto) const;

	/**
	 * Multiplica duas transformações
	 **/
	Transformacao operator *(const Transformacao& rhs) const;

	/**
	 * Cria um transformação de translação
	 **/
	static Transformacao translacao(const Ponto& translacao);

	/**
	 * * Cria um transformação de escala
	 */
	static Transformacao escala(double fatorDeX, double fatorDeY, double fatorDeZ);

	/**
	 * Cria um transformação de rotaçao no eixo X
	 */
	static Transformacao xRotacao(double rad);

	/**
	 * Cria um transformação de rotaçao no eixo Y
	 */
	static Transformacao yRotacao(double rad);

	/**
	 * Cria um transformação de rotaçao no eixo Z
	 */
	static Transformacao zRotacao(double rad);

};
#endif
