console.log("Script Loaded");

//var publicKey = "-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBwzIhtuS2m/9SXH3wSDNl0M1x\nif9FfpfmsQe0PMGY07btBU49YuqqsvV80UnUuitQ4it4FmrdbvHCUEJoBkQOQVxC\nM+GbhW1lA/5jPclvP/QCebjT8GKaXayRsc66wpzLoX1hP7KwxKFK2TR4o9QtrtSr\non7fBmn6RF8TqaJ/8QIDAQAB\n-----END PUBLIC KEY-----";
var publicKey="-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkyE1kirpywXEYW6tg1LN\nhPtt/LHWge5o+tJyMGe3xkSNJg90egdmcQnThbkvXJf38m/dG+Q7gvI/rKv01hMr\n86TS0q3GvU2kDdRIT0J2hTt2GAG1t+4mLP7yT/MFZW5/a3YgOi4//Vn5HjGHfe9S\nJxlY6RCUzICVC+HFo45j65Xpx7bJ46tjKahekOp0gmw3VH1v+0+Ev+V5IIQYx8Ey\n3AMXbA/e5z2b1+AUeFITv5fK7aEe4awSPWBWVVI93b/mZ+Hhibdx/p1IVbLv8NXU\nmlcK/hRdrZuIH0deIob0mzjpCT3vZ44QTlvAQmd9dTfPX/iMqxK+RfXZXkOHljEF\nDQIDAQAB\n-----END PUBLIC KEY-----"

$(document).ready(function(){

    $("#email").focus(function(){
        $("#errorEmail").hide();
    });

});

function submitHotlineForm(){
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey);

    var email = document.getElementById('email').value;
    if(!email){
        $("#errorEmail").show();
        return;
    }
    var encryptedEmail = encrypt.encrypt(email);


    var file = document.getElementById('file');
    if(file.files.length){
        var reader = new FileReader();
        reader.onload = function(){
            var data = reader.result;
            var array = new Int8Array(data);
            var splits = Math.ceil(array.length / 128) ;
            console.log(splits)

            var parts = new Array(splits);
            for(var i=0;i<array.length;i+=128){
                if(i>array.length)
                    i-= ( i-array.length);
                parts[Math.floor(i/128)] = encrypt.encrypt(arrayBufferToBase64(array.slice(i,i+128)));
            }
            sendPostRequest(encryptedEmail,parts);
        }
        reader.readAsArrayBuffer(file.files[0]);
    }else{

        sendPostRequest(encryptedEmail,null);

    }
}

function sendPostRequest(email,splits){
    var data = { "email" : email};
    var splitsData = "";
    for (var i=0;i<splits.length;i++){
        splitsData += i + ":" + splits[i] +"\t";
    }
    data.files= splitsData;

    console.log(data);
    $.post("/hotline/report",data,function(result){
        var json = JSON.parse(result);
        console.log(json.msg);

        $("#title").remove();
        $("#form").replaceWith("<h1> Your report has been submitted!</h1>\n" +
            "<h3> Your Identifier is: <span style=\"color:blue\">"+ json.case_id + "</span></h3>"
        );

    });
}
function arrayBufferToBase64( buffer ) {
    var binary = '';
    var bytes = new Uint8Array( buffer );
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode( bytes[ i ] );
    }
    return window.btoa( binary );
}
