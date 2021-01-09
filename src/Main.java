
import java.util.Random;

//Christopher Valerio
public class Main {

	public static void main(String[] args) {
		Radix temp = new Radix();
		Random ran = new Random();

		int[] a = { ran.nextInt(10000), ran.nextInt(10000), ran.nextInt(1000), ran.nextInt(1000), ran.nextInt(1000),
				ran.nextInt(1000) };
		System.out.println("Originally Unsorted Array:");
		for (int i : a) {
			System.out.println(i);
		}

		temp.sort(a);

		System.out.println("\nArray After Radix Sort:");
		for (int i : a) {
			System.out.println(i);
		}
	}

}
