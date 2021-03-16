package com.pk.eis.controller;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pk.eis.model.Employee;
import com.pk.eis.vo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.eis.IService.IEmpService;

@RestController
public class OnboardingController {

	@Autowired
    private IEmpService iEmpService;
	
	@RequestMapping("/")
    public ModelAndView showForm(Model model) {
        User user = new User();
      //to get object with dummy data.
        user=user.getDummyUser();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("emp_register_form");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
	
	@PostMapping("/register")
	public ModelAndView submitForm(@ModelAttribute("user") User user) throws JmsException, JsonProcessingException, MessagingException {
		
		Employee emp = user.getEmployee(user);
		iEmpService.save(emp);
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register_success");
        modelAndView.addObject("user", user);
        return modelAndView;
	}
	
	
	@DeleteMapping("/emp/{id}")
	public void delete(@PathVariable Integer id) {
		iEmpService.delete(id);
	}
	
}
