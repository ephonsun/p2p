$(function  () {
    var hei = ( $(document).height() > $(window).height() ) ? $(document).height() : $(window).height();
    $("#content").css("height",hei);
    $(".con_bg").css("height",hei);
    $("#download_bg").css("height",hei);
    $(".Christmas_bg").css("height",hei);
    $(".ggl_bg").css("height",hei);
    $(".ggl_black_bg").css("height",hei);
    $(".act_bg").css("height",hei);
    $(".gift_bg").css("height",hei);
    $(".selfitem_by_day_bg").css("height",hei);


    
})
$(function  () {
    var hei = ( $(document).height() > $(window).height() ) ? $(document).height() : $(window).height()-64;
    $(".appupdate_bg").css("height",hei);
    $(".meijia_bg").css("height",hei);
    $(".springFestival_bg").css("height",hei);

   
    
})

function setHeight(x,y,obj){
  var prop= x/y;
  var lim=$(window).width()
  if (lim<=420) {
    obj.height(lim/prop)
  }else{
    lim=420;
    obj.height(lim/prop)
  }
}

function setCss(x,y,obj,css){
  var prop= x/y;
  var lim=$(window).width()
  if (lim<=420) {
    obj.css(css,lim/prop)
  }else{
    lim=420;
    obj.css(css,lim/prop)
  }
}

function setPadtop(x,y,obj){
  var prop= x/y;
  var lim=$(window).width()
  if (lim<=420) {
    obj.css("padding-top",lim/prop)
  }else{
    lim=420;
    obj.css("padding-top",lim/prop)
  }
}
function setMartop(x,y,obj){
  var prop= x/y;
  var lim=$(window).width()
  if (lim<=420) {
    obj.css("margin-top",lim/prop)
  }else{
    lim=420;
    obj.css("margin-top",lim/prop)
  }
}
function Divhei(i,j,o,obj){
    var x=i/j;
    var y=j/o;
    var win=$(window).width();
    if (win<=420) {
      obj.width(win/x);
    }else{
        win=420;
        obj.width(win/x);
      }

    obj.height(win/(x*y));
}
 
$.fn.appconect = function(options) {    
  var defaults = {
    btn: $(".btn"), 
    action: 1,
    title: '',
    content: '',
    url: '',
    channel : '',
    imageUrl : '',
  };    
 
  var opts = $.extend(defaults, options);   
  var oBtn = opts.btn;
  var oAction = opts.action;
  var oTitle = opts.title;
  var oContent = opts.content;
  var oUrl = opts.url;
  var oChannel = opts.channel;
  var imageUrl = opts.imageUrl;
  var oIndex = opts.index;
  var BigUrl;

   if(oAction==1 || oAction==2){
      BigUrl="http://ddsc.location?action="+oAction+"&title="+oTitle+"&content="+oContent+"&url="+oUrl+"&channel="+oChannel+"&imageUrl="+imageUrl;
    }else if(oAction==3){
     BigUrl="http://ddsc.location?action="+oAction+"&title="+oTitle+"&content="+oContent;
    }else if(oAction==4){
     BigUrl="http://ddsc.location?action="+oAction+"&content="+oContent;
    }else if(oAction==7){
      BigUrl="http://ddsc.location?action="+oAction+"&index="+oIndex;
    }else{
      BigUrl="http://ddsc.location?action="+oAction;
    }

  
    var browser = {
  		versions: function () {
  				var u = navigator.userAgent, app = navigator.appVersion;
  				return { //移动终端浏览器版本信息 	
  					iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器 
  					iPad: u.indexOf('iPad')>-1,//是否iPad   
  				
  				};
  			}(),
		  }
		if (browser.versions.iPhone || browser.versions.iPad ) {
			var oIfr = oBtn.find("iframe")
			if (oIfr.length >0 ){
				oIfr.remove()
			};
			oBtn.append("<iframe src ="+BigUrl+" id='iframe'></iframe>");
		}
		else{
      var content = "&title="+oTitle+"&content="+oContent+"&imageurl="+imageUrl+"&url="+oUrl+"&channel="+oChannel+"&index="+oIndex;
      window.WebJavascript.clickcenter(oAction,content);
			    
		}



};    
  


function slideTop(id,n){
    var $this = $(id);
    if($this.find("ul:first").find("li").length<n){
      return;
    }
    
      var scrollTimer = setInterval(function(){
        scrollNews($this);
        },3000);    
      
      function scrollNews(obj){
        var $self = obj.find("ul:first");
        var heights = $self.find("li:first").height();
        $self.animate({"marginTop":-heights+"px"},800,function(){
            $self.css({marginTop:0}).find("li:first").appendTo($self);
          })
        }
    }
function slideLeft(id,n){
    var $this = $(id);
    if($this.find("ul:first").find("li").length<n){
      return;
    }
    
      var scrollTimer = setInterval(function(){
        scrollNews($this);
        },3000);    
      
      function scrollNews(obj){
        var $self = obj.find("ul:first");
        var widths = $self.find("li:first").width();
        $self.animate({"marginLeft":-widths+"px"},800,function(){
            $self.css({marginLeft:0}).find("li:first").appendTo($self);
          })
        }
    }
   
function is_weixn(channel){

 
    var ua = navigator.userAgent.toLowerCase();  
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
     
    
     // alert($(document).height())


      $(".download_btn").on("click",function  () {
          $(".black_bg").height($(document).height());
           $(".wrp_jump_tip").css("top",$(window).scrollTop());
          $(".black_bg,.wrp_jump_tip").removeClass("hide");
          
      })
      $(".black_bg,.wrp_jump_tip").on("click",function  () {
             $(".black_bg,.wrp_jump_tip").addClass("hide");
        })

    } else {

        var browser = {
        versions: function () {
            var u = navigator.userAgent, app = navigator.appVersion;
            return { //移动终端浏览器版本信息  
              iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者ipad QQHD浏览器 
              iPad: u.indexOf('iPad')>-1,//是否iPad  
            
            };
          }(),
        }
        if (browser.versions.iPhone|| browser.versions.iPad ) {
         $(".download_btn").attr("href","https://itunes.apple.com/cn/app/dian-dian-sou-cai/id953002926?mt=8")
        }
        else{
        if(channel == null){
        	$(".download_btn").attr("href","http://web.ddsoucai.com/downloadapp.html")
        } else {
        	$(".download_btn").attr("href","http://web.ddsoucai.com/"+channel)
        }	
        }
    }  
};





