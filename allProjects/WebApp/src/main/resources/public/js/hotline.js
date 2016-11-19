/**
* Checked Personal
*/

function validateForm(){
    var noError=true;
    var form  = document.forms['hotlineForm'];
    var personalDetails = form['personalDetails'].checked;
    if(personalDetails){
        var firstName = form['firstName'].value;
        if(firstName == ''){
            noError = false;
            $("#nameError").show();
        }else{ $("#nameError").hide(); }

        var surname = form['lastName'].value;
        if(surname == ''){
            noError = false;
            $("#surnameError").show();
        }else{ $("#surnameError").hide(); }

        var age = form['age'].value;
        if(age == ''){
            noError = false;
           $("#ageError").show();
        }else{ $("#ageError").hide(); }

        var email = form['email'].value;
        if(email == ''){
            noError = false;
           $("#emailError").show();
        }else{ $("#emailError").hide(); }

        var address = form['address'].value;
        if(address == ''){
            noError = false;
           $("#addressError").show();
        }else{ $("#addressError").hide(); }

        var city = form['city'].value;
        if(city == ''){
            noError = false;
           $("#cityError").show();
        }else{ $("#cityError").hide(); }
    }
    var comments = form['comments'].value;
    if(comments == ''){
        noError = false;
       $("#commentsError").show();
    }else{ $("#commentsError").hide(); }

    if(noError)
        hideAllErrors();
    else
        $("#submitError").show();

    return noError;
}

function hideAllErrors(){
    $("#nameError").hide();
    $("#submitError").hide();
    $("#surnameError").hide();
    $("#ageError").hide();
    $("#emailError").hide();
    $("#addressError").hide();
    $("#cityError").hide();
    $("#commentsError").hide();
}

$("#fillPersonalDetails").click(function(e){
    var checkbox = document.getElementById('fillPersonalDetails');
    if(checkbox.checked)
        $("#personalDetails").show();
    else
        $("#personalDetails").hide();
});


$(document).ready(function(){
    var checkbox = document.getElementById('fillPersonalDetails');
    if(checkbox.checked)
        $("#personalDetails").show();
    else
        $("#personalDetails").hide();

});
