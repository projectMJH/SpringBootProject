package com.sist.web.entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

/*
 * no int AI PK 
name text 
subject text 
content text 
pwd text 
regdate datetime 
hit int
 */
@Entity(name = "board")
@Data
public class BoardEntity {
	@Id
	private int no;
	private String name,subject;
	@Column(insertable = true, updatable = false)
	private String pwd;
	private String content;
	@Column(insertable = true, updatable = false)
	private Date regdate;
	private int hit;
}
