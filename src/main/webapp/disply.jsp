<%@page import="java.util.List" %>
<%@ page import="model.displayx" %>

<%
    if (session != null) {

        String doc = (String) session.getAttribute("doc");

        if (doc == null || doc.trim().equals("")) response.sendRedirect("signin.jsp");
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
    <script src="css/jquery-latest.min.js"></script>
    <script src="css/jquery-1.10.2.js"></script>

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
    <div class='main'>


        <script>
            $(document).ready(function () {
                $('.somebutton').click(function () {
                    var id = $(this).attr('id');
                    $.get('/ajaxstate?email=' + id, function (responseText) {
                        $("#textemail").val(responseText.data.email);
                        $("#reson").val(responseText.data.resion);
                        var status = responseText.data.status;
                        if (status == "Pending....")
                            $("#state").prop("checked", false);
                        else {
                            $("#state").prop("checked", true);
                        }
                    });
                });
            });
        </script>
       <div class="Search">
           <h2>Search <span style="color:#2DAAB3">For</span> Email</h2>
        <form method="get" action="display">
            <input type="text" name="search"><br><br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="Search">
        </form>
       </div>
        <div id="form" class="form">
            <h2>Eidt <span style="color:#2DAAB3">Information</span></h2>

            <form action="updateState" method="post">
                <label>Email:</label>
                <input type="text" id="textemail" value="" name="email"/>

                <label>Reason:</label>
                <textarea id="reson" rows="1" style="color: black"name="reson"></textarea><br><br>
                <label>Status:</label>
                <input type="checkbox" id="state" name="state">
                <input type="submit">
            </form>
        </div>

        <table class="heavyTable">
            <thead>
            <tr>
                <th>image</th>
                <th>name or email</th>
                <th>master name</th>
                <th>master desc</th>
                <th>files</th>
                <th>Status</th>
                <th>load</th>

            </tr>
            </thead>
            <tbody>

            <% List<displayx> e = (List<displayx>) request.getAttribute("data");%>


            <%

                for (displayx displayx : e) {
                    out.print("<tr>");
                    out.print("<td><img  src='img/personal/" + displayx.getImg() + "' style=' display: block;width: 150px;height: 150px;margin: 30px 10px 30px 20px;background-repeat: no-repeat;-webkit-border-radius: 99em;-moz-border-radius: 99em;border-radius: 99em;border: 5px solid #eee;box-shadow: 0 3px 2px rgba(0, 0, 0, 0.3); '></td>");
                    out.print("<td>" + displayx.getName() + "</td>");
                    out.print("<td>" + displayx.getMaster() + "</td>");
                    out.print("<td>" + displayx.getDesc() + "</td>");
                    out.print("<td>");
//                    /download?filename=06.jpg
                    for (String s : displayx.getFilename()) {
                        out.print("<a href='/download?filename=" + s + "'>" + s + "</a></br>");

                    }
                    out.print("</td>");
                    out.print("<td>" + displayx.getStates() + "</td>");

                    out.print("<td>" + "<button class='somebutton'  id='" + displayx.getName() + "'>load</button>" + "</td>");

                    out.print("</tr>");
                }
            %>


            </tbody>
        </table>
    </div>


</div>


<style>
    table {
        width: 100%;
        max-width: 1000px;
        height: 320px;
        border-collapse: collapse;
        border: 1px solid #2DAAB3;
        margin: 50px auto;
        background: white;
    }

    th {
        background: #2DAAB3;
        height: 54px;
        width: 20%;
        font-weight: lighter;
        text-shadow: 0 1px 0 #38678f;
        color: white;
        border: 1px solid #38678f;
        box-shadow: inset 0px 1px 2px #568ebd;
        transition: all 0.2s;
    }

    tr {
        border-bottom: 1px solid #cccccc;
    }

    tr:last-child {
        border-bottom: 0px;
    }

    td {
        border-right: 1px solid #cccccc;
        padding: 10px;
        transition: all 0.2s;
    }

    td:last-child {
        border-right: 0px;
    }

    td.selected {
        background: #d7e4ef;

    }

    td input {
        font-size: 14px;
        background: none;
        outline: none;
        border: 0;
        display: table-cell;
        height: 100%;
        width: 100%;
    }

    td input:focus {
        box-shadow: 0 1px 0 steelblue;
        color: steelblue;
    }

    ::-moz-selection {
        background: steelblue;
        color: white;
    }

    ::selection {
        background: steelblue;
        color: white;
    }

    .heavyTable {
        box-shadow: 0 10px 30px #2DAAB3;
        margin-left: -80px;
        padding-right: 100px;
        animation: float 5s infinite;

    }

    .form {
        color: #fff;
        margin-left: -80px;
        padding-bottom: 30px;
        width: 1160px;
        border: 3px solid #2DAAB3;
    }

    .form input {
        color: black;
    }

    .form input, .form label {
        margin-left: 100px;
    }

    .form textarea {
        margin-top: 50px;
    }

    .form h2 {
        text-align: center;
    }

    .main {
        max-width: 1000px;
        padding: 10px;
        margin: auto;
    }

    .content {
        color: white;
        text-align: center;
    }

    .content p,
    .content pre,
    .content h2 {
        text-align: left;
    }

    .content pre {
        padding: 1.2em 0 0.5em;
        background: white;
        background: rgba(255, 255, 255, 0.7);
        border: 1px solid rgba(255, 255, 255, 0.9);
        color: #38678f;
    }

    .content .download {
        margin: auto;
        background: rgba(255, 255, 255, 0.1);
        display: inline-block;
        padding: 1em 1em;
        border-radius: 12em;
        margin-bottom: 2em;
    }

    .content .button {
        display: inline-block;
        text-decoration: none;
        color: white;
        height: 48px;
        line-height: 48px;
        padding: 0 20px;
        border-radius: 24px;
        border: 1px solid #38678f;
        background: steelblue;
        box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 1px 3px rgba(255, 255, 255, 0.2);
        transition: all 0.1s;
    }

    .content .button:hover {
        background: #4f8aba;
        box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 10px rgba(255, 255, 255, 0.1);
    }

    .content .button:active {
        color: #294d6b;
        background: #427aa9;
        box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 5px rgba(0, 0, 0, 0.2);
    }

    .content .button:focus {
        outline: none;
    }

    h1 {
        text-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
</style>
</body>
</html>