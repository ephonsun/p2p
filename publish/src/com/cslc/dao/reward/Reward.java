package com.cslc.dao.reward;

import java.util.Date;
import com.platform.base.BaseEntity;

public class Reward extends BaseEntity {

	public static final byte STATUS_DISABLE = 0;// 无效
	public static final byte STATUS_ENABLE = 1;// 有效
	
	private Integer score;
	private Date createtime;
	private Long id;
	private String title;
	private Integer category;
	private Byte status;
	private Integer serialno;

	public Integer getScore(){
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

	public String getTitle(){
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCategory(){
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Byte getStatus(){
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getSerialno(){
		return serialno;
	}

	public void setSerialno(Integer serialno) {
		this.serialno = serialno;
	}

}