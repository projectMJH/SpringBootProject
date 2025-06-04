package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
// 테이블명은 _없이 사용 권장
// Entity => 테이블명을 사용
//			 ---------- JOIN
// Emp, Dept => SELECT e FROM Emp e JOIN Dept d
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
