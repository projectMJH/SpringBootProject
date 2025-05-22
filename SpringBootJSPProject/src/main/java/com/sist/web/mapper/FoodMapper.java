package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Repository
@Mapper
public interface FoodMapper {
	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
}
