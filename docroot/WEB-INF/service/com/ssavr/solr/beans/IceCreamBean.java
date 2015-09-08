package com.ssavr.solr.beans;

import java.util.List;

public class IceCreamBean {

	public IceCreamBean() {
		super();
	}
	
	public IceCreamBean(String uid, long companyId,long iceCreamId) {
		super();
		this.uid = uid;
		this.companyId = companyId;
		this.iceCreamId = iceCreamId;		
	}

	public IceCreamBean(String uid, long companyId,long iceCreamId,
			List<String> iceCreamRecipeContent) {
		super();
		this.uid = uid;
		this.companyId = companyId;
		this.iceCreamId = iceCreamId;
		this.iceCreamRecipeContent = iceCreamRecipeContent;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public List<String> getIceCreamRecipeContent() {
		return iceCreamRecipeContent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public void setIceCreamRecipeContent(List<String> iceCreamRecipeContent) {
		this.iceCreamRecipeContent = iceCreamRecipeContent;
	}
	
	public void setIceCreamId(long iceCreamId){
		this.iceCreamId = iceCreamId;
	}
	
	public Long getIceCreamId() {
		return iceCreamId;
	}

	@Override
	public String toString() {
		return "IceCreamBean [uid=" + uid + ", iceCreamId=" + iceCreamId
				+ ", companyId=" + companyId + ", iceCreamRecipeContent="
				+ iceCreamRecipeContent + "]";
	}

	private String uid;
	private long iceCreamId;
	private long companyId;
	private String name;
	private String flavor;
	private List<String> iceCreamRecipeContent;
	
}
