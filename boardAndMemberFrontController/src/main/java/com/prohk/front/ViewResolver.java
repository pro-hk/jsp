package com.prohk.front;

public class ViewResolver {
	private String prefix; // ���ξ�
	private String suffix; // ���̾�
	
	public ViewResolver() {
		super();
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getViewPage(String nextPage) {
		return prefix + nextPage + suffix;
	}
}
