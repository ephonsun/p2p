<link rel="stylesheet" href="../style/style.css">
<input type="hidden"  id="login" name="login" value="${(login)!}">
<input type="hidden"  id="code" name="code" value="${(code)!}">
<section>
    <h2 class="red-h2"><span>${bonusasset!}</span>元</h2>
    <div id="red-box"></div>
</section>

<script>

    //加载数据块，并进行上拉加载更多
    var login=$("#login").val();
    var code=$("#code").val();
    var perCount = 15;
    var pageNo = 1;
    //请求数据块并直接加载
    $(function(){
        requestData(pageNo);
    });


    window.onscroll = function(){
        if(CheckScrollSlide('red-box','red-item')){
            requestData(++pageNo);
        }
    };

    function requestData(currentPageNo){
              $.ajax({
					type: "post",
					url: "bonuspage.html",
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
            var s = '<div class="red-item">';
            s +='       <h3 class="red-h3">'+data[i].title+'</h3>';
            s +='       <div class="red-middle">';
            s +='           <p class="red-p1">'+data[i].bonus+'<span>元</span></p>';
            if(data[i].status==0){
            s +='           <p class="red-p2-4">未使用</p>';
            }else if(data[i].status==1){
            s +='           <p class="red-p2-4">返现中</p>';
            }else if(data[i].status==2){
            s +='           <p class="red-p2-4">已返现</p>';
            }else if(data[i].status==3){
            s +='           <p class="red-p2-4">已过期</p>';
            }
            s +='       </div>';
            s +='       <h4 class="red-h4">有效期：'+data[i].endtime+'</h4>';
            s +='     </div>';
            $('#red-box').append(s);
        }
    }
</script>