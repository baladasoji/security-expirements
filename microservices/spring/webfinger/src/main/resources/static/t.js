var hash = false;
var jwtb = false; 
var id_token;
var access_token;
var token_type;
var state;
//checkHash();

function checkHash(){ 
    if(window.location.hash != hash) { 
        hash = window.location.hash; 
        processHash(hash); 
    } t=setTimeout("checkHash()",400); 
}

function GetQueryStringParams(sParam)
{
    var sFragment = window.location.hash;
    var sURLVariables = sFragment.split('&');

    for (var i = 0; i < sURLVariables.length; i++)
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam)
        {
            return sParameterName[1];
        }
    }
}

function processHash(hash){

id_token = GetQueryStringParams("id_token");
access_token = GetQueryStringParams("access_token");
token_type = GetQueryStringParams("token_type");
state = GetQueryStringParams("state");

}


function getVendorInvoice()
{

checkHash();
      document.getElementById("idtoken").innerHTML = id_token;
      document.getElementById("accesstoken").innerHTML = access_token;
      document.getElementById("tokentype").innerHTML = token_type;
      document.getElementById("state").innerHTML = state;
//var XMLReq = new XMLHttpRequest();

//XMLReq.onreadystatechange = function() {
//    if (this.readyState == 4 && this.status == 200) {
//    }
//  };
//var vid = document.getElementById("vendorid").value;
//XMLReq.open("GET", "http://localhost:8080/showInvoice?vendorid="+vid, true );
//XMLReq.setRequestHeader("Authorization", jwtb);
//XMLReq.send(null);
}


