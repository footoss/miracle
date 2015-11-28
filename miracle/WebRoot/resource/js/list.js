$(document).ready(function(){
	loadList(getPageModel(), '/user/list'); //页面加载时执行，初始化页面
	
	$('#query-btn').click(function(){//点击查询按钮，查询结果
		if($('#id').val()){
			$('#name').val('');
			$('#age').val('');
		}
		loadList(getPageModel(), '/user/list');	
	});

	$('#clear-btn').click(function(){//点击查询按钮，查询结果
		$('.queryParam').each(function(){this.value='';});
	});
	
	$('.queryParam').keydown(function(event){
		 if(event.keyCode == 13){
			 $('#query-btn').trigger('click');
		 }
	});
});
