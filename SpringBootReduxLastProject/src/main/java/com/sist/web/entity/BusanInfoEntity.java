package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity(name = "busan_info")
@Data
public class BusanInfoEntity {
	@Id
	private int no;
	private int cno;
	private String title,address,phone,info,poster;
}
