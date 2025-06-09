package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
	@Autowired
	private RecipeService rService;
	@Autowired
	private FoodService fService;
	
	@GetMapping("/main")
	public ResponseEntity<Map> main_data()
	{
		Map map=new HashMap();
		try
		{
			List<RecipeVO> rList=rService.recipeMainData();
			List<FoodVO> fList=fService.FoodMainData();
			
			RecipeVO main=rList.get(0);
			List<RecipeVO> list1=new ArrayList<RecipeVO>();
			for(int i=1;i<=4;i++)
			{
				list1.add(rList.get(i));
			}
			List<RecipeVO> list2=new ArrayList<RecipeVO>();
			for(int i=5;i<=8;i++)
			{
				list2.add(rList.get(i));
			}
			map.put("main", main);
			map.put("list1", list1);
			map.put("list2", list2);
			map.put("rList", rList);
			map.put("fList", fList);
					
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
