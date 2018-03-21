package tk.ainiyue.danyuan.application.kejiju.xiangmu.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

import tk.ainiyue.danyuan.application.common.ZipUtils;
import tk.ainiyue.danyuan.application.kejiju.chengguo.vo.Flare;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.dao.KjxmDwxxDao;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.dao.KjxmJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.dao.KjxmRyxxDao;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmDwxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmRyxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.vo.KjxmJbxxCount;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.vo.KjxmJbxxInfoVo;

/**    
*  文件名 ： KjxmJbxxInfoServiceImpl.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.xiangmu.service.impl  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午10:14:42  
*  版    本 ： V1.0    
*/
@Service("kjxmJbxxInfoService")
public class KjxmJbxxServiceImpl implements KjxmJbxxService {
	@Autowired
	private KjxmJbxxDao	kjxmJbxxDao;
	
	@Autowired
	private KjxmDwxxDao	kjxmDwxxDao;
	
	@Autowired
	private KjxmRyxxDao	kjxmRyxxDao;
	
	/** 
	*  方法名 ： page
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param pageNumber
	*  参    数 ： @param pageSize
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxInfoService#page(int, int, tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo)  
	*  作    者 ： wang  
	*/
	
	@Override
	public Page<KjxmJbxxInfo> page(int pageNumber, int pageSize, KjxmJbxxInfo info) {
		try {
			Example<KjxmJbxxInfo> example = Example.of(info);
			Sort sort = new Sort(new Order(Direction.DESC, "createTime"));
			PageRequest request = new PageRequest(pageNumber - 1, pageSize, sort);
			return kjxmJbxxDao.findAll(example, request);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return null;
	}
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxInfoService#save(tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void save(KjxmJbxxInfo info) {
		kjxmJbxxDao.save(info);
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param list  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxInfoService#delete(java.util.List)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void delete(List<KjxmJbxxInfo> list) {
		kjxmJbxxDao.delete(list);
	}
	
	/** 
	*  方法名 ： dicJsly
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#dicJsly()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<String> dicJsly() {
		return kjxmJbxxDao.dicJsly();
	}
	
	/** 
	*  方法名 ： dicXmlx
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#dicXmlx()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<String> dicXmlx() {
		return kjxmJbxxDao.dicXmlx();
	}
	
	/** 
	*  方法名 ： dicSj
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#dicSj()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<String> dicSj() {
		return kjxmJbxxDao.dicSj();
	}
	
	/** 
	*  方法名 ： dicDq
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#dicDq()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<String> dicDq() {
		return kjxmJbxxDao.dicDq();
	}
	
	/** 
	*  方法名 ： findOne
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#findOne(tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo)  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public KjxmJbxxInfo findOne(KjxmJbxxInfo info) {
		Example<KjxmJbxxInfo> example = Example.of(info);
		return kjxmJbxxDao.findOne(example);
	}
	
	/** 
	*  方法名 ： statistics
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#statistics()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<KjxmJbxxCount> statistics() {
		List<Object[]> list = kjxmJbxxDao.statistics();
		List<KjxmJbxxCount> jblist = new ArrayList<>();
		for (Object[] objects : list) {
			KjxmJbxxCount count = new KjxmJbxxCount();
			count.setProjectDomain(String.valueOf(objects[0]));
			count.setNumbers(Integer.valueOf(String.valueOf(objects[1])));
			jblist.add(count);
		}
		return jblist;
	}
	
	/** 
	*  方法名 ： outputFile
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @param path
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#outputFile(tk.ainiyue.danyuan.application.kejiju.xiangmu.vo.KjxmJbxxInfoVo, java.lang.String)  
	*  作    者 ： wang  
	 * @throws IOException 
	*/
	
