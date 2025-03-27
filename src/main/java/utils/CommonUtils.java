package utils;

public class CommonUtils {

	public static void hWait(long time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException i) {
			System.out.println(i.toString());
		}
	}
}
