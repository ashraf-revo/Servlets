<!DOCTYPE Html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Graduate Studies</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">


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
                <li><a href=logout">logout</a></li>
                <li><a href="contact_us.jsp">Contact Us</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="contact">
    <h2>Contact <span style="color:#2DAAB3">Us</span></h2>

    <form class="send_email" method="post" action="emailme">
        <label>From:</label>
        <input type="text" name="from"><br><br>
        <label>Title:&nbsp</label>
        <input type="text" name="title"><br><br>
        <label>Subject:</label><br><br>
        <textarea rows="20" cols="80" name="message"></textarea><br><br>
        <button>Send</button>
    </form>
</div>
<div id="contact" class="footer">
    <div class="contact_us">
        <p>Contact us<br><br><br>
            <span style="color:#AAAAAA">Eng:Hamada :+2(0)01067121424</span>
        </p>
    </div>
    <div class="find_us">
        <p>Find Us<br><br><br>
            <span style="color:#AAAAAA"><a href="http://www.menofia.edu.eg/">Menofia Unevirsty</a></span></p>

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