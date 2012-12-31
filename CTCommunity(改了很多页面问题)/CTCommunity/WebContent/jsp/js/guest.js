function checkGuest(uname){
	var username = uname;
	if(username == null){
		easyDialog.open({
		  container : {
		    header : '登陆提示',
		    content : '您现在的身份是游客，不能使用该功能'
		  }
		});	
		return false;
	}
}