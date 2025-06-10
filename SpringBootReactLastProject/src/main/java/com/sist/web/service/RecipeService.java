package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import com.sist.web.vo.*;
// Service : 1. 여러개의 DAO를 통합 => BI, 
//			 2. DAO에서 받은 데이터를 변경, 추가 => Controller
public interface RecipeService {
	public Map recipeListData(int page);
	public List<RecipeVO> recipeMainData();
	public Map recipeDetailData(int no);
}
