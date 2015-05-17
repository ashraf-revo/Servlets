<!DOCTYPE html>
<%@page import="java.util.List" %>
<%@page import="model.student" %>
<%@ page import="model.master" %>
<%@ page import="model.doctor" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<html>
<head>
    <meta charset="utf-8">
    <title>account </title>
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

            <img src="img/personal/<%=student.getProfile_picture()%>" style=" display: block;
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
<div class="account" style="margin: 10% 30% 20% 30%;width: 800px;height: 800px">

    <style>

        .panel-danger {
            border-color: #ffafbd;
            -webkit-border-radius: 3px;
            -webkit-background-clip: padding-box;
            -moz-border-radius: 3px;
            -moz-background-clip: padding;
            border-radius: 3px;
            background-clip: padding-box;
        }

        .panel {
            margin-bottom: 17px;
            border: 1px solid transparent;
            border-radius: 3px;
            margin-left: 20px;
            margin-right: 10px;
        }

        body {
            font-family: "Helvetica Neue", Helvetica, "Noto Sans", sans-serif, Arial, sans-serif;
            font-size: 12px;
            line-height: 1.42857143;
            color: #949494;
        }

    </style>
    <%
        if (master.getId_master() != null) {%>
    <div class="panel panel-danger" data-collapsed="0">
        <div class="panel-heading" style="padding-bottom: 50px">
            <div class="panel-title" style="float: left;margin-left: 100px">
                <%=master.getArabic_name()%>
            </div>
            <div class="panel-title" style="float: right;margin-right: 100px">
                <%=master.getEnglish_name()%>
            </div>

        </div>
        <div class="panel-body">
            <p>
                <%=master.getSubject()%>
            </p>
        </div>
        <div class="panel-title" style="float: left;margin-left: 0px">
            <p style="color: #03cc85;margin-left: 100px"> ststus : <%=master.getStatus()%>
            </p>

            <%=master.getResion()%><br/>
        </div>
        <div class="panel-title" style="float: right;margin-right: 100px">
            <%if (doctor.getFull_name() != null) out.print(doctor.getEmail());%>
        </div>
    </div>
    <%
        }
    %>
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