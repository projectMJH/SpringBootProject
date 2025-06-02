package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
// cookie / session
public interface RecipeService {

	public List<RecipeVO> recipeListData(int start,int end);
	public int recipeTotalPage();
	public Map recipeDetailData(int no);
	public Map recipeFindData(int page,String title);
}
