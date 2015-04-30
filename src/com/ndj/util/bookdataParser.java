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

public class bookdataParser {
	static File file = new File("books.txt");
	static List<bookdata> bookList = new ArrayList<bookdata>();
	static Map<String, bookdata> lookup = new HashMap<String, bookdata>();
	
	public static void init() throws IOException {
		if (file.exists()) {
			store();
		}
	}
	public static void write(bookdata data) throws IOException{
		BufferedWriter output;
		init();
		if(file.exists()&&!isPresent(data.getBookname()))
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
			String[] comments = fields[2].split("\\,");
			bookdata book = new bookdata(fields[0], fields[1], comments);
			bookList.add(book);
		}
		br.close();
		}	
	}
	
	public static void print() throws IOException {
		if (bookList.isEmpty()) {
			read();
		}
		if (!bookList.isEmpty()) {
			for (bookdata book : bookList) {
				System.out.println("\n---------------------------");
				System.out.println("bookname :" + book.getBookname());
				System.out.println("author :" + book.getAuthorname());
				System.out.print("comments: ");
				for (String comment : book.getUsercomments())
					System.out.print(comment.toString() + " ");
			}
			System.out.println("\n---------------------------");
		}
	}


	public static List<bookdata> store() throws IOException {
		if (bookList.isEmpty()) {
			read();
		}
		if (!bookList.isEmpty())
			for (bookdata book : bookList) {
				lookup.put(book.getBookname(), book);
			}
		return bookList;
	}
	public static boolean isPresent(String bookname) {
		return lookup.containsKey(bookname);
	}
	public static void showLookup() {
		if (lookup.isEmpty()) {
			System.out.println("Lookup is empty!");
		} else {
			System.out.println("\nContents of Lookup :\n");
			for (String bookname : lookup.keySet()) {
				System.out.println(lookup.get(bookname));
			}
		}	
	}
	
	public static Map<String, bookdata> getLookup() throws IOException {
		store();	
		return lookup;
	}
}
