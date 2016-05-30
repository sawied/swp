define(["jquery","core/topic","core/overlay","config"],function($,topic,overlay,config){
	
	
	$.ajaxSetup(config.globalSettings);
	
	
	var _failProcessor =function(jqXHR, textStatus){
		console.log("an error occurred while do",textStatus);
	};
	
	var proxyCall = function(serviceName,param){
		var services=config.services,
			service=services[serviceName],
			data=service;
		if(param&&$.isPlainObject(param)){
			data=$.extend({},service,{data:isJSONRequest(serviceName)?JSON.stringify(param):param});
		}
		overlay.show();
		console.log("do service",serviceName,data);
		return $.ajax(service.url,data).always(function(){overlay.close();topic("ajaxComplated").publish({a:1});}).fail(_failProcessor);
		
	};


	
	
	var dummyCall = function(serviceName){
		
		overlay.show();
		var defer=$.Deferred();
		 require(["dummy/"+serviceName+"_dummy"],function(data){	
			 console.log("dummy call from ",serviceName," and the response "+data);
			 setTimeout(function(){overlay.close();defer.resolve(data);}, 1500);	
		});
		 return defer;
	};


	function isJSONRequest(serviceName){
		var service=services[serviceName];
		return (service["contentType"]&&"application/json"== service["contentType"]);
	};
	
	
	return config.dummy?dummyCall:proxyCall;
});