package tk.ainiyue.danyuan.application.kejiju.renyuan.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryJbxxInfo;

/**    
*  文件名 ： KjryJbxxInfoDao.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.renyuan.dao  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午11:38:18  
*  版    本 ： V1.0    
*/
@Repository("kjryJbxxDao")
@DynamicUpdate(true)
@DynamicInsert(true)
public interface KjryJbxxDao extends JpaRepository<KjryJbxxInfo, Serializable> {
	
	/**  
	*  方法名： dicJsly  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： Administrator  
	*  @throws  
	*/
	@Query("select distinct t.researchDirection from KjryJbxxInfo t ")
	List<String> dicJsly();
	
	/**  
	*  方法名： dicZc  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： Administrator  
	*  @throws  
	*/
	@Query("select distinct t.porfessionalTitle from KjryJbxxInfo t ")
	List<String> dicZc();
	
	/**  
	*  方法名： dicSj  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： Administrator  
	*  @throws  
	*/
	@Query("select distinct t.degree from KjryJbxxInfo t ")
	List<String> dicXw();
	
	/**  
	*  方法名： statistics  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<Object []>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT t.honorary as honorary,COUNT(1) as numbers  FROM KjryJbxxInfo t GROUP BY t.honorary")
	List<Object[]> statistics();
	
	/**  
	*  方法名： findAllByMulitity  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param date1
	*  参    数： @param date2
	*  参    数： @param degree
	*  参    数： @param porfessionalTitle
	*  参    数： @param researchDirection
	*  参    数： @param name
	*  参    数： @return 
	*  返    回： List<KjryJbxxInfo>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT t  FROM KjryJbxxInfo t  " + " where t.name like CONCAT('%',:name,'%') " + " and t.degree like CONCAT('%',:degree,'%') and t.porfessionalTitle  like CONCAT('%',:porfessionalTitle,'%') and t.researchDirection like CONCAT('%',:researchDirection,'%')  and TO_DAYS(t.createTime) - TO_DAYS(:date1) > 0 and TO_DAYS(:date2) - TO_DAYS(t.createTime) > 0")
	List<KjryJbxxInfo> findAllByMulitity(@Param("date1") String date1, @Param("date2") String date2, @Param("degree") String degree, @Param("porfessionalTitle") String porfessionalTitle, @Param("researchDirection") String researchDirection, @Param("name") String name);
	
	/**  
	*  方法名： countGroupByCreateTime  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<Map<String,Object>>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT DATE_FORMAT(t.createTime,'%Y-%m') as name ,count(1 ) as value  FROM KjryJbxxInfo t  group by  DATE_FORMAT(t.createTime,'%Y-%m')")
	List<Map<String, Object>> countGroupByCreateTime();
	
	/**  
	*  方法名： countGroupByCreateTimeAnd  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param dates
	*  参    数： @return 
	*  返    回： List<Map<String,Object>>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT  t.field as name ,count(1 ) as value  FROM KjryJbxxInfo t where DATE_FORMAT(t.createTime,'%Y-%m') =:dates  group by  t.field")
	List<Map<String, Object>> countGroupByCreateTimeAnd(@Param("dates") String dates);
	
}
