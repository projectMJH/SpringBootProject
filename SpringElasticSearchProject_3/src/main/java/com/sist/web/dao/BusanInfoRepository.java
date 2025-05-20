package com.sist.web.dao;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
@Repository
public interface BusanInfoRepository extends ElasticsearchRepository<BusanInfoEntity, Integer> {
	// SELECT * FROM table_name, INSERT / UPDATE / DELETE
	// WHERE (조건문) findDistinctByName.... => 메서드 패턴 lessthen < greaterthen >
	// <= : lessthenEqual >= : greaterthenEqual
	public List<BusanInfoEntity> findByCno(@Param("cno") Integer cno);
	public List<BusanInfoEntity> findByTitleContaining(@Param("title") String title);
	/*
	 * 	A% 	findByTitleStartsWith
	 *  %A 	findByTitleEndsWith
	 *  %A% findByTitleContaining
	 */
}
