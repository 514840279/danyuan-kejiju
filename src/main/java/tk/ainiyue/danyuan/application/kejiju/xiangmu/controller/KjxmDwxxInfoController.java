package tk.ainiyue.danyuan.application.kejiju.xiangmu.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmDwxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmDwxxService;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.vo.KjxmDwxxInfoVo;

/**    
*  文件名 ： KjxmDwxxInfoController.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.xiangmu.controller  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午10:29:21  
*  版    本 ： V1.0    
*/
@RestController
@RequestMapping("/kjxmDwxxInfo")
@Api(value = "/KjxmDwxxInfo", description = "科研项目单位信息")
public class KjxmDwxxInfoController {
	//
	private static final Logger	logger	= LoggerFactory.getLogger(KjxmDwxxInfoController.class);
	
	//
	@Autowired
	private KjxmDwxxService		kjxmDwxxService;
	
	//
	@Autowired
	private KjxmJbxxService		kjxmJbxxService;
	
	@ApiOperation(value = "更新", notes = "")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody KjxmDwxxInfo info) {
		logger.info("save", KjxmDwxxInfoController.class);
		System.out.println(info.toString());
		KjxmJbxxInfo jbxx = new KjxmJbxxInfo();
		jbxx.setUuid(info.getXmjbUuid());
		jbxx = kjxmJbxxService.findOne(jbxx);
		info.setKjxmJbxxInfo(jbxx);
		kjxmDwxxService.save(info);
		return "1";
	}
	
	@ApiOperation(value = "删除", notes = "")
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestBody KjxmDwxxInfoVo vo) {
		logger.info("delete", KjxmDwxxInfoController.class);
		try {
			kjxmDwxxService.delete(vo.getList());
			return "1";
		} catch (Exception e) {
			return "0";
		}
	}
	
	@ApiOperation(value = "查询全部信息", notes = "")
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public List<KjxmDwxxInfo> list(KjxmJbxxInfo info) {
		logger.info("list", KjxmDwxxInfoController.class);
		return kjxmDwxxService.list(info);
	}
	
	@ApiOperation(value = "upd", notes = "")
	@RequestMapping(path = "/upd", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView upd(KjxmDwxxInfoVo vo) {
		System.out.println(vo.toString());
		logger.info("upd", KjxmDwxxInfoController.class);
		KjxmDwxxInfo info = new KjxmDwxxInfo();
		KjxmJbxxInfo jb = new KjxmJbxxInfo();
		jb.setUuid(vo.getXmjbUuid());
		info.setKjxmJbxxInfo(jb);
		if (StringUtils.isNullOrEmpty(vo.getUuid())) {
			info.setUuid(UUID.randomUUID().toString());
		} else {
			info.setUuid(vo.getUuid());
			info = kjxmDwxxService.findOne(info);
		}
		ModelAndView view = new ModelAndView("kejiju/xiangmu/danwei_upd");
		view.addObject("kjxmDwxxInfo", info);
		return view;
	}
	
	@ApiOperation(value = "showDetail", notes = "")
	@RequestMapping(path = "/showDetail", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView showDetail(KjxmDwxxInfo info) {
		logger.info("showDetail", KjxmDwxxInfoController.class);
		if (StringUtils.isNullOrEmpty(info.getUuid())) {
			info.setUuid(UUID.randomUUID().toString());
		} else {
			info = kjxmDwxxService.findOne(info);
		}
		ModelAndView view = new ModelAndView("kejiju/xiangmu/danwei_dateil");
		view.addObject("kjxmDwxxInfo", info);
		return view;
	}
	
}
