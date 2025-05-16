package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
public class EBusanFoodController {
	@Autowired
	private EBusanFoodRepository eDao;
	
	

}
