define({
	dummy:true,
	globalSettings:{
		async:true,
		beforeSend:null,
		timeout:10000,
		global:false,
		//processData:false,
		"contentType":'application/x-www-form-urlencoded; charset=UTF-8'
	},
	services:{
		"retrieveUsers":{			
			method:"post",
			url:"service/users/{id}",
			"contentType":"application/json"
		}
	}
	
});