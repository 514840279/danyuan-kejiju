$(function() {
	bandClick();
	// 下拉列表加载
	loadSelect2();
	// 下拉列表初始值
	resetSelect2();
});
function resetSelect2(){
	//
//	$('#kejiju_xiangmu_jbxx_input_industry').select2();
//	$('#kejiju_xiangmu_jbxx_input_discipline').select2();
//	$('#kejiju_xiangmu_jbxx_input_cdc').select2();
//	$('#kejiju_xiangmu_jbxx_input_projectPhase').select2();
}
function loadSelect2(){
	// 项目执行阶段
	ajaxPost("/dic/dicZxjd", null, findProjectPhaseSuccess);
	// 中图分类号
//	ajaxPost("/dic/dicTsfl", null, findCdcSuccess);
	findCdcSuccess(null);
	// 学科分类代码
//	findXiangmuDisciplineSuccess(null);
	ajaxPost("/dic/dicXkfl", null, findXiangmuDisciplineSuccess);
	// 行业分类代码
	ajaxPost("/dic/dicHyfl", null, findXiangmuIndustrySuccess);
	
}
function findXiangmuIndustrySuccess(result){
	var data = [];
	$.each(result,function(index,value){
		data.push({id:value.dm,text:value.mc});
	});
	
	$('#kejiju_xiangmu_jbxx_input_industry').select2({
	    placeholder: "请选择",
	    tags: true,
	    allowClear: true,
	    multiple:"multiple",
	    minimumSelectionLength: 1, 
	    maximumSelectionLength: 3, // 限制数量  
	    data:data
	}).val(JSON.parse(industry)).trigger('change');
}
// 
function findXiangmuDisciplineSuccess(result){
	var data = [];
	$.each(result,function(index,value){
		data.push({id:value.gfdm,text:value.gfmc});
	});
	
	$('#kejiju_xiangmu_jbxx_input_discipline').select2({
	    placeholder: "请选择",
	    tags: true,
	    allowClear: true,
	    multiple:"multiple",
	    minimumSelectionLength: 1, 
	    maximumSelectionLength: 3, // 限制数量  
	    data:data
	}).val(JSON.parse(discipline)).trigger('change');
//	$('#kejiju_xiangmu_jbxx_input_discipline').select2({
//	    placeholder: "请选择",
//	    tags: true,
//	    allowClear: true,
//	    multiple:"multiple",
////	    data:data,
//	    minimumSelectionLength: 1, 
//	    separator: ";", // 分隔符  
//	    maximumSelectionLength: 3, // 限制数量  
//		formatSelection: function(result) {  
//			return result.id;//注意此处的name，要和ajax返回数组的键值一样  
//	    }, // 选择结果中的显示  
//	    ajax: {  
//	        url: "/dic/dicXkfl", // 异步请求地址    
//	        dataType: "json", // 数据类型    
//	        type:"POST",
//	        contentType : 'application/json',
//	        data: function(term, page) { // 请求参数（GET）    
//	        	var KjDicXkfl = {
//	        			gfmc:term.term   
//	        	};
//	            return JSON.stringify(KjDicXkfl);    
//	        },    
//	        processResults: function(data, page) { 
//	        	var datas = [];
//	        	$.each(data,function(index,value){
//	        		datas.push({id:value.gfdm,text:value.gfmc});
//	        	});
//	            return {
//	                 results: datas//,//itemList
//	             };    
//	        }
//	    }  
//    }).val(JSON.parse(discipline)).trigger('change');
}
// 图书分类号
function findCdcSuccess(result){
//	var data = [{id:" ",text:"请选择"}];
//	$.each(result,function(index,value){
//		data.push({id:value.cglx,text:value.cglx});
//	});
	
	$('#kejiju_xiangmu_jbxx_input_cdc').select2({
	    placeholder: "请选择",
	    tags: true,
	    allowClear: true,
	    multiple:"multiple",
//	    data:data,
	    minimumSelectionLength: 1, 
	    separator: ";", // 分隔符  
	    maximumSelectionLength: 3, // 限制数量  
		formatSelection: function(result) {  
			return result.id;//注意此处的name，要和ajax返回数组的键值一样  
	    }, // 选择结果中的显示  
	    ajax: {  
	        url: "/dic/dicTsfl", // 异步请求地址    
	        dataType: "json", // 数据类型    
	        type:"POST",
	        contentType : 'application/json',
	        data: function(term, page) { // 请求参数（GET）    
	        	var kjDicTsfl = {
	        			ztlm:term.term   
	        	};
	            return JSON.stringify(kjDicTsfl);    
	        },    
	        processResults: function(data, page) { 
//	        	console.log(data);
	        	var datas = [];
	        	$.each(data,function(index,value){
	        		datas.push({id:value.ztlh,text:value.ztlm});
	        	});
	            return {
	                 results: datas//,//itemList
//	                 pagination: {
//	                     more:  data.total_count
//	                 }
	             };    
	        }
	    }  
    }).val(JSON.parse(cdc)).trigger('change');
}
// 项目执行阶段  - 成果类型
function findProjectPhaseSuccess(result){
	var data = [{id:" ",text:"请选择"}];
	$.each(result,function(index,value){
		data.push({id:value.zxjd,text:value.zxjd});
	});
	
	$('#kejiju_xiangmu_jbxx_input_projectPhase').select2({
	    placeholder: "请选择",
	    tags: true,
	    allowClear: true,
	    data:data
	}).val(JSON.parse(projectPhase)).trigger('change');
}

