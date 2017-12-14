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

  function callLocationAPI()
{
jwtb = "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJiL082T3ZWdjEreStXZ3JINVVpOVdUaW9MdDA9IiwiYWxnIjoiUlMyNTYifQ.eyJhdF9oYXNoIjoiRU5nMTB6THU3N3g1d0o5dWZJWEVOdyIsInN1YiI6Im9tYmhhbGxhbXVkaSIsImNhcnJpZXJjb2RlIjoiTUFFVSIsImF1ZGl0VHJhY2tpbmdJZCI6IjQyNWNlNjc0LWYyZWEtNGUzMy05NzNiLTM4YzZkZTRmMDU5Yi0xMTg0Iiwicm9sZXMiOiJbXCJlQ29tbWVyY2UtTVNMX0ZBQ1RlU3RhdGVtZW50XCIsXCJlQ29tbWVyY2UtTVNMX090aGVyLkJvb2tpbmdcIixcImVDb21tZXJjZS1NU0xfU0ZYLUFjY2Vzc1wiLFwiZUNvbW1lcmNlLU1TTF9Db250cmFjdFJhdGVcIixcImVDb21tZXJjZS1NU0xfT3RoZXIuTkFQXCIsXCJlQ29bWVyY2UtTVNMX0N1c3RvbWVyUHJvZmlsZVwiLFwiZUNvbW1lcmNlLU1TTF9PdGhlci5Vc2VyUHJvZlwiLFwiZUNvbW1lcmNlLU1TTF9GQUNUSW52b2ljZXNcIixcImVDb21tZXJjZS1NU0xfRGlzcHV0ZUxvZ2dpbmdcIixcImVDb21tZXJjZS1NU0xfT3RoZXIuVHJhY2tpbmdcIixcImVDb21tZXJjZS1NU0xfT3RoZXIuQ3VzdFN0YXRcIixcImVDb21tZXJjZS1NU0xfT3RoZXIuU2hpcEluc3RcIixcImVDb21tZXJjZS1NU0xfT3RoZXIuV0JvTC1BcHByb3ZlXCJdIiwiaXNzIjoiaHR0cDovL2lhbS1jZHQubWFlcnNrbGluZS5jb206ODAvb3BlbmFtL29hdXRoMi9tYWVyc2stdXNlcnMiLCJ0b2tlbk5hbWUiOiJpZF90b2tlbiIsImdpdmVuX25hbWUiOiJPbSIsIm5vbmNlIjoiaGtqY2FzZGJsc2NlcnRzZGdmIiwiYXVkIjoiYWdlbnQxMDEiLCJhenAiOiJhZ2VudDEwMSIsImF1dGhfdGltZSI6MTUxMzIyODg1OSwibmFtZSI6Ik9tIEJoYWxsYW11ZGkiLCJjdXN0b21lcmNvZGUiOiIxMzAwMTUyODA4MiIsInJlYWxtIjoiL21hZXJzay11c2VycyIsImV4cCI6MTUxMzIzMjQ4NywidG9rZW5UeXBlIjoiSldUVG9rZW4iLCJmYW1pbHlfbmFtZSI6IkJoYWxsYW11ZGkiLCJpYXQiOjE1MTMyMjg4ODd9.VLFWnvcXi2nOqD9RwOrUb_jj1S_PdTNS9bSWJNVTNE-IMKh_Xleq9MF-tgiLwQaHGfVXsDthtYYBSrSQEE082KqkYkrBncMg_tPGrN_m0cz5gug7n0wVI2A3hu3aXWrTaYojVu_AWdNkB_H8NBv8f86NNPMrrh78QR3OQR4VN1-EeQ_6Fpr2mdL3T5zO7PeLewA3Qk2dFf-tQcpfeaXQSiWXlvMPIjF2mnXMHjvtF-CZrV4_bga_t0V-Eom2i0YjuuvDls-ReUp38dGqcT8uj8E1X9ZynTusKsOo5Vm6sjzpX_RjDpsubYPpnmiJqS1kEOAe6bb2gkAPxyLMtEAvBQ"  ;
cityXMLReq = new XMLHttpRequest();
cityXMLReq.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("cities").innerHTML = this.responseText;
    document.getElementById("cities").className='authrest'
    }
  else if (this.readyState == 4 && this.status == 403) {
    document.getElementById("cities").innerHTML = this.responseText;
    document.getElementById("cities").className='noauthrest'
  }
  };
	cityXMLReq.open("GET", "https://api205063live.gateway.akana.com/maeu/locations/cities?cityprefix=az", true );
	cityXMLReq.setRequestHeader("Authorization",jwtb );
	cityXMLReq.send(null);
}
