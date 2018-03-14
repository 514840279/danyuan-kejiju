search_kejiju_chengguo_resultType3="";
search_kejiju_chengguo_completedDate3="";
$(function() {
	ajaxPost("/kjcgJbxxInfo/dicCglx", null, findResultTypeSuccess3, 5000, findError);
	
	ajaxPost("/kjcgJbxxInfo/dicCgsj", null, findCompletedDateSuccess3, 5000, findError);
	
	// 下载按钮事件
	$("#output_kejiju_chengguo_button").bind('click',function(){
		var url = "/sysFileOutput/forDownloadChengguo"
		var param={
				projectName:$("#output_kejiju_chengguo_projectName1").val(),
				resultType:search_kejiju_chengguo_resultType3,
				completedDate:search_kejiju_chengguo_completedDate3,
				date1:$("#output_kejiju_chengguo_createTime1").val()==""?'1900-12-31':$("#output_kejiju_chengguo_createTime1").val(),
				date2:$("#output_kejiju_chengguo_createTime2").val()==""?'3000-12-31':$("#output_kejiju_chengguo_createTime2").val(),
		}
		ajaxPost(url, param,forDownload);
		
	})
});

function forDownload(result){
	if(result.fileName==""){
		alert("没有数据");
		return;
	}
	var url ="/sysFileOutput/testDownload";
	var $eleForm = $("<form method='post'><input type='input' name='path' value='"+result.fileName+"'/></form>");
    $eleForm.attr("action",url);
    $(document.body).append($eleForm);
    //提交表单，实现下载
    $eleForm.submit();
}


// 成果类型下拉框加载
function findResultTypeSuccess3(result){
	var data = [{id:" ",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.cglx,text:value.cglx});
	});
	
	$('#output_kejiju_chengguo_resultType1').select2({
	    placeholder: "成果类型",
	    tags: true,
	    data:data
	});
	//种子下拉点击事件
	$('#output_kejiju_chengguo_resultType1').on('select2:select', function (evt) {
		search_kejiju_chengguo_resultType3 = evt.params.data.id;
	});
}



//成果时间下拉框加载
function findCompletedDateSuccess3(result){
	var data = [{id:" ",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value,text:value});
	});
	
	//种子下拉
	$('#output_kejiju_chengguo_completedDate1').select2({
	    placeholder: "时间",
	    tags: true,
	    data:data
	});
	
	//种子下拉点击事件
	$('#output_kejiju_chengguo_completedDate1').on('select2:select', function (evt) {
		search_kejiju_chengguo_completedDate3 = evt.params.data.id;
	});
}

