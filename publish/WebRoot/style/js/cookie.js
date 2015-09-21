// setCookie("user", login);
function setCookie(name,value){
    var Days = 365;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=" + "/;";
}
function getCookie(name){
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if(arr != null){
    	return unescape(arr[2]);
    } 
    return null;
}
function delCookie(name){ 
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if(cval!=null){
    	document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + ";path=" + "/;";
    }
}