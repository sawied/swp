define([ "dojo/query", "dojo/dom", "dojo/dom-construct", "dojo/html",
		"dojo/text!skeleton/template/skeleton.html", "dojo/on",
		"dojo/request/xhr",
		"dojo/request/iframe",
		"dojo/i18n!skeleton/i18n/nls/i18n",
		"dojo/domReady!" ], function(query, dom, domConstruct, htm, template,
		on,xhr,iframe,nls) {
	var node = domConstruct.toDom(template);
	var rootDom=dom.byId("app-root");
	domConstruct.place(node,rootDom, "last");
	// htm.set(window.document.body,text);
	console.log("init skeleton APP.");
	var downloadBtn = dom.byId("download-btn");
	var formNode=domConstruct.create("form",{"action":"resources/sample.pdf","target":"_displaypdf","method":"post","enctype":"multipart/form-data"},dojo.body());
	domConstruct.create('input', {
		type: 'hidden',
		name:"b",
		value: "1"
	}, formNode);
	
	console.dir(nls);
	
	
	on(downloadBtn, "click", function(event) {
		console.log("starting download");
		formNode.submit();
/*		var frame=iframe.create("hrx");
		iframe.post("resources/sample.pdf",{data:{a:1,b:2}}).then(function(){
			console.log("data return");
		});*/
/*		xhr("resources/sample.pdf",{"handleAs":"blob"}).then(function(data){
			window.navigator.msSaveOrOpenBlob(data);
			//var pdfObject=domConstruct.create("img",{"type":"image/gif",src:createObjectURL(data)},dojo.body());
		},function(err){
			console.log(err);	
		});*/
		//iframe.get("http://localhost:8888/smot/file.htm",{"handleAs":"text"})
		
		//iframe.setSrc(frame, "http://localhost:8888/smot/file.htm", true);
	});
	
	
	function createObjectURL(blob){
		if(window.URL){
			return window.URL.createObjectURL(blob);
		}else if(window.webkitURL){
			return window.webkitURL.createObjectURL(blob);
		}else{
			return null;
		}
	}
	
	

});