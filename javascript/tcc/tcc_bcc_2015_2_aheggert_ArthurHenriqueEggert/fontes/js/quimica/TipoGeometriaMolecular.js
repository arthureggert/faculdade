var TipoGeometriaMolecular = {

    Linear: {
        nome: "Linear",
        angulos: [0, 3.14159],
        eixos: "xy"
    },
    TrigonalPlana: {
        nome: "Trigonal Plana",
        angulos: [0, 2.0944, 4.18879],
        eixos: "xy"
    },
    Tetraedrica: {
        nome: "Tetraédrica",
        angulos: [[0, -0.872], [2.09, -0.872], [4.18, -0.872], [0, 1.57]],
        eixos: "xyz"
    },
    BiPiramedeTrigonal: {
        nome: "BoPiramideTrigonal",
        angulos: [[0, 2.09], [0, 4.18], [0, 6.28], [1.57, 0], [-1.57, 0]],
        eixos: "xyz"
    },
    Octaedrica: {
        nome: "Octaedrica",
        angulos: [[0, 1.57], [0, 3.14], [0, 4.71], [0, 6.28], [1.57, 0], [-1.57, 0]],
        eixos: "xyz"
    },
    Angular: {
        nome: "Angular",
        angulos: [5.58, 3.49],
        eixos: "xy"
    },
    PiramedeTrigonal: {
        nome: "PiramedeTrigonal",
        angulos: [[0, -0.872], [2.09, -0.872], [4.18, -0.872], [0, 1.57]],
        eixos: "xyz"
    },
    Gangora: {
        nome: "Gangora",
        angulos: [[1.57, 0], [-1.57, 0], [0, 1.57], [0, -2.09], [0, -0.872]],
        eixos: "xyz"
    },
    FormaDeT: {
        nome: "Forma de T",
        angulos: [[1.57, 0], [-1.57, 0], [0, -1.57], [0, 2.09], [0, 0.872]],
        eixos: "xyz"
    },
    PiramedeBaseQuadrada: {
        nome: "PiramideBaseQuadrada",
        angulos: [[0, 1.57], [0, 3.14], [0, 4.71], [0, 6.28], [1.57, 0], [-1.57, 0]],
        eixos: "xyz"
    },
    QuadradoPlanar: {
        nome: "QuadradoPlanar",
        angulos: [[1.57, 3.14], [0, 3.14], [1.57, 0], [0, 6.28]],
        eixos: "xyz"
    },
    BiPiramidePentagonal: {
        nome: "BiPiramideTrigonal",
        angulos: [[1.25, 0], [2.51, 0], [3.77, 0], [5.03, 0], [6.28, 0], [0, 1.57], [0, -1.57]],
        eixos: "xyz"
    }
};