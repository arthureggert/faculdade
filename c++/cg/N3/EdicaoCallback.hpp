/**
 * @file EdicaoCallback.hpp
 * @brief Definição do estado de edição
 */

#ifndef EDICAO_CALLBACK_HPP
#define EDICAO_CALLBACK_HPP

#include "AbstractCallback.hpp"
#include "ObjetoGrafico.hpp"
#include "Mundo.hpp"
#include "Ponto.hpp"

/**
 * @brief Estado da aplicação com relação aos momentos de edição
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 **/
class EdicaoCallback : public AbstractCallback {
private:
	typedef AbstractCallback base;
	ObjetoGrafico* objetoCorrente;
	Ponto* pontoCorrente;
	char transformacao;
	void translate(int key);
	void rotate(int key);
	void scale(int key);
public:
	EdicaoCallback(Mundo& mundo);
	virtual void keyboard(unsigned char key, const Ponto& point);
	virtual void mouse(int button, int state, const Ponto& point);
	virtual void movimentoMouse(const Ponto& point);
	virtual void special(int key, const Ponto& point);
};

#endif
