package tk.ainiyue.danyuan.application.kejiju.xiangmu.vo;

import tk.ainiyue.danyuan.application.common.base.Pagination;
import tk.ainiyue.danyuan.application.kejiju.xiangmu.po.KjxmJbxxInfo;

/**    
*  文件名 ： KjxmJbxxInfoVo.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.xiangmu.vo  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午10:26:19  
*  版    本 ： V1.0    
*/
public class KjxmJbxxInfoVo extends Pagination<KjxmJbxxInfo> {
	public String	projectName;
	public String	projectDomain;
	public String	projectType;
	public String	region;
	public String	approvalYear;
	private String	date1;
	private String	date2;
	
	/**  
	 *  方法名 ： getDate1 
	 *  功    能 ： 返回变量 date1 的值  
	 *  @return: String 
	 */
	public String getDate1() {
		return date1;
	}
	
	/**  
	 *  方法名 ： setDate1 
	 *  功    能 ： 设置变量 date1 的值
	 */
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	/**  
	 *  方法名 ： getDate2 
	 *  功    能 ： 返回变量 date2 的值  
	 *  @return: String 
	 */
	public String getDate2() {
		return date2;
	}
	
	/**  
	 *  方法名 ： setDate2 
	 *  功    能 ： 设置变量 date2 的值
	 */
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	/**  
	 *  方法名 ： getProjectName 
	 *  功    能 ： 返回变量 projectName 的值  
	 *  @return: String 
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**  
	 *  方法名 ： setProjectName 
	 *  功    能 ： 设置变量 projectName 的值
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	/**  
	 *  方法名 ： getProjectDomain 
	 *  功    能 ： 返回变量 projectDomain 的值  
	 *  @return: String 
	 */
	public String getProjectDomain() {
		return projectDomain;
	}
	
	/**  
	 *  方法名 ： setProjectDomain 
	 *  功    能 ： 设置变量 projectDomain 的值
	 */
	public void setProjectDomain(String projectDomain) {
		this.projectDomain = projectDomain;
	}
	
	/**  
	 *  方法名 ： getProjectType 
	 *  功    能 ： 返回变量 projectType 的值  
	 *  @return: String 
	 */
	public String getProjectType() {
		return projectType;
	}
	
	/**  
	 *  方法名 ： setProjectType 
	 *  功    能 ： 设置变量 projectType 的值
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	/**  
	 *  方法名 ： getRegion 
	 *  功    能 ： 返回变量 region 的值  
	 *  @return: String 
	 */
	public String getRegion() {
		return region;
	}
	
	/**  
	 *  方法名 ： setRegion 
	 *  功    能 ： 设置变量 region 的值
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**  
	 *  方法名 ： getApprovalYear 
	 *  功    能 ： 返回变量 approvalYear 的值  
	 *  @return: String 
	 */
	public String getApprovalYear() {
		return approvalYear;
	}
	
	/**  
	 *  方法名 ： setApprovalYear 
	 *  功    能 ： 设置变量 approvalYear 的值
	 */
	public void setApprovalYear(String approvalYear) {
		this.approvalYear = approvalYear;
	}
	
}
