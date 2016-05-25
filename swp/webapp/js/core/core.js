define(["jquery","domReady","mustache","core/model/users","text!core/template/layout.html"],function($,domReady,mustache,userService,template){
	domReady(function(){
		var dom=mustache.render(template,{appNames:["mustche","jquery","i18n","text","domReady"]});
		
		userService.load({"enable":true}).done(function(data){
			console.log(data);
			$("#doc-root").html(dom);
		}			
		);
		
	});
});