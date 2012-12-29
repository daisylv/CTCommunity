// JavaScript Document
$(document).ready(function(){
$(".userName").blur(function(){
	var nameString=$("#userName").val();
if(nameString.length<10||nameString.length>20){
	$(".alert_username").show();
}else{
	$(".alert_username").hide();
	}
});
});

$("#formID").validationEngine({  validationEventTriggers:"keyup blur", 
success : false,  failure : function() { callFailFunction() }  }) 