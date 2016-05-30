define(["jquery","core/service"],function($,service){
	
	
	
	 var loadAll = function(param){
		 return service("retrieveUsers",param).pipe(function (data) {
			 
			var groups= $.map(data.data,function (item) {

				 var group={id:item.id,name:item.name,birthday:item.birthday,comments:item.comments};
				 return $.extend(group,{json:JSON.stringify(group)});

			 });

			 return {data:groups};


		 });
	 };

	return {
		load:loadAll
	};
	
	
});