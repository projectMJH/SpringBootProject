package com.sist.web.vo;

import org.springframework.data.elasticsearch.annotations.*;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "busaninfo")
// => index명은 반드시 소문자
/*
id int 
CNO int 
TITLE text 
POSTER text 
ADDRESS text 
PHONE text 
INFO text
 */
@Getter
@Setter
public class BusanInfoEntity {
	@Id
	private int id;
	@Field(name = "cno", type = FieldType.Integer)
	private int cno;
	@Field(name="title", type=FieldType.Text)
	private String title;
	@Field(name="poster", type=FieldType.Text)
	private String poster;
	@Field(name="address", type=FieldType.Text)
	private String address;	
	@Field(name="phone", type=FieldType.Text)
	private String phone;
	@Field(name="info", type=FieldType.Text)
	private String info;
}
