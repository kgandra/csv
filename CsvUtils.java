import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class CsvUtils
{
	//Delimiter used in CSV file
	final static String COMMA_DELIMITER = ",";
	final static String NEW_LINE_SEPARATOR = "\n";
			
	//CSV file header
	static final String FILE_HEADER = "name,price,amount,composition,colour,expiryDate,shade,brand,state,endOfRow";
	
	private static final String rowEnd = "rowend";
	
	//Product attributes index
	private static final int PRODUCT_NAME = 0;
	private static final int PRODUCT_PRICE = 1;
	private static final int PRODUCT_AMOUNT = 2;
	private static final int PRODUCT_COMPOSITION = 3;
	private static final int PRODUCT_COLOUR = 4;
	private static final int PRODUCT_EXPIRYDATE = 5;
	private static final int PRODUCT_SHADE = 6;
	private static final int PRODUCT_BRAND = 7;
	private static final int PRODUCT_STATE = 8;
	
	static void wriToCsv(String fileName)
	{
		UtilsBean bean1 = new UtilsBean("powder",100,"10","abc","fair","2/14/2018","","","");
		UtilsBean bean2 = new UtilsBean("powder",200,"10","abc","wheat","2/10/2018","","","");
		UtilsBean bean3 = new UtilsBean("lipstick",100,"","","","","pink","revlon","solid");
		UtilsBean bean4 = new UtilsBean("lipstick",200,"","","","","orange","colorbar","solid");
		
		ArrayList<UtilsBean> list = new ArrayList<UtilsBean>();
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		list.add(bean4);
		
		FileWriter fileWriter = null;
		
		try
		{
			fileWriter = new FileWriter(fileName);
			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			for(UtilsBean bean : list)
			{
				fileWriter.append(bean.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(bean.getPrice()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(bean.getAmount()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(bean.getComposition());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(bean.getColour());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(bean.getExpiryDate());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(bean.getShade());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(bean.getBrand());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(bean.getShade());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(rowEnd);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully !!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileWriter.flush();
				fileWriter.close();
			}
			catch(IOException e)
			{
				System.out.println("Error while flushing/closing the writer");
				e.printStackTrace();
			}
		}
	}
	static void ReadFromCsv(String fileName, String inputProduct)
	{
		BufferedReader fileReader = null;
		try
		{
			ArrayList<UtilsBean> list = new ArrayList<UtilsBean>();
			String line = "";
			//Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));
			//Read the CSV file header to skip it
			fileReader.readLine();
			//Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null)
			{
				//Get all tokens available in line
				String[] tokens = line.split(COMMA_DELIMITER);
				System.out.println("Token count : " + tokens.length);
				if (tokens.length > 0)
				{
					String product = tokens[PRODUCT_NAME];
					if(product.equalsIgnoreCase(inputProduct))
					{
						UtilsBean bean = new UtilsBean(tokens[PRODUCT_NAME],
								   Integer.parseInt(tokens[PRODUCT_PRICE]),
								   tokens[PRODUCT_AMOUNT],
								   tokens[PRODUCT_COMPOSITION],
								   tokens[PRODUCT_COLOUR],
								   tokens[PRODUCT_EXPIRYDATE],
								   tokens[PRODUCT_SHADE],
								   tokens[PRODUCT_BRAND],
								   tokens[PRODUCT_STATE]);
						list.add(bean);
					}
				}
			}
			if(list != null && list.size() > 0)
			{
				UtilsBean maxBean = Collections.max(list);
				for(UtilsBean bean : list)
				{
					System.out.println(bean.toString());
				}
				System.out.println("Expensive product");
				System.out.println(maxBean);
			}
			else
			{
				System.out.println("No such product available");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileReader.close();
			}
			catch(IOException e)
			{
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
	}
}
