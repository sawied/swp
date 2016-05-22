/**
 * used to display a overlay while load or request a resource. please note this
 * is single instance.
 */
define([ "jquery", "mustache","i18n!core/nls/lang",
		"text!core/template/overlay.html" ], function($,mustache,lang,temp) {
	var root = null, init = function() {
		if (!root) {
			var nls=$.extend({},lang);
			var text = mustache.render(temp,nls);
			root = $("body").append(text);
		}
	}, toggleStatus = function(status) {
		if (!root) {
			init();
		}
		root.toggleClass("hide", status);
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
