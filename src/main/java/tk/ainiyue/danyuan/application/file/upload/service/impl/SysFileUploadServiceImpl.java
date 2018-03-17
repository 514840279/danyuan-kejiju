package tk.ainiyue.danyuan.application.file.upload.service.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.thoughtworks.xstream.XStream;

import tk.ainiyue.danyuan.application.file.upload.dao.SysFileUploadDao;
import tk.ainiyue.danyuan.application.file.upload.po.SysFileUploadInfo;
import tk.ainiyue.danyuan.application.file.upload.service.SysFileUploadService;
import tk.ainiyue.danyuan.application.kejiju.chengguo.dao.KjcgJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.dao.KjryJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryGzllInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJyxxInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryXsjzInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryXspsInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.dao.KjxmJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmDwxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmRyxxInfo;

@Service("sysFileUploadService")
public class SysFileUploadServiceImpl implements SysFileUploadService {
	//
	private static final Logger	logger	= LoggerFactory.getLogger(SysFileUploadServiceImpl.class);
	@Autowired
	private SysFileUploadDao	sysFileUploadDao;
	@Autowired
	private KjcgJbxxDao			kjcgJbxxDao;
	
	@Autowired
	private KjryJbxxDao			kjryJbxxDao;
	@Autowired
	private KjxmJbxxDao			kjxmJbxxDao;
	
	@Override
	public void save(SysFileUploadInfo info) {
		sysFileUploadDao.save(info);
	}
	