// 按键绑定
function bandClick(){
	validataForm();
	$("#kejiju_xiangmu_submit_button").click(function() {
		$('#kejiju_xiangmu_jiben_form_id').data("bootstrapValidator").validate();
		var flag = $('#kejiju_xiangmu_jiben_form_id').data("bootstrapValidator").isValid();
		if (flag) {
			var projectPhase= $('#kejiju_xiangmu_jbxx_input_projectPhase').select2("data")[0].text;
			var cdc= $('#kejiju_xiangmu_jbxx_input_cdc').select2("val");
			var discipline= $('#kejiju_xiangmu_jbxx_input_discipline').select2("val");
			var industry= $('#kejiju_xiangmu_jbxx_input_industry').select2("val");
			var data = {
			    uuid : $("#kejiju_xiangmu_jbxx_input_uuid").val(),
			    approvalYear : $("#kejiju_xiangmu_jbxx_input_approvalYear").val(),
			    cdc : JSON.stringify(cdc),
			    cnKeyword : $("#kejiju_xiangmu_jbxx_input_cnKeyword").val(),
			    competentDepartment : $("#kejiju_xiangmu_jbxx_input_competentDepartment").val(),
			    discipline :  JSON.stringify(discipline),
			    email : $("#kejiju_xiangmu_jbxx_input_email").val(),
			    enKeyword : $("#kejiju_xiangmu_jbxx_input_enKeyword").val(),
			    expectedIndex : $("#kejiju_xiangmu_jbxx_input_expectedIndex").val(),
			    govemmentFund : $("#kejiju_xiangmu_jbxx_input_govemmentFund").val(),
			    industry : JSON.stringify(industry),
			    localFund : $("#kejiju_xiangmu_jbxx_input_localFund").val(),
			    name : $("#kejiju_xiangmu_jbxx_input_name").val(),
			    otherFund : $("#kejiju_xiangmu_jbxx_input_otherFund").val(),
			    otherCode : $("#kejiju_xiangmu_jbxx_input_otherCode").val(),
			    planAbstract : $("#kejiju_xiangmu_jbxx_input_planAbstract").val(),
			    planId : $("#kejiju_xiangmu_jbxx_input_planId").val(),
			    planName : $("#kejiju_xiangmu_jbxx_input_planName").val(),
			    planUrl : $("#kejiju_xiangmu_jbxx_input_planUrl").val(),
			    porjectLinks : $("#kejiju_xiangmu_jbxx_input_porjectLinks").val(),
			    projectAbstract : $("#kejiju_xiangmu_jbxx_input_projectAbstract").val(),
			    projectActualEndtime : $("#kejiju_xiangmu_jbxx_input_projectActualEndtime").val(),
			    projectActualStartTime : $("#kejiju_xiangmu_jbxx_input_projectActualStartTime").val(),
			    projectDomain : $("#kejiju_xiangmu_jbxx_input_projectDomain").val(),
			    projectDomainId : $("#kejiju_xiangmu_jbxx_input_projectDomainId").val(),
			    projectId : $("#kejiju_xiangmu_jbxx_input_projectId").val(),
			    projectName : $("#kejiju_xiangmu_jbxx_input_projectName").val(),
			    projectPhase :JSON.stringify(projectPhase) ,
			    projectPlanEndtime : $("#kejiju_xiangmu_jbxx_input_projectPlanEndtime").val(),
			    projectPlanStartTime : $("#kejiju_xiangmu_jbxx_input_projectPlanStartTime").val(),
			    projectType : $("#kejiju_xiangmu_jbxx_input_projectType").val(),
			    provincialFund : $("#kejiju_xiangmu_jbxx_input_provincialFund").val(),
			    region : $("#kejiju_xiangmu_jbxx_input_region").val(),
			    researchContent : $("#kejiju_xiangmu_jbxx_input_researchContent").val(),
			    researchTarget : $("#kejiju_xiangmu_jbxx_input_researchTarget").val(),
			    selfFund : $("#kejiju_xiangmu_jbxx_input_selfFund").val(),
			    telephone : $("#kejiju_xiangmu_jbxx_input_telephone").val(),
			    totalFund : $("#kejiju_xiangmu_jbxx_input_totalFund").val(),
			    createUser : username,
			};
			console.log(data);
			ajaxPost("/kjxmJbxxInfo/save", data, updkejijuxiangmujibenSuccess, 5000, findError);
		}
	});
}
// 更新数据后关闭当前tab

