var DesenhaMolecula3D = new function () {

    var self = this;

    self.inicializa = function (width, height, elemento) {
        Game.loadAPI(new ThreeJSCustomHandler());
        window.addEventListener('resize', this.onResize, false);
        self.scene = new Scene().initialize();
        var defLight = ThreeJSBuilder.createAmbientLightObject(0xffffff /*,0x000000*/);
        self.scene.addLight(defLight);
        self.root = new Layer().initialize();
        self.scene.addLayer(self.root);
        Game.init(elemento, self.scene);
    };

    self.desenhaMolecula = function (molecula) {
        var x = 0;
        var y = 0;
        var z = 0;
        molecula.getAtomosPorQtdLigacao().forEach(function (atomo) {

            if (!atomo.isVisitado()) {
                var ligacoes = molecula.getLigacoesFromAtomo(atomo);
                var tipoGeometria = atomo.getTipoGeometria();
                if (tipoGeometria === null) {
                    throw new Error('Tipo da Geometria Molecular não encontrado!');
                }
                if (!atomo.isPosicionado()) {
                    var object = ThreeJSBuilder.createAtomObject(x, y, z, atomo.getCorAsRGB());
                    var posicao = new THREE.Vector3(x, y, z);
                    Game.apiHandler.addGameObject(object, self.scene);
                    atomo.setPonto3D(posicao);
                    atomo.setPosicionado(true);
                }
                atomo.setVisitado(true);

                x = atomo.getPonto3D().x;
                y = atomo.getPonto3D().y;
                z = atomo.getPonto3D().z;

                var countLigacoes = 0;
                ligacoes.forEach(function (ligacao) {
                    var outroAtomoId = atomo.getId() === ligacao.getAtomoOrigem() ? ligacao.getAtomoDestino() : ligacao.getAtomoOrigem();
                    var outroAtomo = molecula.getAtomoPorId(outroAtomoId);
                    if (!outroAtomo.isVisitado()) {
                        var x2 = x;
                        var y2 = y;
                        var z2 = z;
                        if (tipoGeometria.eixos === "xyz") {
                            x2 = x + 4 * Math.cos(tipoGeometria.angulos[countLigacoes][1]) * Math.sin(tipoGeometria.angulos[countLigacoes][0]);
                            y2 = y + 4 * Math.sin(tipoGeometria.angulos[countLigacoes][1]);
                            z2 = z + 4 * Math.cos(tipoGeometria.angulos[countLigacoes][1]) * Math.cos(tipoGeometria.angulos[countLigacoes][0])
                        } else {
                            x2 = x + Math.cos(tipoGeometria.angulos[countLigacoes]) * 4;
                            y2 = y + Math.sin(tipoGeometria.angulos[countLigacoes]) * 4;
                            z2 = z;
                        }
                        var posicaoOutroAtomo = new THREE.Vector3(x2, y2, z2);
                        var object = ThreeJSBuilder.createAtomObject(x2, y2, z2, outroAtomo.getCorAsRGB());
                        molecula.setAtomoPosicionado(outroAtomoId);
                        if (outroAtomo.getQtdLigacoes() < 2) {
                            molecula.setAtomoVisitado(outroAtomoId);
                        }
                        Game.apiHandler.addGameObject(object, self.scene);
                        molecula.setPonto3DAtomo(outroAtomo.getId(), posicaoOutroAtomo);
                        countLigacoes++;
                    }
                });

            }
        });

        molecula.getLigacoes().forEach(function (ligacao) {

            var atomoOrigem = molecula.getAtomoPorId(ligacao.getAtomoOrigem());
            var atomoDestino = molecula.getAtomoPorId(ligacao.getAtomoDestino());

            var start = atomoOrigem.getPonto3D();
            var end = atomoDestino.getPonto3D();

            var qtdLigacoes = ligacao.getModoLigacao() === ModoLigacao.DUPLA ? 2 : 1;
            for (var i = 0; i < qtdLigacoes; i++) {
                var bond = ThreeJSBuilder.createLigacaoObject(start, end, i / 2);
                Game.apiHandler.addGameObject(bond, self.scene);
            }
        });
    };

    self.onResize = function () {
        var divResultado = $('#divResultado');
        Game.camera.threeObject.aspect = divResultado.width() / divResultado.height();
        Game.camera.threeObject.updateProjectionMatrix();
        Game.apiHandler.renderer.setSize(divResultado.width(), divResultado.height());
    };

    self.limpaCanvas = function () {
        var objsToRemove = _.rest(self.scene.threeObject.children, 1);
        _.each(objsToRemove, function (object) {
            self.scene.threeObject.remove(object);
        });
    }

};
