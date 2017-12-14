var hash = false;
var jwtb = false;
var id_token;
var access_token;
var token_type;
var state;
var hash;
//checkHash();

function checkHash(){
    if(window.location.hash != hash) {
        hash = window.location.hash;
	hash = hash.substring(1);
        processHash(hash);
    } t=setTimeout("checkHash()",400);
}

function GetQueryStringParams(sParam)
{
    var sFragment = hash;
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


function populateTokens()
{

checkHash();
      document.getElementById("idtoken").innerHTML = id_token;
      document.getElementById("accesstoken").innerHTML = access_token;
      document.getElementById("tokentype").innerHTML = token_type;
      document.getElementById("state").innerHTML = state;
}


function callFrAuthenticate()
{
usiidtoken = document.getElementById("idtoken").innerHTML;  
frXMLReqReq = new XMLHttpRequest();
frXMLReqReq.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("frauth").innerHTML = this.responseText;
    }
    else if (this.readyState == 4 && this.status == 403) {
      document.getElementById("frauth").innerHTML = this.responseText;
      document.getElementById("frauth").style.color="red"
    }
  };
//var vid = document.getElementById("decodedtoken").value;
frXMLReqReq.open("POST", "https://iam-cdt.maerskline.com/openam/json/realms/maersk-users/authenticate?authIndexType=module&authIndexValue=UsiJwtAuthentication", true );
frXMLReqReq.setRequestHeader("oidc_id_token", usiidtoken);
frXMLReqReq.send(null);
}



function getFrToken()
{
	sessionStorage.frtoken='put fr token here';
	
frXMLOAuthReq = new XMLHttpRequest();
frXMLOAuthReq.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("frauth").innerHTML = this.responseText;
    }
    else if (this.readyState == 4 && this.status == 403) {
      document.getElementById("frauth").innerHTML = this.responseText;
      document.getElementById("frauth").style.color="red"
    }
  };
//var vid = document.getElementById("decodedtoken").value;
frXMLOAuthReq.open("POST", "https://iam-cdt.maerskline.com/openam/oauth2/realms/maersk-users/authorize", true);
//frXMLOAuthReq.setRequestHeader("oidc_id_token", usiidtoken);
frXMLOAuthReq.send('scope=openid%20profile&redirect_uri=https%3A%2F%2Fautht.maerskline.com%2Findex.html&csrf=LUY6RyGBpFdgRGFAAv4veXGPE8g.*AAJTSQACMDIAAlNLABxHcE1zNWRWdngxb1p1emdzVm53Sm15Tm9PRVU9AAJTMQACMDE.*&decision=allow&response_type=id_token%20token&client_id=agent101&nonce=hkjcasdblscertsdgf');
}
