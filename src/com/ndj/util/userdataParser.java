package com.ndj.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ndj.pojo.bookdata;
import com.ndj.pojo.userdata;

public class userdataParser {
	static List<userdata> userList = new ArrayList<userdata>();
	static Map<String, userdata> lookup = new HashMap<String, userdata>();
	static File file = new File("users.txt");

	public static void init() throws IOException {
		if (file.exists()) {
			store();
		}
	}

	public static void write(userdata data) throws IOException{
		BufferedWriter output;
		init();
		if(file.exists()&&!isPresent(data.getEmail()))
		{
			output = new BufferedWriter(new FileWriter(file,true));
			output.append(data.toString());
			output.newLine();
			output.close();
		}
		if(!file.exists()){
			output = new BufferedWriter(new FileWriter(file));
			output.write(data.toString());
			output.newLine();
			output.close();
		}
		
	}

	public static void read() throws IOException {
		if(file.exists()){
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] fields = line.split("\\|");
			String[] books = fields[3].split("\\,");
			String[] authors = fields[4].split("\\,");
			userdata user = new userdata(fields[0], fields[1], fields[2],
					books, authors);
			userList.add(user);
		}
		br.close();
		}

	}

	public static void print() throws IOException {
		if (userList.isEmpty()) {
			read();
		}
		if (!userList.isEmpty()) {
			for (userdata user : userList) {
				System.out.println("\n---------------------------");
				System.out.println("user :" + user.getUserName());
				System.out.println("password :" + user.getPassword());
				System.out.println("email :" + user.getEmail());
				System.out.print("Books: ");
				for (String book : user.getBooks())
					System.out.print(book + " ");
				System.out.print("\nAuthors: ");
				for (String author : user.getAuthors())
					System.out.print(author + " ");
			}
			System.out.println("\n---------------------------");
		}
	}

	public static List<userdata> store() throws IOException {
		if (userList.isEmpty()) {
			read();
		}
		if (!userList.isEmpty())
			for (userdata user : userList) {
				lookup.put(user.getEmail(), user);
			}
		
		return userList;
	}

	public static void showLookup() {
		if (lookup.isEmpty()) {
			System.out.println("Lookup is empty!");
		} else {
			System.out.println("\nContents of Lookup :\n");
			for (String email : lookup.keySet()) {
				System.out.println(lookup.get(email));
			}
		}
	}

	public static boolean isPresent(String username) {
		return lookup.containsKey(username);
	}
	public static Map<String, userdata> getLookup() throws IOException {
		store();	
		return lookup;
	}
}
