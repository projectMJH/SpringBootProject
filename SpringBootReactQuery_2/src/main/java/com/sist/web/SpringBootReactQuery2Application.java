package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 서버 구도 ㅇ=> Spring - App
// 환경 설정 => XML => properties, yml
// 버전 관리 / 라이브러리 관리 / 프로젝트 관리 => maven / gradel
// 형상 관리 : GIT, SVN
/*
 * 		스프링 부트
 * 		=> 스프링 프레임워크를 기반으로 웹개발을 단순화하고 빠른 개발 / 배포 지원
 * 														------ 배포 jar
 * 		=> XML 설정없이 간단하게 구성 => 자동 구성 , 내장 웹 서버를 가지고 있다
 * 		   => server.port = 80
 * 			  => 8080
 * 			  => AWS에서 0~1023 => 알려진 포트 (사용금지)
 * 				 --- 허용 (보안 그룹) : 8080 / 1521
 * 				 => 단점 : ubuntu 설정
 * 						  ------ 암호화 / 비대칭 (RSA)
 * 										---------- private / public
 * 												   ----------------
 * 				 => webpack => thymeleaf
 * 				 => CI/CD (Continuous Integration / Continuous Distribute) 
 * 					=> git Action / docker / Jenkins
 * 		=> 스프링 프레임워크 / Java, 코틀린
 * 		   C / C++ / Java / 코틀린 / Dart ..... / GO
 * 					 -----------
 * 					 Java + JavaScript
 * 		=> 웹 : JSP, Front (Vue3, Vuex, react, react-query)
 * 		=> react / vue 포함 => 3000
 * 		=> 2800 ~ 3200
 * 		   ----	  ---- 
 */
@SpringBootApplication
//@EnableAspenctJAutoProxy
//@ComponetsScan(basePackage="")
public class SpringBootReactQuery2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactQuery2Application.class, args);
	}

}
