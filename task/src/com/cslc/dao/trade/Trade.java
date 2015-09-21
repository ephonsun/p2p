package com.cslc.dao.trade;

import java.util.Date;
import com.platform.base.BaseEntity;

public class Trade extends BaseEntity {

	public static final byte STATUS_NOT_PAY = 0;// 未支付
	public static final byte STATUS_PAYING = 1;// 支付中
	public static final byte STATUS_TIMEOUT = 2;// 超时
	public static final byte STATUS_PAY_SUCCESS = 3;// 成功
	public static final byte STATUS_PAY_FAILURE = 4;// 失败
	
	private Double amount;
	private Date createtime;
	private String orderno;
	private String ip;
	private String terminalid;
	private String phone;
	private Long bankcardid;
	private Double fee;
	private String mobile;
	private Long selfitemid;
	private String version;
	private String payorderno;
	private Byte platform;
	private Long accountid;
	private Byte paychannel;
	private Date paysuccesstime;
	private Long id;
	private Byte status;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTerminalid() {
		return terminalid;
	}

	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getOrderno(){
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Long getBankcardid(){
		return bankcardid;
	}

	public void setBankcardid(Long bankcardid) {
		this.bankcardid = bankcardid;
	}

	public Double getFee(){
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getSelfitemid(){
		return selfitemid;
	}

	public void setSelfitemid(Long selfitemid) {
		this.selfitemid = selfitemid;
	}

	public String getVersion(){
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPayorderno(){
		return payorderno;
	}

	public void setPayorderno(String payorderno) {
		this.payorderno = payorderno;
	}

	public Byte getPlatform(){
		return platform;
	}

	public void setPlatform(Byte platform) {
		this.platform = platform;
	}

	public Long getAccountid(){
		return accountid;
	}

	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}

	public Byte getPaychannel(){
		return paychannel;
	}

	public void setPaychannel(Byte paychannel) {
		this.paychannel = paychannel;
	}

	public Date getPaysuccesstime(){
		return paysuccesstime;
	}

	public void setPaysuccesstime(Date paysuccesstime) {
		this.paysuccesstime = paysuccesstime;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getStatus(){
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}