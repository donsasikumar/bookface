package com.dj.bf;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ndj.pojo.bookdata;
import com.ndj.pojo.userdata;
import com.ndj.util.bookdataParser;
import com.ndj.util.userdataParser;

@Controller
public class BookFaceController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] { "userMobile" });
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "userDOB",
				new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/HomePage.html", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView model1 = new ModelAndView("HomePage");
		return model1;
	}

	@RequestMapping(value = "/Register.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model1 = new ModelAndView("Register");
		return model1;
	}
	
	@RequestMapping(value = "/submitRegister.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("user1") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("Register");
			return model1;
		}
		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
	}

	@ModelAttribute
	public void addingCommonObjects(Model model1) throws IOException {
		setupTestData();
		List<bookdata> bookList = bookdataParser.store();
		List<userdata> userList = userdataParser.store();
		model1.addAttribute("headerMessage", "Bookface");
		model1.addAttribute("bookList", bookList);
		model1.addAttribute("userList", userList);
	}

	public void setupTestData() throws IOException {

		userdataParser.write(new userdata("don", "don", "don@yahoo.com",
				new String[] { "ABC" }, new String[] { "AABBCC" }));
		userdataParser.write(new userdata("don1", "don1", "don1@yahoo.com",
				new String[] { "ABC1", "ABC1", "ABC1", "ABC1" }, new String[] {
						"BBC11", "BBC12", "BBC13", "BBC14" }));
		userdataParser.write(new userdata("don2", "don2", "don2@yahoo.com",
				new String[] { "ABC2", "ABC2", "ABC2", "ABC2" }, new String[] {
						"BBC21", "BBC22", "BBC23", "BBC24" }));
		userdataParser.write(new userdata("don3", "don3", "don3@yahoo.com",
				new String[] { "ABC3", "ABC3", "ABC3", "ABC3" }, new String[] {
						"BBC31", "BBC32", "BBC33", "BBC34" }));
		userdataParser.write(new userdata("don4", "don4", "don4@yahoo.com",
				new String[] { "ABC4", "ABC4", "ABC4", "ABC4" }, new String[] {
						"BBC41", "BBC42", "BBC43", "BBC44" }));

		bookdata bd1 = new bookdata("book1", "author1", new String[] {
				"user1:nice", "user2:waste" });
		bookdata bd2 = new bookdata("book2", "author2", new String[] {
				"user3:nice", "user4:waste" });
		bookdata bd3 = new bookdata("book3", "author3", new String[] {
				"user5:nice", "user6:waste" });
		bookdata bd4 = new bookdata("book4", "author4", new String[] {
				"user7:nice", "user8:waste" });
		bookdataParser.write(bd1);
		bookdataParser.write(bd2);
		bookdataParser.write(bd3);
		bookdataParser.write(bd4);
	}


}
