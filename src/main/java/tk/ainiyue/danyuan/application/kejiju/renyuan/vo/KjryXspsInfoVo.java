package tk.ainiyue.danyuan.application.kejiju.renyuan.vo;

import tk.ainiyue.danyuan.application.common.base.Pagination;
import tk.ainiyue.danyuan.application.kejiju.renyuan.po.KjryXspsInfo;

/**    
*  文件名 ： KjryXspsInfoVo.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.renyuan.vo  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午11:26:35  
*  版    本 ： V1.0    
*/
public class KjryXspsInfoVo extends Pagination<KjryXspsInfo> {
	KjryXspsInfo info = new KjryXspsInfo();
	
	/**  
	 *  方法名 ： getInfo 
	 *  功    能 ： 返回变量 info 的值  
	 *  @return: KjryXspsInfo 
	 */
	public KjryXspsInfo getInfo() {
		return info;
	}
	
	/**  
	 *  方法名 ： setInfo 
	 *  功    能 ： 设置变量 info 的值
	 */
	public void setInfo(KjryXspsInfo info) {
		this.info = info;
	}
	
}
