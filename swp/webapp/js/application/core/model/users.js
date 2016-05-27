define(["jquery","core/service"],function($,service){
	
	
	
	 var loadAll = function(param){
		 return service("retrieveUsers",param);
	 };

	return {
		load:loadAll
	};
	
	
});