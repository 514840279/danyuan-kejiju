package tk.ainiyue.danyuan.application.dic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tk.ainiyue.danyuan.application.dic.po.KjDicTsfl;

@Repository("kjDicTsflDao")
public interface KjDicTsflDao extends JpaRepository<KjDicTsfl, String> {
	
	/**  
	*  方法名： findAll  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param ztlm
	*  参    数： @return 
	*  返    回： List<KjDicTsfl>  
	*  作    者 ： wang  
	*  @throws  
	*/
	@Query("Select t from KjDicTsfl t where t.ztlm like concat('%', :ztlm, '%')")
	List<KjDicTsfl> findAllByZtlm(@Param("ztlm") String ztlm);
	
}
