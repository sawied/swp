/**
 * execute AJAX Request and Validate Request and Response
 */
define("skeleton/xservice",["dojo/request/xhr","dojo/_base/lang"],function(xhr,lang){
	
	var defaultOptions={method:"POST",handleAs:"JSON"},
		doExecute=function(request){
		var tempOptions=lang.mixin({},defaultOptions),
			options=lang.mixin(tempOptions,request);
		
		xhr(request.url,options).then(function(data){
			
		},function(error){
			
		});
	};
	
});