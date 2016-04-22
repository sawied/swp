define(["jquery",
"mustache",
"domReady",
"text!template/default.html",
"iscroll"
],function($,mustache,domReady,defaultView){
	
	var me =function(){
		this.root=null;
		this.init.apply(this,arguments);
	};
	
	me.prototype.init=function(root){
		var self=this;
		self.root=root;
		
		//make template append to root dom
		var template=mustache.render(defaultView,{"name":"dojo"});
		self.root.append(template); 
		self.animationEle=self.root.find("animationId");
		self.root.find("#scroller").on("transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd",function(){
			console.log("....");
		});
		window.isc=new iScroll('wrapper',{momentum :true,
			onScrollMove:function(){
				console.log(this.x);
			},
			onScrollEnd:function(){
				console.log("end",this.x);
			}
		});
		
	};
	return me;
});
