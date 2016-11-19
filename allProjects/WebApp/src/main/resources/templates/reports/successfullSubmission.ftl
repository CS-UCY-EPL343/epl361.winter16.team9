<#import "../masterTemplate.ftl" as layout/>

<@layout.masterTemplate title="Submitted" active="reports" brand="Thank you!" subBrand="Your Report has been submitted!">
    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">

                    <form >
                        <label for="copy-input" >Your case id:</label>
                        <div class="input-group">
                            <input id="copy-input" type="text" class="form-control" value="${case_id}" readonly/>
                            <span class="input-group-btn">
                               <button class="btn btn-default" type="button" id="copy-button"
                                       data-toggle="tooltip" data-placement="button" title="Copy">Copy</button>
                            </span>
                        </div>

                    </form>


                </div>


            </div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/submission.js"></script>
</@layout.masterTemplate>
