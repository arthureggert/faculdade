function ThreeJSCustomHandler() {
}

ThreeJSCustomHandler.prototype = new ThreeJSHandler();

ThreeJSCustomHandler.prototype._onRender = ThreeJSCustomHandler.prototype.onRender;

ThreeJSCustomHandler.prototype._addGameObject = ThreeJSCustomHandler.prototype.addGameObject;

ThreeJSCustomHandler.prototype.controls;

ThreeJSCustomHandler.prototype.camera;

//ThreeJSCustomHandler.prototype.objects = [];

ThreeJSCustomHandler.prototype.setupCanvas = function (element) {
    this.renderer = new THREE.WebGLRenderer({
        antialias: true
    });
    var divResultado = $('#divResultado');
    this.renderer.setClearColor(0x050505);
    this.renderer.setPixelRatio(window.devicePixelRatio);
    this.renderer.setSize(divResultado.width(), divResultado.height());
    element.append(this.renderer.domElement);
    return this.renderer.domElement;
};

ThreeJSCustomHandler.prototype.setupCamera = function (angle, near, far) {
    var divResultado = $('#divResultado');
    ThreeJSCustomHandler.prototype.camera = new Camera().initialize(0, 25, 10, divResultado.width() / divResultado.height(), angle, near, far);
    ThreeJSCustomHandler.prototype.camera.threeObject.aspect = divResultado.width() / divResultado.height();
    ThreeJSCustomHandler.prototype.camera.threeObject.updateProjectionMatrix();
    this.setupControl(ThreeJSCustomHandler.prototype.camera.threeObject);
    return this.camera;
};

ThreeJSCustomHandler.prototype.setupControl = function (camera) {
    var renderer = this.renderer;
    var scene = DesenhaMolecula3D.scene;
    ThreeJSCustomHandler.prototype.controls = new THREE.TrackballControls(camera, renderer.domElement);
    ThreeJSCustomHandler.prototype.controls.rotateSpeed = 2;
    ThreeJSCustomHandler.prototype.controls.addEventListener('change', function () {
        renderer.render(scene.threeObject, camera);
    });
};

ThreeJSCustomHandler.prototype.onRender = function () {
    this._onRender();
    this.controls.update();
};

ThreeJSCustomHandler.prototype.clear = function () {
    //ThreeJSCustomHandler.prototype.objects.forEach(function (elemento) {
    //    ThreeJSCustomHandler.prototype.removeGameObject(elemento.object, elemento.parent);
    //});
    //ThreeJSCustomHandler.prototype.objects = [];
    //this.renderer.clear();
    //this.renderer.clearDepth();
};

ThreeJSCustomHandler.prototype.addGameObject = function (object, parent) {
    //ThreeJSCustomHandler.prototype.objects.push({
    //    'object': object,
    //    'parent': parent
    //});
    ThreeJSCustomHandler.prototype._addGameObject(object, parent);
};