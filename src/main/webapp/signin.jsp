<!DOCTYPE Html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Graduate Studies</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form method="post" action="login">
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
    </div>
    <div class="applyonline">
        <h2>Applying<span style="color:#2DAAB3">&nbspNow</span></h2>

        <p>Thank you for choosing to apply for admission to a Postgraduate Programme at The University of
            Manchester.</p>

        <h3><span style="color:#2DAAB3">NEW APPLICANT</span></h3>

        <p>If this is your first application:</p>
        <ul>
            <li>Enter your email address. This will be used as your sign on name. We will also use this email address to
                contact you regarding your application.
            </li>
            <li>Type in the security code (case-sensitive). This helps protect our online application service.
            </li>
            <li>Enter your password. Select a password that is easy for you to remember, but is not obvious to others.
            </li>
            <li>Finally click the REGISTER button. You will be asked to confirm your password.
            </li>
        </ul>
        <br>
        Please read the guidance notes before submitting your application.<br>
        Contact<a href="http://www.menofia.edu.eg/">http://www.menofia.edu.eg/</a> if you need further help or would
        like to comment on our online application service. We value your feedback.
        <div class="applay_nw">
            <ul>
                <div id="app" class="applay">
                    <li><a href="#">Applay Now</a></li>
                </div>
            </ul>
            <br>
        </div>
    </div>
    <div class="mainform">
        <div class="secform">
            <form action="emailme" method="post">
                <label>Email Address</label>
                <input type="text" name="email" value=""><br><br>
                <label> Password</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <input type="password" name="password" value="">&nbsp&nbsp<input type="submit" value="forget"
                                                                                 name="forget"/>
                <br><br><br>
                <label>Sign in as Doctor</label>
                <input type="checkbox" name="doc"/>

                <div class="button">
                    <button>Sign on</button>
                    &nbsp&nbsp
                    <button><a href="account.jsp">Register</a></button>
                </div>
            </form>
        </div>
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
</form>
</body>
</html>