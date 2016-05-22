define(["jquery","domReady","mustache","text!core/template/layout.html"],function($,domReady,mustache,template){
	domReady(function(){
		var dom=mustache.render(template,{appNames:["mustche","jquery","i18n","text","domReady"]});
		$("#doc-root").html(dom);
	});
});