<html>
<head>
    <meta charset="utf-8">
    <title>成功页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    成功!
                </h4> <strong>${msg !""}</strong><a href="${url}" class="alert-link"><span id="timer">3</span>秒后自动跳转</a>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    var maxtime = 3; //一个小时，按秒计算，自己调整!
                 function CountDown() {
                      if (maxtime > 0) {
                                 maxtime =  maxtime-1 ;
                                 document.getElementById("timer").innerHTML = maxtime;
                           } else{
                                 clearInterval(timer);
                                location.href="${url}";
                          }
                     }
                 timer = setInterval("CountDown()", 1000);
</script>
</html>
