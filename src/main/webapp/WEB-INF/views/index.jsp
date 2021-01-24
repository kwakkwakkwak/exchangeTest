<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>
    환율 계산
</h1>
<div>
    <div>
        송금국가:<span>미국(USD)</span>
    </div>
    <div>
        수취국가:
        <select id="country" onchange="country()">
            <option value="" selected disabled hidden></option>
            <option value="KRW">한국(KRW)</option>
            <option value="JPY">일본(JPY)</option>
            <option value="PHP">필리핀(PHP)</option>
        </select>
    </div>
    <div>
        환율:<span id="exchangeRate"></span>
    </div>
    <div>
        송금액:<input id="amount"><span id="quote">USD</span>
    </div>
    <button onclick="send()">Submit</button>
    <div id="result" style="margin-top: 20px">

    </div>
</div>
<script>
    function country(){
        var quote = $("#country option:selected").val();
        $.ajax({
            url: "/api/getExchangeRate/"+quote,
            success: function(data) {
                $("#exchangeRate").html(data.exchangeRate + " " + quote + "/USD");
            },
            error: function (data){
                alert("fail!!" + data);
            }
        })
    }
    function send(){
        data ={"quote": $("#country option:selected").val(), "amount":$("#amount").val(),"exchangeRate":$("#exchangeRate").html()}
        $.ajax({
            url: "/api/clacExchange",
            type: "POST",
            data: JSON.stringify(data),
            contentType:"application/json",
            success: function(data) {
                $("#result").html(data);
            },
            error: function (data){
                alert("fail!!" + data);
            }
        })
    }
</script>
</body>
</html>
