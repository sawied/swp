define(["bootstrap","mustache","text!core/template/alert.html","domReady!"],function($,mustache,template){



    function Alert(message,title){

        this.def=$.Deferred();

        var html=mustache.render(template,{content:message,title:title});
        $("body").append(html);
        this.$root=$("#alert-dialog");

        //bind events
        $("[data-event='confirm']",this.$root).on("click",$.proxy(confirm,this));
        this.$root.on("hidden.bs.modal",$.proxy(closeEventListener,this));

        this.$root.modal("show");

        return this.def;

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


    return Alert;


});