	@Override
	public Page<SysFileUploadInfo> findAllBySearchText(int pageNumber, int pageSize, String discription) {
		logger.info("findAllBySearchText", SysFileUploadServiceImpl.class);
		SysFileUploadInfo info = new SysFileUploadInfo();
		info.setDiscription(discription);
		Example<SysFileUploadInfo> example = Example.of(info);
		Sort sort = new Sort(new Order(Direction.ASC, "createTime"));
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, sort);
		Page<SysFileUploadInfo> sourceCodes = sysFileUploadDao.findAll(example, request);
		return sourceCodes;
	}
	
	@Override
	public void delete(List<SysFileUploadInfo> list) {
		if (list.isEmpty()) {
			return;
		} else {
			Iterator<SysFileUploadInfo> aa = list.iterator();
			while (aa.hasNext()) {
				SysFileUploadInfo info = aa.next();
				String path = info.getPath();
				File file = new File(path);
				if (!file.exists()) {
					System.out.println("删除文件失败:" + path + "不存在！");
				} else {
					if (file.exists() && file.isFile())
						if (file.delete()) {
							System.out.println("删除单个文件" + path + "成功！");
						} else
							System.out.println("删除文件失败:" + path + "不存在！");
				}
				sysFileUploadDao.delete(info);
			}
		}
		
	}
	
	/** 
	*  方法名 ： importSysFileUploadInfo
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.file.upload.service.SysFileUploadService#importSysFileUploadInfo(tk.ainiyue.danyuan.application.file.upload.po.SysFileUploadInfo)  
	*  作    者 ： wang  
	*/
	
	@Override
	public String importSysFileUploadInfo(SysFileUploadInfo info) {
		String message = null;
		String xml = null;
		try {
			xml = FileInputStreamDemo(info.getPath());
			if (xml == null) {
				return "读取文件内容为空，请确认";
			}
		} catch (IOException e) {
			return e.toString();
		}
		
		if (info.getPath().contains("/chengguo/")) {
			message = analyzeChengguo(xml, info.getCreateUser());
		} else if (info.getPath().contains("/renyuan/")) {
			message = analyzeRenyuan(xml, info.getCreateUser());
		} else if (info.getPath().contains("/xiangmu/")) {
			message = analyzeXiangmu(xml, info.getCreateUser());
		}
		return message;
	}
	
	/**  
	*  方法名： analyzeXiangmu  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param xml
	*  参    数： @param createUser
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： wang  
	*  @throws  
	*/
	private String analyzeXiangmu(String xml, String username) {
		String message = null;
		System.err.println(xml);
		XStream xStream = new XStream();
		xStream.alias("KjxmJbxxInfo", KjxmJbxxInfo.class);
		xStream.alias("KjxmDwxxInfo", KjxmDwxxInfo.class);
		xStream.alias("KjxmRyxxInfo", KjxmRyxxInfo.class);
		
		try {
			Object obj = xStream.fromXML(xml);
			Map<String, Object> map = objectToMap(obj);
			KjxmJbxxInfo info2 = new KjxmJbxxInfo();
			transMap2Bean(map, info2);
			// 验证
			if (StringUtils.isNullOrEmpty(info2.getRegion())) {
				return "科技项目基本信息 省市地区 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getPlanId())) {
				return "科技项目基本信息 科技计划编码 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getPlanName())) {
				return "科技项目基本信息 科技计划名称 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getProjectId())) {
				return "科技项目基本信息 项目编码 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getProjectName())) {
				return "科技项目基本信息 项目名称 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getApprovalYear())) {
				return "科技项目基本信息 立项年度 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getProjectPlanStartTime())) {
				return "科技项目基本信息 项目计划起始时间 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getProjectPlanEndtime())) {
				return "科技项目基本信息 项目计划结束时间 必填";
			}
			System.err.println(info2.toString());
			info2.setCreateUser(username);
			
			List<KjxmDwxxInfo> listgz = new ArrayList<>();
			for (Object kjxmDwxxInfo : info2.getKjxmDwxxInfos()) {
				Map<String, Object> mapgz = objectToMap(kjxmDwxxInfo);
				KjxmDwxxInfo infogz = new KjxmDwxxInfo();
				transMap2Bean(mapgz, infogz);
				if (StringUtils.isNullOrEmpty(infogz.getMainOrganization())) {
					return "科技项目单位信息 主承担单位 必填";
				}
				infogz.setKjxmJbxxInfo(info2);
				infogz.setCreateUser(username);
				listgz.add(infogz);
			}
			info2.setKjxmDwxxInfos(listgz);
			
			List<KjxmRyxxInfo> listxsj = new ArrayList<>();
			for (Object KjryJyxxInfo : info2.getKjxmRyxxInfos()) {
				Map<String, Object> mapgz = objectToMap(KjryJyxxInfo);
				KjxmRyxxInfo infogz = new KjxmRyxxInfo();
				transMap2Bean(mapgz, infogz);
				if (StringUtils.isNullOrEmpty(infogz.getHeadName())) {
					return "科技项目人员信息 负责人姓名 必填";
				} else if (StringUtils.isNullOrEmpty(infogz.getHeadIdType())) {
					return "科技项目人员信息 负责人证件类型 必填";
				} else if (StringUtils.isNullOrEmpty(infogz.getHeadIdNumber())) {
					return "科技项目人员信息 负责人证件号码 必填";
				}
				infogz.setKjxmJbxxInfo(info2);
				infogz.setCreateUser(username);
				listxsj.add(infogz);
			}
			info2.setKjxmRyxxInfos(listxsj);
			
			kjxmJbxxDao.save(info2);
			message = "成功";
		} catch (IllegalAccessException e) {
			message = e.toString();
		}
		return message;
	}
	
	/**  
	*  方法名： analyzeRenyuan  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param xml
	*  参    数： @param createUser
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： wang  
	*  @throws  
	*/
	private String analyzeRenyuan(String xml, String username) {
		String message = null;
		System.err.println(xml);
		XStream xstream = new XStream();
		xstream.alias("kjryJbxxInfo", KjryJbxxInfo.class);
		xstream.alias("KjryGzllInfo", KjryGzllInfo.class);
		xstream.alias("KjryJyxxInfo", KjryJyxxInfo.class);
		xstream.alias("KjryXsjzInfo", KjryXsjzInfo.class);
		xstream.alias("KjryXspsInfo", KjryXspsInfo.class);
		
		try {
			Object obj = xstream.fromXML(xml);
			Map<String, Object> map = objectToMap(obj);
			KjryJbxxInfo info2 = new KjryJbxxInfo();
			transMap2Bean(map, info2);
			
			if (StringUtils.isNullOrEmpty(info2.getPersonId())) {
				return "科技人员基本信息 本地唯一标 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getName())) {
				return "科技人员基本信息 姓名 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getGender())) {
				return "科技人员基本信息 性别 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getBirthdate())) {
				return "科技人员基本信息 出生日期 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getOrganization())) {
				return "科技人员基本信息 单位名称 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getMobileTelephone())) {
				return "科技人员基本信息 移动电话 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getOfficeTelephone())) {
				return "科技人员基本信息 办公电话 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getIdType())) {
				return "科技人员基本信息 证件类型 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getIdNumber())) {
				return "科技人员基本信息 证件号码 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getResearchDirection())) {
				return "科技人员基本信息 研究方向 必填";
			} else if (StringUtils.isNullOrEmpty(info2.getResearchDirection())) {
				return "科技人员基本信息 研究方向 必填";
			}
			
			info2.setCreateUser(username);
			//			System.err.println(info2.toString());
			List<KjryJyxxInfo> listjy = new ArrayList<>();
			for (Object KjryJyxxInfo : info2.getKjryJyxxInfos()) {
				Map<String, Object> mapjr = objectToMap(KjryJyxxInfo);
				KjryJyxxInfo infojy = new KjryJyxxInfo();
				transMap2Bean(mapjr, infojy);
				infojy.setKjryJbxxInfo(info2);
				infojy.setCreateUser(username);
				listjy.add(infojy);
				System.err.println(KjryJyxxInfo.toString());
			}
			info2.setKjryJyxxInfos(listjy);
			
			List<KjryGzllInfo> listgz = new ArrayList<>();
			for (Object KjryJyxxInfo : info2.getKjryGzllInfos()) {
				Map<String, Object> mapgz = objectToMap(KjryJyxxInfo);
				KjryGzllInfo infogz = new KjryGzllInfo();
				transMap2Bean(mapgz, infogz);
				infogz.setKjryJbxxInfo(info2);
				infogz.setCreateUser(username);
				listgz.add(infogz);
				System.err.println(KjryJyxxInfo.toString());
			}
			info2.setKjryGzllInfos(listgz);
			
			List<KjryXsjzInfo> listxsj = new ArrayList<>();
			for (Object KjryJyxxInfo : info2.getKjryXsjzInfos()) {
				Map<String, Object> mapgz = objectToMap(KjryJyxxInfo);
				KjryXsjzInfo infogz = new KjryXsjzInfo();
				transMap2Bean(mapgz, infogz);
				infogz.setKjryJbxxInfo(info2);
				infogz.setCreateUser(username);
				listxsj.add(infogz);
				System.err.println(KjryJyxxInfo.toString());
			}
			info2.setKjryXsjzInfos(listxsj);
			
			List<KjryXspsInfo> listxsp = new ArrayList<>();
			for (Object KjryJyxxInfo : info2.getKjryXspsInfos()) {
				Map<String, Object> mapxs = objectToMap(KjryJyxxInfo);
				KjryXspsInfo infoxs = new KjryXspsInfo();
				transMap2Bean(mapxs, infoxs);
				infoxs.setKjryJbxxInfo(info2);
				infoxs.setCreateUser(username);
				listxsp.add(infoxs);
				System.err.println(KjryJyxxInfo.toString());
			}
			info2.setKjryXspsInfos(listxsp);
			kjryJbxxDao.save(info2);
			message = "成功";
		} catch (IllegalAccessException e) {
			message = e.toString();
		}
		return message;
	}
	
	public String FileInputStreamDemo(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		FileInputStream fis = new FileInputStream(file);
		byte[] buf = new byte[1024];
		StringBuffer sb = new StringBuffer();
		while ((fis.read(buf)) != -1) {
			sb.append(new String(buf));
			buf = new byte[1024];//重新生成，避免和上次读取的数据重复
		}
		return sb.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").trim();
	}
	
	public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		Class<?> clazz = obj.getClass();
		System.out.println(clazz);
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = field.get(obj);
			map.put(fieldName, value);
		}
		return map;
	}
	
	// Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
	public static void transMap2Bean(Map<String, Object> map, Object t) {
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				
				if (map.containsKey(key)) {
					Object value = map.get(key);
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					setter.invoke(t, value);
				}
				
			}
			
		} catch (Exception e) {
		}
		
		return;
		
	}
	
	/**
	 * @throws IllegalAccessException   
	*  方法名： analyzeChengguo  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param path
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： wang  
	*  @throws  
	*/
	private String analyzeChengguo(String xml, String username) {
		String message = null;
		System.err.println(xml);
		XStream xStream = new XStream();
		xStream.alias("KjcgJbxxInfo", KjcgJbxxInfo.class);
		xStream.omitField(KjcgJbxxInfo.class, "createTime");//把字段节点隐藏
		xStream.omitField(KjcgJbxxInfo.class, "createUser");//把字段节点隐藏
		
		try {
			Object obj = xStream.fromXML(xml);
			Map<String, Object> map = objectToMap(obj);
			KjcgJbxxInfo info2 = new KjcgJbxxInfo();
			transMap2Bean(map, info2);
			System.err.println(info2.toString());
			info2.setCreateUser(username);
			kjcgJbxxDao.save(info2);
			message = "成功";
		} catch (IllegalAccessException e) {
			message = e.toString();
		}
		return message;
	}
	
}
