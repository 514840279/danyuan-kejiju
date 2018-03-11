package tk.ainiyue.danyuan.application.file.upload.vo;

import tk.ainiyue.danyuan.application.common.base.Pagination;
import tk.ainiyue.danyuan.application.file.upload.po.SysFileUploadInfo;

/**    
*  文件名 ： SysFileUploadVo.java  
*  包    名 ： tk.ainiyue.danyuan.application.file.upload.vo  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月11日 下午6:47:32  
*  版    本 ： V1.0    
*/
public class SysFileUploadVo extends Pagination<SysFileUploadInfo> {
	private String discription;
	
	/**  
	 *  方法名 ： getDiscription 
	 *  功    能 ： 返回变量 discription 的值  
	 *  @return: String 
	 */
	public String getDiscription() {
		return discription;
	}
	
	/**  
	 *  方法名 ： setDiscription 
	 *  功    能 ： 设置变量 discription 的值
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
}
