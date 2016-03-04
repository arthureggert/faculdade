/**-
 * @file AbstractCallback.hpp
 * @brief Definição abstrata da classe da aplicação.
 */

#ifndef ABSTRACT_CALLBACK_HPP
#define ABSTRACT_CALLBACK_HPP

#include "Mundo.hpp"
#include "Ponto.hpp"

/**
 * @brief Classe abstrata para lidar com os eventos dependendo do estado
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 */
class AbstractCallback {

protected:

	Mundo& mundo;

public:
	/**
	 * Cria um estado para a manipulação do mundo grafico
	 */
	AbstractCallback(Mundo& mundo);

	/**
	 * Destroi este estado da aplicacao.
	 */
	virtual ~AbstractCallback();

	/**
	 * Faz o display do Mundo Grafico.
	 */
	virtual void display();

	/**
	 * Callback de Teclado
	 */
	virtual void keyboard(unsigned char key, const Ponto& point);

	/**
	 * Callback de Mouse
	 */
	virtual void mouse(int button, int state, const Ponto& point) = 0;

	/**
	 * Callback do movimento de mouse
	 */
	virtual void movimentoMouse(const Ponto& ponto) = 0;

	/**
	 * Callback do redimencionamento da tela
	 */
	virtual void reshape(int width, int height);

	/**
	 * Calbback para teclas especias do teclado
	 */
	virtual void special(int key, const Ponto& point) = 0;

private:

	//Bloqueando copia desta classe;
	AbstractCallback(const AbstractCallback& src) = delete;
	AbstractCallback& operator=(const AbstractCallback& src) = delete;
};

#endif
