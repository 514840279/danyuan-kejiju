package tk.ainiyue.danyuan.application.kejiju.chengguo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import tk.ainiyue.danyuan.application.dic.dao.KjDicCglxDao;
import tk.ainiyue.danyuan.application.dic.po.KjDicCglx;
import tk.ainiyue.danyuan.application.kejiju.chengguo.dao.KjcgJbxxDao;
import tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo;
import tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService;
import tk.ainiyue.danyuan.application.kejiju.chengguo.vo.KjcgJbxxCount;
import tk.ainiyue.danyuan.application.kejiju.chengguo.vo.KjcgJbxxInfoVo;

/**    
*  文件名 ： KjcgJbxxInfoServiceImpl.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.chengguo.service.impl  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午11:17:39  
*  版    本 ： V1.0    
*/
@Service("kjcgJbxxService")
public class KjcgJbxxServiceImpl implements KjcgJbxxService {
	@Autowired
	private KjcgJbxxDao		kjcgJbxxDao;
	
	@Autowired
	private KjDicCglxDao	kjDicCglxDao;
	
	/** 
	*  方法名 ： page
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param pageNumber
	*  参    数 ： @param pageSize
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxInfoService#page(int, int, tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo)  
	*  作    者 ： wang  
	*/
	
	@Override
	public Page<KjcgJbxxInfo> page(int pageNumber, int pageSize, KjcgJbxxInfo info) {
		Example<KjcgJbxxInfo> example = Example.of(info);
		Sort sort = new Sort(new Order(Direction.DESC, "createTime"));
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, sort);
		return kjcgJbxxDao.findAll(example, request);
	}
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxInfoService#save(tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void save(KjcgJbxxInfo info) {
		kjcgJbxxDao.save(info);
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param list  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxInfoService#delete(java.util.List)  
	*  作    者 ： wang  
	*/
	
	@Override
	public void delete(List<KjcgJbxxInfo> list) {
		kjcgJbxxDao.delete(list);
	}
	
	/** 
	*  方法名 ： dicCglx
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService#dicCglx()  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public List<KjDicCglx> dicCglx() {
		return kjDicCglxDao.findAll();
	}
	
	/** 
	*  方法名 ： dicCgsj
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService#dicCgsj()  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public List<String> dicCgsj() {
		return kjcgJbxxDao.findAllCgsj();
	}
	
	/** 
	*  方法名 ： findone
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService#findone(tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo)  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public KjcgJbxxInfo findone(KjcgJbxxInfo info) {
		return kjcgJbxxDao.findOne(info);
	}
	
	/** 
	*  方法名 ： statistics
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService#statistics()  
	*  作    者 ： wang  
	*/
	
	@Override
	public List<KjcgJbxxCount> statistics() {
		List<Object[]> list = kjcgJbxxDao.statistics();
		List<KjcgJbxxCount> jblist = new ArrayList<>();
		for (Object[] objects : list) {
			KjcgJbxxCount count = new KjcgJbxxCount();
			count.setResultType(String.valueOf(objects[0]));
			count.setNumbers(Integer.valueOf(String.valueOf(objects[1])));
			jblist.add(count);
		}
		return jblist;
	}
	
	/** 
	*  方法名 ： outputFile
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @return  
	*  参    考 ： @see tk.ainiyue.danyuan.application.kejiju.chengguo.service.KjcgJbxxService#outputFile(tk.ainiyue.danyuan.application.kejiju.chengguo.vo.KjcgJbxxInfoVo)  
	*  作    者 ： wang  
	 * @throws IOException 
	*/
	
	@Override
	public String outputFile(KjcgJbxxInfoVo vo, String path) throws IOException {
		
		File filepath = new File(path);
		//		String fullpath = file.getAbsolutePath();
		if (!filepath.exists()) {
			filepath.mkdirs();
		}
		System.out.println(vo.toString());
		List<KjcgJbxxInfo> list = kjcgJbxxDao.findAllByMulitity(vo.getCompletedDate().trim(), vo.getDate1().trim(), vo.getDate2().trim(), vo.getProjectName().trim(), vo.getResultType().trim());
		if (list == null || list.size() == 0) {
			return "";
		}
		List<File> fileList = new ArrayList<>();
		for (KjcgJbxxInfo kjcgJbxxInfo : list) {
			String fileName = path + "/" + kjcgJbxxInfo.getResultId() + ".xml";
			//			System.err.println(fileName.toString());
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileList.add(file);
			XStream xstream = new XStream();
			xstream.alias("KjcgJbxxInfo", KjcgJbxxInfo.class);
			
			//			xstream.omitField(KjcgJbxxInfo.class, "createTime");//把字段节点隐藏
			//			xstream.omitField(KjcgJbxxInfo.class, "createUser");//把字段节点隐藏
			//序列化
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xstream.toXML(kjcgJbxxInfo);
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
	
}
