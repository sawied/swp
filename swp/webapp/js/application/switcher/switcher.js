define(["bootstrap", "text!switcher/template/sidePanel.html","switcher/detail"], function ($, template,detail) {


    // Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
    "use strict";

    function Switcher(root,cname, param) {


        if (!(this instanceof Switcher)) {
            throw new TypeError("Switcher constructor cannot be called as a function.");
        }

        var self = this;
        self.root = $(root);
        self.root.html(template);
        self.cname=cname;
        self.components=[];
        self.currentPage=null;
        self.opened=false;

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

        /**
         * init first component
         */
        self.pages=[];
        self.root.find("div[data-name]").each(function(index,item,items) {
            var $this=$(this);
            return self.pages[$this.data("name")]=$this;
        });

        if(!self.components[self.cname]){
           self.components[cname]=new Switcher.MODULES[self.cname](self.pages[cname],this,{});
        }


    }

    Switcher.MODULES={
        "detail":detail
    };




        /**
         * Adding static properties is as simple as adding them directly to the constructor
         * function directly.
         */
        Switcher.MAX=3;


        Switcher.create=function (root,cname,param) {
            var result=new Switcher(root,cname,param);
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
            moveTo:function (name,param) {
                if(!(this.currentPage&&this.opened)){
                    this.open();
                    this.currentPage=name;
                    this.opened=true;
                }
            },


            open:function(){
                this.root.addClass("open");
            },

            close:function () {
                this.root.removeClass("open");
            }




        }

    return Switcher;

});