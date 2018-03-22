package tk.ainiyue.danyuan.application.dic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.ainiyue.danyuan.application.dic.po.KjDicCglx;
import tk.ainiyue.danyuan.application.dic.po.KjDicDqdm;
import tk.ainiyue.danyuan.application.dic.po.KjDicDwxz;
import tk.ainiyue.danyuan.application.dic.po.KjDicGzxz;
import tk.ainiyue.danyuan.application.dic.po.KjDicHyfl;
import tk.ainiyue.danyuan.application.dic.po.KjDicMzdm;
import tk.ainiyue.danyuan.application.dic.po.KjDicPxjx;
import tk.ainiyue.danyuan.application.dic.po.KjDicRyjs;
import tk.ainiyue.danyuan.application.dic.po.KjDicTsfl;
import tk.ainiyue.danyuan.application.dic.po.KjDicXkfl;
import tk.ainiyue.danyuan.application.dic.po.KjDicXlmc;
import tk.ainiyue.danyuan.application.dic.po.KjDicXwmc;
import tk.ainiyue.danyuan.application.dic.po.KjDicZjlx;
import tk.ainiyue.danyuan.application.dic.po.KjDicZwjb;
import tk.ainiyue.danyuan.application.dic.po.KjDicZxjd;
import tk.ainiyue.danyuan.application.dic.po.KjDicZydm;
import tk.ainiyue.danyuan.application.dic.po.KjDicZzmm;
import tk.ainiyue.danyuan.application.dic.service.DicService;
import tk.ainiyue.danyuan.application.kejiju.chengguo.controller.KjcgJbxxController;

/**    
*  文件名 ： DicController.java  
*  包    名 ： tk.ainiyue.danyuan.application.dic.controller  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月22日 下午8:42:53  
*  版    本 ： V1.0    
*/
@RestController
@RequestMapping("/dic")
@Api(value = "/DIC", description = "字典列表")
public class DicController {
	private static final Logger	logger	= LoggerFactory.getLogger(KjcgJbxxController.class);
	@Autowired
	DicService					dicService;
	
	// 成果类型  cglx
	@ApiOperation(value = "成果类型", notes = "")
	@RequestMapping(path = "/dicCglx", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicCglx> dicCglx() {
		logger.info("dicCglx", DicController.class);
		return dicService.dicCglx();
	}
	
	// 单位性质  dwxz
	@ApiOperation(value = " 单位性质", notes = "")
	@RequestMapping(path = "/dicDwxz", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicDwxz> dicDwxz() {
		logger.info("dicDwxz", DicController.class);
		return dicService.dicDwxz();
	}
	
	// 高等学校本科专科专业名称代码  zydm
	@ApiOperation(value = "高等学校本科专科专业名称代码", notes = "")
	@RequestMapping(path = "/dicZydm", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicZydm> dicZydm() {
		logger.info("dicZydm", DicController.class);
		return dicService.dicZydm();
	}
	
	// 工作性质 gzxz
	@ApiOperation(value = "工作性质", notes = "")
	@RequestMapping(path = "/dicGzxz", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicGzxz> dicGzxz() {
		logger.info("dicGzxz", DicController.class);
		return dicService.dicGzxz();
	}
	
	// 行业分类 hyfl
	@ApiOperation(value = "行业分类", notes = "")
	@RequestMapping(path = "/dicHyfl", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicHyfl> dicHyfl() {
		logger.info("dicHyfl", DicController.class);
		return dicService.dicHyfl();
	}
	// 培训进修 pxjx
	
	@ApiOperation(value = " 培训进修", notes = "")
	@RequestMapping(path = "/dicPxjx", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicPxjx> dicPxjx() {
		logger.info("dicPxjx", DicController.class);
		return dicService.dicPxjx();
	}
	
	// 人员角色  ryjs
	@ApiOperation(value = "人员角色", notes = "")
	@RequestMapping(path = "/dicRyjs", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicRyjs> dicRyjs() {
		logger.info("dicRyjs", DicController.class);
		return dicService.dicRyjs();
	}
	
	// 世界各国地区名称代码  dqdm
	@ApiOperation(value = "世界各国地区名称代码", notes = "")
	@RequestMapping(path = "/dicDqdm", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicDqdm> dicDqdm() {
		logger.info("dicDqdm", DicController.class);
		return dicService.dicDqdm();
	}
	
	// 项目执行阶段  zxjd
	@ApiOperation(value = "项目执行阶段", notes = "")
	@RequestMapping(path = "/dicZxjd", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicZxjd> dicZxjd() {
		logger.info("dicZxjd", DicController.class);
		return dicService.dicZxjd();
	}
	
	// 学科分类代码  Xkfl
	@ApiOperation(value = "学科分类代码", notes = "")
	@RequestMapping(path = "/dicXkfl", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicXkfl> dicXkfl() {
		logger.info("dicXkfl", DicController.class);
		return dicService.dicXkfl();
	}
	
	// 学历 Xlmc
	@ApiOperation(value = "学历", notes = "")
	@RequestMapping(path = "/dicXlmc", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicXlmc> dicXlmc() {
		logger.info("dicXlmc", DicController.class);
		return dicService.dicXlmc();
	}
	
	// 学位 Xwmc
	@ApiOperation(value = "学位", notes = "")
	@RequestMapping(path = "/dicXwmc", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicXwmc> dicXwmc() {
		logger.info("dicXwmc", DicController.class);
		return dicService.dicXwmc();
	}
	
	// 证件类型 Zjlx
	@ApiOperation(value = "证件类型", notes = "")
	@RequestMapping(path = "/dicZjlx", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicZjlx> dicZjlx() {
		logger.info("dicZjlx", DicController.class);
		return dicService.dicZjlx();
	}
	
	// 政治面貌代码 Zzmm
	@ApiOperation(value = "政治面貌代码", notes = "")
	@RequestMapping(path = "/dicZzmm", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicZzmm> dicZzmm() {
		logger.info("dicZzmm", DicController.class);
		return dicService.dicZzmm();
	}
	
	// 职务级别 Zwjb
	@ApiOperation(value = "职务级别", notes = "")
	@RequestMapping(path = "/dicZwjb", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicZwjb> dicZwjb() {
		logger.info("dicZzmm", DicController.class);
		return dicService.dicZwjb();
	}
	
	// 中国各民族名称 Mzdm
	@ApiOperation(value = "中国各民族名称", notes = "")
	@RequestMapping(path = "/dicMzdm", method = RequestMethod.POST)
	@ResponseBody
	public List<KjDicMzdm> dicMzdm() {
		logger.info("dicMzdm", DicController.class);
		return dicService.dicMzdm();
	}
	
	// 图书分类 Tsfl
	@ApiOperation(value = "图书分类 ", notes = "")
	@RequestMapping(path = "/dicTsfl", method = { RequestMethod.POST })
	@ResponseBody
	public List<KjDicTsfl> dicTsfl(@RequestBody KjDicTsfl kjDicTsfl) {
		logger.info("dicTsfl", DicController.class);
		logger.info(kjDicTsfl.toString());
		return dicService.dicTsfl(kjDicTsfl);
	}
	
}
