<%--
  Created by IntelliJ IDEA.
  User: kwak
  Date: 2021/01/24
  Time: 2:30 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    환율 계산
</h1>
<div>
    <div>
        송금국가:<span></span>
    </div>
    <div>
        수취국가:<select>
        <option selected>한국</option>
        <option>일본</option>
        <option>필리핀</option>
        </select>
    </div>
    <div>
        환율:<span></span>
    </div>
    <div>
        송금액:<input><span>KRW</span>
    </div>
    <button>Submit</button>
</div>
</body>
</html>
