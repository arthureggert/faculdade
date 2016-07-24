function Atomo(pId, elemento) {

    var self = this;

    var id = pId;

    var cor = elemento.cor;

    var nome = elemento.nome;

    var simbolo = elemento.sigla;

    var estadosOxidacao = elemento.nox;

    var configuracaoEletronica = elemento.configuracaoEletronica;

    var eletronegatividade = elemento.eletronegatividade;

    var eletrons = elemento.eletrons;

    var numeroAtomico = elemento.numeroAtomico;

    var buscaGrupoElementoQuimico = function (grupo) {

        switch (grupo) {

            case 'Gases Nobres':
                return GrupoElemento.GASES_NOBRES;
                break;

            case 'Hidrogênio':
                return GrupoElemento.HIDROGENIO;
                break;

            case 'Metais Alcalinos':
                return GrupoElemento.METAIS_ALCALINOS;
                break;

            case 'Metais Alcalinos Terrosos':
                return GrupoElemento.METAIS_ALCALINOS_TERROSOS;
                break;

            case 'Metais de Transição':
                return GrupoElemento.METAIS_TRANSICAO;
                break;

            case 'Metais de Transição Interna':
                return GrupoElemento.METAIS_TRANSICAO_INTERNA;
                break;

            case 'Não Metais':
                return GrupoElemento.NAO_METAIS;
                break;

            case 'Outros Metais':
                return GrupoElemento.OUTROS_METAIS;
                break;
        }
    };

    var grupo = buscaGrupoElementoQuimico(elemento.grupo);

    var qtdLigacoes = 0;

    var visitado = false;

    var posicionado = false;

    var ponto3D = null;

    var calculaEletronsCamadaValencia = function (eletrons) {
        for (var i = 0; i < eletrons.length; i++) {
            var eletron = eletrons[i];
            if (eletron === 0) {
                return eletrons[i - 1];
            }
        }
    };

    var qtdEletronsCamadaValencia = calculaEletronsCamadaValencia(elemento.eletrons);

    var qtdEletronsLivresCamadaValencia = qtdEletronsCamadaValencia;

    var pnl = qtdEletronsCamadaValencia;

    var pl = 0;

    var biMolecular = false;

    self.getId = function () {
        return id;
    };

    self.getCor = function () {
        return cor;
    };

    self.getCorAsRGB = function () {
        return 'rgb(' + cor[0] + ',' + cor[1] + ',' + cor[2] + ')';
    };

    self.getSimbolo = function () {
        return simbolo
    };

    self.getEletronegatividade = function () {
        return eletronegatividade;
    };

    self.getGrupo = function () {
        return grupo;
    };

    self.getQtdLigacoes = function () {
        return qtdLigacoes;
    };

    self.incrementaQtdLigacoes = function () {
        qtdLigacoes++;
    };

    self.getQtdEletronsLivresCamadaValencia = function () {
        return qtdEletronsLivresCamadaValencia
    };

    self.decrementaQtdEletronsLivresCamandaValencia = function () {
        qtdEletronsLivresCamadaValencia--;
    };

    self.incrementaQtdEletronsLivresCamandaValencia = function () {
        qtdEletronsLivresCamadaValencia++;
    };

    self.isVisitado = function () {
        return visitado;
    };

    self.setVisitado = function (pVisitado) {
        visitado = pVisitado;
    };

    self.isPosicionado = function () {
        return posicionado;
    };

    self.setPosicionado = function (pPosicionado) {
        posicionado = pPosicionado;
    };

    self.incrementaPl = function () {
        pl++;
    };

    self.decrementaPnl = function () {
        pnl--;
    };

    self.getPl = function () {
        return pl;
    };

    self.getPnl = function () {
        var tmp = (pnl / 2) | 0;
        if (tmp < 0) {
            return pnl;
        }
        return tmp;
    };

    self.getNct = function () {
        return self.getPl() + self.getPnl();
    };

    self.setPonto3D = function (pPonto3D) {
        ponto3D = pPonto3D;
    };

    self.getPonto3D = function () {
        return ponto3D;
    };

    self.setBiMolecular = function (pBiMolecular) {
        biMolecular = pBiMolecular;
    };

    self.isBiMolecular = function () {
        return biMolecular;
    };

    self.getValorEletronsRegraDoOcteto = function () {
        var value = estadosOxidacao[0] < 0 ? estadosOxidacao[0] * -1 : estadosOxidacao[0];
        switch (simbolo) {
            case "Be":
            case "B":
            case "Al":
                return 6;
            case "P":
                return 10;
            case"S":
                return 12;
            case "N":
                return 7;
            default:
                return qtdEletronsCamadaValencia + value;
        }
    };

    self.getTipoGeometria = function () {
        //console.log(self.getSimbolo());
        //console.log('PNL Original: ' + pnl);
        //console.log('PNL: ' + self.getPnl());
        //console.log('PL: ' + self.getPl());
        //console.log('NCT: ' + self.getNct());
        if (self.isBiMolecular()) {
            return TipoGeometriaMolecular.Linear;
        }
        if (self.getPnl() === 0) {
            switch (self.getNct()) {
                case 1:
                    return TipoGeometriaMolecular.Linear;
                case 2:
                    return TipoGeometriaMolecular.Linear;
                case 3:
                    return TipoGeometriaMolecular.TrigonalPlana;
                case 4:
                    return TipoGeometriaMolecular.Tetraedrica;
                case 5:
                    return TipoGeometriaMolecular.BiPiramedeTrigonal;
                case 6:
                    return TipoGeometriaMolecular.Octaedrica;
                case 7:
                    return TipoGeometriaMolecular.BiPiramidePentagonal;

            }
        } else if (self.getPnl() === 1) {
            switch (self.getNct()) {
                case 3:
                    return TipoGeometriaMolecular.Angular;
                case 4:
                    return TipoGeometriaMolecular.PiramedeTrigonal;
                case 5:
                    return TipoGeometriaMolecular.Gangora;
                case 6:
                    return TipoGeometriaMolecular.PiramedeBaseQuadrada;
            }
        } else if (self.getPnl() === 2) {
            switch (self.getNct()) {
                case 4:
                    return TipoGeometriaMolecular.Angular;
                case 5:
                    return TipoGeometriaMolecular.FormaDeT;
                case 6:
                    return TipoGeometriaMolecular.QuadradoPlanar;
            }
        } else if (self.getPnl() === 3) {
            switch (self.getNct()) {
                case 5:
                    return TipoGeometriaMolecular.Linear;
            }
        }
    }

}