/**
 * @file ObjetoGrafico.hpp
 * @brief Definição de Ojeto Gráfico.
 */

#ifndef OBJETOGRAFICO_HPP
#define OBJETOGRAFICO_HPP

#include "BBox.hpp"
#include "Cor.hpp"
#include "Ponto.hpp"
#include "Transformacao.hpp"

#include <vector>

#include <GL/gl.h>
#include <GL/glut.h>
using namespace std;

/**
 * @brief Um Objeto Grafico do mundo
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 *
 * Um Objeto Grafico que matem responsabilidade sobre sua cor, filhos, transformação
 * e bbox
 */
class ObjetoGrafico {
private:
	Cor cor;

	Transformacao transformacao;

	BBox bbox;

	vector<ObjetoGrafico> filhos;

	vector<Ponto> pontos;

	bool selecionado;

	GLenum primitivaGrafica;

public:
	/**
	 * Cria um novo ObjetoGrafico
	 **/
	ObjetoGrafico();

	/**
	 * Renderiza o obejto e seus filhos
	 **/
	void renderizar() const;

	/**
	 * Adiciona um ponto ao objeto
	 **/
	void adicionaPonto(const Ponto& ponto);

	/**
	 * Adiciona um ponto falso, assim o usuario pode ver o que ocorre ao adicionar este ponto
	 **/
	void adicionaPontoFalso(const Ponto& ponto);

	/**
	 * Remove o ultimo ponto falso.
	 **/
	void removePontoFalso();

	/**
	 * Adiciona um obejto filho ao objeto.
	 **/
	void adicionaObjetoFilho(const ObjetoGrafico& objeto);

	/**
	 * Seta a cor do Objeto Grafico.
	 */
	void setCor(const Cor& cor);

	/**
	 * Seta o objeto como selecionado
	 **/
	void seleciona();

	/**
	 * Deseleciona o Objeto Grafico
	 **/
	void deseleciona();

	/**
	 * Retorna o objeto selecionado, se ele ou um dos filhos estiver selecionado
	 * Retorna nullptr nos demais casos
	 **/
	ObjetoGrafico* objetoSelecionado();

	/**
	 * Reseta a matriz de transformação do objeto
	 **/
	void resetaTransformacao();

	/**
	 * Aplica um trnaformação
	 **/
	void aplicaTransformacao(const Transformacao& transformacao);

	/**
	 * Muda a primitiva grafica para identificar um poligono aberto ou fechado
	 */
	void mudaPoligonoAbertoOuFechado();

	/**
	 * Remove o ponto recebido por paramentro
	 **/
	void removePonto(const Ponto& ponto);

	/**
	 * Remove o objeto filho igual ao recebido via parametro
	 **/
	void removeFilho(const ObjetoGrafico& filho);

	/**
	 * Retorna um ponto proximo ao ponto passado por parametro.
	 **/
	Ponto* pontoProximo(const Ponto& ponto);

	/**
	 * Redesenha a BBox quando um ponto do objeto foi alterado.
	 **/
	void redesenhaBBox();

	/**
	 * Verifica se o ponto recebido esta dentro do objeto.
	 **/
	ObjetoGrafico* contem(const Ponto& ponto);

	/**
	 * Compara dois obejtos.
	 */
	bool operator ==(const ObjetoGrafico& objeto);

	/**
	 * O Centro do objeto grafico
	 */
	Ponto centroObjetoGrafico() const;
};

#endif
