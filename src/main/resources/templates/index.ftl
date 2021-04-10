<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepaginator/1.1.0/bootstrap-datepaginator.js"
            integrity="sha512-WlaA01/icDQjNVYFdx2ElC+3MuC+LAd85g4zU0uDnoc081ZrxmUppD8ifrh+/411+5Q5tGRbvuIN4THadY1ptw=="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
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
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
            <div class="pagination">

            </div>
        </table>
    </div>
</div>
<script>

    $(function () {
        render();
    });

    function render() {
        $.getJSON("http://localhost:8081/student", {"pageSize": 10, "pageNo": 1}, function (resp) {
            var html = "";
            $(resp.data.records).each(function (i, e) {
                html += "<tr>"
                    + "<td>" + e.id + "</td>"
                    + " <td>" + e.name + "</td>"
                    + " <td>" + e.age + "</td>"
                    + " </tr>"
            })
            $("#studentList").html(html)
            setPage(resp.data.current, resp.data.total, render)
        })
    }


    function setPage(pageCurrent, pageSum, callback) {
        $(".pagination").bootstrapPaginator({
            //设置版本号
            bootstrapMajorVersion: 3,
            // 显示第几页
            currentPage: pageCurrent,
            // 总页数
            totalPages: pageSum,
            //当单击操作按钮的时候, 执行该函数, 调用ajax渲染页面
            onPageClicked: function (event, originalEvent, type, page) {
                // 把当前点击的页码赋值给currentPage, 调用ajax,渲染页面
                currentPage = page
                callback && callback()
            }
        })
    }


</script>
</body>
</html>