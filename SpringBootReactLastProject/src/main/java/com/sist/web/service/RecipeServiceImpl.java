package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository rDao;

	@Override
	public Map recipeListData(int page) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		
		int rowSize=12;
	    int start=(rowSize*page)-(rowSize-1);
	    int end=(rowSize*page);
	    List<RecipeListVO> list=rDao.recipeListData(start, end);
	    int count=rDao.recipeCount();
	    int totalpage=(int)(Math.ceil(count/12.0));
	    
	    final int BLOCK=10;
	    int startPage=(page-1)/BLOCK*BLOCK+1;
	    int endPage=(page-1)/BLOCK*BLOCK+BLOCK;
	    if (endPage>totalpage)
	    	endPage=totalpage;
	    
	    map.put("list", list);
	    map.put("curpage", page);
	    map.put("totalpage", totalpage);
	    map.put("startPage", startPage);
	    map.put("endPage", endPage);
	    		
		return map;
	}


	@Override
	public List<RecipeVO> recipeMainData() {
		// TODO Auto-generated method stub
		return rDao.recipeMainData();
	}
	
	
}
