package com.sist.web.vo;

import jakarta.persistence.*;
import lombok.Data;
/*
EMPNO int 
ENAME text 
JOB text 
MGR text 
HIREDATE text 
SAL int 
COMM text 
DEPTNO int
 */
@Entity
@Data
public class Emp {
	@Id
	private int empno;
	private int sal;
	@Column(insertable = false,updatable = false)
	private int deptno;
	private String ename,job,mgr,hiredate,comm;
	
	@ManyToOne(fetch = FetchType.EAGER) // EAGER (즉시 로딩) , LAZE(지연)
	@JoinColumn(name = "deptno", referencedColumnName = "deptno")
	private Dept dept;
}
