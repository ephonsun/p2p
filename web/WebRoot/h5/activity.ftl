<link rel="stylesheet" href="../style/style.css">
<div>    
   <#if records??>
    <#list records as l>    
    
    <div class="activity-item">
    	<a class="activity-a" href="${l.url!}">
	        <img class="active-img" src="${l.img!}" />
	        <div>
	        <div class="active-down">
	            <div class="active-left"><img src="images/clock.png" /><span>${(l.starttime)!}</span>&nbsp<span>${(l.endtime)!}</span></div>
	            <#if l.status?? & l.status=0>
	             <div class="active-right"><p class="active-right-soon">未上线</div>
	            </#if>
	            <#if l.status?? & l.status=1>
	             <div class="active-right"><p class="active-right-ing">进行中</div>
	            </#if>
	            <#if l.status?? & l.status=2>
	             <div class="active-right"><p class="active-right-end">已结束</div>
	            </#if>
	        	</div>
	    	</div>
	   	</a>
	   	</div>
     </#list>
    </#if>
    
</div>