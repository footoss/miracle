<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="add-div">
	<div>添加用户</div>
	<div>
		<label for="add-name">姓名：</label>
		<div style="display:inline-block;"><input type="text" id="add-name" class="add-param" /></div>
		<span class="tooltip">?</span>
	</div>
	
	<div>
		<label for="add-age">年龄：</label>
		<div style="display:inline-block;"><input type="text" id="add-age" class="add-param"/></div>
		<span class="tooltip">?</span>
	</div>
	<div>
		<div id="add-btn" class="qaudc add">保存</div>
		<div id="add-clear-btn" class="qaudc clear">清空</div>
		<div id="add-cancel-btn" class="qaudc cancel">取消</div>
	</div>
</div>

<div id="auc" class="mask opacity"></div>
<script>
(function(){
	
	
/* 	 var isToolTipHover = false,
	 		 isToolTipBoxHover = false; 
	 $('.tooltip').hover(
			 function () {
		 			isToolTipHover = true;
		 
		 			var target = $(this);
		 			var tips = [];
		 			tips.push('asdfasdf');
		 			tips.push('cvbdsffsfd');
		 			tips.push('lkjlkkj');
		 			 
		 			createTooltipBox(target,'fixed',160,120,tips);
		 			
				 	
				 	$('.tooltipBox').hover(
				 			function(){
				 				isToolTipBoxHover = true;
				      		},
				   		function(){
				      		isToolTipBoxHover = false;
				      		setTimeout(hideTipBox,300);
				      		});
		     },
	    function () {
			  isToolTipHover = false;
			  setTimeout(hideTipBox,300);
			  
		    }
		  );
	 
		 function hideTipBox(){
			 if(!isToolTipBoxHover && !isToolTipBoxHover){
		   		$('.tooltipBox').remove();
	   		}
		 }
		 
		 function createTooltipBox(target,pos,width,height,tips){
			 	
			 	var tipContent = '';
			 	if(tips){
				 	for(var i = 0 ; i < tips.length ; i++){
				 		tipContent += '<li>' + tips[i] + '</li>';
				 	}
			 	}else{
			 		tipContent += '<li></li>';
			 	}
			 	
			 	var tooltipBox = $('<div class="tooltipBox"><span class="arrow-left"></span><ul class="tips">'
			 										+tipContent+'</ul></div>');
			 	
			 	target.parent().append(tooltipBox);
			 	
			 	var boxWidth = width ? width + 'px' : 'auto';
			 	var boxHeight=height ?height + 'px' : 'auto'
			 	
			 	var offset = target.offset();
			 	var left = offset.left + target.width() + 15 + 'px';
			 	var top = offset.top - target.height()/2 -height/2 + 'px';
			 	
			 	$('.tooltipBox').css({"position":pos,"display":"block","width":boxWidth,
			 												"height":boxHeight,"left":left,"top":top,"z-index":"9999",
			 												"background-color":"#FFFFA3","border":"1px solid #EEEE00"
			 												});
		 } */
	 
		 
		 var com = window.com || {};
		 console.log(com);
		 var NS = window.NS || {};
		 NS._registerNS = function(ns){
			 var levels = ns.split('\.');
			 var ns = com;
			 for(var i = (levels[0] == 'com')? 1 : 0 ; i < levels.length ; i++ ){
				 ns[levels[i]] = ns[levels[i]] || {};
				 ns = ns[levels[i]];
			 }
			 return ns;
		 }
		 
		 NS._createjsClass = function() {
			  return function() {
			    	this._defaultInitializer.apply(this,arguments); 
			    }
			}
		 
		 NS._registerNS('com.footoss.ui');
		 NS._registerNS('com.footoss.conf.ui');

		 com.footoss.conf.ui.Tip = {
				 defaultAnimate:{
//					 position:'fixed',
					 width:80,
					 height:60,
					 display:'block'
				 }
		 }
		 com.footoss.ui.Tip = NS._createjsClass();
		 
		 com.footoss.ui.Tip.prototype = {
				 _defaultInitializer : function(tooltipClassName,instanceName){
					 if(!document.getElementsByClassName(tooltipClassName)){
						 throw new Error('Cannot get ref elem by '+id+' , maybe arguments raise an error!');
					 }
					 this.defaultAnimate = com.footoss.conf.ui.Tip.defaultAnimate;
					 
					 this.name = instanceName;
					 this.tooltips = document.getElementsByClassName(tooltipClassName);
					 this.tooltipBox = null;// this.tooltipWrapper.getElementsByClassName('tooltipBox');
					 
					 this.showBox = null;
					 this.closeBox= null;
					 
					 this.heights = [];
					 this.animate = this.defaultAnimate;
					 
					 
					 this.isTooltipHover = false;
					 this.isTooltipBoxHover = false;
					 return this;
				 },
				render : function(){
					
					for(var i = 0 ; i < this.tooltips.length ; i++){
						this.tooltips[i].onmouseover = new Function(this.name+ ".expandBox(" +i+ ");");
						this.tooltips[i].onmouseout  = new Function(this.name+ ".removeBox();");
						
					}
					this.tooltips = null;
					this.tooltipBox = null;
					return this;
				},
				setStyle : function(name){
					return this;
				},
				setAnimate : function(oAnimate){
					if(typeof oAnimate != 'object'){
						return this;
					}
					this.animate = {
//							delay : parseInt(oAnimate.delay) || this.defaultAnimate.delay
					};
					return this;
				},
				expandBox :  function(ithTooltips){
					/* if(this.isAnimate)	 return;
					var self = this;
					this.closeBox = this.expandBox; */
					this.isTooltipHover = true;
					var hoverTooltipTarget = document.getElementsByClassName('tooltip')[ithTooltips];
					
					var box = document.createElement("div");
					hoverTooltipTarget.parentNode.appendChild(box);
					
					box.id = ithTooltips + 'tooltipBox' ;
					box.innerHTML = 'asdfasdfhasjkdfhjahsdflkjahsldf';
					box.style.width = this.defaultAnimate.width? this.defaultAnimate.width+"px":"auto";
					box.style.height= this.defaultAnimate.height?this.defaultAnimate.height+"px":"auto";
					
					var left = hoverTooltipTarget.offsetLeft;
					var top  = hoverTooltipTarget.offsetTop;
					
					box.style.top  = top - box.offsetHeight/2 + 'px';
					box.style.left = left + hoverTooltipTarget.offsetWidth + 'px';
					
					box.style.position = this.defaultAnimate.position || 'absolute';
					box.style.display  = 'block';
					box.style.backgroundColor  = '#FFFFA3';

					
					
					this.tooltipBox = box;
					var bindBox = new Function(this.name+ ".bindBox();");
					bindBox();
				},
				removeBox : function(){
					this.isTooltipHover = false;
					var bindBox = new Function(this.name+ ".bindBox();");
					bindBox();
				},
				bindBox : function(){
					var that = this;
					this.tooltipBox.onmouseover = function(){
						that.isTooltipBoxHover = true;
					};
					this.tooltipBox.onmouseout = function(){
						that.isTooltipBoxHover = false;
						var delayRemoveBox = new Function(that.name+ ".delayRemoveBox();");
						setTimeout(delayRemoveBox,300);
					};
				},
				delayRemoveBox: function(){
					console.log(this.isTooltipHover);
					console.log(this.isTooltipBoxHover);
					if(!this.isTooltipHover && !this.isTooltipBoxHover){
						this.tooltipBox.parentNode.removeChild(this.tooltipBox);
					}
				}
		 }
		 
		 o = new com.footoss.ui.Tip('tooltip','o').render();
		 
 })();
</script>