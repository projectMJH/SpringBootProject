package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
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
	
	
}
