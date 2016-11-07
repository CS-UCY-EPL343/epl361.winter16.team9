<#import "../masterTemplate.ftl" as layout/>

<@layout.masterTemplate title="Hotline" active="hotline">

<div class="row">
    <h3>Mission</h3>

    <p> CyberEthics Hotline promotes the safe use of Internet in Cyprus. It serves the needs
        of all people that live on the island (i.e., also Turkish Cypriots and other minorities) and
        addresses issues of child pornography, child erotica, child nudism, child grooming activities,
        child trafficking, child sex tourism, but also racism (currently on the rise in Cyprus),
        gender discrimination and inappropriate use of peoples' images.
    </p>
    <p>
        It operates as a combined Awareness Node and a Hotline under the name CyberEthics. The project engages
        actors from the government and the civil society, thus contributing towards the eradication of cyber
        crime through informed actions of European citizens and public institutions that aim to change behaviors,
        mentality and attitudes, giving special emphasis to rural and less developed areas of the country.
    </p>

    <div class="btn-group btn-group-justified" role="group" >
        <div class="btn-group" role="group">
            <button onclick="gotoHotlineForm()" type="button" class="btn btn-danger"> Report</button>
        </div>
    </div>

<script src="hotline/hotline.js"></script>
</div>

</@layout.masterTemplate>
