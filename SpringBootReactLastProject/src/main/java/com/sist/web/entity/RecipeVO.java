package com.sist.web.entity;
/*
 * NO         NOT NULL NUMBER         
TITLE      NOT NULL VARCHAR2(4000) 
POSTER     NOT NULL VARCHAR2(260)  
CHEF       NOT NULL VARCHAR2(500)  
LINK                VARCHAR2(300)  
HIT                 NUMBER         
LIKECOUNT           NUMBER         
REPLYCOUNT          NUMBER   
==> CLOB => TO_CHAR
 */
// 원하는 데이터를 읽는 경우 
public interface RecipeVO {
	public int getNo();
	public String getTitle();
	public String getPoster();
	public String getChef();
	public int getHit();
	public int getLikecount();
	public int getRownum();
}
