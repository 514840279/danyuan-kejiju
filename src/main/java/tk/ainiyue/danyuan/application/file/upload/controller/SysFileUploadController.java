package tk.ainiyue.danyuan.application.file.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.ainiyue.danyuan.application.file.upload.po.SysFileUploadInfo;
import tk.ainiyue.danyuan.application.file.upload.service.SysFileUploadService;
import tk.ainiyue.danyuan.application.file.upload.vo.SysFileUploadVo;

@RestController
@RequestMapping("/sysFileUploadInfo")
@Api(value = "/SysFileUploadInfo", description = "文件上传")
public class SysFileUploadController {
	//
	private static final Logger		logger	= LoggerFactory.getLogger(SysFileUploadController.class);
	
	//
	@Autowired
	private SysFileUploadService	sysFileUploadService;
	
	@RequestMapping("/upload/{path}")
	public Map<String, Object> upload(@PathVariable("path") String path, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		logger.info("upload", SysFileUploadController.class);
		request.setCharacterEncoding("UTF-8");
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		
		/** 页面控件的文件流* */
		MultipartFile multipartFile = null;
		Map<String, MultipartFile> map = multipartRequest.getFileMap();
		for (Object obj : map.keySet()) {
			multipartFile = map.get(obj);
		}
		/** 获取文件的后缀* */
		String filename = multipartFile.getOriginalFilename();
		System.out.println(filename);
		InputStream inputStream;
		
		try {
			inputStream = multipartFile.getInputStream();
			path = "./uploadfile/" + path;
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			path = path + "/" + filename;
			FileOutputStream fos = new FileOutputStream(path);
			
			byte[] b = new byte[1024];
			while ((inputStream.read(b)) != -1) {
				fos.write(b);
			}
			inputStream.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> result = new HashMap<>();
		result.put("path", path);
		return result;
	}
	
	@ApiOperation(value = "保存文件信息", notes = "")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@RequestBody SysFileUploadInfo info) {
		logger.info("save", SysFileUploadController.class);
		info.setUuid(UUID.randomUUID().toString());
		sysFileUploadService.save(info);
		return "1";
	}
	
	@ApiOperation(value = "分页查询全部文件", notes = "")
	@RequestMapping(path = "/findAllBySearchText", method = RequestMethod.POST)
	public Page<SysFileUploadInfo> findAllBySearchText(@RequestBody SysFileUploadVo vo) {
		logger.info("findAllBySearchText", SysFileUploadInfo.class);
		return sysFileUploadService.findAllBySearchText(vo.getPageNumber(), vo.getPageSize(), vo.getDiscription());
	}
	
	@ApiOperation(value = "删除文件信息", notes = "")
	@RequestMapping(path = "/deleteAll", method = RequestMethod.POST)
	@ResponseBody
	public String deleteAll(@RequestBody SysFileUploadVo vo) {
		logger.info("deleteAll", SysFileUploadInfo.class);
		try {
			sysFileUploadService.delete(vo.getList());
			return "1";
		} catch (Exception e) {
			return "0";
		}
	}
	
	@ApiOperation(value = "更新前", notes = "")
	@RequestMapping(path = "/kejiju/{path}", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView upd(@PathVariable("path") String path) {
		logger.info("upd", SysFileUploadInfo.class);
		ModelAndView view = new ModelAndView("kejiju/index");
		view.addObject("path", path);
		return view;
	}
}
