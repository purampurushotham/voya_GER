package com.voyager.controller;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.voyager.model.Tour;
import com.voyager.model.Tourist;
import com.voyager.service.TourService;
import com.voyager.service.TouristService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.jboss.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@Controller
public class ToursController {
    private static final Logger logger = Logger
            .getLogger(ToursController.class);
    @Autowired
    private TourService tourService;

    @Autowired
    private TouristService touristService;

    public ToursController() {
        System.out.println("Controller constructor");
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String setIndex(){
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }
    @RequestMapping(value = "/tours")
    public ModelAndView toursList(ModelAndView model) throws IOException {
        List<Tour> toursList = tourService.getAllTours();
        model.setViewName("tours");
        model.addObject("toursList",toursList);
        return model;
    }
    @RequestMapping(value = "/saveTour", method = RequestMethod.POST)
    public ModelAndView saveTour(@ModelAttribute Tour tour){
        System.out.println("Save Tour");
        System.out.println(tour.getId());
        if(tour.getId() == 0){
            tourService.addTour(tour);
        }
        else{
            tourService.updateTour(tour);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/newTour",method = RequestMethod.GET)
    public ModelAndView newTour(ModelAndView modelAndView){
        Tour tour = new Tour();
        modelAndView.addObject("tour",tour);
        modelAndView.setViewName("newTourForm");
        return modelAndView;
    }
    @RequestMapping(value = "/editTour",method = RequestMethod.GET)
    public ModelAndView editTour(HttpServletRequest request){

        int tourId = Integer.parseInt(request.getParameter("id"));
        Tour tour = tourService.getTour(tourId);
        ModelAndView modelAndView = new ModelAndView("newTourForm");
        modelAndView.addObject("tour",tour);
        return modelAndView;
    }
    @RequestMapping(value = "/deleteTour", method = RequestMethod.GET)
    public ModelAndView deleteTour(HttpServletRequest request){
        int tourId = Integer.parseInt(request.getParameter("id"));
        tourService.deleteTour(tourId);
        return  new ModelAndView("redirect:/tours");
    }
    /*@RequestMapping(value = "/bookTour", method = RequestMethod.GET)
    public ModelAndView bookTour(HttpServletRequest request){
        int tourID = Integer.parseInt(request.getParameter("id"));
        Tourist tourist = new Tourist();
        Tour tour = tourService.getTour(tourID);
        ModelAndView modelAndView = new ModelAndView("touristForm");
        modelAndView.addObject("tourist",tourist);
        modelAndView.addObject("tourName",tour.getPackageName());
        return modelAndView;
    }*/
}
