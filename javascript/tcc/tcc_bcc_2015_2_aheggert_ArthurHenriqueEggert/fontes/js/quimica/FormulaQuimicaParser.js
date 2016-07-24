function FormulaQuimicaParser() {

    var self = this;

    var isElementoQuimicoValido = function (simbolo) {
        return _.includes(ElementosQuimicos.SIGLAS, simbolo);
    };

    self.parse = function (formula) {
        var formulaSplited;
        var elementos = [];

        if (formula) {
            formulaSplited = formula.split(/(?=[A-Z])/);

            formulaSplited.forEach(function (elemento) {

                var elementoSplited, elementoQuimico, qtdElemento;
                elementoSplited = elemento.split(/(?=[0-9])/);
                elementoQuimico = _.get(elementoSplited, 0);
                qtdElemento = _.get(elementoSplited, 1, 1);
                for (var i = 2; i < elementoSplited.length; i++) {
                    qtdElemento += _.get(elementoSplited, 2, 1);
                }

                if (isNaN(qtdElemento)) {
                    throw new EvalError('Elemento Químico ' + elementoQuimico + ' com quantidade inválida ' +
                        '(' + qtdElemento + ')');
                } else {
                    if (isElementoQuimicoValido(elementoQuimico) === true) {
                        for (i = 0; i < parseInt(qtdElemento); i++) {
                            elementos.push({sigla: elementoQuimico});
                        }
                    } else {
                        throw new EvalError('Elemento Químico ' + elementoQuimico + ' não encontrado!');
                    }
                }
            });
        } else {
            throw new EvalError('Valor não pode ser nula/branco')
        }
        return elementos;
    };

}