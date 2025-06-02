package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;


@Repository
public interface RecipeDetailRepository extends JpaRepository<RecipeDetailEntity, Integer>{
	public RecipeDetailEntity findByNo(int no);
	// where no=?
}
