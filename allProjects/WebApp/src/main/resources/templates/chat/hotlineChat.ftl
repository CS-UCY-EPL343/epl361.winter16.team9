<#import "../masterTemplate.ftl" as layout/>
<@layout.masterTemplate title="Hotline Chatroom" active="chat" brand="Hotline Chatroom" subBrand="Enter the hotline chatroom to talk with one of our operators live">
<div class="container">        
<div class="row">
    <div class="box">
        <div class="col-lg-12">
            <p>Open up a new chatroom to talk with a trained operative.</p>
            <form role="form">
            <div class="row">
			<div class="form-group col-lg-12">
                <input type="hidden" name="save" value="session">
                <center><button type="submit" class="btn btn-default">New Session</button></center>
            </div>
        </div>
    </form>
</div>
</div>
</div>
<div class="row">
    <div class="box">
        <div class="col-lg-12">
            <p>Enter your case ID number to enter a chatroom to talk about that case.</p>
            <form role="form">
            <div class="row">
                <div class="form-group col-lg-12">
                    <center><label>Case ID Number</label></center>
                    <input type="text" class="form-control">
                </div>
                <div class="clearfix"></div>                            <div class="form-group col-lg-12">
                <input type="hidden" name="save" value="session">
                <center><button type="submit" class="btn btn-default">Submit</button></center>
            </div>
        </div>
    </form>
</div>
</div>
</div>

</@layout.masterTemplate>
