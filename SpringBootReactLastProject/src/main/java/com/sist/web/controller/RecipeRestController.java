package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.service.*;
@RestController
@CrossOrigin(origins = "*")
public class RecipeRestController {
	@Autowired
	private RecipeService rService;
	
	@GetMapping("/recipe/list/{page}")
	public ResponseEntity<Map> recipe_list(@PathVariable("page") int page)
	{
		Map map=new HashMap();
		try
		{
			map=rService.recipeListData(page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/recipe/detail/{no}")
	public ResponseEntity<Map> recipe_detail(@PathVariable("no") int no)
	{
		Map map=new HashMap();
		try
		{
			map=rService.recipeDetailData(no);
			
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
