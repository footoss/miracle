
(function(){
	
	var validate = 
		[
		 {
				"id"      :"add-name",
				"name"    :"name",
				"type"    :"String",
				"desc"    :"User name",
				"required":true,
				"rules":
					[
					 {"type":1,"content":"","tipID":"","tip":""},
					 {"type":1,"content":"","tipID":"","tip":""}
					],
				"union":{
					"uIDs":[],
					"callback":"function"
				}
			
		 },
		 {
			"id"      :"add-age",
			"name"    :"age",
			"type"    :"int",
			"desc"    :"User age",
			"required":true,
			"rules":
				[
				 {"type":1,"content":"","tipID":"","tip":""},
				 {"type":1,"content":"","tipID":"","tip":""}
				]
	
	   }
      ];
	
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
})();