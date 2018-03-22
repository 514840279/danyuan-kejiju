package tk.ainiyue.danyuan.application.dic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.ainiyue.danyuan.application.dic.dao.KjDicCglxDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicDqdmDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicDwxzDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicGzxzDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicHyflDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicMzdmDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicPxjxDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicRyjsDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicTsflDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicXkflDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicXlmcDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicXwmcDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicZjlxDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicZwjbDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicZxjdDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicZydmDao;
import tk.ainiyue.danyuan.application.dic.dao.KjDicZzmmDao;
import tk.ainiyue.danyuan.application.dic.po.KjDicCglx;
import tk.ainiyue.danyuan.application.dic.po.KjDicDqdm;
import tk.ainiyue.danyuan.application.dic.po.KjDicDwxz;
import tk.ainiyue.danyuan.application.dic.po.KjDicGzxz;
import tk.ainiyue.danyuan.application.dic.po.KjDicHyfl;
import tk.ainiyue.danyuan.application.dic.po.KjDicMzdm;
import tk.ainiyue.danyuan.application.dic.po.KjDicPxjx;
import tk.ainiyue.danyuan.application.dic.po.KjDicRyjs;
import tk.ainiyue.danyuan.application.dic.po.KjDicTsfl;
import tk.ainiyue.danyuan.application.dic.po.KjDicXkfl;
import tk.ainiyue.danyuan.application.dic.po.KjDicXlmc;
import tk.ainiyue.danyuan.application.dic.po.KjDicXwmc;
import tk.ainiyue.danyuan.application.dic.po.KjDicZjlx;
import tk.ainiyue.danyuan.application.dic.po.KjDicZwjb;
import tk.ainiyue.danyuan.application.dic.po.KjDicZxjd;
import tk.ainiyue.danyuan.application.dic.po.KjDicZydm;
import tk.ainiyue.danyuan.application.dic.po.KjDicZzmm;

/**    
*  文件名 ： DicService.java  
*  包    名 ： tk.ainiyue.danyuan.application.dic.service  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月22日 下午8:50:01  
*  版    本 ： V1.0    
*/
@Service("dicService")
public class DicService {
	
	@Autowired
	KjDicCglxDao	kjDicCglxDao;
	
	@Autowired
	KjDicDqdmDao	kjDicDqdmDao;
	
	@Autowired
	KjDicDwxzDao	kjDicDwxzDao;
	
	@Autowired
	KjDicGzxzDao	kjDicGzxzDao;
	@Autowired
	KjDicHyflDao	kjDicHyflDao;
	@Autowired
	KjDicMzdmDao	kjDicMzdmDao;
	
	@Autowired
	KjDicPxjxDao	kjDicPxjxDao;
	
	@Autowired
	KjDicRyjsDao	kjDicRyjsDao;
	
	@Autowired
	KjDicTsflDao	kjDicTsflDao;
	
	@Autowired
	KjDicXkflDao	kjDicXkflDao;
	
	@Autowired
	KjDicXlmcDao	kjDicXlmcDao;
	
	@Autowired
	KjDicXwmcDao	kjDicXwmcDao;
	
	@Autowired
	KjDicZjlxDao	kjDicZjlxDao;
	
	@Autowired
	KjDicZwjbDao	kjDicZwjbDao;
	
	@Autowired
	KjDicZxjdDao	kjDicZxjdDao;
	
	@Autowired
	KjDicZydmDao	kjDicZydmDao;
	
	@Autowired
	KjDicZzmmDao	kjDicZzmmDao;
	
	/**  
	*  方法名： dicCglx  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicCglx>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicCglx> dicCglx() {
		return kjDicCglxDao.findAll();
	}
	
	/**  
	*  方法名： dicDwxz  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicDwxz>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicDwxz> dicDwxz() {
		return kjDicDwxzDao.findAll();
	}
	
	/**  
	*  方法名： dicZydm  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicZydm>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicZydm> dicZydm() {
		return kjDicZydmDao.findAll();
	}
	
	/**  
	*  方法名： dicGzxz  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicGzxz>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicGzxz> dicGzxz() {
		return kjDicGzxzDao.findAll();
	}
	
	/**  
	*  方法名： dicHyfl  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicHyfl>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicHyfl> dicHyfl() {
		return kjDicHyflDao.findAll();
	}
	
	/**  
	*  方法名： dicPxjx  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicPxjx>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicPxjx> dicPxjx() {
		return kjDicPxjxDao.findAll();
	}
	
	/**  
	*  方法名： dicRyjs  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicRyjs>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicRyjs> dicRyjs() {
		return kjDicRyjsDao.findAll();
	}
	
	/**  
	*  方法名： dicDqdm  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicDqdm>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicDqdm> dicDqdm() {
		return kjDicDqdmDao.findAll();
	}
	
	/**  
	*  方法名： dicZxjd  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicZxjd>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicZxjd> dicZxjd() {
		return kjDicZxjdDao.findAll();
	}
	
	/**  
	*  方法名： dicXkfl  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicXkfl>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicXkfl> dicXkfl() {
		return kjDicXkflDao.findAll();
	}
	
	/**  
	*  方法名： dicXlmc  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicXlmc>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicXlmc> dicXlmc() {
		return kjDicXlmcDao.findAll();
	}
	
	/**  
	*  方法名： dicXwmc  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicXwmc>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicXwmc> dicXwmc() {
		return kjDicXwmcDao.findAll();
	}
	
	/**  
	*  方法名： dicZjlx  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicZjlx>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicZjlx> dicZjlx() {
		return kjDicZjlxDao.findAll();
	}
	
	/**  
	*  方法名： dicZzmm  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicZzmm>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicZzmm> dicZzmm() {
		return kjDicZzmmDao.findAll();
	}
	
	/**  
	*  方法名： dicZwjb  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicZwjb>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicZwjb> dicZwjb() {
		return kjDicZwjbDao.findAll();
	}
	
	/**  
	*  方法名： dicMzdm  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicMzdm>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicMzdm> dicMzdm() {
		return kjDicMzdmDao.findAll();
	}
	
	/**  
	*  方法名： dicTsfl  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<KjDicTsfl>  
	*  作    者 ： wang  
	*  @throws  
	*/
	public List<KjDicTsfl> dicTsfl(KjDicTsfl ts) {
		return kjDicTsflDao.findAllByZtlm(ts.getZtlm());
	}
	
}
