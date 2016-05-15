define("skeleton/loader",["dojo/require","dojo/request","dojo/cache"],function(require,request,cache){
	
	var getText= function(url, sync, load){
		request(url, {sync:!!sync, headers: { 'X-Requested-With': null } }).then(load);
	};
	
	return {
		normalize: function(id, toAbsMid){
			// id is something like (path may be relative):
			//
			//	 "path/to/text.html"
			//	 "path/to/text.html!strip"
			var parts= id.split("!"),
				url= parts[0];
			return (/^\./.test(url) ? toAbsMid(url) : url) + (parts[1] ? "!" + parts[1] : "");
		},
		load: function(id, require, load){
			var
			parts= id.split("!"),
			stripFlag= parts.length>1,
			finish = function(text){
				load(stripFlag ? strip(text) : text);
			},
			url = require.toUrl(parts[0]);
			getText(url, !require.async, function(text){
				finish(text);
			});
		}
	};
	
});