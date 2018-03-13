search_kejiju_renyuan_researchDirection3 ="";
search_kejiju_renyuan_porfessionalTitle3 ="";
search_kejiju_renyuan_degree3 ="";

$(function() {
	ajaxPost("/kjryJbxxInfo/dicJsly", null, findJslySuccess3, 5000, findError);
	
	ajaxPost("/kjryJbxxInfo/dicZc", null, findZcSuccess3, 5000, findError);
	
	ajaxPost("/kjryJbxxInfo/dicXw", null, findXwSuccess3, 5000, findError);
	
	// 下载按钮事件
	$("#output_kejiju_renyuan_button").bind('click',function(){
		var url = "/sysFileOutput/forDownloadRenyuan"
		var param={
				name:$("#output_kejiju_renyuan_name1").val(),
				researchDirection:search_kejiju_renyuan_researchDirection3,
				porfessionalTitle:search_kejiju_renyuan_porfessionalTitle3,
				degree:search_kejiju_renyuan_degree3,
		}
		ajaxPost(url, param,forDownload);
		
	})
	
	
});

function forDownload(result){
	var url ="/sysFileOutput/testDownload";
	var $eleForm = $("<form method='post'><input type='input' name='path' value='"+result.fileName+"'/></form>");
    $eleForm.attr("action",url);
    $(document.body).append($eleForm);
    //提交表单，实现下载
    $eleForm.submit();
}



// 技术类型下拉框加载
function findJslySuccess3(result){
	var data = [{id:" ",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value,text:value});
	});
	
	$('#output_kejiju_renyuan_researchDirection1').select2({
	    placeholder: "研究方向",
	    tags: true,
	    data:data
	});
	//种子下拉点击事件
	$('#output_kejiju_renyuan_researchDirection1').on('select2:select', function (evt) {
		output_kejiju_renyuan_researchDirection3 = evt.params.data.id;
		
	});
}



// 职称下拉框加载
function findZcSuccess3(result){
	var data = [{id:" ",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value,text:value});
	});
	
	//种子下拉
	$('#output_kejiju_renyuan_porfessionalTitle1').select2({
	    placeholder: "职务",
	    tags: true,
	    data:data
	});
	
	//种子下拉点击事件
	$('#output_kejiju_renyuan_porfessionalTitle1').on('select2:select', function (evt) {
		search_kejiju_renyuan_porfessionalTitle3 = evt.params.data.id;
		
	});
}

// 学位下拉框加载
function findXwSuccess3(result){
	var data = [{id:" ",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value,text:value});
	});
	
	//种子下拉
	$('#output_kejiju_renyuan_degree1').select2({
	    placeholder: "学位",
	    tags: true,
	    data:data
	});
	
	//种子下拉点击事件
	$('#output_kejiju_renyuan_degree1').on('select2:select', function (evt) {
		search_kejiju_renyuan_degree3 = evt.params.data.id;
		
	});
}
