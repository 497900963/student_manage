<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/jquery.sPage.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="/js/jquery.sPage.js"></script>
    <script src="/js/template-web.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 100px">
        <div class="col-xs-12">
            <form class="form-inline" style="text-align: center">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" id="keywords" placeholder="关键字">
                    </div>
                </div>
                <button type="button" id="search" class="btn btn-primary">search</button>
            </form>
        </div>
    </div>
    <div class="row">
        <table class="table table-hover ">
            <thead>
            <tr>
                <th>id</th>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
            </thead>
            <tbody id="studentList">
            </tbody>
        </table>
    </div>
    <div id="paginator" style="text-align:center;padding-top:30px"></div>

    <div id="pNum" class="num"></div>
    <div id="myPage" class="demo"></div>
</div>
</style>
<script type="text/html" id="list">
    {{each records as value i}}
    <tr>
        <td>{{value.id}}</td>
        <td>{{value.name}}</td>
        <td>{{value.age}}</td>
    </tr>
    {{/each}}
</script>
<script>
    $(function () {
        search();
        $("#search").on('click', function () {
            search();
        })
    })

    function search(page) {
        var p = page || 1;
        var keywords = $("#keywords").val();
        var param = {"keywords": keywords, "pageSize": 10, "pageNo": p}
        $.ajax({
            url: "/student",
            data: param,
            method: "get",
            contentType: "json",
            success: function (resp) {
                var html = template('list', resp.data);
                $("#studentList").html(html);
                $("#paginator").sPage({
                    page: resp.data.current,//当前页码，必填
                    total: resp.data.total,//数据总条数，必填
                    pageSize: resp.data.size,//每页显示多少条数据，默认10条
                    totalTxt: "共{total}条",//数据总条数文字描述，{total}为占位符，默认"共{total}条"
                    showTotal: "true",//是否显示总条数，默认关闭：false
                    showSkip: "true",//是否显示跳页，默认关闭：false
                    showPN: "true",//是否显示上下翻页，默认开启：true
                    prevPage: "上一页",//上翻页文字描述，默认“上一页”
                    nextPage: "下一页",//下翻页文字描述，默认“下一页”
                    backFun: function (page) {
                        search(page)
                    }
                });
            }
        })
    }

</script>
</body>
</html>