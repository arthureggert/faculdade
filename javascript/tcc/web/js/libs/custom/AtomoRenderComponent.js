function AtomoRenderComponent() {
}

AtomoRenderComponent.prototype = new RenderableComponent();

JSUtils.addMethod(AtomoRenderComponent.prototype, "initialize",
    function (rgb) {
        this.initialize();
        this.rgb = rgb;
        return this;
    }
);

AtomoRenderComponent.prototype.getSystems = function () {
    var systems = new Array();
    systems = ArrayUtils.addElement(systems, RenderSystem);
    return systems;
};

AtomoRenderComponent.prototype.getTag = function () {
    return "ATOM_RENDER_COMPONENT";
};

AtomoRenderComponent.prototype.genThreeObject = function () {
    var sphereGeometry = new THREE.IcosahedronGeometry(1, 2);
    var cor = new THREE.Color(this.rgb);
    var material = new THREE.MeshLambertMaterial({color: cor});
    var object = new THREE.Mesh(sphereGeometry, material);
    return object;
};