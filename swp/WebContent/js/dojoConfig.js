var dojoConfig = {
	has : {
		"dojo-firebug" : true,
		"dojo-debug-messages" : true,
	},
	baseUrl : "js",
	async : true,
	locale: "ja",
	packages : [ "smartDoc" ],
	map : {},
	paths : {
		"dojo":"dojo/dojo",
		"smartDoc" : "app/smartDocument/",
		"skeleton" : "app/skeleton"
		
	},
	parseOnLoad : false,
	deps : ["skeleton/skeleton"],
	cacheBust : false,
	waitSeconds : 10,
};