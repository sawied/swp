requirejs.config({
	baseUrl : "js",
	paths : {
		"domReady":"lib/domReady",
		"i18n":"lib/i18n",
		"jquery":"lib/jquery-1.12.3",
		"text":"lib/text",
		"mustache":"lib/mustache",
		"bootstrap":"lib/bootstrap/bootstrap",
		"dummy":"application/dummy",
		"core" : "application/core",
		"switcher":"application/switcher"
	},
	deps : [ "core/core" ],
	callback : function(a, b, c) {

	},
	packages:[
		{
			name:"core",
			location:"application/core"
		}

	],
	shim:{
		"bootstrap":{
			deps: ["jquery"],
			exports:"$",
		}
	}

});