function validataForm(){

	/**
	 * 下面是进行插件初始化 你只需传入相应的键值对
	 */
	$('#kejiju_xiangmu_jiben_form_id').bootstrapValidator({
	    message : '验证失败消息',
	    feedbackIcons : {/* 输入框不同状态，显示图片的样式 */
	        valid : 'glyphicon glyphicon-ok',
	        invalid : 'glyphicon glyphicon-remove',
	        validating : 'glyphicon glyphicon-refresh'
	    },
	    fields : {/* 验证 */
	    	region : {/* 键名username和input name值对应 */
		        message : '省市地区无效',
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '省市地区不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 20,
		                message : '省市地区长度必须在20之内'
		            }
		        }
		    },planId : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '科技计划编码不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 50,
		                message : '科技计划编码长度必须在50之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },planName : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '科技计划名称不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 100,
		                message : '科技计划名称长度必须在100之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },projectId : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '项目编码不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 100,
		                message : '项目编码长度必须在100之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },projectName : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '项目名称不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 100,
		                message : '项目名称长度必须在100之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },approvalYear : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '立项年度不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 4,
		                message : '立项年度长度必须在4之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },projectPlanStartTime : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '项目计划起始时间不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 10,
		                message : '项目计划起始时间长度必须在10之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },projectPlanEndtime : {/* 键名username和input name值对应 */
		        validators : {
		            notEmpty : {/* 非空提示 */
			            message : '项目计划结束时间不能为空'
		            },
		            stringLength : {/* 长度提示 */
		                max : 10,
		                message : '项目计划结束时间长度必须在10之内'
		            }
		        /* 最后一个没有逗号 */
		        }
		    },totalFund : {/* 键名username和input name值对应 */
		        validators : {
		            stringLength : {/* 长度提示 */
		                max : 30,
		                message : '项目总经费长度必须在30之内'
		            },
		        	regexp: {
                        regexp: /^[\d]*$/,
                        message: '项目总经费 必须数字，长度必须在30以内'
                    }
		        /* 最后一个没有逗号 */
		        }
		    },govemmentFund : {/* 键名username和input name值对应 */
		        validators : {
		            stringLength : {/* 长度提示 */
		                max : 30,
		                message : '中央拨付经费长度必须在30之内'
		            },
		        	regexp: {
                        regexp: /^[\d]*$/,
                        message: ' 中央拨付经费 必须数字，长度必须在30以内'
                    }
		        /* 最后一个没有逗号 */
		        }
		    },provincialFund : {/* 键名username和input name值对应 */
		        validators : {
		            stringLength : {/* 长度提示 */
		                max : 30,
		                message : '省级拨付经费长度必须在30之内'
		            },
		        	regexp: {
                        regexp: /^[\d]*$/,
                        message: ' 省级拨付经费 必须数字，长度必须在30以内'
                    }
		        /* 最后一个没有逗号 */
		        }
		    },localFund : {/* 键名username和input name值对应 */
		        validators : {
		            stringLength : {/* 长度提示 */
		                max : 30,
		                message : '地方配套经费长度必须在30之内'
		            },
		        	regexp: {
                        regexp: /^[\d]*$/,
                        message: ' 地方配套经费 必须数字，长度必须在30以内'
                    }
		        /* 最后一个没有逗号 */
		        }
		    },selfFund : {/* 键名username和input name值对应 */
		        validators : {
		            stringLength : {/* 长度提示 */
		                max : 30,
		                message : '单位自筹经费长度必须在30之内'
		            },
		        	regexp: {
                        regexp: /^[\d]*$/,
                        message: ' 单位自筹经费 必须数字，长度必须在30以内'
                    }
		        /* 最后一个没有逗号 */
		        }
		    },otherFund : {/* 键名username和input name值对应 */
		        validators : {
		            stringLength : {/* 长度提示 */
		                max : 30,
		                message : '其他来源经费长度必须在30之内'
		            },
		        	regexp: {
                        regexp: /^[\d]*$/,
                        message: ' 其他来源经费 必须数字，长度必须在30以内'
                    }
		        /* 最后一个没有逗号 */
		        }
		    }
	    
	    }
	});
}

function updkejijuxiangmujibenSuccess(result) {
	$("#kejiju_xiangmu_table_datagrid").bootstrapTable('refresh');
	removeByValue(_history, 'xiangmu_add');
	// 固定 表的tab 的id
	$("#tabContainer").data("tabs").showTab('254DD0B66C981B0100796E1C72C5D677');
	$("#tabContainer").data("tabs").remove('xiangmu_add');
	
}