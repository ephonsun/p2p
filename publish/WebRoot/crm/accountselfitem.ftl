<#include "/crm/menu.ftl" />

<table class="tables">
	<tr class="th">
		<th>投资产品</th>
		<th>投资本金</th>
		<th>可获收益</th>
		<th>每日收益</th>
		<th>待收收益</th>
		<th>获得积分</th>
		<th>返现红包</th>
		<th>起息时间</th>
		<th>回款时间</th>
		<th>状态</th>
	</tr>
	<#if list??>
		<#list list as p>
			<tr>
				<td>${(p.selfitem.name)!}，${(p.selfitem.annualrate)!}%<#if p.selfitem.annualrateextra!=0>+${(p.selfitem.annualrateextra)!}%</#if>，${(p.selfitem.incomedays)!}天</td>
				<td>${(p.amount)!}</td>
				<td>${(p.totalincome)!} </td>
				<td>${(p.dayincome)!}</td>
				<td>${(p.restincome)!}</td>
				<td>${(p.score)!}</td>
				<td>${(p.bonus)!}</td>
				<td>${(p.selfitem.backtime?string('yyyy-MM-dd'))!}</td>
				<td>${(p.selfitem.incometime?string('yyyy-MM-dd'))!}</td>
				<td><#if p.selfitem.status==1>募集中<#elseif p.selfitem.status==2>募集完成<#elseif p.selfitem.status==3>计息中<#elseif p.selfitem.status==4>已还款</#if></td>
			</tr>
		</#list>
	</#if>
</table>

<div class="admin-right-content" style="border:0;">
	<script type="text/javascript">page("/admincrm/accountselfitem.html?accountid=${(account.id)!}","${(map.get("page").currentPage)!}","${(map.get("page").totalPages)!}")</script>
</div>