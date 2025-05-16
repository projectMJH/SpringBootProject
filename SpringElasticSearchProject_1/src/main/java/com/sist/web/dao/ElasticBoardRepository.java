package com.sist.web.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.ElasticBoard;
/*
 * 	LIKE 의 방식: A%, %B, %C%
 * 	findByNameStartWith(String name) 	=> name%
 * 	findByNameEndWith(String name) 		=> %name
 * 	findByNameContaining(String name) 	=> %name%
 *  => 부산 검색시 사용 예정
 */
@Repository
public interface ElasticBoardRepository extends ElasticsearchRepository<ElasticBoard, Integer> {
	public ElasticBoard findById(int id); // SELECT * FROM board WHERE id=?
	
	// CRUD설정
	/*
	 * 	findAll() => 전체 데이터 읽기
	 *  findBy컬럼영() => 상세보기
	 *  save() => insert / update
	 *  delete() => delete
	 *  
	 *  mybatis / hibernate
	 *    | SQL기반    | 메서드 => 자동 SQL문장을 생성
	 *    				---- 형식
	 *    				| 단점: JOIN(O), subquery는 없다
	 *    				| ~Entity (컬럼과 일치) a,b,c => d insert into table(a,b,c,d)
	 *    | ~VO (다른 데이터 추가가능)
	 */
}
