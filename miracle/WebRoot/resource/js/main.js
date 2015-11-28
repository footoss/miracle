
function contextPath(){
	var path = document.location.pathname;
	var index = path.substr(1).indexOf('/');
	return path.substr(0,index+1);
}

function getPageModel(pageSize,currentPage,lastPage){
	var pageModel = {};
	pageModel.pageSize 		= pageSize || parseInt($('#pageSize').val()) || 10;
	pageModel.currentPage 	= currentPage || parseInt($('#currentPage').val()) || 1;
	pageModel.lastPage 		= lastPage || parseInt($('#lastPage').attr('pn')) || 1;
	pageModel.queryParams   = {};
	if($('#id').val()) pageModel.queryParams.id= parseInt($('#id').val());
	if($('#name').val()) pageModel.queryParams.name= $('#name').val();
	if($('#age').val()) pageModel.queryParams.age= $('#age').val();
	var json = JSON.stringify(pageModel);
	console.log(json);
	return json;
}

function getPageNav(navSize,currentPage,lastPage){
	
	if(lastPage < 0){alert('The last page number is wrong! Please check!');}
	
	if(lastPage == 0){  }

	if(navSize < 2) navSize = 2;
	if(navSize > lastPage) navSize = lastPage;
	if(currentPage < 1) currentPage = 1;
	if(currentPage > lastPage) currentPage =lastPage;

	var middleNav = parseInt(navSize/2) + 1;


	var pageNav = '',head = '',tail = '', pageNos = '';
	if(currentPage > 1){
		var preStr = currentPage - 1 + '';
		head = '<li id="firstPage" pn="1" class="pageNav-btn pageJump" >首页</li><li id="prevPage" pn="'+preStr+'" class="pageNav-btn pageJump">上一页</li>';
	}
	if(currentPage < lastPage){
		var nextStr = currentPage+1 + '';
		var lastStr = lastPage + '';
		tail = '<li id="nextPage" pn="'+nextStr+'" class="pageNav-btn pageJump" >下一页</li><li id="lastPage" pn="'+lastPage+'" class="pageNav-btn pageJump" >尾页</li>';
	}

	var pageNos = '';
	if(currentPage <= middleNav) {
		for(var i = 1 ; i <= navSize ; i++){
			var pageNo = i;
			if(currentPage != i){
				pageNos += '<li id="pn-'+pageNo+'" pn="'+pageNo+'" class="pageNav-btn pageNo" >'+pageNo+'</li>';
			}else{
				pageNos += '<li id="currentPage" pn="'+pageNo+'"  class="pageNav-btn current" >-'+pageNo+'-</li>';
			}
		}
	}else if(lastPage - currentPage < middleNav){
		for(var j = 1; j <= navSize ; j++){
			var pageNo = lastPage - navSize + j;
			if(pageNo != currentPage){
				pageNos += '<li id="pn-'+pageNo+'" pn="'+pageNo+'"  class="pageNav-btn pageNo" >'+pageNo+'</li>';
			}else{
				pageNos += '<li id="currentPage" pn="'+pageNo+'"  class="pageNav-btn current">-'+pageNo+'-</li>';
			}
		}
	}else if(currentPage>middleNav && (lastPage - currentPage) >= middleNav){
		for(var k=1 ; k <= navSize; k++){
			var pageNo = currentPage + k -middleNav;
			if(pageNo != currentPage){
				pageNos += '<li id="pn-'+pageNo+'" pn="'+pageNo+'" class="pageNav-btn pageNo" >'+pageNo+'</li>';
			}else{
				pageNos += '<li id="currentPage" pn="'+pageNo+'" class="pageNav-btn current" >-'+pageNo+'-</li>';
			}
		}
	}

	pageNav = '<ul>' + head + pageNos + tail + '</ul>';
	return pageNav;
}

function loadList(json,url){
	$.ajax({
		type:'GET',
		url	: contextPath() + url,
		data:json,
		contentType:'application/json',
		dataType:'json',
		success:successCallback, //successCallback(data,textStatus)
		complete:function(){
			setTimeout(function(){
				$('#queryReqult').removeClass('bg-result');
			}, 500)
		},
		statusCode: {
		    404: function() {
		    	alert( "page not found" );
		    },
		    500:function(){
		    	alert("Server Internal Error!");
		    }
		},
		error:function(){
			alert('error');
		}
	});
	

	function successCallback(data){
		setList(data);
		setResultSummary(data);
		setPageNav(data,url);
	}

	function setResultSummary(data){
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
		$('#current').html ( data.currentPage);
		$('#totalPages').html ( data.totalPages);
		
		$('#queryReqult').addClass('bg-result');
	}

	function setList(data){
		var dataList = data.rows;
		var tbody = '';
		var len = dataList.length;
		if(len > 0){
			for(var i = 0 ; i < len; i++){
				var rowData = dataList[i];
				var tr = '<tr> <td> <input type="checkbox" class="todo" id="todo-'+ rowData.id + '" value="'+ rowData.id +'" /></td> <td>' 
					+ rowData.name +   '</td> <td>'
					+ rowData.age  +   '</td></tr>';
				tbody += tr;
			}
		}else{
			tbody = '<tr><td colspan="3" style="color:red"> 没有符合搜索条件的结果！</td></tr>' 
		}
//			console.log(tbody);
		$('#list').html ( tbody);
	}

	function setPageNav(data,url){
		var pageNav = getPageNav(data.navSize,data.currentPage,data.totalPages);
//			console.log(pageNav);
		$('#pageNav').html(pageNav,url);
		
		if($('.pageNav-btn')){
			$('.pageNav-btn').click(function(){
				var pageSize 	= parseInt($('#pageSize').val());
				var currentPage = parseInt(this.getAttribute('pn')); //this.id.split('-')[1];
				var lastPage 	= parseInt($('#lastPage').attr('pn')) || 1;
				loadList(getPageModel(pageSize,currentPage,lastPage), url);	
			});
		}
		
	}
}
