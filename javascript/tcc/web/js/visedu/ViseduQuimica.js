$(function () {
    'use strict';

    var utilitario = new Utilitario();

    var desenho2d = new FormulaEstruturalDrawer('canvasDesenho',
        function (atomoId) {
            var idAtomo = '#' + atomoId;
            $(idAtomo).prop('disabled', true);
        }, function (modoLigacao, idAtomo, idAtomo2) {
            molecula.criaLigacao(idAtomo, idAtomo2, modoLigacao);
        });

    desenho2d.inicializa();

    var formulaQuimicaParser = new FormulaQuimicaParser();

    var molecula = new Molecula();

    var desenho3d = DesenhaMolecula3D;

    desenho3d.inicializa($('#divResultado').width(), $('#divResultado').height(), $('#canvasResultado'));

    var formulaParseada = [];

    $('#btn_submit_fq').on('click', function () {
        if (formulaParseada.length === 0) {
            try {
                formulaParseada = formulaQuimicaParser.parse($('#formula_quimica').val());
                utilitario.criaListaElementosTela(formulaParseada);
            } catch (e) {
                alert(e);
            }
        } else {
            if (confirm("Lista de Elementos já foi preenchida, deseja reiniciar o processo!?")) {
                molecula = new Molecula();
                utilitario.limpaElementos();
                desenho2d.limpaCanvas();
                desenho3d.limpaCanvas();
                formulaParseada = formulaQuimicaParser.parse($('#formula_quimica').val());
                utilitario.criaListaElementosTela(formulaParseada);
            }
        }
    });

    $('#listaElementos').on('click', '.elementoQuimico', function () {
        var atomo = molecula.adicionaAtomo(this.id, $(this).text());
        desenho2d.setAtomoCorrente(atomo);
    });

    $('#listaElementos').on('click', '.tipoLigacao', function () {
        if (this.id === 'ligacaoSimples') {
            desenho2d.setModoLigacao(ModoLigacao.SIMPLES);
        } else {
            desenho2d.setModoLigacao(ModoLigacao.DUPLA);
        }
    });

    $('#btn_gera3d').on('click', function () {
        try {
            molecula.identificaTipoLigacoes();
            molecula.calculaRegraDoOcteto();
            molecula.valida(formulaParseada.length);
            desenho3d.desenhaMolecula(molecula);
        } catch (e) {
            console.log(e);
            alert(e);
        }
    });

    $('#btn_disable_rg8').on('click', function() {
        molecula.setValidaRegraDoOcteto(!molecula.getValidaRegraDoOcteto);
    })

});