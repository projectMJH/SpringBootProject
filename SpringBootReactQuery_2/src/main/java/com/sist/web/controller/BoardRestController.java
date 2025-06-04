package com.sist.web.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.repository.*;
import com.sist.web.entity.*;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
// => Restful => GET, POST, PUT, DELETE
@CrossOrigin(origins = "*")	// 모든 port 허용
// 1521 / 8080 => AWS는 0~1023까지 port를 접근 거부
public class BoardRestController {
	@Autowired
	private BoardRepository bDao;
	
	// http://localhost/board/list/${page}
	// ResponseEntity<Map>
	@GetMapping("/board/list/{page}")
	public Map board_list(@PathVariable("page") int page)
	{
		Map map=new HashMap();
		int rowSize=10;
		int start=(page*rowSize)-(rowSize-1);
		int end=(page*rowSize);
		List<BoardVO> list=bDao.boardListData(start,end);

		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		map.put("today", today);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("list", list);
		
		return map;
	}
	
	@PostMapping("/board/insert")
	public Map board_insert(@RequestBody BoardEntity vo)
	{
		Map map=new HashMap();
		try
		{
			vo.setHit(0);
			vo.setNo(bDao.maxNo());
			vo.setRegdate(new Date());

			BoardEntity _vo=bDao.save(vo);
			map.put("vo", _vo);
			map.put("msg", "yes");			
		}catch(Exception ex) 
		{
			map.put("msg", ex.getMessage());	
		}

		return map;
	}
	/*
	 * 	JPA => DataSet => VO를 가지고 데이터베이스 제어
	 * 			  |
	 * 			SQL없이 사용이 가능
	 *  => 복잡한 query, WHERE (조건문) => 직접 추가
	 *  => 나머지는 제공하는 메서드 사용
	 *  	= count() SELECT COUNT(*) ~
	 *  	= save() => insert / update
	 *  	= delete()
	 *  
	 *  => 규칙
	 *  	findByNO(int no) WHERE no=?
	 *  	SELECT WHERE Column
	 *  	SELECT DISTINCT ~ => findDistinctBy
	 *  	
	 */
	@GetMapping("/board/detail/{no}")
	public BoardEntity board_detail(@PathVariable("no") int no) 
	{
		BoardEntity vo=bDao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		bDao.save(vo);
		//vo=bDao.findByNo(no);
		
		return vo;
	}
	// 삭제
	@DeleteMapping("/board/delete/{no}/{pwd}")
	public Map board_delete(@PathVariable("no") int no,
							@PathVariable("pwd") String pwd)
	{
		Map map=new HashMap();
		BoardEntity vo=bDao.findByNo(no);
		if(pwd.equals(vo.getPwd()))
		{
			bDao.delete(vo);
			map.put("msg", "yes");
		}
		else
		{
			map.put("msg", "no");
		}

		return map;		
	}
	
	@GetMapping("/board/update/{no}")
	public BoardEntity board_update(@PathVariable("no") int no)
	{
		BoardEntity vo=bDao.findByNo(no);
		
		return vo;
	}
	
	@PutMapping("/board/update_ok")
	public Map board_update_ok(@RequestBody BoardEntity vo)
	{
		Map map=new HashMap();
		BoardEntity db=bDao.findByNo(vo.getNo());
		if(vo.getPwd().equals(db.getPwd()))
		{
			//vo.setNo(vo.getNo());
			vo.setHit(db.getHit());
			bDao.save(vo);
			map.put("msg","yes");
		}
		else
		{
			map.put("msg","no");
		}
		return map;
	}
	
}
