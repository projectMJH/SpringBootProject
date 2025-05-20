package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// 서버 => 클라이언트 통신
/*
 * 												모바일 (코틀린)	
 * 	서버 = 클라이언트와 동일한 언어						   | JSON
 * 	------------- 언어가 다른 경우	파이썬 == 장고, 스프링 == 자바, 	C# === Asp.net
 * 									  |	XML,JSON   |			|
 * 								  자바스크립트		자바스크립트
 */
import com.sist.web.service.*;
import com.sist.web.entity.*;
@CrossOrigin(origins = "*")
@RestController
public class BusanInfoRestController {
	@Autowired
	private BusanInfoService bService;
	
	@GetMapping("/main_react")
	public Map main_react()
	{
		List<BusanInfoEntity> list1=bService.getBusanInfoData(1); // 명소
		List<BusanInfoEntity> list2=bService.getBusanInfoData(2); // 음식
		List<BusanInfoEntity> list3=bService.getBusanInfoData(3); // 쇼핑
		
		Map map=new HashMap();
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("list3", list3);
		
		return map;
	}
	
	@GetMapping("/info/list_react")
	public Map info_list(@RequestParam("page") int page)
	{
		List<BusanInfoEntity> list=bService.getBusanInfoAll(page);
		int[] data=bService.getPageDatas(page);
		Map map=new HashMap();
		map.put("list", list);
		map.put("pages", data);
		return map;
	}
}
