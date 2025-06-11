package com.sist.web.entity;
/*
 * NO      NOT NULL NUMBER         
FNO              NUMBER         
ID               VARCHAR2(20)   
NAME    NOT NULL VARCHAR2(50)   
MSG     NOT NULL VARCHAR2(4000) 
REGDATE          DATE 
 */
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity(name = "reactcomment")
@Data
public class CommentEntity {
	@Id
	private int no;
	
	// msg 만 update, 나머지는 insert만 가능
	@Column(updatable = false,insertable = true)
	private int fno;
	@Column(updatable = false,insertable = true)
	private String id;
	@Column(updatable = false,insertable = true)
	private String name;
	private String msg;
	@Column(updatable = false,insertable = true)
	private Date regdate;
}
