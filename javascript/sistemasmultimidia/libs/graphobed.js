/*!
 * graphobed
 * http://www.matheretter.de/tools/graphobed.js
 *
 * graphobed is a jquery script that can find equations on your website, 
 * parses them and embeds the according graphs below the formula as HTML5 canvas. 
 * To let the script find your equations, enclose them in *# equation #*
 * Embedded Graphs can be changed later on, use the created input field.
 * This script relies on: jquery, easeljs, math.js
 *
 * @version 0.0.1
 * @date    2015-04-02
 *
 * @license
 * Copyright (C) 2015 Kai Noack, http://www.matheretter.de/
 *
 * Distributed under the terms of the MIT license.
 * http://www.opensource.org/licenses/mit-license.html
 *
 * This notice shall be included in all copies or substantial portions of the Software. 
**/

function Graphobed() {

    this.coordTranslate = 50;

    function setSize(graph) {
        //set graph width
        var margin = 20;
        var td = $(graph).closest("td");
        var graphWidth = td.height() - margin;
        $(graph).width(graphWidth);

        //set to background same height and width of graph
        var backgroundGraph = $(graph).parent();
        $(backgroundGraph).width(graphWidth);
        $(backgroundGraph).height($(graph).height());

        //align graph to left/right
        if ($(graph).parent().attr("class").indexOf("left") > 0) {
            $(graph).parent().css('left', (td.width() - $(graph).width() - ($(graph).width() / 2)));
        } else {
            $(graph).parent().css('right', (-($(graph).width() - ($(graph).width() / 2))));
        }
    }

    this.atualizarGraficos = function () {
        $('canvas.graphobed').each(function (idx, obj) {
            setSize(obj);
            var funcao = $(obj).attr('function');
            // Se houverem funções desenhar
            if (funcao != '') {
                var gxs = funcao.split(';');
                redrawObject(gxs, obj.id);
            }
        });
    }

    /* DRAWING */

    // draw complete graph with coordinate system
    function redrawObject(graphfx, rcanvas_name, stage) {

        // if(typeof stage == 'undefined') {
        // console.log('creating stage');
        stage = new createjs.Stage(rcanvas_name);
        // stage.canvas.width = $('.graphobeds:first-child').parent().width(); // e.g. 750 : 600 px = 1,25
        stage.canvas.width = $('#' + rcanvas_name).width(); // e.g. 750 : 600 px = 1,25
        // console.log(stage.canvas.width);
        stage.canvas.height = stage.canvas.width / 1.25;
        stage.coord_xaxis = new createjs.Shape();
        stage.addChild(stage.coord_xaxis);
        stage.coord_yaxis = new createjs.Shape();
        stage.addChild(stage.coord_yaxis);
        stage.coord_arrow_x = new createjs.Shape();
        stage.addChild(stage.coord_arrow_x);
        stage.coord_arrow_y = new createjs.Shape();
        stage.addChild(stage.coord_arrow_y);
        stage.coord_xaxis_lines = new createjs.Shape();
        stage.addChild(stage.coord_xaxis_lines);
        stage.coord_yaxis_lines = new createjs.Shape();
        stage.addChild(stage.coord_yaxis_lines);

        stage.curve = new createjs.Shape();
        stage.addChild(stage.curve);
        // }

        // drawCoordinateSystem
        // console.log('stage: '+stage);
        // if(typeof stage == 'undefined') {
        stage.coord_xaxis.graphics.clear();
        stage.coord_yaxis.graphics.clear();

        var axis_center_x = $('#' + rcanvas_name).width() / 2;;
        var axis_center_y = $('#' + rcanvas_name).height() / 2;
        var xaxis_width = $('#' + rcanvas_name).width() - 0.05 * $('#' + rcanvas_name).width(); // 90 % of canvas width 
        var yaxis_width = $('#' + rcanvas_name).height() - 0.05 * $('#' + rcanvas_name).height(); // 90 % of canvas height 
        var axis_start_x = ($('#' + rcanvas_name).width() - xaxis_width) / 2;
        var axis_start_y = ($('#' + rcanvas_name).height() - yaxis_width) / 2;

        var axis_strokewidth = 2;
        stage.coord_xaxis.graphics.setStrokeStyle(axis_strokewidth, 'round').beginStroke('#000');
        stage.coord_xaxis.graphics.moveTo(axis_start_x, axis_center_y).lineTo(axis_start_x + xaxis_width, axis_center_y);
        stage.coord_yaxis.graphics.setStrokeStyle(axis_strokewidth, 'round').beginStroke('#000');
        stage.coord_yaxis.graphics.moveTo(axis_center_x, axis_start_y).lineTo(axis_center_x, axis_start_y + yaxis_width);

        var arrwidth = 5;
        var arrxtnd = 5;

        // draw coordsys arrow for x-axis
        stage.coord_arrow_x.graphics.beginFill('#000');
        stage.coord_arrow_x.graphics.beginStroke('#000');
        stage.coord_arrow_x.graphics.moveTo(axis_start_x + xaxis_width + arrwidth / 2, axis_center_y).lineTo(axis_start_x + xaxis_width - arrwidth - arrxtnd, axis_center_y + arrwidth).lineTo(axis_start_x + xaxis_width - arrwidth - arrxtnd, axis_center_y - arrwidth).lineTo(axis_start_x + xaxis_width + arrwidth / 2, axis_center_y);
        stage.coord_arrow_x.graphics.endFill();

        // draw coordsys arrow for y-axis
        stage.coord_arrow_y.graphics.beginFill('#000');
        stage.coord_arrow_y.graphics.setStrokeStyle(axis_strokewidth, 'round').beginStroke('#000');
        stage.coord_arrow_y.graphics.moveTo(axis_center_x, axis_start_y - arrwidth / 2).lineTo(axis_center_x + arrwidth, axis_start_y + arrwidth + arrxtnd).lineTo(axis_center_x - arrwidth, axis_start_y + arrwidth + arrxtnd).lineTo(axis_center_x, axis_start_y - arrwidth / 2);
        stage.coord_arrow_y.graphics.endFill();

        var label_x = new createjs.Text('x', 'bold 16px Arial', '#333');
        var label_y = new createjs.Text('y', 'bold 16px Arial', '#333');
        stage.addChild(label_x);
        stage.addChild(label_y);
        label_x.x = axis_start_x + xaxis_width - 5;
        label_x.y = axis_center_y + 10;
        label_y.x = axis_center_x - 20;
        label_y.y = axis_start_y - 5;

        var stepdist = xaxis_width / 14;
        // assign main drawing step value
        coordTranslate = stepdist;

        var steplinew = 6;
        // 10 horizontal lines
        var xlines = 10;
        var labels_x = [];
        for (var i = 0; i <= xlines; i++) {
            // dont overdraw x-axis-line
            if (i != xlines / 2) {
                // long gray line
                stage.coord_yaxis_lines.graphics.setStrokeStyle(1, 'round').beginStroke('#DDD');
                stage.coord_yaxis_lines.graphics.moveTo(axis_start_x, axis_center_y + (i - xlines / 2) * stepdist).lineTo(axis_start_x + xaxis_width, axis_center_y + (i - xlines / 2) * stepdist);
                // little black marker
                stage.coord_yaxis_lines.graphics.setStrokeStyle(1, 'round').beginStroke('#000');
                stage.coord_yaxis_lines.graphics.moveTo(axis_center_x - steplinew, axis_center_y + (i - xlines / 2) * stepdist).lineTo(axis_center_x + steplinew, axis_center_y + (i - xlines / 2) * stepdist);
                // labels
                labels_x[i] = new createjs.Text('x', '14px Arial', '#333');
                labels_x[i].x = axis_center_x - 12;
                labels_x[i].y = axis_center_y + (i - xlines / 2) * stepdist - 6; // move up a bit
                stage.addChild(labels_x[i]);
                labels_x[i].text = -(i - xlines / 2);
                labels_x[i].textAlign = 'right';
            }
        }
        // 12 orthogonal lines
        var ylines = 12;
        var labels_y = [];
        for (var i = 0; i <= ylines; i++) {
            // dont overdraw y-axis-line
            if (i != ylines / 2) {
                // long gray line
                stage.coord_xaxis_lines.graphics.setStrokeStyle(1, 'round').beginStroke('#DDD');
                stage.coord_xaxis_lines.graphics.moveTo(axis_center_x + (i - ylines / 2) * stepdist, axis_start_y).lineTo(axis_center_x + (i - ylines / 2) * stepdist, axis_start_y + yaxis_width);
                // little black marker
                stage.coord_xaxis_lines.graphics.setStrokeStyle(1, 'round').beginStroke('#000');
                stage.coord_xaxis_lines.graphics.moveTo(axis_center_x + (i - ylines / 2) * stepdist, axis_center_y - steplinew).lineTo(axis_center_x + (i - ylines / 2) * stepdist, axis_center_y + steplinew);
                // labels
                labels_y[i] = new createjs.Text('x', '14px Arial', '#333');
                labels_y[i].x = axis_center_x + (i - ylines / 2) * stepdist; // move up a bit
                labels_y[i].y = axis_center_y + 12;
                stage.addChild(labels_y[i]);
                labels_y[i].text = (i - ylines / 2);
                labels_y[i].textAlign = 'center';
            }
        }

        stage.update();
        // } // drawcoord

        /* GRAPH */

        // console.log('rendering canvas');
        // console.log('got: '+val_a6+'x^6 + '+val_a5+'x^5 + '+val_a4+'x^4 + '+val_a3+'x^3 + '+val_a2+'x^2 + '+val_a1+'x + '+infunction);

        // clear last curves
        stage.curve.graphics.clear();

        for (g = 0; g < graphfx.length; g++) {

            console.log('drawing: ' + graphfx[g]);

            var paintcenter_x = $('#' + rcanvas_name).width() / 2;
            var paintcenter_y = $('#' + rcanvas_name).height() / 2;

            // var steps = 2*100;  // 2*100
            // zeichnungsgenauigkeit 
            // ... 0.05

            // curve style
            var lineThickness = 2;
            var lineColor = "#00F";
            if (g == 1) {
                lineColor = "#F00";
            }
            else if (g == 2) {
                lineColor = "#0A0";
            }
            else if (g == 3) {
                lineColor = "#5A0";
            }
            else if (g == 4) {
                lineColor = "#0A5";
            }
            else if (g > 4) {
                lineColor = "#ABC";
            }

            stage.curve.graphics.setStrokeStyle(lineThickness, 'round').beginStroke(lineColor);
            stage.curve.graphics.alpha = 80;

            // zeichnungsweite (echte koordinaten: 7 Einheiten rechts und links)
            var coordSteps = 7;  // 5 bis 50
            var max_yval = 10;

            // use math.js to check if equation is okay and can be drawn
            // console.log( '++ '+math.parse(graphfx) );

            // function prepared for y values
            var ourX = 0;
            var ourY = 0;
            var func_equation = graphfx[g]; // e.g. 'sqrt(9)*(x)'
            var fe = function (x) {
                var scope = { x: x };
                var expr = math.eval(func_equation, scope);
                return expr;
            };

            // PAINT from LEFT to RIGHT
            var firstdot = true;
            var paint_x;
            var paint_y;
            for (var i = -coordSteps; i <= coordSteps; i += 0.05) {
                // real values
                ourX = i;
                // ourY = infunction;
                ourY = fe(ourX);

                if (ourY < -max_yval) {
                    ourY = -max_yval;
                }
                if (ourY > max_yval) {
                    ourY = max_yval;
                }
                // console.log("x: " + ourX + " # y: " + ourY);

                // painting values
                paint_x = paintcenter_x + ourX * coordTranslate;
                paint_y = paintcenter_y - ourY * coordTranslate;

                if (firstdot) {
                    stage.curve.graphics.moveTo(paint_x, paint_y);
                    firstdot = false;
                }
                else {
                    stage.curve.graphics.lineTo(paint_x, paint_y);
                }
            }

            stage.update();
        } // end for g
    } // end redrawObject
};