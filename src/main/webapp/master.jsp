<%@page import="java.util.List" %>
<%@page import="model.student" %>
<%@ page import="model.master" %>
<%@ page import="model.doctor" %>
<%!
    student student = new student();
    master master = new master();
    doctor doctor = new doctor();
%>
<%


    if (session != null) {


        Object user_list = session.getAttribute("user_list");


        if (user_list == null) response.sendRedirect("signin.jsp");
        else {
            List l = (List) user_list;
            List zz = (List) l.get(0);
            student = (model.student) zz.get(0);

            zz = (List) l.get(1);
            master = (master) zz.get(0);
            zz = (List) l.get(2);
            doctor = (doctor) zz.get(0);
        }
    } else {
        response.sendRedirect("signin.jsp");
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_acc.css">
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
                <li><a href="logout">logout</a></li>
                <li><a href="contact_us.jsp">Contact Us</a></li>
            </ul>
        </div>
    </div>

    <div class="user_navebar">
        <div class="container">

            <img src="img/personal/06.jpg" style=" display: block;
  width: 150px;
  height: 150px;
  margin: 30px 10px 30px 20px;

  background-repeat: no-repeat;

  -webkit-border-radius: 99em;
  -moz-border-radius: 99em;
  border-radius: 99em;
  border: 5px solid #eee;
  box-shadow: 0 3px 2px rgba(0, 0, 0, 0.3); "/>
            <ul>
                <li><a href="profile.jsp">View <span style="color:#ffffff">Master's</span></a></li>
                <li><a href="master.jsp">Upload <span style="color:#ffffff">Master's</span></a></li>
                <li><a href="contact_us.jsp">Contact<span style="color:#ffffff">Us</span></a></li>
            </ul>
        </div>

    </div>
</div>
<div class="acc" style="margin: 10% 30% 20% 27%;">


    <form method="post" action="/addmaster" enctype="multipart/form-data">
        <div class="master">

            <h2>Please add your <span style="color:#2DAAB3">MASTER'S</span></h2>
            <label>Master Name (In english):</label><input type="text" name="en"/>
            <label>Master Name (In Arabic):</label><input type="text" name="ar"/><br><br>

            <div class="des"><h2><label>Description</label></h2><br><br>
                <textarea rows="8" cols="80" name="desc"></textarea>

                <div class="upload"><input type="file" name="file"/></div>
            </div>
            <input style="width: 100px" type="submit" value="Submit"/>

        </div>
    </form>

    <br/>

</div>


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