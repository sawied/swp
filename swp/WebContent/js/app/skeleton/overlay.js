/**
 * used to display a overlay while load or request a resource. please note this
 * is single instance.
 */
define("overlay", [ "", "dojo/dom-construct",
		"dojo/text!skeleton/template/skeleton.html" ], function(domConstruct,
		template) {
	var instance = {}, 
		root, 
		init = function() {
		if (root) {
			root = domConstruct.toDom(template, body);
		}},
		close = function(){
			
		};
		

});
