define(["jquery","text!core/template/Tip.html","domReady!"],function($,template){


    /**
     * init default template
     * @type {null}
     */

    var $root=null,
        status=null,
        dataContent=null;

    if(!$root){
        $("body").append(template);
        $root=$("#tip-container");
        dataContent=$root.find("[data-content]");
    }

    function show(msg) {

        if(!status){
            status="showed";
            dataContent.html(msg);
            $root.get(0).innerHeight;
            $root.addClass("open");
            setTimeout(function () {
                $root.removeClass("open");
                status=null;
            },5000);
        }
    }

    return show;

});