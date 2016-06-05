define(["bootstrap","mustache","text!core/template/alert.html","i18n!core/nls/lang","domReady!"],function($,mustache,template,lang){


    /**
     * the params describe as following:
     * args={
     * title : required ,if not specify the value ,will be applied "No title",
     * content: html segment ,support mustache render via the parameter of param,
      * callbacks:callback functions
     * }
     *
     * @param args
     * @returns {*}
     * @constructor
     */
    function Alert(args){


        this.params=$.extend({title:lang['defaultDialogTitle'],content:lang['defaultDialogContent']},args);

        this.def=$.Deferred();

        var innnerHTML=mustache.render(this.params['content'],this.params);
        var html=mustache.render(template,{content:innnerHTML,title:this.params['title']});
        $("body").append(html);


        /**
         * root element
         * @type {jQuery|HTMLElement}
         */
        this.$root=$("#alert-dialog");
        
        
        
        //bind events
        _bindEvents.apply(this);
        this.$root.modal("show");
        return this.def;
    }

    /**
     * factory method
     * @param args
     * @returns {Alert}
     */
    function create(args){
        return new Alert(args);
    }
    

    function confirm(event){
        this.def.resolve(true);
        this.$root.modal("hide");
    }

    function reject(event){
        this.def.resolve(false);
    }

    function closeEventListener(event) {
        var status=this.def.state();
        if(status==='pending'){
            this.def.resolve(false);
        }
        this.$root.remove();
    }



    /**
     * bind events that element has attribute date-event
     * @private
     */
    function  _bindEvents() {
        var events=$.extend({"confirm":$.proxy(confirm,this)},this.params["callback"]);
        this.$root.find("[data-event]").map(function(){
            var eventName=$(this).attr("data-event");
            $(this).on("click",events[eventName]);
        });
        this.$root.on("hidden.bs.modal",$.proxy(closeEventListener,this));
    }
    


    return create;


});