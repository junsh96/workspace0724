<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>일반게시판</title>

    <style>

        .board-container {
            max-width: 1000px;
            margin: 50px auto;
            padding: 2rem;
        }

        .board-card {
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        .board-card h2 {
            text-align: center;
            color: #333;
            margin-bottom: 2rem;
            padding-bottom: 1rem;
            border-bottom: 2px solid #4b89fc;
        }

        .write-btn-area {
            text-align: right;
            margin-bottom: 1rem;
        }

        .board-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 2rem;
        }

        .board-table thead {
            background: #4b89fc;
            color: white;
        }

        .board-table th,
        .board-table td {
            padding: 1rem;
            text-align: center;
            border-bottom: 1px solid #e0e0e0;
        }

        .board-table th {
            font-weight: 500;
        }

        .board-table tbody tr {
            transition: all 0.2s ease;
        }

        .board-table tbody tr:hover {
            background-color: #f5f8ff;
            cursor: pointer;
            transform: translateY(-2px);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .pagination {
            display: flex;
            justify-content: center;
            gap: 0.5rem;
            margin-top: 2rem;
        }

        .pagination .btn {
            min-width: 40px;
        }
    </style>
</head>
<body>
	<jsp:include page="/views/common/menubar.jsp" />

    <div class="board-container">
        <div class="board-card">
            <h2>일반게시판</h2>

            <div class="write-btn-area">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/enrollForm.bo">글쓰기</a>
            </div>
            <table class="board-table">
                <thead>
                    <tr>
                        <th width="70">글번호</th>
                        <th width="100">카테고리</th>
                        <th width="300">제목</th>
                        <th width="100">작성자</th>
                        <th width="70">조회수</th>
                        <th width="100">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="board" items="${boardList}">
             		<c:url var="listUrl" value="detail.bo">
		    			<c:param name="boardNo" value="${board.boardNo}"/>
				    </c:url>
                    	<tr>
                    		<td>${board.boardNo}</td>
                    		<td>${board.categoryName}</td>
                    		<td><a href="${pageContext.request.contextPath}/${listUrl}">${board.boardTitle}</a></td>
                    		<td>${board.memberName}</td>
                    		<td>${board.count}</td>
                    		<td>${board.createDate}</td>
                    	</tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="pagination">
            		<c:choose>
            			<c:when test="${pageNo != 1}">
            				<c:url var="bePage" value="list.bo">
								<c:param name="pageNo" value="${pageNo - 1}"/>
						    </c:url>
						    <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/${bePage}'">
								&lt; 이전
			                </button>
            			</c:when>
            			<c:otherwise>
						    <button class="btn btn-secondary">
								&lt; 이전
			                </button>
            			</c:otherwise>
            		</c:choose>
            		
 
                
                <c:forEach var="i" begin="0" end="${boardCnt}" step="1">
               		<c:url var="pageUrl" value="list.bo">
						<c:param name="pageNo" value="${i+1}"/>
				    </c:url>
		    		<button class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/${pageUrl}'">${i+1}</button>
			    </c:forEach>

			    <c:choose>
			    	<c:when test="${ boardCnt+1 != pageNo}">
			    		<c:url var="nextPage" value="list.bo">
							<c:param name="pageNo" value="${pageNo + 1}"/>
					    </c:url>
			    	
		           	    <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/${nextPage}'">
		                &lt; 다음
		                </button>			    	
			    	</c:when>
			    	<c:otherwise>
		           	    <button class="btn btn-secondary">
		                &lt; 다음
		                </button>				    	
			    	</c:otherwise>
			    </c:choose>

            </div>
        </div>
    </div>

</body>
</html>