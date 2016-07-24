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
        var x, y, z = 0;
        for (var i = 1; i <= 1280; i++) {
            x = i * 2;
            var object = ThreeJSBuilder.createAtomObject(x, 0, 0, 'rgb(255,255,255)');
            Game.apiHandler.addGameObject(object, self.scene);
            z = i * 2;
            object = ThreeJSBuilder.createAtomObject(0, 0, z, 'rgb(150,150,150)');
            Game.apiHandler.addGameObject(object, self.scene);
            y = i * 2;
            object = ThreeJSBuilder.createAtomObject(0, y, 0, 'rgb(220,220,220)');
            Game.apiHandler.addGameObject(object, self.scene);
        }
        Game.init(elemento, self.scene);
    };

    self.onResize = function () {
        var divResultado = $('#divResultado');
        Game.camera.threeObject.aspect = divResultado.width() / divResultado.height();
        Game.camera.threeObject.updateProjectionMatrix();
        Game.apiHandler.renderer.setSize(divResultado.width(), divResultado.height());
    }
};
