//package vote.advanced;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeMap;

public class FileWrite {

	Calendar calendar 				= new GregorianCalendar();

	static BufferedReader reader 	= null;

	public static void main(String[] args) {

		String runType = args[0];
		String writableData = "";
		String bDayFileName = "C:/Users/admin/Desktop/BirthDayReminder.txt";
		String amountFileName = "C:/Users/admin/Desktop/AmountReminder.txt";
		boolean writableStatus = false;
		try {
			System.out.println("\nPrakash Welcomes U All......");
			if(runType != null && runType.trim().equalsIgnoreCase("write")){
				reader = new BufferedReader(new InputStreamReader(System.in));
				int ch = 0;
				main:for(int m = 0; m < 1; m++){
					System.out.println("\t\t Menu");
					System.out.println("\t1. Add BirthDay");
					System.out.println("\t2. Add Amount");
					System.out.println("\t3. Exit");
					System.out.print("Choose Ur Choice Either (1/2/3) : ");

					try{
						ch = Integer.parseInt(reader.readLine());
					}catch(Exception e){
						System.out.println("Enter Choice as Number");
						m--;
						continue main;
					}
					switch(ch){

						case 1: loop1:for(int i = 0; i < 1; i++){
								writableData = "";
								System.out.println();
								System.out.print("Enter Person Name                   : ");
								String name = reader.readLine();
								boolean status = name.matches("[a-zA-Z ]{3,30}");
								if(!status || name == null || (name != null && name.trim().equals(""))){
									System.out.println("Enter Valid Name Only");
									i--;
									continue loop1;
								}
								System.out.print("Enter Date of Birth (Ex: 14/02/1988): ");
								String dob = reader.readLine();
								status = dob.matches("[0-9/]{10}");
								if(!status || dob == null || (dob != null && dob.trim().equals(""))){
									System.out.println("Enter Valid Date Of Birth Only");
									i--;
									continue loop1;
								}
								writableData += name.trim() + "#" + dob.trim() + "$";
								loop2:for(int j = 0; j < 1; j++){
									System.out.println();
									System.out.print("Do u want to Add Another One (Y/N)? : ");
									String need = reader.readLine();
									if(need != null && (need.trim().equalsIgnoreCase("y") || need.trim().equalsIgnoreCase("yes"))){
										i--;
										continue loop1;
									}else if(need != null && (need.trim().equalsIgnoreCase("n") || need.trim().equalsIgnoreCase("no"))){
										writableStatus = writeFile(writableData.trim(), bDayFileName);
									}else{
										j--;
										continue loop2;
									}
								}
							}
							break;
						case 2: loop11:for(int i = 0; i < 1; i++){
								writableData = "";
								System.out.println();
								System.out.print("Enter Person Name                   : ");
								String name = reader.readLine();
								boolean status = name.matches("[a-zA-Z ]{3,30}");
								if(!status || name == null || (name != null && name.trim().equals(""))){
									System.out.println("Enter Valid Name Only");
									i--;
									continue loop11;
								}
								System.out.print("Enter the Amount                    : ");
								String amt = reader.readLine();
								status = amt.matches("[0-9.]{1,20}");
								if(!status || amt == null || (amt != null && amt.trim().equals(""))){
									System.out.println("Enter Valid Amount Only");
									i--;
									continue loop11;
								}
								System.out.print("Enter the Status Credit/Debit (C/D) : ");
								String tranStatus = reader.readLine();
								status = tranStatus.matches("[c-dC-D]{1}");
								if(!status || tranStatus == null || (tranStatus != null && tranStatus.trim().equals(""))){
									System.out.println("Enter Valid Status Only");
									i--;
									continue loop11;
								}
								writableData += name.trim() + "#" + amt.trim() + "#" + tranStatus.trim().toUpperCase() + "$";
								loop12:for(int j = 0; j < 1; j++){
									System.out.println();
									System.out.print("Do u want to Add Another One (Y/N)? : ");
									String need = reader.readLine();
									if(need != null && (need.trim().equalsIgnoreCase("y") || need.trim().equalsIgnoreCase("yes"))){
										i--;
										continue loop11;
									}else if(need != null && (need.trim().equalsIgnoreCase("n") || need.trim().equalsIgnoreCase("no"))){
										writableStatus = writeFile(writableData.trim(), amountFileName);
									}else{
										j--;
										continue loop12;
									}
								}
							}
							break;
						case 3: System.out.println("\n\t Bye");
								break main;
						default: System.out.println("Enter Correct Choice");
								 m--;
								 continue main;
					}
					if(writableStatus){
						System.out.println("Ur Data Successfully Updated");
					}else{
						System.out.println("Updation Failed");
					}
				}
			}else{
				System.out.println("********** BirthDay Reminder ********");
				String[] twoDates = new FileWrite().getTwoDates();
				TreeMap<String, String> friendsList = String2TreeMap(getFile(bDayFileName));
				if(friendsList != null && friendsList.size() > 0){
					System.out.println("\n");
					for(int i = 0; i < twoDates.length; i++){
						if(friendsList.containsKey(twoDates[i])){
							writableStatus = true;
							String friends = friendsList.get(twoDates[i]);
							String[] names = friends.split("\\#");
							System.out.println("BirthDate is "+twoDates[i]);
							String day = i == 0 ? "Today" : "Tomorrow";
							System.out.println(day + " BirthDay Guys are : ");
							for(int j = 0; j < names.length; j++){
								System.out.println(names[j]);
							}
							System.out.println("\n");
						}
					}
					if(!writableStatus){
						System.out.println("There is No Birthday Guys on Today and Tomorrow");
					}
				}
				System.out.println("\n********** Amount Reminder ********");
				String[][] amountData = splitedOutPut(getFile(amountFileName));
				if(amountData != null && amountData.length > 0){
					System.out.println("\nPerson\t\t\tAmount\tStatus\n");
					for(int i = 0; i < amountData.length; i++){
						String st = amountData[i][2];
						st = st != null ? st.trim() : "";
						st = st.trim().equalsIgnoreCase("C") ? "From Him/Her" : st.trim();
						st = st.trim().equalsIgnoreCase("D") ? "To Him/Her" : st.trim();
						System.out.println(amountData[i][0] + "\t\t" + amountData[i][1] + "\t" + st.trim());
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			String a = e.getMessage();
			System.out.println("Exception is " + a);
		}

	}

	// To get Two Dates
	public String[] getTwoDates() {
		String[] date			= new String[2];
		int currentYearDate 	= calendar.get(Calendar.DATE);
		int currentYearMonth 	= calendar.get(Calendar.MONTH)+1;
		int currentYear 		= calendar.get(Calendar.YEAR);

		String data = ((currentYearDate < 10) ? ("0" + String.valueOf(currentYearDate)) : String.valueOf(currentYearDate)) + "/";
		data += (((currentYearMonth < 10) ? ("0" + String.valueOf(currentYearMonth)) : String.valueOf(currentYearMonth)) + "/") + String.valueOf(currentYear);
		date[0] = data;

		if(currentYearDate == 28 && currentYearMonth == 2 && currentYear % 4 != 0){
			currentYearDate = 1;
			currentYearMonth++;
		}else if(currentYearDate == 29 && currentYearMonth == 2 && currentYear % 4 == 0){
			currentYearDate = 1;
			currentYearMonth++;
		}else if(currentYearDate == 30 && ((currentYearMonth % 2 == 0 && currentYearMonth < 7) || (currentYearMonth % 2 != 0 && currentYearMonth > 8))){
			currentYearDate = 1;
			currentYearMonth++;
		}else if(currentYearDate == 31 && ((currentYearMonth % 2 != 0 && currentYearMonth < 8) || (currentYearMonth % 2 == 0 && currentYearMonth > 7))){
			currentYearDate = 1;
			currentYearMonth++;
			if(currentYearMonth == 13){
				currentYearMonth = 1;
				currentYear++;
			}
		}else{
			currentYearDate++;
		}

		data = ((currentYearDate < 10) ? ("0" + String.valueOf(currentYearDate)) : String.valueOf(currentYearDate)) + "/";
		data += (((currentYearMonth < 10) ? ("0" + String.valueOf(currentYearMonth)) : String.valueOf(currentYearMonth)) + "/") + String.valueOf(currentYear);
		date[1] = data;

		if(date != null && date.length > 0){
			return date;
		}
		return null;
	}

	// To Write the Content in to a File
	public static boolean writeFile(String inContent, String fileName){
		boolean status = false;
		try{
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(inContent);
			bw.flush();
			bw.close();
			status = true;
		}catch(FileNotFoundException fi){
			fi.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;

	}

	// To read the Content from the File
	public static String getFile(String fileName){
		String top5 = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			StringBuilder content = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
			top5 = content.toString();
			top5 = top5.substring(0, top5.length() - 1);
		}catch(FileNotFoundException fi){
			fi.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return top5;
	}

	// To Store in TreeMap
	public static TreeMap<String, String> String2TreeMap(String response){
		TreeMap<String, String> outRes = null;
		String[][] res = splitedOutPut(response);
		if(res != null && res.length > 0){
			outRes = new TreeMap<String, String>();
			for(int i = 0; i < res.length; i++){
				if(outRes.size() > 0 && outRes.containsKey(res[i][1])){
					String value = outRes.get(res[i][1]) + "#" + res[i][0];
					outRes.put(res[i][1], value);
				}else{
					outRes.put(res[i][1], res[i][0]);
				}
			}
		}
		return outRes;
	}

	public static String[][] splitedOutPut(String response){
		String[][] finalOutput = null;
		if(response != null && !response.trim().equals("")){
			String[] rowData = response.split("\\$");
			finalOutput = new String[rowData.length][rowData[0].split("\\#").length];
			for(int i = 0; i < rowData.length; i++){
				String[] colData = rowData[i].split("\\#");
				for(int j = 0; j< colData.length; j++){
					finalOutput[i][j] = colData[j];
				}
			}
		}
		return finalOutput;
	}
}