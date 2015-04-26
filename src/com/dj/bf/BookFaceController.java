package com.dj.bf;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@Controller
public class BookFaceController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.setDisallowedFields(new String[] {"userMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "userDOB", new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value="/Register.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model1 = new ModelAndView("Register");
		
		return model1;
	}

	@ModelAttribute
    public void addingCommonObjects(Model model1) {
		
		model1.addAttribute("headerMessage", "Bookface");
	}

	@RequestMapping(value="/submitRegister.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("user1") User user, BindingResult result) {
		
		 if (result.hasErrors()) {

				ModelAndView model1 = new ModelAndView("Register");
				return model1;
		 }

		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
	}
	
}