	@Override
	public String outputFile(KjxmJbxxInfoVo vo, String path) throws IOException {
		File filepath = new File(path);
		//		String fullpath = file.getAbsolutePath();
		if (!filepath.exists()) {
			filepath.mkdirs();
		}
		List<KjxmJbxxInfo> list = kjxmJbxxDao.findAllByMulitity(vo.getProjectName().trim(), vo.getProjectDomain().trim(), vo.getApprovalYear().trim(), vo.getRegion().trim(), vo.getProjectType().trim(), vo.getDate1().trim(), vo.getDate2().trim());
		if (list == null || list.size() == 0) {
			return "";
		}
		List<File> fileList = new ArrayList<>();
		for (KjxmJbxxInfo kjxmJbxxInfo : list) {
			
			//
			KjxmDwxxInfo dwxx = new KjxmDwxxInfo();
			dwxx.setKjxmJbxxInfo(kjxmJbxxInfo);
			Example<KjxmDwxxInfo> empgzll = Example.of(dwxx);
			kjxmJbxxInfo.setKjxmDwxxInfos(kjxmDwxxDao.findAll(empgzll));
			
			//
			KjxmRyxxInfo ryxx = new KjxmRyxxInfo();
			ryxx.setKjxmJbxxInfo(kjxmJbxxInfo);
			Example<KjxmRyxxInfo> empryxx = Example.of(ryxx);
			kjxmJbxxInfo.setKjxmRyxxInfos(kjxmRyxxDao.findAll(empryxx));
			
			//
			String fileName = path + "/" + kjxmJbxxInfo.getUuid() + ".xml";
			System.err.println(kjxmJbxxInfo.toString());
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileList.add(file);
			XStream xstream = new XStream();
			// 别称
			xstream.alias("KjxmJbxxInfo", KjxmJbxxInfo.class);
			xstream.alias("KjxmDwxxInfo", KjxmDwxxInfo.class);
			xstream.alias("KjxmRyxxInfo", KjxmRyxxInfo.class);
			xstream.omitField(KjxmJbxxInfo.class, "uuid");//把字段节点隐藏
			// 忽略
			xstream.omitField(KjxmDwxxInfo.class, "uuid");//把字段节点隐藏
			xstream.omitField(KjxmDwxxInfo.class, "kjxmJbxxInfo");//把字段节点隐藏
			xstream.omitField(KjxmDwxxInfo.class, "createTime");//把字段节点隐藏
			xstream.omitField(KjxmDwxxInfo.class, "createUser");//把字段节点隐藏
			// 忽略
			xstream.omitField(KjxmRyxxInfo.class, "uuid");//把字段节点隐藏
			xstream.omitField(KjxmRyxxInfo.class, "kjxmJbxxInfo");//把字段节点隐藏
			xstream.omitField(KjxmRyxxInfo.class, "createTime");//把字段节点隐藏
			xstream.omitField(KjxmRyxxInfo.class, "createUser");//把字段节点隐藏
			//序列化
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xstream.toXML(kjxmJbxxInfo);
			//			System.err.println(xml);
			//构造函数中的第二个参数true表示以追加形式写文件
			FileWriter fw = new FileWriter(fileName);
			fw.write(xml);
			fw.close();
			
		}
		String FileName = path + ".zip";
		if (list.size() > 0) {
			// 执行打包zip文件
			/** 测试压缩方法2  */
			FileOutputStream fos2 = new FileOutputStream(new File(FileName));
			ZipUtils.toZip(fileList, fos2);
			for (File file : fileList) {
				file.delete();
			}
		}
		filepath.delete();
		return FileName;
	}
	
	/** 
	*  方法名 ： flare
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.xiangmu.service.KjxmJbxxService#flare()  
	*  作    者 ： wang  
	*/
	
	@Override
	public Flare flare() {
		Flare flare = new Flare();
		Long longs = kjxmJbxxDao.count();
		flare.setName("总量");
		flare.setValue(Integer.parseInt(longs.toString()));
		List<Map<String, Object>> listc = kjxmJbxxDao.countGroupByCreateTime();
		List<Flare> listcl = new ArrayList<>();
		for (Map<String, Object> flare2 : listc) {
			Flare flarec = new Flare();
			String dates = (String) flare2.get("name");
			flarec.setName(dates);
			flarec.setValue(Integer.parseInt(flare2.get("value").toString()));
			List<Map<String, Object>> lists = kjxmJbxxDao.countGroupByCreateTimeAnd(dates);
			List<Flare> listsl = new ArrayList<>();
			for (Map<String, Object> flare3 : lists) {
				Flare flares = new Flare();
				flares.setName((String) flare3.get("name"));
				flares.setValue(Integer.parseInt(flare3.get("value").toString()));
				listsl.add(flares);
			}
			flarec.setChildren(listsl);
			listcl.add(flarec);
		}
		flare.setChildren(listcl);
		return flare;
	}
}
