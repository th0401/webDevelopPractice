package practice;

public class MyBeanFactory {
	
	public Object getBean(String beanName) {
		if(beanName.equals("Sony")||beanName.equals("sony")||beanName.equals("�Ҵ�")) {
			return new Sony();
		}
		else if(beanName.equals("Cannon")||beanName.equals("cannon")||beanName.equals("�ɳ�")) {
			return new Cannon();
		}
		System.out.println("Ȯ��");
		return null;
	}
}
