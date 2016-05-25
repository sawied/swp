define(["jquery","core/topic","core/overlay","config"],function($,topic,overlay,config){
	
	
	$.ajaxSetup(config.globalSettings);
	
	
	var _failProcessor =function(jqXHR, textStatus){
		console.log("an error occurred while do",textStatus);
	};
	
	var proxyCall = function(serviceName,param){
		var services=config.services,
			service=services[serviceName],
			data=service;
		if(param){
			//assume all the parameters are JSON
			data=$.extend({},service,{data:JSON.stringify(param)});
		}
		overlay.show();
		
		return $.ajax(service.url,data).always(function(){overlay.close();topic("ajaxComplated").publish({a:1});}).fail(_failProcessor);
		
	};
	
	
	return proxyCall;
});