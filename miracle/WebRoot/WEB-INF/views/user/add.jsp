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
	
	var target = document.getElementsByClassName('tooltip');
	var len = target.length;
	for(var i = 0; i  < len;i++){
		target[i].onmouseover = function(){
			
		}
		
		target[i].onmouseout = function(){
			
		}
	}
	
	 var isToolTipHover = false,
	 		 isToolTipBoxHover = false; 
	 $('.tooltip').hover(
			 function () {
		 			isToolTipHover = true;
		 
		 			var target = $(this);
		 			var tips = [];
		 			tips.push('asdfasdf');
		 			tips.push('cvbdsffsfd');
		 			tips.push('lkjlkkj');
		 			showTooltipBox(target,'fixed',160,120,tips);
		 			
				 	
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
		 
		 function showTooltipBox(target,pos,width,height,tips){
			 	
			 	var tipContent = '';
			 	for(var i = 0 ; i < tips.length ; i++){
			 		tipContent += '<li>' + tips[i] + '</li>';
			 	}
			 	
			 	var tooltipBox = $('<div class="tooltipBox"><span class="arrow-left"></span><ul class="tips">'+tipContent+'</ul></div>');
			 	
			 	target.parent().append(tooltipBox);
			 	
			 	var offset = target.offset();
			 	var left = offset.left + target.width() + 20;
			 	var top = offset.top - target.height()/2 -height/2;
			 	$('.tooltipBox').css({"position":pos,"display":"block","width":width+"px",
			 												"height":height+"px","left":left+"px","top":top+"px","z-index":"9999",
			 												"background-color":"#FFFF93","border":"1px solid #EEEE00"
			 												});
		 }
	 
})();
</script>