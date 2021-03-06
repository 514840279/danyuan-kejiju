package tk.ainiyue.danyuan.application.kejiju.xiangmu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmDwxxInfo;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo;

/**    
*  文件名 ： KjxmDwxxInfoService.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.xiangmu.service  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午10:17:10  
*  版    本 ： V1.0    
*/
public interface KjxmDwxxService {
	
	/**  
	*  方法名： page  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param pageNumber
	*  参    数： @param pageSize
	*  参    数： @param info
	*  参    数： @return 
	*  返    回： Page<KjxmDwxxInfo>  
	*  作    者 ： wang  
	*  @throws  
	*/
	Page<KjxmDwxxInfo> page(int pageNumber, int pageSize, KjxmDwxxInfo info);
	
	/**  
	*  方法名： save  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param info 
	*  返    回： void  
	*  作    者 ： wang  
	*  @throws  
	*/
	void save(KjxmDwxxInfo info);
	
	/**  
	*  方法名： delete  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param info 
	*  返    回： void  
	*  作    者 ： wang  
	*  @throws  
	*/
	void delete(List<KjxmDwxxInfo> list);
	
	/**  
	*  方法名： findList  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param xmjbUuid
	*  参    数： @return 
	*  返    回： List<KjxmDwxxInfo>  
	*  作    者 ： wang  
	*  @throws  
	*/
	List<KjxmDwxxInfo> findList(String xmjbUuid);
	
	/**  
	*  方法名： list  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param info
	*  参    数： @return 
	*  返    回： List<KjxmDwxxInfo>  
	*  作    者 ： wang  
	*  @throws  
	*/
	List<KjxmDwxxInfo> list(KjxmJbxxInfo info);
	
	/**  
	*  方法名： findOne  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param info
	*  参    数： @return 
	*  返    回： KjxmDwxxInfo  
	*  作    者 ： Administrator  
	*  @throws  
	*/
	KjxmDwxxInfo findOne(KjxmDwxxInfo info);
	
}
