package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.vo.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	// CRUD => update/insert => save(), delete => delete()
	// findAll(), count()
	// 조건 처리 (X)
	// ElasticSearch => NoSQL => JSON (MongoDB, 카산드라...)
	// 컬럼의 갯수가 명확한 경우(DB:SQL), 명확하지 않은 경우(NoSQL)
	@Query(value = "SELECT * FROM emp",nativeQuery = true)
	public List<Emp> empAllData();
	
	// SELECT * FROM emp WHERE empno=?
	public Emp findByEmpno(int empno);
	//         ----- ----- ---------
	//		  WHERE empno=? 
	
	public List<Emp> findByEnameContaining(String ename);
	//				WHERE  ename LIKE '%?%'
	
	public List<Emp> findByEnameStartsWith(String ename);
	//				WHERE  ename LIKE '?%'
	// SELECT DISTINCT job FROM emp
	//public List<String> findDistinctByJob();
	// find => SELECT, By => WHERE
	// SELECT * FROM emp WHERE sal>? sal<?
	/*
	 *  findBySalLessThen => sal<?
	 *  findBySalGreaterThen => sal>?
	 *  findBySalLessThenEqual => sal<=?
	 *  findBySalGreaterThenEqual => sal>=?
	 */
	// SELECT * FROM emp ORDER BY sal
	// findBySalOrderBy
}
