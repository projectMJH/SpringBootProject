package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;
import com.sist.web.service.*;
// => Maven / Gradle => 프로젝트 관리, 라이브러리 관리, 버전 관리, 배포 관리
// => 원격 : git / svn => 형상 관리
// => 브런치 : 
// => 협업 경험
/*
 * 	1. 웹 흐름, 데이터베이스 연동 : CRUD, 동적
 *  2. 스프링 / MVC / SQL 고급
 *  3. 최신 기술
 *     => CI/CD
 *     
 *  => 프로젝트 구현
 *     --------- 과정 중시 => 산출물, 협업 (문제점 / 해결책)
 *     
 *  => 학습
 *  	로션 / GIT      
 */
@Controller
public class FoodController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("/list")
	public String food_list(@RequestParam(name = "page",defaultValue = "1") String page, Model model)
	{
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", curpage*12-11);
		map.put("end", curpage*12);
		List<FoodVO> list=fService.foodListData(map);
		int totalpage=fService.foodTotalPage();
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String food_detail(@RequestParam("fno") int fno, Model model)
	{
		FoodVO vo=fService.foodDetailData(fno);
		model.addAttribute("vo",vo);
		return "detail";
	}
}
