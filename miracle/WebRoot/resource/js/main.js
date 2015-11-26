
$(document).ready(function(){
	
	function getPageModel(currentPage){
		var pageModel = {};
		pageModel.pageSize 		= parseInt($('#pageSize').val()) || 10;
		pageModel.currentPage 	= currentPage || parseInt($('#currentPage').val()) || 1;
		pageModel.queryParams   = {};
		if($('#id').val()) pageModel.queryParams.id= parseInt($('#id').val());
		if($('#name').val()) pageModel.queryParams.name= $('#name').val();
		if($('#age').val()) pageModel.queryParams.age= $('#age').val();
		var json = JSON.stringify(pageModel);
		console.log(json);
		return json;
	}
	
	function loadList(json){
		$.ajax({
			type:'GET',
			url	: contextPath() + '/page/list',
			data:json,
			contentType:'application/json',
			dataType:'json',
			success:function(data){
				successCallback(data);
			},
			complete:function(){
				setTimeout(function(){
					$('#queryReqult').removeClass('bg-result');
				}, 200)
			},
			error:function(){
				alert('error');
			}
		});
	}
	
	loadList(getPageModel()); //页面加载时执行，初始化页面
	
	$('#query-btn').click(function(){
		loadList(getPageModel());	
	});
	
	function successCallback(data){
		var dataList = data.rows;
		var tbody = '';
		var len = dataList.length;
		if(len > 0){
			for(var i = 0 ; i < len; i++){
				var rowData = dataList[i];
				var tr = '<tr> <td>'+ rowData.id + '</td> <td>' 
					+ rowData.name +   '</td> <td>'
					+ rowData.age  +   '</td></tr>';
				tbody += tr;
			}
		}else{
			tbody = '<tr><td colspan="3" style="color:red"> 没有符合搜索条件的结果！</td></tr>' 
		}
//		console.log(tbody);
		$('#list').html ( tbody);	
		
		$('#pageSize').val( data.pageSize);
		$('#totalRecords').html ( data.totalRecords);
		if(data.totalRecords == 0){
			$('#startRecord').html( 0 );
		}else{
			$('#startRecord').html( data.startRecord + 1);
		}
		if(data.endRecord >= data.totalRecords ){
			$('#endRecord').html( data.totalRecords);
		}else{
			$('#endRecord').html( data.endRecord + 1);
		}
		$('#currentPage').html ( data.currentPage);
		$('#totalPages').html ( data.totalPages);
		
		$('#queryReqult').addClass('bg-result');
		
		
		var pageNav = getPageNav(data.navSize,data.currentPage,data.totalPages);
//			console.log(pageNav);
		$('#pageNav').html(pageNav);
		
		$('.pageNav-btn').click(function(){
			var currentPage = this.id.split('-')[1];
			loadList(getPageModel(currentPage));	
		});
	}
	
})