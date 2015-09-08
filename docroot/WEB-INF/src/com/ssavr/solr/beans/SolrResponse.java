package com.ssavr.solr.beans;

import org.apache.solr.client.solrj.beans.Field;

public class SolrResponse {
	
	public String getEntryClassPK() {
		return entryClassPK;
	}

	public void setEntryClassPK(String entryClassPK) {
		this.entryClassPK = entryClassPK;
	}

	public String getIceCreamFlavor() {
		return iceCreamFlavor;
	}

	public void setIceCreamFlavor(String iceCreamFlavor) {
		this.iceCreamFlavor = iceCreamFlavor;
	}

	public String getIceCreamName() {
		return iceCreamName;
	}

	public void setIceCreamName(String iceCreamName) {
		this.iceCreamName = iceCreamName;
	}

	@Field
	private String entryClassPK;
	@Field
	private String iceCreamFlavor;
	@Field
	private String iceCreamName;
}
