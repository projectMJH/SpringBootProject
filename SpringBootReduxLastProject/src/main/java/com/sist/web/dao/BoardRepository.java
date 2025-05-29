package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	@Query(value = "SELECT * FROM board "
			+ "ORDER BY no DESC "
			+ "LIMIT :start,10", nativeQuery = true)
	public List<BoardEntity> boardListData(@Param("start") int start);
	
	public BoardEntity findByNo(int no);
}
