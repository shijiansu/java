package tarena.day03_syntax;

public class IfTest {
	public static void main(String[] args) {
		int power1 = 100;// 一日丧命散的power
		int power2 = 80;// 含笑半步颠
		if (power1 > power2) {
			System.out.println("唐伯虎吃了一日丧命散");
			System.out.println("唐伯虎一日丧命");
		} else {
			System.out.println("唐伯虎没有吃一日丧命散");
			System.out.println("唐伯虎没有一日丧命");
		}
		System.out.println("==========================");
		if (power1 > power2) {
			System.out.println("唐伯虎吃了一日丧命散");
		}
		System.out.println("==========================");
		int i = 0;// 天气 0：晴 1：阴 2：多云 3： 下雨
		if (i == 0) {// boolean
			System.out.println("爬山");
		} else if (i == 1) {
			System.out.println("踢球");
		} else if (i == 2) {
			System.out.println("约会");
		} else if (i == 3) {
			System.out.println("睡觉");
		} else {
			System.out.println("上班");
		}
		System.out.println("===========================");

		int a = 2;
		if (a < 0) {
			System.out.println("a<0");
		} else if (a < 3) {
			System.out.println("a<3");
		} else if (a < 4) {
			System.out.println("a<4");
		}
	}
}