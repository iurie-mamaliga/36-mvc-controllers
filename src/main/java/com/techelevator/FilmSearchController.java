package com.techelevator;

import com.techelevator.dao.FilmDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/film")
    public String showFilmSearchForm() {
    	return "filmList";
    }

    @RequestMapping("/filmList")
    public String searchFilms(HttpServletRequest request) {
    		int minimumLength = 0;
    		int maximumLength = 0;
    		try{minimumLength = Integer.parseInt(request.getParameter("MinimumLength"));
    		}catch(Exception e){
    			minimumLength = 0;
    		}
    		try{maximumLength = Integer.parseInt(request.getParameter("MaximumLength"));
    		}catch(Exception e){
    			maximumLength = Integer.MAX_VALUE;
    		}

    		String category = request.getParameter("MovieCategory");
    		
    		request.setAttribute("films", filmDao.getFilmsBetween(category, minimumLength, maximumLength));
    		
    	return "filmList";
    }
    
}