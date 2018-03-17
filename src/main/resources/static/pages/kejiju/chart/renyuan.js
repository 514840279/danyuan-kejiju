$(function() {
	// 重载
	var url = "/kjryJbxxInfo/statistics";
	ajaxPost(url, null, findrenyuanStatisticsSuccess, 5000, findError);
	
	// 重载
	var url = "/kjryJbxxInfo/flare";
	ajaxPost(url, null, findrenyuanflareSuccess, 5000, findError);
})
function findrenyuanStatisticsSuccess(result) {
	xAxis_data = [];
	series_data = [];
	$.each(result, function(index, value) {
		xAxis_data.push(value.honorary);
		series_data.push(value.numbers);
	})
	renyuan_echart_init(xAxis_data, series_data, result);
}
function renyuan_echart_init(xAxis_data, series_data, result) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('renyuan_chart_id'));
	
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
	$('#kejiju_renyuan_chart_data_table_datagrid').bootstrapTable({
		columns : [ {
	        title : '类型',
	        field : 'honorary',
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



function findrenyuanflareSuccess(result) {
	console.log(result);
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('renyuan_chart_tree_id'));
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
	
	var data_tree = [];
	rdata(result,data_tree);
	
	
	console.log(data_tree);
	// bootstrap table
	$('#kejiju_renyuan_chart_data_tree_datagrid').bootstrapTable({
		columns : [ {
	        title : '项目',
	        field : 'name',
	    }, {
	        title : '数量',
	        field : 'number',
	    }, ],
	    data : data_tree,
	});
}

function rdata(result,data_tree){
	data_tree.push({"name":result.name,"number":result.value})
	if(result.children!=null){
		$.each(result.children,function(index,val){
			rdata(val,data_tree)
		})
	}
}