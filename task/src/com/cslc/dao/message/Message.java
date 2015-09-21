package com.cslc.dao.message;

import java.util.Date;
import com.platform.base.BaseEntity;

public class Message extends BaseEntity {

	public static final byte STATUS_NOT_READ = 0;// 未读
	public static final byte STATUS_READ = 1;// 已读
	
	private Long accountid;
	private Date createtime;
	private Long id;
	private Integer category;
	private String content;
	private Byte status;

	public Long getAccountid(){
		return accountid;
	}

	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}

	public Date getCreatetime(){
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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