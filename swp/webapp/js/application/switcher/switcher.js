define(["bootstrap","text!switcher/template/sidePanel.html"],function($,template){
	
	function switcher(root,param){
		
		var self=this;
			self.root=$(root);
			self.root.html(template);
			
			switcher.prototype.open=function(name){
				self.root.addClass("open");
			};	
			
		
	}
	
	return switcher;
	
});