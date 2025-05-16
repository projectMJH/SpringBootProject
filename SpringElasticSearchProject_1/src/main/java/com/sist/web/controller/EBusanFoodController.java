package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * 		Spring-Boot : 순수하게 서버역할 => 요청 / 응답 : vue = boot, react = boot
 * 		--------------------------------------- Back-End : 설정 파일 제외 : XML, Tomcat 내장
 * 												=> Spring-Framework 호환
 * 		ThymeLeaf
 * 		---------
 * 		웹에서 독립적인 실행환경을 위한 Java 템플릿
 * 		=> jsp : 브라우저에 실행 : 텍스트 파일로 변경
 * 		=> thymeleaf => HTML 
 * 		=> SSR : 서버사이드 HTML 렌더링
 * 				 ------- NodeJS
 * 		=> 목적 : 순수하게 HTML을 최대한 유지
 * 		=> 스프링에서 통합
 * 		=> JSP보다 속도가 늦다
 * 		   --- 오라클에서 유료화 대비 => 대체 (JSP: ThymeLeaf, JAVA: 코틀린)
 * 		=> 기본 사용법
 * 		   --------
 * 			데이터 출력
 * 				th:text="${}" <td>[[${}]]</td>
 * 				url => @{}
 * 				선택 변수 => *{}
 * 				메세지 표현식 => #{}
 * 			연산자
 * 				산술 ${10+20}
 * 					: +, -, *, /, %
 * 				비교 : <, >, <=, >=, !=, ==
 * 				논리 : and, or, not
 * 				삼항연산자 : (조건)?값:값
 * 			제어문	
 * 				th:if / th:else, th:each
 * 				=> EL + JSTL
 * 				=> 장점 : HTML안에 출력
 */
import com.sist.web.dao.*;
import com.sist.web.vo.*;
import java.util.*;
@Controller
public class EBusanFoodController {
	@Autowired
	private EBusanFoodRepository eDao;
	
	@GetMapping("/busan/list")
	public String ebusan_list(@RequestParam(name="page", defaultValue = "1") String page, Model model)
	{
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		// 페이징 사용
		Pageable pg=PageRequest.of(curpage-1, rowSize, Sort.by(Sort.Direction.DESC,"id"));
		// 데이터 읽기
		Page<EBusanFood> pList=eDao.findAll(pg);
		// Page => List 변환
		List<EBusanFood> list=new ArrayList<EBusanFood>();
		// 데이터가 있는 경우에만 List에 값을 채운다 => JPA(SQL)
		if (pList!= null && pList.hasContent())
		{
			list=pList.getContent();
		}
		// Poster url 주소 update
		for(EBusanFood eb:list)
		{
			String s=eb.getPoster();
			s="https://www.menupan.com"+s;
			eb.setPoster(s);
		}
		
		// 총페이지 구하기
		int count=(int)eDao.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		// BLOCK 
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
		{
			endPage=totalpage;
		}
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
				
		return "busan/list";
	}
	
	@RequestMapping("/busan/find")
	public String busan_find(@RequestParam(name="type", defaultValue = "한식") String type, Model model)
	{
		List<EBusanFood> list=eDao.findByTypeContaining(type);
		model.addAttribute("list",list);
		return "busan/find";
	}
	
	@GetMapping("/busan/detail")
	public String busan_detail(@RequestParam("id") String id, Model model)
	{
		EBusanFood vo=eDao.findById(id);
		model.addAttribute("vo",vo);
		
		return "busan/detail";
	}

}
