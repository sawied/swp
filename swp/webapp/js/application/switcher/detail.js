define(["bootstrap", "text!switcher/template/detail.html"], function ($, template) {

    /**
     *  "use strict";
     */

    function Detail(root, controller, param) {
        this.root = root;
        this.param = param;


        /**
         * render html elements
         */

        this.root.html(template);
        controller.moveTo(Detail.CNAME);
    }

    Detail.CNAME = "detail";


    Detail.prototype = {
        constructor: Detail
    }


    return Detail;


});