package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@RestController
public class BusanRestController {
	@Autowired
	private BusanFoodService service;
	
	@GetMapping("/main/main_react")
	public Map busan_main()
	{
		Map map=new HashMap();
		List<BusanFoodVO> list=service.busanMainData();
		List<BusanFoodVO> mList=new ArrayList<BusanFoodVO>();
		List<BusanFoodVO> lList=new ArrayList<BusanFoodVO>();
		BusanFoodVO vo=list.get(0);
		
		for(int i=1;i<list.size();i++)
		{
			if(i<=4)
			{
				mList.add(list.get(i));
			}
			else
			{
				lList.add(list.get(i));
			}
		}
		
		map.put("main", vo);
		map.put("mList", mList);
		map.put("lList", lList);
		return map;
	}

}
