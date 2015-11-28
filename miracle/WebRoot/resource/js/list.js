$(document).ready(function(){
	loadList(getPageModel(), '/user/list'); //页面加载时执行，初始化页面
	
	$('#query-btn').click(function(){//点击查询按钮，查询结果
		loadList(getPageModel(), '/user/list');	
	});
	
	$('.queryParam').keydown(function(event){
		 if(event.keyCode == 13){
			 $('#query-btn').trigger('click');
		 }
	});
	
	
});
