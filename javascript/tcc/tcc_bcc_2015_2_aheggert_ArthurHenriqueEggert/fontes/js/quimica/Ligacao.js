function Ligacao(atomoOrigem, atomoDestino, modoLigacao) {

    var self = this;

    var atomoOrigem = atomoOrigem;

    var atomoDestino = atomoDestino;

    var modoLigacao = modoLigacao;

    var tipoLigacao = null;

    self.getAtomoOrigem = function () {
        return atomoOrigem;
    };

    self.getAtomoDestino = function () {
        return atomoDestino;
    };

    self.getModoLigacao = function () {
        return modoLigacao;
    };

    self.getTipoLigacao = function () {
        return tipoLigacao;
    };

    self.setTipoLigacao = function (pTipoLigacao) {
        tipoLigacao = pTipoLigacao;
    }
}