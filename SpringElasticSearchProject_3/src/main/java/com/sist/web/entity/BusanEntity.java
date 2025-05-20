package com.sist.web.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document(indexName = "busanfood")
@Data
public class BusanEntity {
	@Id
	private int id;
	private String name,type,phone,address,theme,
					poster,images,time,parking,content,price;
	private int hit,jjimcount,likecount,replycount;
	private double score;
}

