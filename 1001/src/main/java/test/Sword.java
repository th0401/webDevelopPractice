package test;

// <bean class="test.Sword" id="sword"> �� ������ @Component
// @Component("sword")
public class Sword implements Weapon{

	@Override
	public void attack() {
		System.out.println("������ ����!");
	}

}

