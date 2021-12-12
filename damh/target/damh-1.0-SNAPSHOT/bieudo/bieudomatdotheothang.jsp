<%@page import="entity.Matdo"%>
<%@page import="java.util.List"%>
<%@page import="dao.matdoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
                    ['Tuyen Sai Gon - Vung Tau', 3],
                    ['Tuyen Sai Gon - Can Tho', 4],
                    ['Dong Nai - Vung Tau', 4],
                    ['Long An - Binh Duong', 7],
                    ['Ca Mau - Sai Gon', 10],
                    ['Long An - Ca Mau', 7],
                    ['Binh Phuoc - Ca Mau', 8]
                ]);

                var options = {
                    title: 'Biểu đồ mật độ chuyến xe theo tuyến xe',
                    is3D: true,
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                chart.draw(data, options);
            }
        </script>
    </head>
    <body>
        <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
    </body>
</html>
