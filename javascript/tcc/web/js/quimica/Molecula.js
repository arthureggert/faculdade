function Molecula() {

    var self = this;

    var atomos = [];

    var ligacoes = [];

    var validaRegraOcteto = true;

    var adicionaLigacao = function (atomoUm, atomoDois, modoLigacao) {
        ligacoes.push(new Ligacao(atomoUm.getId(), atomoDois.getId(), modoLigacao));
        atomoUm.incrementaQtdLigacoes();
        atomoDois.incrementaQtdLigacoes();

        atomoUm.decrementaPnl();
        atomoUm.incrementaPl();
        atomoDois.decrementaPnl();
        atomoDois.incrementaPl();

        if (modoLigacao === ModoLigacao.DUPLA) {
            atomoUm.decrementaPnl();
            atomoDois.decrementaPnl();
        }
    };

    self.setValidaRegraDoOcteto = function (pValidaRegraDoOcteto) {
        validaRegraOcteto = pValidaRegraDoOcteto;
    };

    self.getValidaRegraDoOcteto = function () {
        return validaRegraOcteto;
    };

    self.criaLigacao = function (atomoOrigem, atomoDestino, modoLigacao) {
        var a1 = self.getAtomoPorId(atomoOrigem);
        var a2 = self.getAtomoPorId(atomoDestino);
        adicionaLigacao(a1, a2, modoLigacao);
    };

    self.inicializa = function () {
        atomos = [];
        ligacoes = [];
    };

    self.getAtomos = function () {
        return atomos;
    };

    self.getLigacoes = function () {
        return ligacoes;
    };

    self.setPonto3DAtomo = function (atomoId, ponto) {
        atomos.forEach(function (atomo) {
            if (atomo.getId() === atomoId) {
                atomo.setPonto3D(ponto);
            }
        })
    };

    self.getAtomoPorId = function (idDoAtomo) {
        for (var i = 0; i < atomos.length; i++) {
            var atomo = atomos[i];
            if (atomo.getId() === idDoAtomo) {
                return atomo;
            }
        }
    };

    self.adicionaAtomo = function (id, sigla) {
        var tmpElemento = ElementosQuimicos.ELEMENTOS[sigla];
        var atomo = new Atomo(id, tmpElemento);
        atomos.push(atomo);
        return atomo;
    };

    self.calculaRegraDoOcteto = function () {

        ligacoes.forEach(function (ligacao) {

            var origem = self.getAtomoPorId(ligacao.getAtomoOrigem());
            var destino = self.getAtomoPorId(ligacao.getAtomoDestino());

            if (ligacao.getTipoLigacao() === TipoLigacao.COVALENTE) {
                origem.incrementaQtdEletronsLivresCamandaValencia();
                destino.incrementaQtdEletronsLivresCamandaValencia();
                if (ligacao.getModoLigacao() === ModoLigacao.DUPLA) {
                    origem.incrementaQtdEletronsLivresCamandaValencia();
                    destino.incrementaQtdEletronsLivresCamandaValencia();
                }
            } else {
                if (ligacao.getTipoLigacao() === TipoLigacao.IONICA && ligacao.getModoLigacao() !== ModoLigacao.SIMPLES) {
                    throw new Error('Ligações Ionicas são sempre simples');
                } else {
                    if (origem.getEletronegatividade() > destino.getEletronegatividade()) {
                        origem.incrementaQtdEletronsLivresCamandaValencia();
                        destino.decrementaQtdEletronsLivresCamandaValencia();
                    } else {
                        origem.decrementaQtdEletronsLivresCamandaValencia();
                        destino.incrementaQtdEletronsLivresCamandaValencia();
                    }
                }
            }
        });
    };

    self.valida = function (qtdElementosFormula) {
        if (qtdElementosFormula != atomos.length) {
            throw new Error('Nem todos os elementos da formula fora utilizados![Qtd Elementos: ' + qtdElementosFormula +
                '] [Qtd Atomos: ' + atomos.length + ']');
        }

        atomos.forEach(function (atomo) {

            if (atomos.length === 2) {
                atomo.setBiMolecular(true);
            }

            var achou = false;
            ligacoes.forEach(function (ligacao) {
                if (ligacao.getAtomoOrigem() === atomo.getId() || ligacao.getAtomoDestino() === atomo.getId()) {
                    achou = true;
                }
                if (ligacao.getTipoLigacao() === TipoLigacao.IONICA && ligacao.getModoLigacao() !== ModoLigacao.SIMPLES) {
                    throw new Error('Ligações Ionicas são sempre simples');
                }
                if (ligacao.getTipoLigacao() === TipoLigacao.METALICA) {
                    throw new Error('Ligações Metálicas não são tratadas pelo aplicativo');
                }
            });
            if (validaRegraOcteto) {
                if (atomo.getQtdEletronsLivresCamadaValencia() !== 0) {
                    if (atomo.getValorEletronsRegraDoOcteto() !== atomo.getQtdEletronsLivresCamadaValencia()) {
                        throw new Error('Molécula não esta obedecendo a regra do octeto ' + '[ Atomo => ' + atomo.getSimbolo() +
                            ' Valor Regra do Octeto => ' + atomo.getValorEletronsRegraDoOcteto() + ' Eletrons Livres => ' +
                            atomo.getQtdEletronsLivresCamadaValencia() + ' ]')
                    }
                }
            }
            if (!achou) {
                throw new Error('Atomo ' + atomo.getSimbolo() + ' não é usado em nenhuma ligação![1]');
            }
            if (atomo.getQtdLigacoes() === 0) {
                throw new Error('Atomo ' + atomo.getSimbolo() + ' não é usado em nenhuma ligação![2]');
            }
        });
    };

    self.identificaTipoLigacoes = function () {
        ligacoes.forEach(function (ligacao) {

                var origem = self.getAtomoPorId(ligacao.getAtomoOrigem());
                var destino = self.getAtomoPorId(ligacao.getAtomoDestino());

                if ((origem.getGrupo() === GrupoElemento.METAIS_ALCALINOS || origem.getGrupo() === GrupoElemento.METAIS_ALCALINOS_TERROSOS)
                    && destino.getGrupo() === GrupoElemento.HIDROGENIO) {
                    if (origem.getEletronegatividade() > 1.0) {
                        ligacao.setTipoLigacao(TipoLigacao.COVALENTE);
                    } else {
                        ligacao.setTipoLigacao(TipoLigacao.IONICA);
                    }
                }
                if ((destino.getGrupo() === GrupoElemento.METAIS_ALCALINOS || destino.getGrupo() === GrupoElemento.METAIS_ALCALINOS_TERROSOS)
                    && origem.getGrupo() === GrupoElemento.HIDROGENIO) {
                    if (destino.getEletronegatividade() > 1.0) {
                        ligacao.setTipoLigacao(TipoLigacao.COVALENTE);
                    } else {
                        ligacao.setTipoLigacao(TipoLigacao.IONICA);
                    }
                }
                if (((origem.getGrupo() === GrupoElemento.NAO_METAIS || origem.getGrupo() === GrupoElemento.OUTROS_METAIS)
                    && destino.getGrupo() === GrupoElemento.HIDROGENIO) ||
                    ((destino.getGrupo() === GrupoElemento.NAO_METAIS || destino.getGrupo() === GrupoElemento.OUTROS_METAIS)
                    && origem.getGrupo() === GrupoElemento.HIDROGENIO)) {
                    ligacao.setTipoLigacao(TipoLigacao.COVALENTE);
                }
                if ((origem.getGrupo() === GrupoElemento.NAO_METAIS || origem.getGrupo() === GrupoElemento.OUTROS_METAIS)
                    && (destino.getGrupo() === GrupoElemento.NAO_METAIS || destino.getGrupo() === GrupoElemento.OUTROS_METAIS)) {
                    ligacao.setTipoLigacao(TipoLigacao.COVALENTE)
                }
                if (origem.getGrupo().grandeGrupo === GrandeGrupo.METAIS && destino.getGrupo().grandeGrupo === GrandeGrupo.METAIS) {
                    ligacao.setTipoLigacao(TipoLigacao.METALICA);
                }
                if ((origem.getGrupo().grandeGrupo === GrandeGrupo.METAIS && (destino.getGrupo() === GrupoElemento.OUTROS_METAIS
                    || destino.getGrupo() === GrupoElemento.NAO_METAIS)) ||
                    (destino.getGrupo().grandeGrupo === GrandeGrupo.METAIS && (origem.getGrupo() === GrupoElemento.OUTROS_METAIS
                    || origem.getGrupo() === GrupoElemento.NAO_METAIS))) {
                    if (origem.getEletronegatividade() - destino.getEletronegatividade() < 1.7
                        || destino.getEletronegatividade() - origem.getEletronegatividade() < 1.7) {
                        ligacao.setTipoLigacao(TipoLigacao.COVALENTE);
                    } else {
                        ligacao.setTipoLigacao(TipoLigacao.METALICA);
                    }
                }
                if (ligacao.getTipoLigacao() === null) {
                    throw Error('Tipo de Ligacação entre ' + origem.getSimbolo() + ' e ' + destino.getSimbolo() + ' não existe!');
                }
            }
        );
    };

    self.getAtomosPorQtdLigacao = function () {
        var compareFunction = function (atomoUm, atomoDois) {
            if (atomoUm.getQtdLigacoes() < atomoDois.getQtdLigacoes()) {
                return 1;
            }
            if (atomoUm.getQtdLigacoes() > atomoDois.getQtdLigacoes()) {
                return -1
            }
            return 0;
        };

        return atomos.sort(compareFunction);
    };

    self.getLigacoesFromAtomo = function (atomo) {
        var ligacoesAtomo = [];
        ligacoes.forEach(function (ligacao) {
            if (ligacao.getAtomoOrigem() === atomo.getId() || ligacao.getAtomoDestino() === atomo.getId()) {
                ligacoesAtomo.push(ligacao);
            }
        });
        return ligacoesAtomo;
    };

    self.getAtomosVizinhosFromAtomo = function (atomo) {
        var atomosVizinhos = [];
        ligacoes.forEach(function (ligacao) {
            if (ligacao.getAtomoOrigem() === atomo.getId()) {
                atomosVizinhos.push(self.getAtomoPorId(ligacao.getAtomoDestino()));
            }
            if (ligacao.getAtomoDestino() === atomo.getId()) {
                atomosVizinhos.push(self.getAtomoPorId(ligacao.getAtomoOrigem()));
            }
        });
        return atomosVizinhos;
    };

    self.setAtomoVisitado = function (atomoId) {
        self.getAtomos().forEach(function (atomo) {
            if (atomo.getId() === atomoId) {
                atomo.setVisitado(true);
            }
        });
    };

    self.setAtomoPosicionado = function (atomoId) {
        self.getAtomos().forEach(function (atomo) {
            if (atomo.getId() === atomoId) {
                atomo.setPosicionado(true);
            }
        });
    };

}