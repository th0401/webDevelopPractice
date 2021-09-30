package test;

import java.util.List;
import java.util.Map;

public class CBean {
	public CBean() {
		System.out.println("CBean 기본생성자 호출");
	}
	
	private List<String> list;

	private Map<String,String> map;
	
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
