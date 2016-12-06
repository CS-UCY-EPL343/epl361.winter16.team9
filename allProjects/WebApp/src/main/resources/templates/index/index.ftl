<#import "../masterTemplate.ftl" as layout/>

<@layout.masterTemplate title="Cyber Crime Report" active="index" brand="Case Management Platform and Tools" subBrand="Report Internet crimes easily and anonymously">

<div class="container">

<div class="row">


    <div class ="col-xs-6 text-center">
        <div class="box" style="background-color:#CCFF99">
            <h1 > <strong>Helpline</strong></h1>
            <p> Contact us with your online safety concerns</p>
            <br/>
            <button style="padding: 20px 50px;font-size:20px" class="btn btn-success " id="helplineReport"><big>Report</big></button>

        </div>
    </div>
    <div class ="col-xs-6 text-center">
        <div class="box" style="background-color:#FFBC9A">
            <h1 > <strong>Hotline</strong></h1>
            <p>Anonymous and safe place to report online child sexual abuse imagery and videos</p>
            <button style="padding: 20px 50px;font-size:20px" class="btn btn-danger" id="hotlineReport"><big>Report</big></button>
        </div>
    </div>

</div>

<div class="row">
    <div class="box">
        <div class="col-lg-12">
            <hr/> <h2 class="intro-text text-center">About Us <strong>What do we do?</strong>
            </h2>
            <hr/>
            <img class="img-responsive img-border img-left" src="img/man-coffee-cup-pen.jpg" alt=""/>
            <hr class="visible-xs"/>
            <p>We are a non-governmental and non-profit organization that aims to enable victims of cyber crimes to report those crimes easily and, if they chose so, anonymously.</p>
            <p>Our mission is to make sure you get the help that you need as soon as possible. You have the right to speak up against those that would commit crimes against you.
                We put our voice behind yours, because we <i>know</i> that you are not alone.</p>
            <p>Make a report now. Help us give you the help that you deserve.</p>
        </div>
    </div>
</div>



<div class="row">
    <div class="box">
        <div class="col-lg-12">
            <hr/>
            <h2 class="intro-text text-center">
                <strong>Contact Us</strong>
            </h2>
            <hr/>
            <center>
                <br/><b>Tel.:</b> 22 123456 <b>Fax:</b> 22 123455<br/><b>email:</b> contactus@cyberethics.eu<br/>
                <a href="#">
                    <img src="img/fb.png" alt="Visit our facebook page." width="50px" height="50px"/>
                </a>
                <a href="#">
                    <img src="img/twitter.png" alt="Follow us on twitter." width="40px" height="40px"/>
                </a>
                <a href="#">
                    <img src="img/google+.png" alt="Visit our google+ profile." width="40px" height="40px"/>
                </a>
            </center>
        </div>
    </div>
</div>

</div>
        <!-- /.container -->


<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
<script src="/js/reports.js"></script>
</@layout.masterTemplate>
