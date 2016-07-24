function LigacaoRenderComponent() {
}

LigacaoRenderComponent.prototype = new RenderableComponent();

JSUtils.addMethod(LigacaoRenderComponent.prototype, "initialize",
    function () {
        this.initialize();
        return this;
    }
);

LigacaoRenderComponent.prototype.getSystems = function () {
    var systems = new Array();
    systems = ArrayUtils.addElement(systems, RenderSystem);
    return systems;
};

LigacaoRenderComponent.prototype.getTag = function () {
    return "BOND_RENDER_COMPONENT";
};

LigacaoRenderComponent.prototype.genThreeObject = function () {
    var boxGeometry = new THREE.BoxGeometry(1, 1, 1);
    var cor = new THREE.Color('rgb(168,168,168)');
    var object = new THREE.Mesh(boxGeometry, new THREE.MeshLambertMaterial({color: cor}));
    return object;
};