package com.cslc.dao.sms;

import java.util.Date;
import com.platform.base.BaseEntity;

public class Sms extends BaseEntity {

	public static final byte STATUS_SUBMIT = 0;// 已提交
	public static final byte STATUS_RECEIVED = 1;// 已收到
	public static final byte STATUS_VERIFIED = 2;// 已验证
	
	private Date createtime;
	private Date sendtime;
	private String verifycode;
	private String mobile;
	private Byte channel;
	private Long id;
	private Integer category;
	private Date verifytime;
	private String content;
	private Byte status;

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Date getCreatetime(){
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getVerifycode(){
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Byte getChannel(){
		return channel;
	}

	public void setChannel(Byte channel) {
		this.channel = channel;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCategory(){
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Date getVerifytime(){
		return verifytime;
	}

	public void setVerifytime(Date verifytime) {
		this.verifytime = verifytime;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getStatus(){
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}