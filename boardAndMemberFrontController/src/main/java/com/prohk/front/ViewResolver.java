package com.prohk.front;

public class ViewResolver {
	private String prefix; // 접두어
	private String suffix; // 접미어
	
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
