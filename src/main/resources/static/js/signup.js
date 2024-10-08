$("#chk").on("click", (e)=>{
	e.preventDefault();
	
	const username = $("#username").val();
	$.ajax({
		type : "GET",
		url : "/idcheck?username=" + username
	}).done(function(response){
		console.log(response); /*여러정보가 담긴 객체로 응답받았을때는 명시가 필요!*/
		
		if(response == 0){
			alert("사용 가능한 아이디 입니다.");
		}else{
			alert("사용 불가능한 아이디 입니다.");
		}
		
	}).fail(function(error){
		console.log(error);
	})
	
})