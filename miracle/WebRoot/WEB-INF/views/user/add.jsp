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
				 	var tooltipBox = $('<div class="tooltipBox">asdfasdf</div>');
				 	target.parent().append(tooltipBox);
				 	var width = 80;
				 	var height = 60;
				 	var offset = target.offset();
				 	var left = offset.left + target.width() + 20;
				 	var top = offset.top - target.height()/2 -height/2;
				 	$('.tooltipBox').css({"position":"fixed","display":"block","width":width+"px",
				 												"height":height+"px","left":left+"px","top":top+"px","z-index":"9999",
				 												"background-color":"#FFFF93","border":"1px solid #EEEE00"
				 												});
				 	
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
	 
})();
</script>