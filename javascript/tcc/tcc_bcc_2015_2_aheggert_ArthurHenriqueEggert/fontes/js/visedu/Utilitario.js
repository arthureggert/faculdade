function Utilitario() {

    var self = this;

    self.criaListaElementosTela = function (formulaParseada) {
        var liElementos, i, j, counter;
        liElementos = $('#listaElementos').append('<button id="ligacaoSimples" class="btn btn-primary tipoLigacao col-xs-6" type="button"> | </button>');
        liElementos = $('#listaElementos').append('<button id="ligacaoDupla" class="btn btn-primary tipoLigacao col-xs-6" type="button"> || </button>');

        for (i = 0; i < formulaParseada.length; i++) {
            var tmp = _.get(formulaParseada, i);
            liElementos = $('#listaElementos').append('<button id="' + i + '"class="btn btn-default elementoQuimico col-xs-3" type="button">' + tmp.sigla + '</button>');
        }
    };

    self.limpaElementos = function () {
        $('#listaElementos').html('');
    };
}