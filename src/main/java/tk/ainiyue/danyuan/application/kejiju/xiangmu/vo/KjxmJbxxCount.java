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
public class KjxmJbxxCount extends Pagination<KjxmJbxxInfo> {
	// ，地区、部门、领域、机构类型、年份，立项情况、经费情况、承担单位性质、
	// 负责人支撑、负责人学位、负责人年龄、
	// 项目状态、项目领域
	private Integer	numbers;
	private String	projectDomain;
	private String	approvalYear;
	private String	headEducation;
	
	/**  
	 *  方法名 ： getNumbers 
	 *  功    能 ： 返回变量 numbers 的值  
	 *  @return: Integer 
	 */
	public Integer getNumbers() {
		return numbers;
	}
	
	/**  
	 *  方法名 ： setNumbers 
	 *  功    能 ： 设置变量 numbers 的值
	 */
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
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
	
	/**  
	 *  方法名 ： getHeadEducation 
	 *  功    能 ： 返回变量 headEducation 的值  
	 *  @return: String 
	 */
	public String getHeadEducation() {
		return headEducation;
	}
	
	/**  
	 *  方法名 ： setHeadEducation 
	 *  功    能 ： 设置变量 headEducation 的值
	 */
	public void setHeadEducation(String headEducation) {
		this.headEducation = headEducation;
	}
	
}
