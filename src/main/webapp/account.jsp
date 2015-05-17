<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_acc.css">
  <script>
      function validate(){
          var name=document.forms["myform"]["name"].value;
          var email=document.forms["myform"]["email"].value;
          var password=document.forms["myform"]["password"].value;
          var confirm=doocument.forms["myform"]["confirm_passwor"].value;

          if(name==null||name==""){
              alert("Name must be filled out");
              return false;
          }else if(email==null||email=="") {
              alert("email must be filled out");
              return false;
          }
          else if(password==null||password==""){
                  alert("password must be filled out");
                  return false;

              }else if(confirm ==null||confirm==""){
              alert("You  must be Confirm password");
              return false;

          }


      }


  </script>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="intro">
            <h2>Graduate Studies</h2>
            <button><a href="#app">Applay Now</a></button>
        </div>
    </div>
    <div class="navbar">
        <div class="container">
            <h2>Menofia<span style="color:#2DAAB3">university</span></h2>
            <ul>
                <li><a href="Graduate_Studies.jsp">Home</a></li>
                <li><a href="signin.jsp">Login/</a><a href="account.jsp">Registration</a></li>
                <li><a href="signin.jsp">logout</a></li>
                <li><a href="contact_us.jsp">Contact Us</a></li>

            </ul>
        </div>
    </div>
</div>
<style>
    tr {
        border-spacing: 25em
    }
</style>

<form name="myform" method="post" action="account"  onsubmit="return validate()" enctype="multipart/form-data">
<div class="account">
    <h1>Create <span style="color:#2DAAB3">New</span> Account</h1>

    <div class="form"  style="margin-left: 15%" >
        <table style="border-collapse:separate;
border-spacing:1em;">
            <tr>
                <td>
                    <img src="img/user.png"/>

                </td>
                <td>
                    <input type="file" name="image">
                </td>
            </tr>
            <tr>
                <td><label>Email :</label></td>
                <td><input tybe="Email" name="Email"></td>
            </tr>
            <tr>
            <td><label>name :</label></td>
            <td><input tybe="text" name="name"></td>
        </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><input tybe="text" name="password"></td>
            </tr>
            <tr>
                <td><label>Confirm Password:</label></td>
                <td><input tybe="text" name="confirm_password"></td>
            </tr>
            <tr>
                <td><label>Mobile:</label></td>
                <td><input tybe="text" name="mobile"></td>
            </tr>
            <tr>
                <td><label>Adress:</label></td>
                <td><input tybe="text" name="adress"></td>
            </tr>
            <tr>
                <td><label>Date of Birth:</label></td>
                <td><input type="date" style="color: #1D1D1D;width: 63%" name="date_birth"></td>
            </tr>
            <tr>
                <td><label>University:</label></td>
                <td><input tybe="text" name="University"></td>
            </tr>
            <tr>
                <td><label>Faculty OF:</label></td>
                <td><input tybe="text" name="faculty"></td>
            </tr>
            <tr>
                <td><label>SNN:</label></td>
                <td><input tybe="text" name="snn"></td>
            </tr>
            <tr>
                <td><label>Date of Graduate:</label></td>
                <td><input type="date" style="color: #1D1D1D;width: 63%" name="date_grad"></td>
            </tr>
            <tr>
                <td><label>Hints</label></td>
                <td><textarea name="hints" style="color: #1D1D1D"></textarea></td>
            </tr>
        </table>

        <div class="button">
            <button>Sign On</button>
        </div>
    </div>
</div>
</form>
<div id="contact" class="footer">
    <div class="contact_us">
        <p>Contact us<br><br><br>
            <span style="color:#AAAAAA">Eng:Hamada :+2(0)01067121424</span>
        </p>
    </div>
    <div class="find_us">
        <p>Find Us<br><br><br>
            <span style="color:#AAAAAA"><a href="http://www.menofia.edu.eg">Menofia Unevirsty</a></span></p>

        <div class="icons">
            <p>Contact With us<br><br><br>
                <a href="http://www.menofia.edu.eg/"><img src="img/f.png"></a>
                <a href="http://www.google.com"><img src="img/twitter.png"></a>
                <a href="http://wwww.twitter.com"><img src="img/googleplus.png"></a>
            </p>
        </div>
    </div>
</div>
</body>
</html>