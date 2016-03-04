/**
 * @file Mundo.hpp
 * @brief Definição de Mundo par o Trabalho N3 de CG.
 */

#ifndef MUNDO_HPP
#define MUNDO_HPP

#include "ObjetoGrafico.hpp"
#include "Camera.hpp"

#include <vector>

using namespace std;

class Ponto;

/**
 * @brief O Universo gráfico.
 * @author Arthur Henrique Eggert
 * @date 2014-09-21
 *
 * O Mundo ou Universo Gráfico, mantem as informações sobre todos os
 * ObjetosGraficos e sobre a Camera
 **/
class Mundo {
private:

	Camera camera;

	vector<ObjetoGrafico> objetosGraficos;

	ObjetoGrafico* rascunho;

	ObjetoGrafico eixosReferencia;

public:
	/**
	 * Cria um novo Mundo gráfico
	 */
	Mundo();

	/**
	 * Renderiza todos os objetosgraficos da cena
	 **/
	void render() const;

	/**
	 * A altura do mundo
	 **/
	double altura() const;

	/**
	 * A largura do mundo
	 **/
	double largura() const;

	/**
	 * Retona a camera do mundo
	 */
	Camera getCamera();

	/**
	 * Normaliza um ponto de acordo com o tamanho da tela e o zoom da camera.
	 **/
	Ponto normalizar(int x, int y);

	/**
	 * Cria um novo rascunho de ObjetoGrafico e retorna o mesmo.
	 **/
	ObjetoGrafico* criaObjetoGrafico();

	/**
	 * Adiciona o rascunho a lista de objetos graficos
	 **/
	void adicionaObjetoGrafico();

	/**
	 * Retorna o objeto grafico sobre um determinado ponto. Pode
	 * retorna um nullptr se nenhum objeto estiver selecionado
	 */
	ObjetoGrafico* objetoGraficoNoPonto(const Ponto& ponto);

	/**
	 * Remove o objeto grafico passado por paramentro
	 **/
	void removerObjetoGrafico(const ObjetoGrafico& object);

};

#endif
