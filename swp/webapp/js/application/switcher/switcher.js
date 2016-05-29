define(["bootstrap", "text!switcher/template/sidePanel.html"], function ($, template) {


    // Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
    "use strict";

    function Switcher(root, param) {


        if (!(this instanceof Switcher)) {
            throw new TypeError("Switcher constructor cannot be called as a function.");
        }

        var self = this;
        self.root = $(root);
        self.root.html(template);
        _bindEvent();
        /**
         * binding all the events marked with data-event and mapping the handler as data-handler
         * @private
         */
        function _bindEvent() {
            self.root.find("[data-event]").map(function () {
                var handler = {};
                $(this).bind(this.getAttribute("data-event"), handler[this.getAttribute("data-handler")]);
            });
        }

        }


        /**
         * Adding static properties is as simple as adding them directly to the constructor
         * function directly.
         */
        Switcher.MAX=3;


        Switcher.create=function (root,param) {
            var result=new Switcher(root,param);
            return result;
        }


        Switcher.prototype={
            /**
             * Whenever you replace an Object's Prototype, you need to repoint
             * the base Constructor back at the original constructor Function,
             * otherwise `instanceof` calls will fail.
             */
            constructor: Switcher,

            /**
             * 
             * @param name component name
             * @param param
             */
            goTo:function (name,param) {
                
            }


        }

    return Switcher;

});