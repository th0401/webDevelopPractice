package practice;

public class MyBeanFactory {
	
	public Object getBean(String beanName) {
		if(beanName.equals("Sony")||beanName.equals("sony")||beanName.equals("소니")) {
			return new Sony();
		}
		else if(beanName.equals("Cannon")||beanName.equals("cannon")||beanName.equals("케논")) {
			return new Cannon();
		}
		System.out.println("확인");
		return null;
	}
}
