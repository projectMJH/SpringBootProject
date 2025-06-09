package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;

public interface FoodService {
	public List<FoodVO> FoodMainData();
	public Map foodListData(int page);
}
