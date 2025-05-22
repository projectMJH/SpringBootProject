<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
  margin: 0px auto;
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.container{
  margin-top: 50px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <c:forEach var="vo" items="${list }">
       <div class="col-sm-4"> <!-- for(BusanVO vo:list) -->
        <div class="thumbnail">
          <a href="/detail?fno=${vo.fno}">
            <img src="https://www.menupan.com${vo.poster}" style="width: 230px;height: 120px">
            <div class="caption">
              <p>${vo.name}</p>
            </div>
          </a>
        </div>  
       </div>  
      </c:forEach>
    </div>
    <div class="text-center" style="margin-top: 10px">
      <a href="/list?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
        ${curpage } page / ${totalpage } pages
      <a href="/list?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
    </div>
    
  </div> 
  

</body>
</html>