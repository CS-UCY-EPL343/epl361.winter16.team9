<#macro masterTemplate title="" active="">
<html>
<head>
    <title>${title}</title>
    <meta charset="utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"/>

    <!-- Custom styles for this template -->
    <link href="./justified-nav.css" rel="stylesheet">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="masthead">
        <div class="jumbotron">
            <h1>Cyprus Cyber Crime Report Tool</h1>
        </div>
        <nav>
            <ul class="nav nav-justified">
                <li  <#if active == "index"> class="active" </#if> > <a href="${WebPath.getINDEX()}">Home</a></li>
                <li  <#if active == "hotline"> class="active" </#if> > <a href="${WebPath.getHOTLINE()}">Hotline</a></li>
                <li  <#if active == "helpline"> class="active" </#if> > <a href="${WebPath.getHELPLINE()}">Helpline</a></li>
                <li  <#if active == "chat"> class="active" </#if> > <a href="${WebPath.getCHAT()}">Chat</a></li>
                <li><a href="#">Describe your problem</a></li>
            </ul>
        </nav>
    </div>

    <#nested/>

</div>
</body>
</html>
</#macro>