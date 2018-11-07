package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.dao.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/customer")
	public String showSearchCustomerForm() {
		return "customerList";
	}
    
 
	@RequestMapping("/customerList")
	public String searchCustomers(HttpServletRequest request) {
	String name = request.getParameter("name");
	String sortBy = request.getParameter("sortBy");

	
	request.setAttribute("customers", customerDao.searchAndSortCustomers(name, sortBy));
	return "customerList";
	}
    
}
