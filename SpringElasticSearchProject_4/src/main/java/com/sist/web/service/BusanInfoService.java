package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.*;

public interface BusanInfoService {
	// findAll()
	public List<BusanInfoEntity> busanAllData(int page);
	// count()
	public int[] getPageData(int page);
	// save, delete
	public List<BusanInfoEntity> findByTitleContaining(@Param("title") String title);
	public List<BusanInfoEntity> busanFindData(@Param("title") String title);
	
	public List<BusanInfoEntity> findByCno(@Param("cno") Integer cno);
	public List<BusanInfoEntity> busanCnoData(@Param("cno") Integer cno);

	public BusanInfoEntity findById(@Param("id") String id);
	public BusanInfoEntity busanDetailData(@Param("id") Integer id);

}
