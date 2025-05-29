package com.sist.web.dao;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Repository
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
	@Query(value = "SELECT fno,name,poster,likecount,score,address,theme,content,hit,type "
			+ "FROM busan_food "
			+ "ORDER BY fno ASC "
			+ "LIMIT 0,9",nativeQuery = true)
	public List<BusanFoodVO> busanMainData();
}
