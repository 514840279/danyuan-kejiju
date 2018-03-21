package tk.ainiyue.danyuan.application.kejiju.xiangmu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo;

/**
 * 文件名 ： SysDatabaseDao.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.addr.dao
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang 
 * 时 间 ： 2017年8月3日 下午3:46:57
 * 版 本 ： V1.0
 */
@Repository("kjxmJbxxDao")
@DynamicUpdate(true)
@DynamicInsert(true)
public interface KjxmJbxxDao extends JpaRepository<KjxmJbxxInfo, Serializable> {
	
	/**  
	*  方法名： dicJsly  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("select distinct t.projectDomain from KjxmJbxxInfo t ")
	List<String> dicJsly();
	
	/**  
	*  方法名： dicXmlx  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("select distinct t.projectType from KjxmJbxxInfo t ")
	List<String> dicXmlx();
	
	/**  
	*  方法名： dicSj  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("select distinct t.approvalYear from KjxmJbxxInfo t ")
	List<String> dicSj();
	
	/**  
	*  方法名： dicDq  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<String>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("select distinct t.region from KjxmJbxxInfo t ")
	List<String> dicDq();
	
	/**  
	*  方法名： statistics  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjxmJbxxCount>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT t.projectDomain as projectDomain,COUNT(1) as numbers  FROM KjxmJbxxInfo t GROUP BY t.projectDomain")
	List<Object[]> statistics();
	
	/**  
	*  方法名： findAllByMulitity  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param projectName
	*  参    数： @param projectDomain
	*  参    数： @param approvalYear
	*  参    数： @param region
	*  参    数： @param projectType
	*  参    数： @param date1
	*  参    数： @param date2
	*  参    数： @return 
	*  返    回： List<KjxmJbxxInfo>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT t  FROM KjxmJbxxInfo t  " + " where t.projectName like CONCAT('%',:project,'%') " + " and t.projectDomain like CONCAT('%',:projectDomain,'%') " + " and t.approvalYear  like CONCAT('%',:approvalYear,'%') " + " and t.region like CONCAT('%',:region,'%') " + " and t.projectType like CONCAT('%',:projectType,'%') " + " and TO_DAYS(t.createTime) - TO_DAYS(:date1) > 0 and TO_DAYS(:date2) - TO_DAYS(t.createTime) > 0")
	List<KjxmJbxxInfo> findAllByMulitity(@Param("project") String projectName, @Param("projectDomain") String projectDomain, @Param("approvalYear") String approvalYear, @Param("region") String region, @Param("projectType") String projectType, @Param("date1") String date1, @Param("date2") String date2);
	
	/**  
	*  方法名： countGroupByCreateTime  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<Map<String,Object>>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("SELECT DATE_FORMAT(t.createTime,'%Y-%m') as name ,count(1 ) as value  FROM KjxmJbxxInfo t  group by  DATE_FORMAT(t.createTime,'%Y-%m')")
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
	@Query("SELECT  t.projectDomain as name ,count(1 ) as value  FROM KjxmJbxxInfo t where DATE_FORMAT(t.createTime,'%Y-%m') =:dates  group by  t.projectDomain")
	List<Map<String, Object>> countGroupByCreateTimeAnd(@Param("dates") String dates);
	
}
