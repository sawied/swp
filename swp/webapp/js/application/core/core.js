define(["bootstrap",
        "domReady",
        "mustache",
        "core/model/users",
        "text!core/template/layout.html",
        "switcher/switcher"
        ],
        function($,domReady,mustache,userService,template,switcher){
	
	domReady(function(){
		
		var $root=$("#doc-root");
		
		userService.load({"enable":true}).done(function(data){
			var dom=mustache.render(template,data);
			$root.html(dom);
//			$("#user-dialog").modal({"show":true});
		}			
		);
		
		
		
		var $sidePanel=$("#sidePanel");
		
		$root.on("click","[data-event='switcherOpen']",function(){
			var swt=new switcher($sidePanel);
			swt.open();
		});
		
		
		
		
		
	});
});