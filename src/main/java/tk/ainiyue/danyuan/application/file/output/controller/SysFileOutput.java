package tk.ainiyue.danyuan.application.file.output.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService;
import tk.ainiyue.danyuan.application.kejiju.chengguo.vo.KjcgJbxxInfoVo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService;
import tk.ainiyue.danyuan.application.kejiju.renyuan.vo.KjryJbxxInfoVo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.vo.KjxmJbxxInfoVo;

/**    
*  文件名 ： SysFileOutput.java  
*  包    名 ： tk.ainiyue.danyuan.application.file.output.controller  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月13日 下午7:49:08  
*  版    本 ： V1.0    
*/
@RestController
@RequestMapping("/sysFileOutput")
@Api(value = "/SysFileOutput", description = "文件下载")
public class SysFileOutput {
	
	//
	private static final Logger	logger	= LoggerFactory.getLogger(SysFileOutput.class);
	
	//
	@Autowired
	private KjcgJbxxService		kjcgJbxxService;
	
	//
	@Autowired
	private KjryJbxxService		KjryJbxxService;
	
	//
	@Autowired
	private KjxmJbxxService		kjxmJbxxService;
	
	@RequestMapping(value = "/testDownload", method = RequestMethod.POST)
	public void testDownload(HttpServletResponse resp, String path) throws IOException {
		// 根据参数进行导出xml 并打包返回zip文件路径
		//		System.err.println(path);
		File file = new File(path);
		resp.setHeader("content-type", "application/octet-stream");
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = resp.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@ApiOperation(value = "导出科技成果包", notes = "")
	@RequestMapping(path = "/forDownloadChengguo", method = RequestMethod.POST)
	public Map<String, String> forDownloadChengguo(@RequestBody KjcgJbxxInfoVo vo) {
		logger.info("forDownloadChengguo", SysFileOutput.class);
		SimpleDateFormat datef = new SimpleDateFormat("YYYYDDMMHH24mmss");
		String date = datef.format(new Date());
		String path = "./outputfile/chengguo/" + date;
		String fileName = null;
		String message = null;
		try {
			fileName = kjcgJbxxService.outputFile(vo, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.toString();
		}
		Map<String, String> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("message", message);
		return map;
	}
	
	@ApiOperation(value = "导出科技人员信息", notes = "")
	@RequestMapping(path = "/forDownloadRenyuan", method = RequestMethod.POST)
	public Map<String, String> forDownloadRenyuan(@RequestBody KjryJbxxInfoVo vo) {
		logger.info("forDownloadRenyuan", SysFileOutput.class);
		SimpleDateFormat datef = new SimpleDateFormat("YYYYDDMMHH24mmss");
		String date = datef.format(new Date());
		String path = "./outputfile/renyuan/" + date;
		String fileName = null;
		String message = null;
		try {
			fileName = KjryJbxxService.outputFile(vo, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("message", message);
		return map;
	}
	
	@ApiOperation(value = "导出项目信息", notes = "")
	@RequestMapping(path = "/forDownloadXiangmu", method = RequestMethod.POST)
	public Map<String, String> forDownloadXiangmu(@RequestBody KjxmJbxxInfoVo vo) {
		logger.info("forDownloadXiangmu", SysFileOutput.class);
		SimpleDateFormat datef = new SimpleDateFormat("YYYYDDMMHH24mmss");
		String date = datef.format(new Date());
		String path = "./outputfile/xiangmu/" + date;
		String fileName = null;
		String message = null;
		try {
			fileName = kjxmJbxxService.outputFile(vo, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("message", message);
		return map;
	}
	
}
