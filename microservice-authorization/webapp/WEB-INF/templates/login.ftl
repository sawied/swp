
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSO sign in</title>
<style type="text/css">
body{
font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
}
.defaultBg{
background-color: #f9f9f9;
}
div.header{
padding-top: 32px !important;
}

div.logo-container{
width: 100%;
text-align: center;
}
.logo-container.title{
font-size: 24px;
font-weight: 300;
color: #333;
text-shadow: 0 -1px 0 rgba(0,0,0,0.3);
}
div.auth-form-body{
padding: 20px;
border: 1px solid #d8dee2;
border-radius: 5px;
background-color: #fff;
border-radius: 0 0 3px 3px;
margin-top: 16px !important;
width: 340px;
margin: 0 auto;
}
.auth-form-body label{
display: block;
margin-bottom: 7px;
font-weight: 600;
}

.form-control, .form-select {
    min-height: 34px;
    padding: 6px 8px;
    font-size: 14px;
    line-height: 20px;
    color: #24292e;
    vertical-align: middle;
    background-color: #fff;
    background-repeat: no-repeat;
    background-position: right 8px center;
    border: 1px solid #d1d5da;
    border-radius: 3px;
    outline: none;
    box-shadow: inset 0 1px 2px rgba(27,31,35,0.075);
}
.input-block{
display: block;
width: 100%;
margin-top: 5px;
margin-bottom: 15px;
box-sizing: border-box;
}
.btn-primary{
color: #fff;
background-color: #28a745;
background-image: linear-gradient(-180deg, #34d058 0%, #28a745 90%);
position: relative;
display: inline-block;
padding: 6px 12px;
font-size: 14px;
font-weight: 600;
line-height: 20px;
white-space: nowrap;
vertical-align: middle;
cursor: pointer;
-webkit-user-select: none;
-moz-user-select: none;
-ms-user-select: none;
user-select: none;
background-repeat: repeat-x;
background-position: -1px -1px;
background-size: 110% 110%;
border: 1px solid rgba(27,31,35,0.2);
border-radius: 0.25em;
-webkit-appearance: none;
-moz-appearance: none;
appearance: none;
display: block;
width: 100%;
text-align: center;
margin-top: 20px;
}
</style>
</head>
<body class="defaultBg">
	
	<div class="header">
	 <div class="logo-container">
	   <span class="title">Sign in to mobile banking</span>
	 </div>
	</div>
	
	<div class="auth-form-body mt-3">
	

	<div class="main">
		<form action="login" method="post">
        <label for="login_field">
          Username or email address
        </label>
        <input autocapitalize="off" value="danan" autocorrect="off" autofocus="autofocus" class="form-control input-block" id="login_field" name="username" tabindex="1" type="text">

        <label for="password">
          Password 
        </label>
        <input class="form-control form-control input-block" id="password" name="password" tabindex="2" type="password">

        <input class="btn btn-primary btn-block" data-disable-with="Signing in…" name="commit" tabindex="3" value="Sign in" type="submit">
        
        </form>
      </div>
	
	
	</div>
</body>
</html>