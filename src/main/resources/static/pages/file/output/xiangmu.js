search_kejiju_xiangmu_projectDomain3 = "";
search_kejiju_xiangmu_projectType3 = "";
search_kejiju_xiangmu_region3 = "";
search_kejiju_xiangmu_approvalYear3 = "";

$(function() {
	// 技术领域
	ajaxPost("/kjxmJbxxInfo/dicJsly", null, findProjectDomainSuccess3, 5000, findError);
	// 项目类型
	ajaxPost("/kjxmJbxxInfo/dicXmlx", null, findProjectTypeSuccess3, 5000, findError);
	// 时间
	ajaxPost("/kjxmJbxxInfo/dicSj", null, findApprovalYearSuccess3, 5000, findError);
	// 地区
	ajaxPost("/kjxmJbxxInfo/dicDq", null, findRegionSuccess3, 5000, findError);
	
	$('#output_kejiju_xiangmu_button').click(function() {
		var param = {
		    projectName : $("#output_kejiju_xiangmu_projectName1").val(),
		    projectDomain : search_kejiju_xiangmu_projectDomain3,
		    projectType : search_kejiju_xiangmu_projectType3,
		    region : search_kejiju_xiangmu_region3,
		    approvalYear : search_kejiju_xiangmu_approvalYear3,
		    date1 : $("#output_kejiju_xiangmu_createTime1").val() == "" ? '1900-12-31' : $("#output_kejiju_xiangmu_createTime1").val(),
		    date2 : $("#output_kejiju_xiangmu_createTime2").val() == "" ? '3000-12-31' : $("#output_kejiju_xiangmu_createTime2").val(),
		
		}
		var url = "/sysFileOutput/forDownloadXiangmu";
		ajaxPost(url, param, forDownload);
	});
});

function forDownload(result) {
	if (result.fileName == "") {
		alert("没有数据");
		return;
	}
	var url = "/sysFileOutput/testDownload";
	var $eleForm = $("<form method='post'><input type='input' name='path' value='" + result.fileName + "'/></form>");
	$eleForm.attr("action", url);
	$(document.body).append($eleForm);
	// 提交表单，实现下载
	$eleForm.submit();
}

// 技术领域下拉框加载
function findProjectDomainSuccess3(result) {
	var data = [ {
	    id : " ",
	    text : "请选择"
	} ];
	$.each(result, function(index, value) {
		data.push({
		    id : value,
		    text : value
		});
	});
	
	$('#output_kejiju_xiangmu_projectDomain1').select2({
	    placeholder : "科技领域",
	    tags : true,
	    data : data
	});
	// 种子下拉点击事件
	$('#output_kejiju_xiangmu_projectDomain1').on('select2:select', function(evt) {
		search_kejiju_xiangmu_projectDomain3 = evt.params.data.id;
		
	});
}

// 项目类型下拉框加载
function findProjectTypeSuccess3(result) {
	var data = [ {
	    id : " ",
	    text : "请选择"
	} ];
	$.each(result, function(index, value) {
		data.push({
		    id : value,
		    text : value
		});
	});
	
	// 种子下拉
	$('#output_kejiju_xiangmu_projectType1').select2({
	    placeholder : "时间",
	    tags : true,
	    data : data
	});
	
	// 种子下拉点击事件
	$('#output_kejiju_xiangmu_projectType1').on('select2:select', function(evt) {
		search_kejiju_xiangmu_projectType3 = evt.params.data.id;
	});
}

// 时间下拉框加载
function findApprovalYearSuccess3(result) {
	var data = [ {
	    id : " ",
	    text : "请选择"
	} ];
	$.each(result, function(index, value) {
		data.push({
		    id : value,
		    text : value
		});
	});
	
	// 种子下拉
	$('#output_kejiju_xiangmu_approvalYear1').select2({
	    placeholder : "时间",
	    tags : true,
	    data : data
	});
	
	// 种子下拉点击事件
	$('#output_kejiju_xiangmu_approvalYear1').on('select2:select', function(evt) {
		search_kejiju_xiangmu_approvalYear3 = evt.params.data.id;
		
	});
}

// 地区下拉框加载
function findRegionSuccess3(result) {
	var data = [ {
	    id : " ",
	    text : "请选择"
	} ];
	$.each(result, function(index, value) {
		data.push({
		    id : value,
		    text : value
		});
	});
	
	// 种子下拉
	$('#output_kejiju_xiangmu_region1').select2({
	    placeholder : "时间",
	    tags : true,
	    data : data
	});
	
	// 种子下拉点击事件
	$('#output_kejiju_xiangmu_region1').on('select2:select', function(evt) {
		search_kejiju_xiangmu_region3 = evt.params.data.id;
		
	});
}
