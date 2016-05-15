/**
 * used to display a overlay while load or request a resource. please note this
 * is single instance.
 */
define("skeleton/overlay", [ "dojo/dom-class", "dojo/dom-construct",
		"dojo/text!skeleton/template/overlay.html" ], function(domClass,
		domConstruct, template) {
	var root = null, init = function() {
		if (!root) {
			root = domConstruct.place(domConstruct.toDom(template),dojo.body(),"last");
		}
	}, toggleStatus = function(status) {
		if (!root) {
			init();
		}
		domClass.toggle(root, "hide", status);
	}, instance = {
		initialize : function() {
			init();
		},
		show : function() {
			toggleStatus(false);
		},
		close : function() {
			toggleStatus(true);
		}
	};

	return instance;

});
