package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity(name = "busan_food")
@Data
@DynamicUpdate
public class BusanFoodEntity {
	@Id
	private int fno;
	private String name,type,phone,address,theme,poster,images,time,parking,content,price;
	private int hit,jjimcount,likecount,replycount;
	private double score;
}
