/**
 * @file Utils.hpp
 * @brief Funções que podem ser reutilizadas
 */

#ifndef UTILS_HPP
#define UTILS_HPP

#include "BBox.hpp"
#include "ObjetoGrafico.hpp"
#include "Ponto.hpp"
#include "Camera.hpp"

	/**
     * Cria uma representação grafica da BBox
     **/
    ObjetoGrafico bboxToObjeto(const BBox& bbox);

    /**
     * Cria um objeto grafico com os eixos
     */
    ObjetoGrafico eixosReferenciaAsObjetoGrafico();

    /**
     * Calcula a distancia **ao quadrado** entre dois pontos.
     */
    double dist(const Ponto& lhs, const Ponto& rhs);

    /**
     * Obtem uma instancia da camera para o mundo
     */
    Camera obtemCamera();

#endif
