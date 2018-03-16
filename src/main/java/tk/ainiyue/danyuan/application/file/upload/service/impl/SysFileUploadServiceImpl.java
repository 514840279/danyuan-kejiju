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

import com.thoughtworks.xstream.XStream;

import tk.ainiyue.danyuan.application.file.upload.dao.SysFileUploadDao;
import tk.ainiyue.danyuan.application.file.upload.po.SysFileUploadInfo;
import tk.ainiyue.danyuan.application.file.upload.service.SysFileUploadService;
import tk.ainiyue.danyuan.application.kejiju.chengguo.dao.KjcgJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo;

@Service("sysFileUploadService")
public class SysFileUploadServiceImpl implements SysFileUploadService {
	//
	private static final Logger	logger	= LoggerFactory.getLogger(SysFileUploadServiceImpl.class);
	@Autowired
	private SysFileUploadDao	sysFileUploadDao;
	@Autowired
	private KjcgJbxxDao			kjcgJbxxDao;
	
	@Override
	public void save(SysFileUploadInfo info) {
		sysFileUploadDao.save(info);
	}
	
	@Override
	public Page<SysFileUploadInfo> findAllBySearchText(int pageNumber, int pageSize, String discription) {
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
			try {
				message = analyzeChengguo(xml, info.getCreateUser());
			} catch (IllegalAccessException e) {
				message = e.toString();
			}
		} else if (info.getPath().contains("/renyuan/")) {
			
		} else if (info.getPath().contains("/xiangmu/")) {
			
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
	private String analyzeChengguo(String xml, String username) throws IllegalAccessException {
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
