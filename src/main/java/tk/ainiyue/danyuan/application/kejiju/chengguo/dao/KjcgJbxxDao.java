package tk.ainiyue.danyuan.application.kejiju.chengguo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo;

/**    
*  文件名 ： KjcgJbxxInfoDao.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.chengguo.dao  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午11:11:29  
*  版    本 ： V1.0    
*/
@Repository("kjcgJbxxDao")
@DynamicUpdate(true)
@DynamicInsert(true)
public interface KjcgJbxxDao extends JpaRepository<KjcgJbxxInfo, Serializable> {
	
	/**  
	*  方法名： findAllCgsj  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： Administrator  
	*  @throws  
	*/
	@Query("select distinct t.completedDate  from KjcgJbxxInfo t")
	List<String> findAllCgsj();
	
	/**  
	*  方法名： statistics  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjcgJbxxInfo>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT t.resultType as resultType,COUNT(1) as numbers  FROM KjcgJbxxInfo t GROUP BY t.resultType")
	List<Object[]> statistics();
	
	/**
	 * @return   
	*  方法名： findAllByMulitity  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param completedDate
	*  参    数： @param date1
	*  参    数： @param date2
	*  参    数： @param projectName
	*  参    数： @param resultType 
	*  返    回： void  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT t  FROM KjcgJbxxInfo t  " + " where t.completedDate like CONCAT('%',:completed,'%') " + " and t.projectName like CONCAT('%',:projectName,'%') and t.resultType  like CONCAT('%',:resultType,'%') and TO_DAYS(t.createTime) - TO_DAYS(:date1) > 0 and TO_DAYS(:date2) - TO_DAYS(t.createTime) > 0")
	List<KjcgJbxxInfo> findAllByMulitity(@Param("completed") String completedDate, @Param("date1") String date1, @Param("date2") String date2, @Param("projectName") String projectName, @Param("resultType") String resultType);
	
}
