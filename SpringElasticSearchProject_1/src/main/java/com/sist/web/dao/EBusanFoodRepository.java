package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
import java.util.*;
/*
 * 	JPA 형식 => 메서드 제작
 * 	1) select distinct ... where lastname and firstname
 * 	   findDistinctByLastnameAndFirstname
 * 
 * 	2) where no between .. and ..
 * 	   findByNoBetween(int a, int b)
 * 
 * 	3) where age<?
 * 	   findByAgeLessThen(int age)
 * 				-------- GreaterThen
 * 				-------- GreaterThenEqual
 *  4) 가격(price) 1000원보다 작고 가격 => 내림차순
 *     findByPriceLessThenOrderByPriceDESC()
 * 
 */

@Repository
public interface EBusanFoodRepository extends ElasticsearchRepository<EBusanFood, Integer>{
	public List<EBusanFood> findByTypeContaining(String type);
	// 메서드화 => 조건이 있는 경우 / Order By, Group By ...
	// 
}
