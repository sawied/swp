define(["jquery","text!core/template/Tip.html"],function($,template){

    var $root=null,
        status=null,
        dataContent=null;

    function show(msg) {
        if(!$root){
            $("body").append(template);
            $root=$("#tip-container");
            dataContent=$root.find("[data-content]");
        }

        if(!status){
            status="showed";
            dataContent.html(msg);
            $root.addClass("open");
            setTimeout(function () {
                $root.removeClass("open");
                status=null;
            },5000);
        }
    }

    return show;

});