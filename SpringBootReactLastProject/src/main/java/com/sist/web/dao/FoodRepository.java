package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

import java.util.*;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer>{
	@Query(value="SELECT fno,name,type,poster,phone,rownum "
			+ "FROM (SELECT fno,name,type,poster,phone FROM project_food ORDER BY fno) "
			+ "WHERE rownum<=10", nativeQuery = true)
	public List<FoodVO> FoodMainData();
	
	@Query(value="SELECT fno,name,type,poster,phone,hit,likecount,num "
			+ "FROM (SELECT fno,name,type,poster,phone,hit,likecount,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_food pf_fno_pk)*/ fno,name,type,poster,phone,hit,likecount "
			+ "FROM project_food)) "
			+ "WHERE num BETWEEN :start AND :end", nativeQuery = true)
	public List<FoodListVO> foodListData(@Param("start") Integer start,
									@Param("end") Integer end);
	
	@Query(value = "SELECT fno,name,type,phone,address,score,TO_CHAR(theme) as theme,poster,"
			+ "images,time,parking,TO_CHAR(content) as content,hit,price,jjimcount,likecount,replycount,rdays "
			+ "FROM project_food "
			+ "WHERE fno=:fno",nativeQuery = true)
	public FoodEntity foodDetailData(@Param("fno") int fno);
	
}
