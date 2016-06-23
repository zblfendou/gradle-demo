package cn.spring.rest.client.test;

import java.io.Serializable;

public class ResultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String websiteCode;
	private String operation;
	private String flowUUID;
	private String message;
	private String code;//0成功、1失败
	private Boolean success;
	private String invokeSource;//调用端标识(BOSS、会员中心)
	private String productInstanceCode;//区分手机版、PC版的编码
	private String orderId;//订单ID
	private String param;//清除缓存传入的参数
	private String makeDomainResult;
	private String productDomainResult;
	private String refSiteCode;    //	客户端传入的网站标识，和实际网站对应

	public String getWebsiteCode () {
		return websiteCode;
	}

	public void setWebsiteCode (String websiteCode) {
		this.websiteCode = websiteCode;
	}

	public String getOperation () {
		return operation;
	}

	public void setOperation (String operation) {
		this.operation = operation;
	}

	public String getFlowUUID () {
		return flowUUID;
	}

	public void setFlowUUID (String flowUUID) {
		this.flowUUID = flowUUID;
	}

	public String getMessage () {
		return message;
	}

	public void setMessage (String message) {
		this.message = message;
	}

	public String getCode () {
		return code;
	}

	public void setCode (String code) {
		this.code = code;
	}

	public Boolean getSuccess () {
		return success;
	}

	public void setSuccess (Boolean success) {
		this.success = success;
	}

	public String getInvokeSource () {
		return invokeSource;
	}

	public void setInvokeSource (String invokeSource) {
		this.invokeSource = invokeSource;
	}

	public String getProductInstanceCode () {
		return productInstanceCode;
	}

	public void setProductInstanceCode (String productInstanceCode) {
		this.productInstanceCode = productInstanceCode;
	}

	public String getOrderId () {
		return orderId;
	}

	public void setOrderId (String orderId) {
		this.orderId = orderId;
	}

	public String getParam () {
		return param;
	}

	public void setParam (String param) {
		this.param = param;
	}

	public String getMakeDomainResult () {
		return makeDomainResult;
	}

	public void setMakeDomainResult (String makeDomainResult) {
		this.makeDomainResult = makeDomainResult;
	}

	public String getProductDomainResult () {
		return productDomainResult;
	}

	public void setProductDomainResult (String productDomainResult) {
		this.productDomainResult = productDomainResult;
	}

	public String getRefSiteCode () {
		return refSiteCode;
	}

	public void setRefSiteCode (String refSiteCode) {
		this.refSiteCode = refSiteCode;
	}
}
