<#import "../masterTemplate.ftl" as layout/>

<@layout.masterTemplate title="Hotline Report" active="hotline">

<div class="row">
    <h3 id="title" >Hotline Report</h3>

    <form id="form" method="post" action="/hotline/report">

        <div class="form-group">
            <label for="topic"> Topic</label>
            <select class="form-control" id="topic">
                <option>Sexual Abuse</option>
                <option>Sextortion</option>
                <option>Sexting</option>
                <option>Grooming</option>
                <option>Sexual Harassment</option>
            </select>
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input name="email" type="email" class="form-control" id="email" placeholder="Email">
            <div id="errorEmail" style="display:none" class="alert alert-danger" role="alert">Please enter email</div>
        </div>
        <div class="form-group">
            <label for="file">Upload File</label>
            <input type="file" id="file">
            <p class="help-block">Example block-level help text here.</p>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Check me out
            </label>
        </div>
        <button type="button" onclick="submitHotlineForm()"  class="btn btn-default">Submit</button>
    </form>

    <script src="/utils/scripts/jsencrypt.min.js"></script>
    <script src="/hotline/scripts/hotlineForm.js"></script>
</div>

</@layout.masterTemplate>
