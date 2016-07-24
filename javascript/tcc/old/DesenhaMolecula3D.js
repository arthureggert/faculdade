function DesenhaMolecula3DOld() {

    var self = this;

    var scene = null;

    var light = null;

    var root = null;

    var camera = null;

    var renderer = null;

    var controls = null;

    self.inicializa = function (width, height, elemento) {

        camera = new THREE.PerspectiveCamera(70, window.innerWidth / window.innerHeight, 1, 5000);
        camera.position.z = 500;

        scene = new THREE.Scene();

        light = new THREE.HemisphereLight(0xffffff, 0x000000);
        light.position.set(1, 1, 1);
        scene.add(light);

        root = new THREE.Object3D();
        scene.add(root);

        renderer = new THREE.WebGLRenderer({
            antialias: true
        });

        renderer.setClearColor(0x050505);
        renderer.setPixelRatio(window.devicePixelRatio);
        renderer.setSize(width, height);
        elemento.append(renderer.domElement);

        controls = new THREE.TrackballControls(camera, renderer.domElement);
        controls.rotateSpeed = 2;
        controls.addEventListener('change', render);

        window.addEventListener('resize', onWindowResize(width, height), false);
    };

    self.desenhaMolecula = function (molecula) {

        var x = 0;
        var y = 0;
        var z = 0;

        while (root.children.length > 0) {
            var object = root.children[0];
            object.parent.remove(object);
        }

        var sphereGeometry = new THREE.IcosahedronGeometry(1, 2);

        molecula.getAtomosPorQtdLigacao().forEach(function (atomo) {

            if (!atomo.isVisitado()) {
                var ligacoes = molecula.getLigacoesFromAtomo(atomo);
                var tipoGeometria = atomo.getTipoGeometria();
                if (tipoGeometria === null) {
                    throw new Error('Tipo da Geometria Molecular não encontrado!');
                }
                if (!atomo.isPosicionado()) {
                    var posicao = new THREE.Vector3(x, y, z);
                    var cor = new THREE.Color(atomo.getCorAsRGB());
                    var material = new THREE.MeshLambertMaterial({color: cor});

                    var object = new THREE.Mesh(sphereGeometry, material);
                    object.position.copy(posicao);
                    object.position.multiplyScalar(75);
                    object.scale.multiplyScalar(25);

                    root.add(object);
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
                            x2 = x + 1 * Math.cos(tipoGeometria.angulos[countLigacoes][1]) * Math.sin(tipoGeometria.angulos[countLigacoes][0])
                            y2 = y + 1 * Math.sin(tipoGeometria.angulos[countLigacoes][1])
                            z2 = z + 1 * Math.cos(tipoGeometria.angulos[countLigacoes][1]) * Math.cos(tipoGeometria.angulos[countLigacoes][0])
                        } else {
                            x2 = x + Math.cos(tipoGeometria.angulos[countLigacoes]) * 1;
                            y2 = y + Math.sin(tipoGeometria.angulos[countLigacoes]) * 1;
                            z2 = z;
                        }
                        var posicaoOutroAtomo = new THREE.Vector3(x2, y2, z2);
                        var corOutroAtomo = new THREE.Color(outroAtomo.getCorAsRGB());
                        var materialOutroAtomo = new THREE.MeshLambertMaterial({color: corOutroAtomo});

                        molecula.setAtomoPosicionado(outroAtomoId);
                        if (outroAtomo.getQtdLigacoes() < 2) {
                            molecula.setAtomoVisitado(outroAtomoId);
                        }

                        var objectOutroAtomo = new THREE.Mesh(sphereGeometry, materialOutroAtomo);
                        objectOutroAtomo.position.copy(posicaoOutroAtomo);
                        objectOutroAtomo.position.multiplyScalar(75);

                        objectOutroAtomo.scale.multiplyScalar(25);
                        root.add(objectOutroAtomo);
                        molecula.setPonto3DAtomo(outroAtomo.getId(), posicaoOutroAtomo);
                        countLigacoes++;
                    }
                });

            }
        });

        var boxGeometry = new THREE.BoxGeometry(1, 1, 1);

        molecula.getLigacoes().forEach(function (ligacao) {

            var atomoOrigem = molecula.getAtomoPorId(ligacao.getAtomoOrigem());
            var atomoDestino = molecula.getAtomoPorId(ligacao.getAtomoDestino());

            var start = atomoOrigem.getPonto3D();
            var end = atomoDestino.getPonto3D();

            start.multiplyScalar(75);
            end.multiplyScalar(75);

            var qtdLigacoes = ligacao.getModoLigacao() === ModoLigacao.DUPLA ? 2 : 1;
            for (var i = 0; i < qtdLigacoes; i++) {
                var object = new THREE.Mesh(boxGeometry, new THREE.MeshLambertMaterial(0xffffff));
                object.position.copy(start);
                object.position.lerp(end, 0.5);
                object.scale.set(5, 5, start.distanceTo(end));
                object.lookAt(end);
                object.translateX(10 * i);
                root.add(object);
            }
        });

        render();
        animate();
    };

    var render = function () {
        renderer.render(scene, camera);
    };

    var onWindowResize = function (width, height) {
        camera.aspect = width / height;
        camera.updateProjectionMatrix();
        renderer.setSize(width, height);
        render();
    };

    var animate = function () {
        requestAnimationFrame(animate);
        controls.update();
        var time = Date.now() * 0.0004;
        root.rotation.x = time;
        root.rotation.y = time * 0.7;
        render();
    };
}
