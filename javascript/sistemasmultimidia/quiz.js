function GerenciadorPontuacao(idJogadores) {

    this.jogadores = idJogadores;
    this.respostasJogadores = [];
    this.pontuacao = null;

    this.pontuacao = [];
    for (var i = 0; i < this.jogadores.length; i++) {
        this.pontuacao[this.jogadores[i]] = 0;
    }

    this.adicionarResposta = function (idJogador, objPergunta, resposta) {
        var result = $.grep(this.respostasJogadores, function (e) {
            if(objPergunta == null) {
                return;
            }
            return e.jogador == idJogador && e.codigoPergunta == objPergunta.Codigo; 
        });

        if (result.length > 0)
            return false;

        console.log('Resposta correta: ' + objPergunta.Pergunta + '   Resposta escolhida: ' + resposta);
        console.log(objPergunta.Pergunta != resposta);
        if (objPergunta.Pergunta != resposta) {
        //    //console.log('Resposta incorreta, pontuacao extra para outro jogador.');
            this.adicionarPontoExtra(idJogador, 2);
            return false;
        }

        this.respostasJogadores.push({ jogador: idJogador, codigoPergunta: objPergunta.Codigo });
        this.pontuacao[idJogador] += 3;
        return true;
        //this.contabilizarPontuacao(); // Apenas ir� ordenar descendente
    };

    this.adicionarPontoExtra = function (idJogador, qtdePontos) {
        //this.pontosExtras.push({ jogador: idJogador, pontos: qtdePontos });
        if(idJogador == "esquerda") {
            this.pontuacao["direita"] += qtdePontos;
        } else {
            this.pontuacao["esquerda"] += qtdePontos;
        }

        //this.pontuacao[idJogador] += qtdePontos;
        //this.contabilizarPontuacao(); // Apenas ir� ordenar descendente
    };

    this.getJogadorVencedor = function () {
        // Inicializar array de pontuacao
        var resultado = [];
        for (var i = 0; i < this.jogadores.length; i++)
            resultado[this.jogadores[i]] = 0;
        // Incrementa respostas dos jogadores
        for (var i = 0; i < this.respostasJogadores.length; i++) {
            resultado[this.respostasJogadores[i].jogador] += 1;
        }
        // Adicionar pontos extras
        for (var i = 0; i < this.pontosExtras.length; i++) {
            resultado[this.pontosExtras[i].jogador] += this.pontosExtras[i].pontos;
        }
        // Buscar o id do jogador que obteve maior pontuacao (nao verificado empate)
        var idJogadorMaiorPontuacao = -1;
        var maiorPontuacao = -1;

        for (var i = 0; i < this.jogadores.length; i++) {
            if (maiorPontuacao < resultado[this.jogadores[i]]) {
                maiorPontuacao = resultado[this.jogadores[i]];
                idJogadorMaiorPontuacao = this.jogadores[i];
            }
        }
        
        return idJogadorMaiorPontuacao;
    };

    this.contabilizarPontuacao = function () {
        this.pontuacao.sort(function (obj1, obj2) {
            return obj2 - obj1; // Ordenar descendente
        });
    }
};

function GerenciadorPerguntas(jsonPerguntas) {

    this.perguntas = eval(jsonPerguntas);
    this.indexQuestaoAtual = -1;

    function getHTMLAlternativa(objResposta, id, lado, tipo) {
        if (tipo == 0)
            return "<tr>" +
                "<td style='height: 25%'>" +
                    "<div class='graph-content-"+lado+"'>" +
                        "<div class='graphobed_canvaswrap graph-"+lado+"' style='background:#FFF;'>" +
                            "<canvas id='canvas2d_" + id + "' class='graphobed graphobed_canvas' function='" + objResposta + "' width='200px' height='160px'></canvas>" +
                        "</div>" +
                    "</div>" +
                "</td>" +
            "</tr>";
        else
            return "<tr>" +
                "<td style='height: 25%'>" +
                    "<span function='" + objResposta + "' width='200px' height='160px'>"+objResposta+"</span>" +
                "</td>" +
            "</tr>";
    };

    this.atualizarDadosQuestao = function(obj) {
        var idAlternativa = 0;
        // Atualizar a quest�o de todos jogadores
        $('.question-left, .question-right').each(function (idxDiv, objDiv) {
            var lado = $(objDiv).attr('class').indexOf('right') > -1 ? 'right' : 'left';
            // Tipo 0 = Pergunta, Tipo 1 = Gr�fico
            if (obj.Tipo == 0)
                $(objDiv).html('Qual &eacute; o gr&aacute;fico gerado pela fun&ccedil;&atilde;o ' + obj.Pergunta + '?');
            else
                $(objDiv).html('Qual &eacute; a fun&ccedil;atilde;o gerado do gr&eacute;fico ' + getHTMLAlternativa(obj.Pergunta, idAlternativa, lado) + '?');

            idAlternativa++;
        });

        $('.table-respostas-left, .table-respostas-right').each(function (idxDiv, objTable) {
            // Limpar as questoes atuais
            $(objTable).empty();
            // Adicionar as alternativas da questao
            $.each(obj.Respostas, function (idxRes, objRes) {
                var lado = $(objTable).attr('class').indexOf('right') > -1 ? 'right' : 'left';
                $(objTable).append(getHTMLAlternativa(objRes, idAlternativa, lado, obj.Tipo));
                // incrementar o id do elemento canvas
                idAlternativa++;
            });
        });
    };
        
    this.atualizarQuestao = function () {

        this.indexQuestaoAtual++;
        if (this.indexQuestaoAtual >= this.perguntas.length)
            return;

        this.atualizarDadosQuestao(this.perguntas[this.indexQuestaoAtual]);
    };
};

