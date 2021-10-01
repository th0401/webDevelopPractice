package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component("champ")
public class Champ implements ChampAction {
	private String name;
	private List<String> inven;
	//@Autowired // �����̳ʴ� �ڽ��� �����ξ��� ��ü���� "Ÿ��"�� Ȯ��!
	@Resource(name="bow")
	private Weapon weapon;
	
	@Override
	public void attack() {
		weapon.attack();
		// ���������ͼ���(����) �߻������������, new �߾���ߴ�!
		// -> ��������� ó��, ������ ����
		// -> setter �������� ����(�⺻ �����ڰ� �ʿ�!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for(String v:inven) {
			System.out.println(v);
		}
	}
}
