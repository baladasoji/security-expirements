var hash = false;
var jwtb = false; 
//checkHash();

function checkHash(){ 
    if(window.location.hash != hash) { 
        hash = window.location.hash; 
        processHash(hash); 
    } t=setTimeout("checkHash()",400); 
}

function processHash(hash){
var fields = hash.split(/=/);
var variable = fields[0];
var jwt=fields[1];
  //  alert(jwt);

jwtb = "Bearer "+jwt;

}


function getVendorInvoice()
{

checkHash();
var XMLReq = new XMLHttpRequest();

XMLReq.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML = this.responseText;
    }
  };
var vid = document.getElementById("vendorid").value;
XMLReq.open("GET", "http://localhost:8080/showInvoice?vendorid="+vid, true );
XMLReq.setRequestHeader("Authorization", jwtb);
XMLReq.send(null);
}


