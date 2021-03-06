package tk.ainiyue.danyuan.application.kejiju.xiangmu.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the kjxm_dwxx_info database table.
 * 
 */
@Entity
@Table(name = "kjxm_dwxx_info")
@NamedQuery(name = "KjxmDwxxInfo.findAll", query = "SELECT k FROM KjxmDwxxInfo k")
public class KjxmDwxxInfo implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	@Id
	private String				uuid;
	
	// 单位开户名称
	@Column(name = "account_name")
	private String				accountName;
	
	// 开户行账号
	@Column(name = "bank_account")
	private String				bankAccount;
	
	// 开户行名称
	@Column(name = "bank_name")
	private String				bankName;
	
	// 合作单位
	@Column(name = "coop_organization")
	private String				coopOrganization;
	
	// 合作单位组织机构代码
	@Column(name = "coop_organization_code")
	private String				coopOrganizationCode;
	
	// 合作单位传真
	@Column(name = "coop_organization_fax")
	private String				coopOrganizationFax;
	
	// 合作单位排序号
	@Column(name = "coop_organization_id")
	private String				coopOrganizationId;
	
	// 合作单位性质
	@Column(name = "coop_organization_property")
	private String				coopOrganizationProperty;
	
	// 合作单位电话 
	@Column(name = "coop_organization_telephone")
	private String				coopOrganizationTelephone;
	
	// 合作单位统一 社会信用代码
	@Column(name = "coop_organization_uscc")
	private String				coopOrganizationUscc;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date				createTime;
	
	@Column(name = "create_user")
	private String				createUser;
	
	// 主承担法人单位
	@Column(name = "main_impersonal_entity")
	private String				mainImpersonalEntity;
	
	// 主承担单位
	@Column(name = "main_organization")
	private String				mainOrganization;
	
	// 主承担单位 通讯地址
	@Column(name = "main_organization_address")
	private String				mainOrganizationAddress;
	
	// 主承担单位上级管理部门
	@Column(name = "main_organization_administration")
	private String				mainOrganizationAdministration;
	
	// 主承担单位组织机构代码
	@Column(name = "main_organization_code")
	private String				mainOrganizationCode;
	
	// 主承担单位电子邮箱
	@Column(name = "main_organization_email")
	private String				mainOrganizationEmail;
	
	// 主承担单位传真
	@Column(name = "main_organization_fax")
	private String				mainOrganizationFax;
	
	// 主承担单位所在地区
	@Column(name = "main_organization_location")
	private String				mainOrganizationLocation;
	
	// 主承担单位邮政编码
	@Column(name = "main_organization_postcode")
	private String				mainOrganizationPostcode;
	
	// 主承担单位性质
	@Column(name = "main_organization_property")
	private String				mainOrganizationProperty;
	
	// 主承担单位推荐部门
	@Column(name = "main_organization_recommend_unit")
	private String				mainOrganizationRecommendUnit;
	
	// 主承担单位电话
	@Column(name = "main_organization_telephone")
	private String				mainOrganizationTelephone;
	
	// 主承担单位统 一社会信用代码
	@Column(name = "main_organization_uscc")
	private String				mainOrganizationUscc;
	
	@Transient
	private String				xmjbUuid;
	
	//bi-directional many-to-one association to KjxmJbxxInfo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "xmjb_uuid")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private KjxmJbxxInfo		kjxmJbxxInfo;
	
	public KjxmDwxxInfo() {
	}
	
	public String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getAccountName() {
		return this.accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public String getBankName() {
		return this.bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getCoopOrganization() {
		return this.coopOrganization;
	}
	
	public void setCoopOrganization(String coopOrganization) {
		this.coopOrganization = coopOrganization;
	}
	
	public String getCoopOrganizationCode() {
		return this.coopOrganizationCode;
	}
	
	public void setCoopOrganizationCode(String coopOrganizationCode) {
		this.coopOrganizationCode = coopOrganizationCode;
	}
	
	public String getCoopOrganizationFax() {
		return this.coopOrganizationFax;
	}
	
	public void setCoopOrganizationFax(String coopOrganizationFax) {
		this.coopOrganizationFax = coopOrganizationFax;
	}
	
	public String getCoopOrganizationId() {
		return this.coopOrganizationId;
	}
	
	public void setCoopOrganizationId(String coopOrganizationId) {
		this.coopOrganizationId = coopOrganizationId;
	}
	
	public String getCoopOrganizationProperty() {
		return this.coopOrganizationProperty;
	}
	
	public void setCoopOrganizationProperty(String coopOrganizationProperty) {
		this.coopOrganizationProperty = coopOrganizationProperty;
	}
	
	public String getCoopOrganizationTelephone() {
		return this.coopOrganizationTelephone;
	}
	
	public void setCoopOrganizationTelephone(String coopOrganizationTelephone) {
		this.coopOrganizationTelephone = coopOrganizationTelephone;
	}
	
	public String getCoopOrganizationUscc() {
		return this.coopOrganizationUscc;
	}
	
	public void setCoopOrganizationUscc(String coopOrganizationUscc) {
		this.coopOrganizationUscc = coopOrganizationUscc;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateUser() {
		return this.createUser;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getMainImpersonalEntity() {
		return this.mainImpersonalEntity;
	}
	
	public void setMainImpersonalEntity(String mainImpersonalEntity) {
		this.mainImpersonalEntity = mainImpersonalEntity;
	}
	
	public String getMainOrganization() {
		return this.mainOrganization;
	}
	
	public void setMainOrganization(String mainOrganization) {
		this.mainOrganization = mainOrganization;
	}
	
	public String getMainOrganizationAddress() {
		return this.mainOrganizationAddress;
	}
	
	public void setMainOrganizationAddress(String mainOrganizationAddress) {
		this.mainOrganizationAddress = mainOrganizationAddress;
	}
	
	public String getMainOrganizationAdministration() {
		return this.mainOrganizationAdministration;
	}
	
	public void setMainOrganizationAdministration(String mainOrganizationAdministration) {
		this.mainOrganizationAdministration = mainOrganizationAdministration;
	}
	
	public String getMainOrganizationCode() {
		return this.mainOrganizationCode;
	}
	
	public void setMainOrganizationCode(String mainOrganizationCode) {
		this.mainOrganizationCode = mainOrganizationCode;
	}
	
	public String getMainOrganizationEmail() {
		return this.mainOrganizationEmail;
	}
	
	public void setMainOrganizationEmail(String mainOrganizationEmail) {
		this.mainOrganizationEmail = mainOrganizationEmail;
	}
	
	public String getMainOrganizationFax() {
		return this.mainOrganizationFax;
	}
	
	public void setMainOrganizationFax(String mainOrganizationFax) {
		this.mainOrganizationFax = mainOrganizationFax;
	}
	
	public String getMainOrganizationLocation() {
		return this.mainOrganizationLocation;
	}
	
	public void setMainOrganizationLocation(String mainOrganizationLocation) {
		this.mainOrganizationLocation = mainOrganizationLocation;
	}
	
	public String getMainOrganizationPostcode() {
		return this.mainOrganizationPostcode;
	}
	
	public void setMainOrganizationPostcode(String mainOrganizationPostcode) {
		this.mainOrganizationPostcode = mainOrganizationPostcode;
	}
	
	public String getMainOrganizationProperty() {
		return this.mainOrganizationProperty;
	}
	
	public void setMainOrganizationProperty(String mainOrganizationProperty) {
		this.mainOrganizationProperty = mainOrganizationProperty;
	}
	
	public String getMainOrganizationRecommendUnit() {
		return this.mainOrganizationRecommendUnit;
	}
	
	public void setMainOrganizationRecommendUnit(String mainOrganizationRecommendUnit) {
		this.mainOrganizationRecommendUnit = mainOrganizationRecommendUnit;
	}
	
	public String getMainOrganizationTelephone() {
		return this.mainOrganizationTelephone;
	}
	
	public void setMainOrganizationTelephone(String mainOrganizationTelephone) {
		this.mainOrganizationTelephone = mainOrganizationTelephone;
	}
	
	public String getMainOrganizationUscc() {
		return this.mainOrganizationUscc;
	}
	
	public void setMainOrganizationUscc(String mainOrganizationUscc) {
		this.mainOrganizationUscc = mainOrganizationUscc;
	}
	
	public KjxmJbxxInfo getKjxmJbxxInfo() {
		return this.kjxmJbxxInfo;
	}
	
	public void setKjxmJbxxInfo(KjxmJbxxInfo kjxmJbxxInfo) {
		this.kjxmJbxxInfo = kjxmJbxxInfo;
	}
	
	/**  
	 *  方法名 ： getXmjbUuid 
	 *  功    能 ： 返回变量 xmjbUuid 的值  
	 *  @return: String 
	 */
	public String getXmjbUuid() {
		return xmjbUuid;
	}
	
	/**  
	 *  方法名 ： setXmjbUuid 
	 *  功    能 ： 设置变量 xmjbUuid 的值
	 */
	public void setXmjbUuid(String xmjbUuid) {
		this.xmjbUuid = xmjbUuid;
	}
	
	/** 
	*  方法名 ： toString
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see java.lang.Object#toString()  
	*  作    者 ： Administrator  
	*/
	
	@Override
	public String toString() {
		return "KjxmDwxxInfo [uuid=" + uuid + ", accountName=" + accountName + ", bankAccount=" + bankAccount + ", bankName=" + bankName + ", coopOrganization=" + coopOrganization + ", coopOrganizationCode=" + coopOrganizationCode + ", coopOrganizationFax=" + coopOrganizationFax + ", coopOrganizationId=" + coopOrganizationId + ", coopOrganizationProperty=" + coopOrganizationProperty + ", coopOrganizationTelephone=" + coopOrganizationTelephone + ", coopOrganizationUscc=" + coopOrganizationUscc + ", createTime=" + createTime + ", createUser=" + createUser + ", mainImpersonalEntity=" + mainImpersonalEntity + ", mainOrganization=" + mainOrganization + ", mainOrganizationAddress=" + mainOrganizationAddress + ", mainOrganizationAdministration=" + mainOrganizationAdministration + ", mainOrganizationCode=" + mainOrganizationCode + ", mainOrganizationEmail=" + mainOrganizationEmail + ", mainOrganizationFax=" + mainOrganizationFax + ", mainOrganizationLocation=" + mainOrganizationLocation + ", mainOrganizationPostcode=" + mainOrganizationPostcode + ", mainOrganizationProperty=" + mainOrganizationProperty + ", mainOrganizationRecommendUnit=" + mainOrganizationRecommendUnit + ", mainOrganizationTelephone=" + mainOrganizationTelephone + ", mainOrganizationUscc=" + mainOrganizationUscc + ", xmjbUuid=" + xmjbUuid + ", kjxmJbxxInfo=" + kjxmJbxxInfo + "]";
	}
	
}