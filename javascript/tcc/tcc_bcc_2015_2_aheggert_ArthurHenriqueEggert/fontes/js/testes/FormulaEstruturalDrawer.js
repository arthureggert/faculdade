function FormulaEstruturalDrawer(canvasId, mouseUpCallback, mouseDownCallback) {

    var self = this;

    var canvas = new fabric.Canvas(canvasId, {selection: false});

    var atomoCorrente = null;

    var onMouseUpCallback = mouseUpCallback;

    var onMouseDownCallback = mouseDownCallback;

    var modoLigacao = null;

    var objetoCorrente = null;

    var objetoAnterior = null;

    var desenhaAtomo = function (ponto) {
        var color = fabric.Color.fromSource(atomoCorrente.getCor()).toHex();

        var atomo = new fabric.Circle({
            left: ponto.x,
            top: ponto.y,
            strokeWidth: 2,
            radius: 25,
            hasControls: false,
            fill: '#' + color,
            stroke: 'black',
            originX: 'center',
            originY: 'center',
            dados: [],
            atomoId: atomoCorrente.getId()
        });
        canvas.add(atomo);
    };

    var desenhaLigacaoSimples = function (coordenadas) {
        var line = new fabric.Line(coordenadas, {
            fill: 'black',
            stroke: 'black',
            strokeWidth: 3,
            selectable: false,
            originX: 'left',
            originY: 'center'
        });
        canvas.add(line);

        objetoCorrente.bringToFront();
        objetoAnterior.bringToFront();

        objetoCorrente.dados.push({linha: line, principal: true, ligacaoDupla: false});
        objetoAnterior.dados.push({linha: line, principal: false, ligacaoDupla: false});
    };

    var desenhaLigacaoDupla = function (coordenadas) {
        var line1 = new fabric.Line(coordenadas, {
            stroke: 'black',
            strokeWidth: 15,
            selectable: false,
            originY: 'center',
            originX: 'center'
        });

        var line2 = new fabric.Line(coordenadas, {
            stroke: 'white',
            strokeWidth: 10,
            selectable: false,
            originY: 'center',
            originX: 'center'
        });

        canvas.add(line1);
        canvas.add(line2);

        objetoCorrente.bringToFront();
        objetoAnterior.bringToFront();

        objetoCorrente.dados.push({linha: [line1, line2], principal: true, ligacaoDupla: true});

        objetoAnterior.dados.push({linha: [line1, line2], principal: false, ligacaoDupla: true});
    };

    var onMouseUp = function () {
        if (atomoCorrente) {
            var atomoId = atomoCorrente.getId();
            atomoCorrente = null;
            onMouseUpCallback(atomoId);
        }
    };

    var onMouseDown = function (evento) {
        if (self.isModoLigacao()) {
            if (objetoAnterior !== null && objetoCorrente != null) {
                if (_.isEqual(modoLigacao, ModoLigacao.SIMPLES)) {
                    desenhaLigacaoSimples([objetoAnterior.left, objetoAnterior.top, objetoCorrente.left, objetoCorrente.top]);
                } else {
                    desenhaLigacaoDupla([objetoAnterior.left, objetoAnterior.top, objetoCorrente.left, objetoCorrente.top])
                }
                onMouseDownCallback(modoLigacao, objetoCorrente.atomoId, objetoAnterior.atomoId);
                objetoAnterior = null;
                objetoCorrente = null;
                modoLigacao = null;
            }
        } else {
            if (atomoCorrente) {
                desenhaAtomo(canvas.getPointer(evento.e));
            }
        }
        canvas.renderAll();
    };

    var onObjectSelected = function (evento) {
        if (evento.target !== objetoCorrente) {
            objetoAnterior = objetoCorrente;
        }
        objetoCorrente = evento.target;
    };

    var onMoveObject = function (evento) {
        //var objeto = evento.target;
        //objeto.dados.forEach(function (dado) {
        //
        //    if (!dado.ligacaoDupla) {
        //        if (dado.principal) {
        //            dado.linha.set({'x1': dado.linha.x1, 'y1': dado.linha.y1, 'x2': objeto.left, 'y2': objeto.top});
        //        } else {
        //            dado.linha.set({'x1': objeto.left, 'y1': objeto.top, 'x2': dado.linha.x2, 'y2': dado.linha.y2});
        //        }
        //    } else {
        //        if (dado.principal) {
        //            dado.linha[0].set({
        //                'x1': dado.linha[0].x1,
        //                'y1': dado.linha[0].y1,
        //                'x2': objeto.left,
        //                'y2': objeto.top
        //            });
        //            dado.linha[1].set({
        //                'x1': dado.linha[1].x1,
        //                'y1': dado.linha[1].y1,
        //                'x2': objeto.left,
        //                'y2': objeto.top
        //            });
        //        } else {
        //            dado.linha[0].set({
        //                'x1': objeto.left,
        //                'y1': objeto.top,
        //                'x2': dado.linha[0].x2,
        //                'y2': dado.linha[0].y2
        //            });
        //            dado.linha[1].set({
        //                'x1': objeto.left,
        //                'y1': objeto.top,
        //                'x2': dado.linha[1].x2,
        //                'y2': dado.linha[1].y2
        //            });
        //        }ponto.y
        //    }
        //});
        //objeto.bringToFront();
        canvas.renderAll();
    };

    self.inicializa = function () {
        canvas.on('mouse:down', onMouseDown);
        canvas.on('mouse:up', onMouseUp);
        canvas.on('object:selected', onObjectSelected);
        canvas.on('object:moving', onMoveObject);

        for (var i = 0; i < 1280; i++) {
            var color = fabric.Color.fromSource([255, 255, 255]).toHex();
            var atomo = new fabric.Circle({
                left: i*Math.random(),
                top: i*Math.random(),
                strokeWidth: 2,
                radius: 25,
                hasControls: false,
                fill: '#' + color,
                stroke: 'black',
                originX: 'center',
                originY: 'center',
            });
            canvas.add(atomo);
        }
    };

    self.setAtomoCorrente = function (pAtomoCorrente) {
        modoLigacao = null;
        atomoCorrente = pAtomoCorrente;
    };

    self.setModoLigacao = function (pModoLigacao) {
        objetoAnterior = null;
        objetoCorrente = null;
        atomoCorrente = null;
        modoLigacao = pModoLigacao;
    };

    self.isModoLigacao = function () {
        return modoLigacao !== null;
    };

    self.canvasToJson = function () {
        return JSON.stringify(canvas);
    };

    self.limpaCanvas = function () {
        for (var i = 0; i < canvas.getObjects().length; i++) {
            var objeto = canvas.getObjects()[i];
            objeto.remove();
        }
        canvas.clear();
        canvas.renderAll();
        modoLigacao = null;
        atomoCorrente = null;
    };

}
