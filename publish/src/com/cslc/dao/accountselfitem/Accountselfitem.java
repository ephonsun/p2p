package com.cslc.dao.accountselfitem;

import java.util.Date;

import com.cslc.dao.selfitem.Selfitem;
import com.platform.base.BaseEntity;

public class Accountselfitem extends BaseEntity {
	
	public static final byte STATUS_ACTIVE = 3;// 购买成功
	public static final byte STATUS_START = 5;// 募集成功，开始计息
	public static final byte STATUS_END = 20;// 计息结束
	
	private Long accountid;
	private Long bankcardid;
	private Integer score;
	private Double amount;
	private Date createtime;
	private Date incometime;
	private Double bonus;
	private Double totalincome;
	private Double restincome;
	private Double dayincome;
	private Long selfitemid;
	private Date backtime;
	private Byte status;
	private Long tradeid;
	private String bonusid;

	private Selfitem selfitem;
	
	public Long getBankcardid() {
		return bankcardid;
	}

	public void setBankcardid(Long bankcardid) {
		this.bankcardid = bankcardid;
	}

	public Long getAccountid(){
		return accountid;
	}

	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}

	public Integer getScore(){
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getAmount(){
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getCreatetime(){
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getIncometime(){
		return incometime;
	}

	public void setIncometime(Date incometime) {
		this.incometime = incometime;
	}

	public Double getBonus(){
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getTotalincome(){
		return totalincome;
	}

	public void setTotalincome(Double totalincome) {
		this.totalincome = totalincome;
	}

	public Double getRestincome(){
		return restincome;
	}

	public void setRestincome(Double restincome) {
		this.restincome = restincome;
	}

	public Double getDayincome(){
		return dayincome;
	}

	public void setDayincome(Double dayincome) {
		this.dayincome = dayincome;
	}

	public Long getSelfitemid(){
		return selfitemid;
	}

	public void setSelfitemid(Long selfitemid) {
		this.selfitemid = selfitemid;
	}

	public Date getBacktime(){
		return backtime;
	}

	public void setBacktime(Date backtime) {
		this.backtime = backtime;
	}

	public Byte getStatus(){
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
	
	public Long getTradeid() {
		return tradeid;
	}

	public void setTradeid(Long tradeid) {
		this.tradeid = tradeid;
	}
	
	public String getBonusid() {
		return bonusid;
	}

	public void setBonusid(String bonusid) {
		this.bonusid = bonusid;
	}

	public Selfitem getSelfitem() {
		return selfitem;
	}

	public void setSelfitem(Selfitem selfitem) {
		this.selfitem = selfitem;
	}
	
	
}