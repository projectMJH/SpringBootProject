package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.vo.*;
import com.sist.web.mapper.*;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodMapper mapper;
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodListData(map);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return mapper.foodDetailData(fno);
	}

}
