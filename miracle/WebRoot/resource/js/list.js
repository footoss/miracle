$(document).ready(function(){
	loadList(getPageModel(), '/page/list'); //页面加载时执行，初始化页面
	
	$('#query-btn').click(function(){//点击查询按钮，查询结果
		loadList(getPageModel(), '/page/list');	
	});
});
