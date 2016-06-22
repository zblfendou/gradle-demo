package cn.spring.rest.client.test;

public class FlowVo {
	private String websiteCode;//网站码
	private String operation;//操作类型
	private String flowUUID;
	private String oldDesignerName;
	private String designerName;
	private String industryId;//行业ID
	private String domain;//主域名
	private String tmplId;//模板ID
	private String makeDomain;//制作期域名
	private String productDomain;//产品期域名
	private String mobileDomain;//手机版域名
	private String invokeSource;//调用端标识(BOSS、会员中心)
	private String language;//语言版本
	private String productInstanceCode;//区分手机版、PC版的编码
	private String orderId;//订单ID
	private String resourceType;//池子类型
	private String operSiteMark;//1:pc , 2:mobile , 9:all


	public String getWebsiteCode() {
		return websiteCode;
	}

	public void setWebsiteCode(String websiteCode) {
		this.websiteCode = websiteCode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getFlowUUID() {
		return flowUUID;
	}

	public void setFlowUUID(String flowUUID) {
		this.flowUUID = flowUUID;
	}

	public String getOldDesignerName() {
		return oldDesignerName;
	}

	public void setOldDesignerName(String oldDesignerName) {
		this.oldDesignerName = oldDesignerName;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getTmplId() {
		return tmplId;
	}

	public void setTmplId(String tmplId) {
		this.tmplId = tmplId;
	}

	public String getMakeDomain() {
		return makeDomain;
	}

	public void setMakeDomain(String makeDomain) {
		this.makeDomain = makeDomain;
	}

	public String getProductDomain() {
		return productDomain;
	}

	public void setProductDomain(String productDomain) {
		this.productDomain = productDomain;
	}

	public String getMobileDomain() {
		return mobileDomain;
	}

	public void setMobileDomain(String mobileDomain) {
		this.mobileDomain = mobileDomain;
	}

	public String getInvokeSource() {
		return invokeSource;
	}

	public void setInvokeSource(String invokeSource) {
		this.invokeSource = invokeSource;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getProductInstanceCode() {
		return productInstanceCode;
	}

	public void setProductInstanceCode(String productInstanceCode) {
		this.productInstanceCode = productInstanceCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getOperSiteMark() {
		return operSiteMark;
	}

	public void setOperSiteMark(String operSiteMark) {
		this.operSiteMark = operSiteMark;
	}
}
