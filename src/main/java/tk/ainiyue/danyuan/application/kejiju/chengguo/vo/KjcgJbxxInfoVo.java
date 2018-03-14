package tk.ainiyue.danyuan.application.kejiju.chengguo.vo;

import tk.ainiyue.danyuan.application.common.base.Pagination;
import tk.ainiyue.danyuan.application.kejiju.chengguo.po.KjcgJbxxInfo;

/**    
*  文件名 ： KjcgJbxxInfoVo.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.chengguo.vo  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月1日 下午11:08:33  
*  版    本 ： V1.0    
*/
public class KjcgJbxxInfoVo extends Pagination<KjcgJbxxInfo> {
	private String	completedDate;
	private String	projectName;
	private String	resultType;
	
	private String	date1;
	private String	date2;
	
	/** 
	*  方法名 ： toString
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see java.lang.Object#toString()  
	*  作    者 ： wang  
	*/
	
	@Override
	public String toString() {
		return "KjcgJbxxInfoVo [completedDate=" + completedDate + ", projectName=" + projectName + ", resultType=" + resultType + ", date1=" + date1 + ", date2=" + date2 + "]";
	}
	
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
	 *  方法名 ： getCompletedDate 
	 *  功    能 ： 返回变量 completedDate 的值  
	 *  @return: String 
	 */
	public String getCompletedDate() {
		return completedDate;
	}
	
	/**  
	 *  方法名 ： setCompletedDate 
	 *  功    能 ： 设置变量 completedDate 的值
	 */
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
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
	 *  方法名 ： getResultType 
	 *  功    能 ： 返回变量 resultType 的值  
	 *  @return: String 
	 */
	public String getResultType() {
		return resultType;
	}
	
	/**  
	 *  方法名 ： setResultType 
	 *  功    能 ： 设置变量 resultType 的值
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	
}
