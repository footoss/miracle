
(function(){
	
var validate =
{
	"form":"formID",
	"fields":[
		{
			"id"      :"add-name",
			"name"    :"name",
			"type"    :"String",
			"desc"    :"User name",
			"required":true,
			"union":{
				"uIDs":[],
				"callback":"function"
			},
			"rules":
				[
				 {"type":1,"content":"","tipID":"","tipFor":"","tip":""},
				 {"type":1,"content":"","tipID":"","tipFor":"","tip":""}
				],
			"isValid":true
		},
		{
			"id"      :"add-age",
			"name"    :"age",
			"type"    :"int",
			"desc"    :"User age",
			"required":true,
			"rules":
				[
				 {"type":1,"content":"","tipID":"","tipFor":"","tip":""},
				 {"type":1,"content":"","tipID":"","tipFor":"","tip":""}
				],
			"isValid":true
			
		}
	],
	"isValid":true
	
};
		
/*	
	function vf(validate){
		$.each(validate,function(i){
			var value = $(this["id"]).val();
			if(this["required"] && !value){
				alert(this["desc"]+" required!");
				return true;
			}
			
			$.each(validate["rules"],function(i){
				
			});
		});
	}	
*/

function showTooltip(target,tipHtml,width,height,direction){
	if($.trim(tipHtml)){
		var tipBox = $('<div></div>');
		var boxWidth  = width ? width+'px':'auto';
		var boxHeight = htight?htight+'px':'auto';
		tipBox.css({"width":boxWidth,"height":boxHeight,"position":"absolute","diplay":"block"});
		tipBox.html(tipHtml);
		
		console.log(this.target);
		
		switch(direction){
		case 'top': break;
		case 'right': break;
		case 'bottom': break;
		case 'left': break;
		default: break;
		}
	}
	
	
	
}



})();