<link rel="stylesheet" href="../style/style.css">
<section class="investment-main">
<input type="hidden" id="login" name="login" value="${login!}"  >
<input type="hidden" id="code" name="code" value="${code!}"  >
    <div>
        <div class="investment-up">
            <ul>
                <li class="investment-li">
                    <h3 class="invest-h3">投资本金</h3>
                    <h4><span class="investment-sp">${(amount)!}</span>元</h4>
                </li>
                <li class="investment-li1">
                    <h3 class="invest-h3">可获收益</h3>
                    <h4><span class="investment-sp">${(totalincome)!}</span>元</h4>
                </li>
                <li class="investment-li">
                    <h3 class="invest-h3">红包返现</h3>
                    <h4><span class="investment-sp">${(bonusasset)!}</span>元</h4>
                </li>
            </ul>
        </div>
        <div id="invest-box"></div>
        </div>
</section>
<script>
    var login=$("#login").val();
    var code=$("#code").val();
    var perCount =15;
    var pageNo = 1;
    
    $(function(){
        requestData(pageNo);
    });

    window.onscroll = function(){
        if(CheckScrollSlide('invest-box','invest-main')){
            requestData(++pageNo);
        }
    };

    function requestData(pageNo){
         $.ajax({
					type: "post",
					url: "selfitemlistpage.html",
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
            var s ='<div class="invest-main">';
            s +='       <a  class="invest-calendar-down-a" href="agreement.html?selfitemid='+data[i].selfitemid+'">';
            s +='        <div class="invest-item1">';
            s +='           <div><h5 class="invest-h5">'+data[i].name+'</h5></div>';
            s +='            <p class="invest-p1">&nbsp;本金<span class="invest-letter-rb">'+data[i].amount+'</span>元</p>';
            s +='</div>';
            s +='<div class="invest-item2">';
            s +='       <div class="invest-count">';
            s +='        <img class="invest-back-circle" src="images/count.png" />';
            s +='        <div class="invest-letter-y1"><span>'+data[i].days+'</span>天</div>';
            s +='</div>';
            s +='       <p class="invest-p">收益<span class="invest-letter-y">'+data[i].income+'</span>元</p>';
            s +='</div>';
            s +='<div class="invest-item3">';
            if(data[i].status==1){
            s +='       <div class="invest-position">募集中<img class="invest-img" src="images/yright.png" alt="" /></div>';
            }else if(data[i].status==2){
            s +='       <div class="invest-position">募集完成<img class="invest-img" src="images/yright.png" alt="" /></div>';
            }else if(data[i].status==3){
            s +='       <div class="invest-position">计息中<img class="invest-img" src="images/yright.png" alt="" /></div>';
            }else{
            s +='       <div class="invest-position">已还款<img class="invest-img" src="images/yright.png" alt="" /></div>';
            }
            
            s +='           <p class="invest-p">红包<span class="invest-letter-rs">'+data[i].bonus+'</span>元</p>';
            s +='</div>';
            s +='       </a>';
            s +='</div>';
            $('#invest-box').append(s);
        }
    }
</script>


       
