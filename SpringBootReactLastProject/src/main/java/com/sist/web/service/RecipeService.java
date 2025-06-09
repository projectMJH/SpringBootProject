package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;

public interface RecipeService {
	public Map recipeListData(int page);
	public List<RecipeVO> recipeMainData();
}
