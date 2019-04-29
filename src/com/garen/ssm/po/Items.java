package com.garen.ssm.po;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.garen.ssm.controller.validation.ValidGroup1;
import com.garen.ssm.controller.validation.ValidGroup2;

public class Items {
    private Integer id;

    // 校验名称在1到30字符之间
    @Size(min=1, max=30, message="{items.name.length.error}", groups={ValidGroup1.class})
    private String name;

    private Float price;

    private String pic;

    //非空校验
    @NotNull(message="{items.createtime.error}", groups={ValidGroup2.class})
    private Timestamp createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

//    public Date getCreatetime() {
//        return createtime;
//    }
//
//    public void setCreatetime(Date createtime) {
//        this.createtime = createtime;
//    }
    
    

    public String getDetail() {
        return detail;
    }

    public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}