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
	
	
	var add_HTML = '';
	$('#add-init-btn').click(function(){
		if(!add_HTML){
			$.get(contextPath()+'/user/add',function(data){	
				add_HTML = data; 
				initAddPage(add_HTML);
			});
		}else{
			initAddPage(add_HTML);
		}
	});
	
	function initAddPage(data){
		$('#add-content').html(data);
		$('#add-cancel-btn').click(function(){
			$('#add-content').html('');
		});
		$('#add-btn').click(function(){
			var user = {};
			if($('#add-name').val()){ 
				user.name = $('#add-name').val(); 
			}else{
				alert('姓名不能为空');
				return;
			}
			if($('#add-age').val()) { 
				user.age  = $('#add-age').val(); 
			}else{
				alert('年龄不能为空！');
				return;
			}
			var user_JSON = JSON.stringify(user);
			$.post(contextPath()+'/user/add', user_JSON,function(data,status){
				var row = '<tr><td> <input type="checkbox" class="todo" value="'+data["id"]+'" /></td><td>'
								+data["name"]+'</td><td>'+data["age"]+'</td></tr>'
				$('#list tr:first').before(row);
				$('#list tr:first').css({"background-color":"#C3FFFF"});
				setTimeout(function(){$('#list tr:first').css({"background-color":"#FFFFFF"});},1000);
				$('#add-content').html('');
			},'json');
		});
	}
	
});
