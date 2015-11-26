
function contextPath(){
	var path = document.location.pathname;
	var index = path.substr(1).indexOf('/');
	return path.substr(0,index+1);
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
		head = '<li id="jump-1" class="pageNav-btn pageJump" >首页</li><li id="jump-'+preStr+'" class="pageNav-btn pageJump">上一页</li>';
		console.log(head);
	}
	if(currentPage < lastPage){
		var nextStr = currentPage+1 + '';
		var lastStr = lastPage + '';
		tail = '<li id="jump-'+nextStr+'" class="pageNav-btn pageJump" >下一页</li><li id="jump-'+lastPage+'" class="pageNav-btn pageJump" >尾页</li>';
	}

	var pageNos = '';
	if(currentPage <= middleNav) {
		for(var i = 1 ; i <= navSize ; i++){
			var pageNo = i;
			if(currentPage != i){
				pageNos += '<li id="pageNo-'+i+'" class="pageNav-btn pageNo" >'+pageNo+'</li>';
			}else{
				pageNos += '<li id="currentPage" class="pageNav-btn current" >-'+pageNo+'-</li>';
			}
		}
	}else if(lastPage - currentPage < middleNav){
		for(var j = 1; j <= navSize ; j++){
			var pageNo = lastPage - navSize + j;
			if(pageNo != currentPage){
				pageNos += '<li id="pageNo-'+j+'" class="pageNav-btn pageNo" >'+pageNo+'</li>';
			}else{
				pageNos += '<li id="currentPage" class="pageNav-btn current">-'+pageNo+'-</li>';
			}
		}
	}else if(currentPage>middleNav && (lastPage - currentPage)>middleNav){
		for(var k=1 ; k <= navSize; k++){
			var pageNo = currentPage + k -middleNav;
			if(pageNo != currentPage){
				pageNos += '<li id="pageNo-'+k+'" class="pageNav-btn pageNo" >'+pageNo+'</li>';
			}else{
				pageNos += '<li id="currentPage" class="pageNav-btn current" >-'+pageNo+'-</li>';
			}
		}
	}

	pageNav = '<ul>' + head + pageNos + tail + '</ul>';
	return pageNav;
}