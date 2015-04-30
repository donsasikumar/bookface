package com.ndj.pojo;

import java.util.Arrays;

public class bookdata {
	protected String bookname;
	protected String authorname;
	protected String[] usercomments;
	
	public bookdata(String bookname, String authorname,
			String[] usercomments) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.usercomments = usercomments;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String[] getUsercomments() {
		return usercomments;
	}

	public void setUsercomments(String[] usercomments) {
		this.usercomments = usercomments;
	}

	@Override
	public String toString() {
		return bookname + "|" + authorname
				+ "|" + Arrays.toString(usercomments);
	}
	
	
}
