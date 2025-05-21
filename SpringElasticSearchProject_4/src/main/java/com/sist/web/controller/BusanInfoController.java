package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;
import com.sist.web.service.*;
 
@Controller
public class BusanInfoController {
	@Autowired
	private BusanInfoService bService;
	
	@GetMapping("/")
	public String busan_info(@RequestParam(name = "page",defaultValue = "1") String page, Model model)
	{
		List<BusanInfoEntity> list=bService.busanAllData(Integer.parseInt(page));
		int[] pages=bService.getPageData(Integer.parseInt(page));
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",pages[0]);
		model.addAttribute("totalpage",pages[1]);
		model.addAttribute("startPage",pages[2]);
		model.addAttribute("endPage",pages[3]);
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String busan_detail(@RequestParam("id") String id, Model model)
	{
		System.out.println("id:"+id);
//		Optional<BusanInfoEntity> op=bService.findById(id);
//		BusanInfoEntity vo=op.orElse(new BusanInfoEntity());
		BusanInfoEntity vo=bService.findById(id);
		System.out.println("vo"+vo.getAddress());
		
		model.addAttribute("vo",vo);
		return "detail";
	}
	
	@RequestMapping("/find")
	public String busan_find(@RequestParam(name = "title",defaultValue = "부산") String title, Model model)
	{
		List<BusanInfoEntity> list=bService.busanFindData(title);
		model.addAttribute("list",list);
		System.out.println("list:"+list.toString());
		return "find";
	}
}
