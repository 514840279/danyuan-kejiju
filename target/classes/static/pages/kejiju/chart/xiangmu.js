$(function() {
	// 重载
	var url = "/kjxmJbxxInfo/statistics";
	ajaxPost(url, null, findXiangmuStatisticsSuccess, 5000, findError);
})
function findXiangmuStatisticsSuccess(result) {
	xAxis_data = [];
	series_data = [];
	$.each(result, function(index, value) {
		xAxis_data.push(value.projectDomain);
		series_data.push(value.numbers);
	})
	Xiangmu_echart_init(xAxis_data, series_data, result);
}
function Xiangmu_echart_init(xAxis_data, series_data, result) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('xiangmu_chart_id'));
	
	// 指定图表的配置项和数据
	option = {
	    xAxis : {
	        type : 'category',
	        data : xAxis_data
	    },
	    yAxis : {
		    type : 'value'
	    },
	    series : [ {
	        data : series_data,
	        label : {
		        normal : {
		            show : true,
		            position : 'top'
		        }
	        },
	        type : 'bar'
	    } ]
	};
	
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
	
	// bootstrap table
	$('#kejiju_xiangmu_chart_data_table_datagrid').bootstrapTable({
		columns : [ {
	        title : '类型',
	        field : 'projectDomain',
//	        sortable : true,
//	        align : 'center',
//	        valign : 'middle',
	    }, {
	        title : '数量',
	        field : 'numbers',
//	        sortable : true,
//	        align : 'center',
//	        valign : 'middle',
	    }, ],
	    data : result,
	});
}
