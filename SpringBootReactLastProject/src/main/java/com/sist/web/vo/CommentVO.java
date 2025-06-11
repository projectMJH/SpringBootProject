package com.sist.web.vo;

// Entity : table을 제어 => column명외 다른 데이터를 사용할 수 없다 => insert
// VO : 추가하는 항목이나 alias가 있는 경우
public interface CommentVO {
	public int getNo();
	public int getFno();
	public String getId();
	public String getName();
	public String getMsg();
	public String getDbday();
}
