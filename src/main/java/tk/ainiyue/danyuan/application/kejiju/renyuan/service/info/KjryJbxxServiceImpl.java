package tk.ainiyue.danyuan.application.kejiju.renyuan.service.info;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
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
import tk.ainiyue.danyuan.application.kejiju.renyuan.dao.KjryGzllDao;
import tk.ainiyue.danyuan.application.kejiju.renyuan.dao.KjryJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.renyuan.dao.KjryJyxxDao;
import tk.ainiyue.danyuan.application.kejiju.renyuan.dao.KjryXsjzDao;
import tk.ainiyue.danyuan.application.kejiju.renyuan.dao.KjryXspsDao;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryGzllInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJyxxInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryXsjzInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryXspsInfo;
import tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService;
import tk.ainiyue.danyuan.application.kejiju.renyuan.vo.KjryJbxxCount;
import tk.ainiyue.danyuan.application.kejiju.renyuan.vo.KjryJbxxInfoVo;

@Service("kjryJbxxService")
@Persistent
public class KjryJbxxServiceImpl implements KjryJbxxService {
	@Autowired
	private KjryJbxxDao	kjryJbxxDao;
	@Autowired
	private KjryGzllDao	kjryGzllDao;
	@Autowired
	private KjryJyxxDao	kjryJyxxDao;
	@Autowired
	private KjryXsjzDao	kjryXsjzDao;
	@Autowired
	private KjryXspsDao	kjryXspsDao;
	
	/** 
	*  方法名 ： page
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param pageNumber
	*  参    数 ： @param pageSize
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxInfoService#page(int, int, tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJbxxInfo)  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public Page<KjryJbxxInfo> page(int pageNumber, int pageSize, KjryJbxxInfo info) {
		Example<KjryJbxxInfo> example = Example.of(info);
		Sort sort = new Sort(new Order(Direction.DESC, "createTime"));
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, sort);
		return kjryJbxxDao.findAll(example, request);
	}
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxInfoService#save(tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJbxxInfo)  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public void save(KjryJbxxInfo info) {
		kjryJbxxDao.save(info);
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param list  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxInfoService#delete(java.util.List)  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public void delete(List<KjryJbxxInfo> list) {
		kjryJbxxDao.delete(list);
	}
	
	/** 
	*  方法名 ： dicJsly
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#dicJsly()  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public List<String> dicJsly() {
		return kjryJbxxDao.dicJsly();
	}
	
	/** 
	*  方法名 ： dicZc
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#dicZc()  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public List<String> dicZc() {
		return kjryJbxxDao.dicZc();
	}
	
	/** 
	*  方法名 ： dicSj
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#dicSj()  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public List<String> dicXw() {
		return kjryJbxxDao.dicXw();
	}
	
	/** 
	*  方法名 ： findOne
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#findOne(tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJbxxInfo)  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public KjryJbxxInfo findOne(KjryJbxxInfo info) {
		Example<KjryJbxxInfo> example = Example.of(info);
		return kjryJbxxDao.findOne(example);
	}
	
	/** 
	*  方法名 ： statistics
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#statistics()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<KjryJbxxCount> statistics() {
		List<Object[]> list = kjryJbxxDao.statistics();
		List<KjryJbxxCount> jblist = new ArrayList<>();
		for (Object[] objects : list) {
			KjryJbxxCount count = new KjryJbxxCount();
			count.setHonorary(String.valueOf(objects[0]));
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
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#outputFile(tk.ainiyue.danyuan.application.kejiju.renyuan.vo.KjryJbxxInfoVo, java.lang.String)  
	*  作    者 ： wang  
	 * @throws IOException 
	*/
	
