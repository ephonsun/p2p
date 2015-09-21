<link rel="stylesheet" href="../style/style.css">
<section>
<input type="hidden" id="login" name="login" value="${login!}"  >
<input type="hidden" id="code" name="code" value="${code!}"  >

    <h2 class="point-h2">${scoreasset!}<span>元</span></h2>
    <div class="point-chaining">
        <ul>
            <li class="active"><a class="point-a award"><img class="record-img" src="images/ybox.png" /><p>兑换奖品</p></a></li>
            <li><a class="point-a1"><img class="record-img" src="images/man.png" /><p>我的任务</p></a></li>
            <li><a class="point-a record"><img class="record-img" src="images/calendar.png" /><p>积分记录</p></a></li>
        </ul>
    </div>
    <div id="integral-box"></div>
</section>


<script type="text/javascript">
    var code = $("#code").val();
    var login = $("#login").val();
    var perCount = 15;
    var pageNo = 1;
      $(".point-a1").on("click", function() {
			window.location.href = "scoretask.html?code="+code+"&login="+login+"&newopen";
		});
		$(".record").on("click", function() {
			window.location.href = "scorerecord.html?code="+code+"&login="+login+"&newopen";
		});
		

    //请求数据块并直接加载
    $(function(){
        requestData(pageNo);
    });

    window.onscroll = function(){
        if(CheckScrollSlide('integral-box','invite-chaining1')){
            requestData(++pageNo);
        }
    };

    function requestData(pageNo){
         $.ajax({
					type: "post",
					url: "scoreawardpage.html",
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
            var s = '<div class="integral-chaining1">';
            s +='       <h3 class="integral-up">'+data[i].title+'</h3>';
            s +='       <botton class="integral-middle">'+data[i].score+'积分</botton>';
            s +='       <h4 class="integral-down">有效期：<span>'+data[i].createtime+'</span></h4>';
            s +='       <input type="hidden" id="id" name="id" value='+data[i].rewardid+'>';
            s +='     </div>';
            $('#integral-box').append(s);
        }
        
        $(".integral-middle").on("click",function  () {
		var _this= $(this);
	
	    var rewardid=$(this).parents(".integral-chaining1").find("#id").val();
	       $.ajax({
					type: "post",
					url: "executescoreaward.html",
					data:{"login":login,"rewardid":rewardid,"code":code},
				    success : function(data) {
                    if(data=="success"){
                       alert("兑换成功");
				    }else if(data=="error"){
				       alert("积分余额不足");
				    }else{
				       alert("未登录");
				    }
				  }
				  
	    		});
	    })
    }
    
    

	
    
    
</script>