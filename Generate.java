import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.security.SecureRandom;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;  
public class Generate{
	//passwords should have at least 12 characters (we are gonna limit it to 20 however)
	// a mixutre of both uppercase and lowecase letters
	//a mixture of letters and numbers
	//special characters must be included
	//conditions must be met to make passwords completely
	//different, random
	protected String dir = System.getProperty("user.dir");
	protected File file = new File(dir); //grab the users current working directory
	//and un-predictable. 
	private static void LockFile() { //file encryption
		
	}
	//from google authenticator best practice
	public static String generateSecretKey() {
//	    SecureRandom random = new SecureRandom();
//	    byte[] bytes = new byte[20];
//	    random.nextBytes(bytes);
//	    Base32 base32 = new Base32();
//	    return base32.encodeToString(bytes);
	}
	
	private static void encrpytPath() { //path encrpyio
		
	}
	private static File createDir(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String path = System.getProperty("user.home") + File.separator + "Documents";
		File dir = new File(path);
		dir.mkdir(); //make directory
		//random set of characters for a name

		
		
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		         + "0123456789"
		         + "abcdefghijklmnopqrstuvxyz";
		  StringBuilder sb = new StringBuilder(7);
		for(int i = 0; i < 7; i++) {
			int index
		    = (int)(AlphaNumericString.length()
		      * Math.random());
		   sb.append(AlphaNumericString
		      .charAt(index));
		}
		
		File file = new File(dir, "password list(rename as you see fit) " + sb.toString() + ".txt"); //create file at system directory
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println(dtf.format(now) + " File Created: " + file.getName());
			} else {
				System.out.println("File Already Exists");
			}
		}
		catch(IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		return file;
	}
	private static void password() {
		//how about we create an array of valid special elements and 
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = uppercase.toLowerCase();
		String numerical = "0123456789";
		String symbols = "~`! @#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
		String characters = uppercase + lowercase + numerical + symbols;
		//we just pull from that?
		String[] charlist = characters.split("(?!^)") ;
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < charlist.length; i++) {
			list.add(charlist[i]);
		}
		//random number algorithm
		ArrayList<StringBuilder> passwords = new ArrayList<StringBuilder>();
		SecureRandom rand = new SecureRandom(); //random
		Collections.shuffle(list, rand);

		int amount = 20; //amount of passwords
		int maxlength = 20; //max length

		for(int j = 0, y = 1; j < amount; j++, y++) {
			StringBuilder passconstruct = new StringBuilder();
			for(int i = 0; i < maxlength; i++) {
				int index = rand.nextInt(list.size());
				passconstruct.append(list.get(index));	
			}
			passwords.add(passconstruct);
			//System.out.println(passwords.get(j));
			//System.out.println("password " + y + ": " + passconstruct);
		}
		//System.out.println(passwords.get(i));
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(createDir());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);

		try {
			out.write("(Beta)Password List: "+ "\n");
			for(int i = 1; i < amount; i++) {
				out.write(i + "." + passwords.get(i).toString() + "\n");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//we want to write our file to the directory
	//passwords stores in passwords
	public static void main(String[] args) {
             	password();
	}
}
