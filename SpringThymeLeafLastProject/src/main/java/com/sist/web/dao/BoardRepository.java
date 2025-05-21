package com.sist.web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import java.util.*;
/*
 * 		Controller 동일
 * 		DAO / Service : 오라클(MyBatis), MySQL(JPA), ElasticSearch
 * 		Front-End : JSP / ThymeLeaf, Vue, React
 * 
 * 		@Query
 * 		JOIN / CRUD
 * 
 * 		1. MyBatis : SQL
 * 		2. JPA : 메서드 규칙 => findAll()
 * 							 --------- 조건 검색 메서드 => 컬럼명을 알지 못한다
 * 							 find(Distinct)By(컬럼명)조건
 * 												   --- Like
 * 								  -------- select 명령
 */
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
	// findAll()
	// SELECT b FROM BoardEntity b
	// JPQL, 일반 SQL = nativeQuery = true
	// 페이징 => LIMIT 시작, 갯수
	@Query(value = "SELECT no,subject,name,regdate,hit "
			+ "FROM board ORDER BY no DESC "
			+ "LIMIT :start,10",nativeQuery = true)
	//@Query("SELECT b FROM BoardEntity b ")
	// ? #{start}	:start
	public List<BoardVO> boardListData(@Param("start") int start);
	// public Page<BoardVO> findAll(Pageable pg)
	
	// 상세보기
	public BoardEntity findByNo(@Param("no") Integer no);
	
	// 검색
	public List<BoardEntity> findByNameContaining(@Param("name") String name);
	public List<BoardEntity> findBySubjectContaining(@Param("subject") String subject);
	public List<BoardEntity> findByContentContaining(@Param("content") String content);
	
	// JPA => JOIN(O), SubQuery(X)
	// MyBatis
	
	// JPA => JOIN(O), SubQuery(X)
	// MyBatis
	// count() save() : INSERT, UPDATE, delete() => SELECT
}
