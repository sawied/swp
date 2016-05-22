requirejs.config({
	baseUrl : "js",
	paths : {
		"domReady":"lib/domReady",
		"i18n":"lib/i18n",
		"jquery":"lib/jquery-1.12.3",
		"text":"lib/text",
		"mustache":"lib/mustache",
		"core" : "core"
	},
	deps : [ "core/core" ],
	callback : function(a, b, c) {

	}

});