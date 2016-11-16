<#import "../masterTemplate.ftl" as layout/>

<@layout.masterTemplate title="FAQ" active="faq" brand="Frequently Asked Questions" subBrand="Find answers to the mostly asked questions you make">
    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">

                    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.95.3/css/materialize.min.css" rel="stylesheet"/>

                    <div>
                        <ul class="collapsible" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header"><i class="mdi-navigation-chevron-right"></i>How do I report an incident?</div>
                                <div class="collapsible-body">
                                    <p>You can select the "Make a Report" or "Live Chatroom" panel on the menu to file a report. You can also call our call center, whose
                                        number is found in the "Make a Report" panel on the menu.</p>
                                </div>
                            </li>
                            <li>
                                <div class="collapsible-header"><i class="mdi-navigation-chevron-right"></i>Can i stay anonymous?</div>
                                <div class="collapsible-body">
                                    <p>Yes. In hotline form the name is  optional but in the helpline form the name is necessary.</p>
                                </div>
                            </li>
                            <li>
                                <div class="collapsible-header"><i class="mdi-navigation-chevron-right"></i>What happens to the hotline reports?</div>
                                <div class="collapsible-body">
                                    <p>The reports are checked by an operator and if the case is valid it is sent to the police without any information regarding the person who
                                        made the report, if he/she wishes to remain anonymous.</p>
                                </div>
                            </li>
                        </ul>
                    </div>


                </div>


            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.95.3/js/materialize.min.js"></script>
    </div>

</@layout.masterTemplate>
