/**
 * used to display a overlay while load or request a resource. please note this
 * is single instance.
 */
define([ "bootstrap", "mustache","i18n!core/nls/lang",
		"text!core/template/overlay.html" ], function($,mustache,lang,temp) {
	var root = null, init = function() {
		if (!root) {
			var nls=$.extend({},lang);
			var text = mustache.render(temp,nls);
			 $("body").append(text);
			 root = $("#loadingOverlay");
		}
	}, toggleStatus = function(status) {
		if (!root) {
			init();
		}
		root.modal(status?"show":"hide");
	}, instance = {
		initialize : function() {
			init();
		},
		show : function() {
			toggleStatus(true);
		},
		close : function() {
			toggleStatus(false);
		}
	};

	return instance;

});
