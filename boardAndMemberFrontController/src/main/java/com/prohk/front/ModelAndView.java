package com.prohk.front;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	// 데이터 싣고 다음페이지로 연결
	private String nextPage;
	private Map<String, Object> model = new HashMap<>();
	
	public ModelAndView() {}

	public ModelAndView(String nextPage) {
		super();
		this.nextPage = nextPage;
	}

	public ModelAndView(String nextPage, String key, Object object) {
		setNextPage(nextPage);
		addObject(key, object);
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	// 모델에 데이터 담기
	public void addObject(String key, Object object) {
		model.put(key, object);
	}
}
