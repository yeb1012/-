<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		fetch('drawChart.do')
		.then(resolve=>resolve.json())
		.then(result=>{
			let dataAry =[['Writer', 'Cnt']];
			result.forEach(item => {
				console.log(result);
				dataAry.push([item.replyer, item.cnt])//xml쿼리문에서 ""넣어서 소문자 처리 했으면 여기도 소문자 해줘야함 대문자로 쓰면 차트 안나옴
			})
			console.log(dataAry);
			var data = google.visualization.arrayToDataTable(dataAry);
			var options = {
					title : '작성자 건수별',
					is3D : true,
				};

				var chart = new google.visualization.PieChart(document
						.getElementById('piechart_3d'));
				chart.draw(data, options);
			
		})
		.catch(err => console.log(err))
		
	}
</script>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>


<jsp:include page="../layout/footer.jsp"></jsp:include>