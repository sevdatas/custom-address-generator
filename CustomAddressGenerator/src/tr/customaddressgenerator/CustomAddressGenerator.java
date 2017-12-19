package tr.customaddressgenerator;

public class CustomAddressGenerator {

	public static void main(String[] args) {

		int threadNumber = Runtime.getRuntime().availableProcessors() + 1;
		for (int i = 0; i < threadNumber; i++) {
			Generator generator = new Generator(i);
			generator.start();
		}
	}

}
