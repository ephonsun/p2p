<link rel="stylesheet" href="../style/style.css">
<section>
<input type="hidden" id="login" name="login" value="${login!}"  >
<input type="hidden" id="code" name="code" value="${code!}"  >
    <div class="point-chaining-invite">
        <ul>
            <li  class="active"><a class="point-a"><img class="invite-img" src="images/yshopcar.png" /><p>邀请奖励</p></a></li>
            <li><a class="point-a1 record"><img class="invite-img" src="images/redpackge.png" /><p>邀请记录</p></a></li>
            <li><a class="point-a income"><img class="invite-img" src="images/dollar.png" /><p>收益红包</p></a></li>
        </ul>
    </div>
    <h2 class="reward-h2">邀请规则:</h2>
        <p class="reward-p1"><img class="reward-img" src="images/circle1.png" />被邀请人成功投资，您可获得20元邀请红包</p>
        <p class="reward-p1"><img class="reward-img" src="images/circle2.png" />被邀请人投资10000元及以上，您可获得投资收益1%的收益红包</p>
    <h2 class="reward-h2">举例说明:</h2>
    <p class="reward-p2">被邀请人投资20000元，被邀请人可获得200元投资收益，此时您将立即获得20元收益红包</p>
</section>
<footer>
    <button type="button" class="reward-btn">邀请好友</button>
</footer>

<script type="text/javascript">
    var code = $("#code").val();
    var login = $("#login").val();
    var perCount = 15;
    var pageNo = 1;
      $(".record").on("click", function() {
			window.location.href = "inviterecord.html?code="+code+"&login="+login+"&newopen";
		});
		$(".income").on("click", function() {
			window.location.href = "inviteincome.html?code="+code+"&login="+login+"&newopen";
		});
		
		
    
		
		
</script>



