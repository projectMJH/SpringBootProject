package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

public interface FoodService {
	public List<FoodVO> FoodMainData();
	public Map foodListData(int page);
}
