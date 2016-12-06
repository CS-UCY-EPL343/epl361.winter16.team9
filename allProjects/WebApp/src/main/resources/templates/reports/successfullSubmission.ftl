<#import "../masterTemplate.ftl" as layout/>

<@layout.masterTemplate title="Submitted" active="reports" brand="Thank you!" subBrand="Your Report has been submitted!">
    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">

                    <form >
                        <label for="copy-input" > <h3> Your case id:</h3></label>
                        <div class="input-group">
                            <input style="font-size:20px" id="copy-input" type="text" class="form-control" value="${case_id}" readonly/>
                            <span class="input-group-btn">
                               <button class="btn btn-default" type="button" id="copy-button"
                                       data-toggle="tooltip" data-placement="button" title="Copy">Copy</button>
                            </span>
                        </div>
                    </form>


                </div>


            </div>
        </div>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading text-center"> <h3> Confirmation </h3></div>
                <div class="panel-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td> <strong>Date Completed:</strong> </td>
                            <td> ${date} </td>
                        </tr>

                        <tr>
                            <td> <strong>Topic:</strong></td>
                            <td> ${topic} </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/submission.js"></script>
    </div>
</@layout.masterTemplate>
