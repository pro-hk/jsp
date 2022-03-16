package com.prohk.front;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	// ������ �ư� ������������ ����
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
	
	// �𵨿� ������ ���
	public void addObject(String key, Object object) {
		model.put(key, object);
	}
}
