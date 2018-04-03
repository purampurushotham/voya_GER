package com.voyager.controller;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.voyager.model.Tour;
import com.voyager.service.TourService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.jboss.logging.Logger;
import java.io.IOException;
import java.util.List;
@Controller
public class ToursController {
    private static final Logger logger = Logger
            .getLogger(ToursController.class);
    @Autowired
    private TourService tourService;
    public ToursController() {
        System.out.println("Controller constructor");
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String setIndex(){
        return "redirect:/tours";
    }
    @RequestMapping(value = "/tours")
    public ModelAndView toursList(ModelAndView model) throws IOException {
        List<Tour> toursList = tourService.getAllTours();
        model.addObject("toursList", toursList);
        System.out.println("toursList");
        System.out.println(toursList);
        model.setViewName("home");
        model.addObject("toursList",toursList);
        return model;
    }
    @RequestMapping(value = "/saveTour", method = RequestMethod.POST)
    public ModelAndView saveTour(@ModelAttribute Tour tour){
        if(tour.getId() == 0){
            tourService.addTour(tour);
        }
        else{
            tourService.updateTour(tour);
        }
        return new ModelAndView("redirect:/tours");
    }

    @RequestMapping(value="/newTour",method = RequestMethod.GET)
    public ModelAndView newTour(ModelAndView modelAndView){
        Tour tour = new Tour();
        modelAndView.addObject("tour",tour);
        modelAndView.setViewName("newTourForm");
        return modelAndView;
    }

}
