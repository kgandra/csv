import java.util.Scanner;

public class CsvClient {

	public static void main(String[] args)
	{
		// System.getProperty("user.home") will be the home directory of the current logged in user --> c:\Users\${current_user_name}
		System.out.println("user home : " + System.getProperty("user.home"));
		String fileName = System.getProperty("user.home") + "/product.csv";
		System.out.println("Write CSV file:");
		CsvUtils.wriToCsv(fileName);
		System.out.println("Enter the product name : ");
		Scanner s = new Scanner(System.in);
		String product = s.nextLine();
		System.out.println("\nRead CSV file:");
		CsvUtils.ReadFromCsv(fileName,product);
	}
}
