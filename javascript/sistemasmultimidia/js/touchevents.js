function loadTouchEvents() {
    (function (modules) { // webpackBootstrap
        // The module cache
        var installedModules = {};

        // The require function
        function __webpack_require__(moduleId) {

            // Check if module is in cache
            if (installedModules[moduleId])
                return installedModules[moduleId].exports;

            // Create a new module (and put it into the cache)
            var module = installedModules[moduleId] = {
                exports: {},
                id: moduleId,
                loaded: false
            };

            // Execute the module function
            modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

            // Flag the module as loaded
            module.loaded = true;

            // Return the exports of the module
            return module.exports;
        }

        // expose the modules object (__webpack_modules__)
        __webpack_require__.m = modules;

        // expose the module cache
        __webpack_require__.c = installedModules;

        // __webpack_public_path__
        __webpack_require__.p = "/";

        // Load entry module and return exports
        return __webpack_require__(0);
    })
	([
		function (module, exports, __webpack_require__) {

		    var toggle = document.querySelector(".toggle-sidebar");
		    var target = document.querySelector(".sidebar");
		    if (toggle && target) {
		        toggle.addEventListener("click", function (ev) {
		            if (target.className.indexOf('show') === -1) {
		                target.className += ' show';
		            } else {
		                target.className = target.className.replace('show', '');
		            }
		            ev.preventDefault();
		        });
		    }

		    if (document.querySelector("#canvas2d_4")) {
		        __webpack_require__(1);
		    }

		    __webpack_require__(2);


		    /***/
		},
		/* 1 */
		/***/ function (module, exports, __webpack_require__) {

		    /**
			 * kind of messy code, but good enough for now
			 */
		    // polyfill
		    var reqAnimationFrame = (function () {
		        return window[Hammer.prefixed(window, 'requestAnimationFrame')] || function (callback) {
		            window.setTimeout(callback, 1000 / 60);
		        };
		    })();

		    var touchEvent = (function (el) {
		        var screen = document.querySelector(".device-screen");
		        var START_X = 0;
		        var START_Y = 0;

		        var ticking = false;
						var responseMarked = false;
		        var transform;

		        var mc = new Hammer.Manager(el);

		        mc.add(new Hammer.Pan({ threshold: 0, pointers: 0 }));

		        mc.add(new Hammer.Swipe()).recognizeWith(mc.get('pan'));
		        mc.add(new Hammer.Rotate({ threshold: 0 })).recognizeWith(mc.get('pan'));
		        mc.add(new Hammer.Pinch({ threshold: 0 })).recognizeWith([mc.get('pan'), mc.get('rotate')]);

		        mc.add(new Hammer.Tap({ event: 'doubletap', taps: 2 }));
		        mc.add(new Hammer.Tap());

		        mc.on("panstart panmove", onPan);

		        mc.on("hammer.input", function (ev) {
		            if (ev.isFinal) {
		                resetElement();
		            }
		        });

		        function logEvent(ev) {
		            //console.log(ev.type);
		        }

		        function resetElement() {
		            el.className = 'animate';
		            transform = {
		                translate: { x: START_X, y: START_Y },
		                scale: 1,
		                angle: 0,
		                rx: 0,
		                ry: 0,
		                rz: 0
		            };
		            requestElementUpdate();
		        }

		        function updateElementTransform() {
		            var value = [
						'translate3d(' + transform.translate.x + 'px, ' + transform.translate.y + 'px, 0)',
						'scale(' + transform.scale + ', ' + transform.scale + ')',
						'rotate3d(' + transform.rx + ',' + transform.ry + ',' + transform.rz + ',' + transform.angle + 'deg)'
		            ];

		            value = value.join(" ");
		            el.style.webkitTransform = value;
		            el.style.mozTransform = value;
		            el.style.transform = value;
		            ticking = false;
		        }

		        function requestElementUpdate() {
		            if (!ticking) {
		                reqAnimationFrame(updateElementTransform);
		                ticking = true;
		            }
		        }

		        //TODO Verificar direÃ§Ã£o e inverter sinais...
		        function onPan(ev) {

		            el.className = '';
		            if (isRightCanvas()) {
		                transform.translate = {
		                    x: -(START_Y + ev.deltaY),
		                    y: START_X + ev.deltaX
		                };
		            } else {
		                transform.translate = {
		                    x: START_Y + ev.deltaY,
		                    y: -(START_X + ev.deltaX)
		                };
		            }

		            if (isPositionedInResponse(el, $(el).offset().left) && !responseMarked) {
		                if (isRightCanvas()) {
		                    marcarResposta('direita', $(el).attr('function'));
		                } else {
    		                marcarResposta('esquerda', $(el).attr('function'));
		                }
									responseMarked = true;
		            }
		            logEvent(ev);
		            requestElementUpdate();
		        }
		        resetElement();


		        function isPositionedInResponse(el, positionLeft) {
		            if (isRightCanvas()) {
		                var pageWidth = $(document).width();
		                var responseRightWidth = $(".response-content-right").width();
		                var graphWidth = $(el).height();
		                if ((positionLeft + graphWidth) >= (pageWidth - responseRightWidth)) {
		                    return true;
		                }
		                return false;
		            } else {
		                var responseLeftWidth = $(".response-content-left").width();
		                if (responseLeftWidth >= positionLeft) {
		                    return true;
		                }
		                return false;
		            }
		        }

		        function isRightCanvas() {
		            if ($(el).parent().attr('class').indexOf('right') > -1) {
		                return true;
		            }
		            return false;
		        }
		    });

		    [].forEach.call(document.querySelectorAll(".graphobed_canvas"), function (el) {
		        touchEvent(el);
		    });
		},

		function (module, exports, __webpack_require__) {


		}
	])


}
