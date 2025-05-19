package com.sist.web.controller;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import org.springframework.web.bind.annotation.*;
@Controller
public class MusicController {
	@Autowired
	private MusicService mService;
	
	/*
	 * 		리턴형 : void	/ String
	 * 		----------------------
	 * 		매개변수 : 일반 데이터 / 클래스 (VO) => 내장 객체 => Model (전송)
	 */
	/*
	@GetMapping("/music/data")
	public String music_data(Model model) {
		List<Music> list=new ArrayList<Music>();
		try
		{
			int k=1;
			for(int i=1;i<=4;i++) {
					Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20250519&hh=11&rtm=Y&pg="+i).get();
					//Elements rank=doc.select("table.list-wrap td.number");
					Elements title=doc.select("table.list-wrap td.info a.title");
					Elements singer=doc.select("table.list-wrap td.info a.artist");
					Elements album=doc.select("table.list-wrap td.info a.albumtitle");
					Elements poster=doc.select("table.list-wrap a.cover img");
					Elements etc=doc.select("table.list-wrap span.rank");
					
					for(int j=0;j<title.size();j++) 
					{
						try {
							Music m=new Music();
							m.setId(String.valueOf(k));
							m.setTitle(title.get(j).text());
							m.setSinger(singer.get(j).text());
							m.setAlbun(album.get(j).text());
							m.setPoster(poster.get(j).attr("src"));
							String e=etc.get(j).text();
							String temp=e.replaceAll("[^가-힣]","");
							String id="";
							String state="";
							if(temp.equals("유지"))
							{
								id="0";
								state=temp;
							}
							else
							{
								state=temp;
								id=e.replaceAll("[^0-9]", "");
							}
							m.setState(state);
							m.setIdcrement(Integer.parseInt(id.trim()));
							mService.saveMusic(m);
							System.out.println(k+"."+title.get(j).text());
							list.add(m);
							k++;
						}catch(Exception e) {}
					}
			}
			System.out.println("저장 완료!");
		}catch(Exception ex) {}
		model.addAttribute("list",list);
		model.addAttribute("msg","저장 완료");
		return "music/data";
	}
	*/
	
	@GetMapping("/music/list")
	public String music_list(@RequestParam(name = "page",defaultValue = "1") String page, Model model)
	{
		int curpage=Integer.parseInt(page);
		List<Music> list=mService.getAllMusics(curpage);
		int totalpage=mService.getTotalPage();
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "music/list";
	}
}
