package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.vo.ElasticBoard;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
@RestController
public class ElasticBoardRestController {
	@Autowired
	private ElasticBoardRepository bDao;
	
	@PostMapping("/eboard/update_ok")
	public String eboard_update_ok(ElasticBoard vo)
	{
		// id / name / subject / content / pwd => hit, regdate 는 값이 없다 => dbvo 에서 채워야 함
		String result="";
		ElasticBoard dbvo=bDao.findById(vo.getId());
		if(dbvo.getPwd().equals(vo.getPwd()))
		{
			vo.setHit(dbvo.getHit());
			vo.setRegdate(dbvo.getRegdate());
			bDao.save(vo);
			result="<script>"
					+ "location.href=\"/eboard/detail?id="+vo.getId()+"\""
					+ "</script>";
		}
		else
		{
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return result;	// controller는 이동 정보만 가능
	}
	@PostMapping("/eboard/delete_ok")
	// 가급적 => AJAX / VUE
	public String eboard_delete_ok(@RequestParam("id") int id, @RequestParam("pwd") String pwd)
	{
		String result="";
		ElasticBoard vo=bDao.findById(id);
		if(vo.getPwd().equals(pwd))
		{
			bDao.delete(vo);
			result="<script>"
					+ "location.href=\"/eboard/list\""
					+ "</script>";		}
		else
		{
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
}
