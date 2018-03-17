package tk.ainiyue.danyuan.application.kejiju.chengguo.vo;

import java.util.List;

/**    
*  文件名 ： Flare.java  
*  包    名 ： tk.ainiyue.danyuan.application.kejiju.chengguo.vo  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年3月17日 下午3:16:11  
*  版    本 ： V1.0    
*/
public class Flare {
	public String	name;
	public Integer	value;
	List<Flare>		children;
	
	/**  
	 *  方法名 ： getName 
	 *  功    能 ： 返回变量 name 的值  
	 *  @return: String 
	 */
	public String getName() {
		return name;
	}
	
	/**  
	 *  方法名 ： setName 
	 *  功    能 ： 设置变量 name 的值
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**  
	 *  方法名 ： getValue 
	 *  功    能 ： 返回变量 value 的值  
	 *  @return: Integer 
	 */
	public Integer getValue() {
		return value;
	}
	
	/**  
	 *  方法名 ： setValue 
	 *  功    能 ： 设置变量 value 的值
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	
	/**  
	 *  方法名 ： getChildren 
	 *  功    能 ： 返回变量 children 的值  
	 *  @return: List<Flare> 
	 */
	public List<Flare> getChildren() {
		return children;
	}
	
	/**  
	 *  方法名 ： setChildren 
	 *  功    能 ： 设置变量 children 的值
	 */
	public void setChildren(List<Flare> children) {
		this.children = children;
	}
	
}
