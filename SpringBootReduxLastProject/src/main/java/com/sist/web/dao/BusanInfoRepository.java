package com.sist.web.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;
import java.util.*;

@Repository
public interface BusanInfoRepository extends JpaRepository<BusanInfoEntity, Integer>{
	@Query(value = "SELECT * FROM busan_info "
			+ "ORDER BY no ASC "
			+ "LIMIT 0,5", nativeQuery = true)
	public List<BusanInfoEntity> busanInfoMainData();
}