	@Override
	public String outputFile(KjryJbxxInfoVo vo, String path) throws IOException {
		File filepath = new File(path);
		//		String fullpath = file.getAbsolutePath();
		if (!filepath.exists()) {
			filepath.mkdirs();
		}
		List<KjryJbxxInfo> list = kjryJbxxDao.findAllByMulitity(vo.getDate1().trim(), vo.getDate2().trim(), vo.getDegree().trim(), vo.getPorfessionalTitle().trim(), vo.getResearchDirection().trim(), vo.getName().trim());
		if (list == null || list.size() == 0) {
			return "";
		}
		List<File> fileList = new ArrayList<>();
		for (KjryJbxxInfo kjryJbxxInfo : list) {
			
			//
			KjryGzllInfo gzll = new KjryGzllInfo();
			gzll.setKjryJbxxInfo(kjryJbxxInfo);
			Example<KjryGzllInfo> empgzll = Example.of(gzll);
			kjryJbxxInfo.setKjryGzllInfos(kjryGzllDao.findAll(empgzll));
			
			//
			KjryJyxxInfo jyxx = new KjryJyxxInfo();
			jyxx.setKjryJbxxInfo(kjryJbxxInfo);
			Example<KjryJyxxInfo> empjyxx = Example.of(jyxx);
			kjryJbxxInfo.setKjryJyxxInfos(kjryJyxxDao.findAll(empjyxx));
			
			//
			KjryXsjzInfo xsjz = new KjryXsjzInfo();
			xsjz.setKjryJbxxInfo(kjryJbxxInfo);
			Example<KjryXsjzInfo> empxsjz = Example.of(xsjz);
			kjryJbxxInfo.setKjryXsjzInfos(kjryXsjzDao.findAll(empxsjz));
			
			//
			KjryXspsInfo xsps = new KjryXspsInfo();
			xsps.setKjryJbxxInfo(kjryJbxxInfo);
			Example<KjryXspsInfo> empxsps = Example.of(xsps);
			kjryJbxxInfo.setKjryXspsInfos(kjryXspsDao.findAll(empxsps));
			
			//
			String fileName = path + "/" + kjryJbxxInfo.getPersonId() + ".xml";
			System.err.println(kjryJbxxInfo.toString());
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileList.add(file);
			XStream xstream = new XStream();
			// 别称
			xstream.alias("kjryJbxxInfo", KjryJbxxInfo.class);
			xstream.alias("KjryGzllInfo", KjryGzllInfo.class);
			xstream.alias("KjryJyxxInfo", KjryJyxxInfo.class);
			xstream.alias("KjryXsjzInfo", KjryXsjzInfo.class);
			xstream.alias("KjryXspsInfo", KjryXspsInfo.class);
			xstream.omitField(KjryJbxxInfo.class, "personId");//把字段节点隐藏
			// 忽略
			xstream.omitField(KjryGzllInfo.class, "uuid");//把字段节点隐藏
			xstream.omitField(KjryGzllInfo.class, "kjryJbxxInfo");//把字段节点隐藏
			xstream.omitField(KjryGzllInfo.class, "createTime");//把字段节点隐藏
			xstream.omitField(KjryGzllInfo.class, "createUser");//把字段节点隐藏
			// 忽略
			xstream.omitField(KjryJyxxInfo.class, "uuid");//把字段节点隐藏
			xstream.omitField(KjryJyxxInfo.class, "kjryJbxxInfo");//把字段节点隐藏
			xstream.omitField(KjryJyxxInfo.class, "createTime");//把字段节点隐藏
			xstream.omitField(KjryJyxxInfo.class, "createUser");//把字段节点隐藏
			
			xstream.omitField(KjryXsjzInfo.class, "uuid");//把字段节点隐藏
			xstream.omitField(KjryXsjzInfo.class, "kjryJbxxInfo");//把字段节点隐藏
			xstream.omitField(KjryXsjzInfo.class, "createTime");//把字段节点隐藏
			xstream.omitField(KjryXsjzInfo.class, "createUser");//把字段节点隐藏
			
			xstream.omitField(KjryXspsInfo.class, "uuid");//把字段节点隐藏
			xstream.omitField(KjryXspsInfo.class, "kjryJbxxInfo");//把字段节点隐藏
			xstream.omitField(KjryXspsInfo.class, "createTime");//把字段节点隐藏
			xstream.omitField(KjryXspsInfo.class, "createUser");//把字段节点隐藏
			//序列化
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xstream.toXML(kjryJbxxInfo);
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
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.renyuan.service.KjryJbxxService#flare()  
	*  作    者 ： wang  
	*/
	
	@Override
	public Flare flare() {
		Flare flare = new Flare();
		Long longs = kjryJbxxDao.count();
		flare.setName("总量");
		flare.setValue(Integer.parseInt(longs.toString()));
		List<Map<String, Object>> listc = kjryJbxxDao.countGroupByCreateTime();
		List<Flare> listcl = new ArrayList<>();
		for (Map<String, Object> flare2 : listc) {
			Flare flarec = new Flare();
			String dates = (String) flare2.get("name");
			flarec.setName(dates);
			flarec.setValue(Integer.parseInt(flare2.get("value").toString()));
			List<Map<String, Object>> lists = kjryJbxxDao.countGroupByCreateTimeAnd(dates);
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
