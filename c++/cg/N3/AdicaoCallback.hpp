/**
 * @file AdicaoCallback.hpp
 * @brief Definição do estado de adição
 */

#ifndef ADICAO_CALLBACK_STATE_HPP
#define ADICAO_CALLBACK_STATE_HPP

#include "AbstractCallback.hpp"
#include "ObjetoGrafico.hpp"
#include "Mundo.hpp"

/**
 * @brief Estado da aplicação com relação aos momentos de adição
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 */
class AdicaoCallback : public AbstractCallback {
private:
	typedef AbstractCallback base;

	ObjetoGrafico* objetoCorrente;
public:
	AdicaoCallback(Mundo& mundo);

	virtual void keyboard(unsigned char key, const Ponto& point);
	virtual void mouse(int button, int state, const Ponto& point);
	virtual void movimentoMouse(const Ponto& point);
	virtual void special(int key, const Ponto& point);
};

#endif
