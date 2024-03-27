function f1(){
	var name=document.getElementById("userName");
	if(name.value==""){
		alert("The user can not be null");
		name.focus();
		return false;
	}
	var password=document.getElementById("password");
	var password2=document.getElementById("password2");
	if(password.value==""){
		alert("The password can not be null");
		password.focus();
		return false;
		}
	if(password.value!=password2.value){	
			alert("Two passwords are not consistent with each other");
			password.focus();
			return false;
		
	}
	
	var telephone=document.getElementById("user_telephone");
	if(telephone.value==""){
		alert("The telephone can not be null");
		telephone.focus();
		return false;
	}
	var email=document.getElementById("user_email");
	if(email.value==""){
		alert("The email can not be null");
		email.focus();
		return false;
	}
	var birthday=document.getElementById("user_birthday");
	if(birthday.value==""){
		alert("The birthday can not be null");
		birthday.focus();
		return false;
	}
	var address=document.getElementById("user_address");
	if(address.value==""){
		alert("The address can not be null");
		address.focus();
		return false;
	}
	var postcode=document.getElementById("user_postcode");
	if(postcode.value==""){
		alert("The postcode can not be null");
		postcode.focus();
		return false;
	}

}