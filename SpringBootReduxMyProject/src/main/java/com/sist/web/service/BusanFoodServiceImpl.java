package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class BusanFoodServiceImpl implements BusanFoodService {
	@Autowired
	private BusanFoodRepository bDao;

	@Override
	public List<BusanFoodVO> busanMainData() {
		// TODO Auto-generated method stub
		return bDao.busanMainData();
	}
}
