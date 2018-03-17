$(function() {
	// 重载
	var url = "/kjcgJbxxInfo/flare";
	ajaxPost(url, null, findChengguoflareSuccess, 5000, findError);
})

function findChengguoflareSuccess(result) {
	console.log(result);
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('chengguo_chart_tree_id'));
	myChart.setOption(option = {
	        tooltip: {
	            trigger: 'item',
	            triggerOn: 'mousemove'
	        },
	        series: [
	            {
	                type: 'tree',
	                data: [result],
	                top: '18%',
	                bottom: '14%',
	                layout: 'radial',
	                symbol: 'emptyCircle',
	                symbolSize: 7,
	                initialTreeDepth: 3,
	                animationDurationUpdate: 750

	            }
	        ]
	    });
}
