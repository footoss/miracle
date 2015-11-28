function contextPath(){
	var path = document.location.pathname;
	var index = path.substr(1).indexOf('/');
	return path.substr(0,index+1);
}