<link rel="stylesheet" href="../style/style.css">
<section>
<input type="hidden" id="login" name="login" value="${login!}"  >
<input type="hidden" id="code" name="code" value="${code!}"  >
    <div class="point-chaining-invite">
        <ul>
            <li><a class="point-a invite"><img class="invite-img" src="images/shopcar.png" /><p>邀请奖励</p></a></li>
            <li><a class="point-a1 record"><img class="invite-img" src="images/redpackge.png" /><p>邀请记录</p></a></li>
            <li class="active"><a class="point-a"><img class="invite-img" src="images/ydollar.png" /><p>收益红包</p></a></li>
        </ul>
    </div>
    <div id="inviting-red-box"></div>
</section>




    <script type="text/javascript">
    var code = $("#code").val();
    var login = $("#login").val();
    var perCount = 15;
    var pageNo = 1;
      $(".invite").on("click", function() {
			window.location.href = "invite.html?code="+code+"&login="+login+"&newopen";
		});
		$(".record").on("click", function() {
			window.location.href = "inviterecord.html?code="+code+"&login="+login+"&newopen";
		});
		
	$(function(){
        requestData(pageNo);
    });

         window.onscroll = function(){
        if(CheckScrollSlide('inviting-red-box','invite-chaining2')){
            requestData(++pageNo);
        }
    };

    function requestData(pageNo){
        $.ajax({
					type: "post",
					url: "inviteincomepage.html",
					data:{"login":login,"perCount":perCount,"pageNo":pageNo,"code":code},
					dataType: 'json',
				    success : function(data) {
                          loadData(data);
				    }
				  
	    		});
    }

    function loadData(data){
        //将数据块渲染到页面中
        for(var i = 0;i<data.length;i++){
            var s = '<div class="invite-chaining2">';
            s +='       <h2 class="invite-up">'+data[i].title+'</span></h2>';
            s +='       <div class="invite-middle">';
            s +='       <div class="middle-1"><span class="middle-1-1">'+data[i].bonus+'</span>元</div>';
            if(data[i].status==0){
              s +='           <p class="middle-2">未使用</p>';
            }else if(data[i].status==1){
              s +='           <p class="middle-2">返现中</p>';
            }else if(data[i].status==2){
              s +='           <p class="middle-2">已返现</p>';
            }else if(data[i].status==3){
              s +='           <p class="middle-2">已过期</p>';
            }
            s +='           <a href="#"><img src="images/right.png" /></a>';
            s +='           </div>';
            s +='       <h3 class="invite-down">返现日期 <span>'+data[i].backtime+'</span></h3>';
            s +='       </div>';
            $('#inviting-red-box').append(s);
        }
    }
		
		
		
</script>