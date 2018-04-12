package com.voyager.controller;

import com.google.gson.Gson;
import com.sun.corba.se.impl.oa.toa.TOA;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.voyager.model.Tour;
import com.voyager.model.Tourist;
import com.voyager.service.TourService;
import com.voyager.service.TouristService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.jboss.logging.Logger;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    public ModelAndView toursList(){
        List<Tour> toursList = tourService.getAllTours();
        ModelAndView modelAndView=  new ModelAndView("tours");
        modelAndView.addObject("toursList",toursList);
        return modelAndView;
    }
    @RequestMapping(value = "/saveTour", method = RequestMethod.POST)
    public String saveTour(@ModelAttribute Tour tour){
        System.out.println(tour.getId());
        if(tour.getId() == 0){
            System.out.println("Save Tour");
            tourService.addTour(tour);
        }
        else{
            System.out.println("Update Tour");
            tourService.updateTour(tour);
        }
        return "tours";
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
    @RequestMapping(value = "/viewTour", method = RequestMethod.GET)
    public ModelAndView viewTour(HttpServletRequest request){
        int tourID = Integer.parseInt(request.getParameter("id"));
        Tour tour = tourService.getTour(tourID);
        ModelAndView modelAndView = new ModelAndView("viewTourForm");
        /*Tourist tourist = new Tourist();
        Set<Tour> tours = new HashSet<Tour>();
        Tour tour = tourService.getTour(tourID);
        tours.add(tour);
        ModelAndView modelAndView = new ModelAndView("touristForm");
        tourist.setTours(tours);*/
        modelAndView.addObject("tour",tour);
        /*modelAndView.addObject("tourName",tour.getPackageName());*/
        return modelAndView;
    }
    @RequestMapping(value="/getTourPackages",method = RequestMethod.GET)
    public @ResponseBody List searchTour(HttpServletRequest request){
        String tourName = request.getParameter("term");
        System.out.println(tourName);
        List tourList = tourService.searchPackages(tourName);
        /*Gson gson = new Gson();*/
        return tourList;
    }
}
