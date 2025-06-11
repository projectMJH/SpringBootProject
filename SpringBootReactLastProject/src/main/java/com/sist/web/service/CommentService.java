package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

public interface CommentService {
	public int idCount(String id);
	public MemberEntity memberDetailData(String id);
	public List<CommentVO> commentListData(int fno);
	public List<CommentVO> commentInsert(CommentEntity vo);
	public List<CommentVO> commentDelete(int no,int fno);
	public List<CommentVO> commentUpdate(int no,String msg);
}
