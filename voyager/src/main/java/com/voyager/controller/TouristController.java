package com.voyager.controller;

import com.voyager.model.Address;
import com.voyager.model.Tour;
import com.voyager.model.Tourist;
import com.voyager.service.AddressService;
import com.voyager.service.TourService;
import com.voyager.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TouristController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("init Builder");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @Autowired
    private TouristService touristService;

    @Autowired
    private TourService tourService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/newTourist", method = RequestMethod.GET)
    public ModelAndView newTourist(HttpServletRequest request, HttpSession session) {
        String param = request.getParameter("id");
        Integer tourId = Integer.parseInt(request.getParameter("id"));
        Tour tour = tourService.getTour(tourId);
        List<Tour> tourList = new LinkedList<Tour>();
        Tourist tourist = new Tourist();
        tourList.add(tour);
        tourist.setTours(tourList);
        tour.getTouristSet().add(tourist);
        Address address1 = new Address();
        Address address2 = new Address();
        List<Address> addressesList = new LinkedList<Address>();
        addressesList.add(address1);
        addressesList.add(address2);
        tourist.setAddressList(addressesList);
        address1.setTourist(tourist);
        address2.setTourist(tourist);
        ModelAndView modelAndView = new ModelAndView("touristForm");
        modelAndView.addObject("tourist", tourist);
        /*modelAndView.setViewName("touristForm");*/
        return modelAndView;
    }

    @RequestMapping(value = "/saveTourist", method = RequestMethod.POST)
    public ModelAndView saveTourist(ModelAndView modelAndView, Model model, @Valid Tourist tourist, BindingResult result) {
        System.out.println("save tourist");
        System.out.println(result);
        List<Tour> tourList = tourist.getTours();
        List<Tourist> touristList = new LinkedList<Tourist>();
        touristList.add(tourist);
        Iterator<Tour> tourIterator = tourList.iterator();
        while (tourIterator.hasNext()) {
            tourIterator.next().setTouristSet(touristList);
        }
        if (tourist.getId() == 0) {
            touristService.addTourist(tourist);
        } else {
            touristService.updateTourist(tourist);
        }
        modelAndView = new ModelAndView("redirect:/tourists");
        modelAndView.addObject("successMsg", true);
        return modelAndView;
    }

    @RequestMapping(value = "/tourists", method = RequestMethod.GET)
    public ModelAndView getTourists(ModelAndView modelAndView) {
        List<Tourist> touristList = touristService.getAllTourists();
        System.out.println("tourists");
        System.out.println(touristList);
        modelAndView.addObject("touristList", touristList);
        modelAndView.setViewName("tourists");
        return modelAndView;
    }

    @RequestMapping(value = "/editTourist", method = RequestMethod.GET)
    public ModelAndView editEmployee(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Tourist tourist = touristService.getTourist(id);
        ModelAndView modelAndView = new ModelAndView("touristForm");
        modelAndView.addObject("tourist", tourist);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteTourist", method = RequestMethod.GET)
    public ModelAndView deleteTourist(HttpServletRequest request) {
        Integer touristId = Integer.parseInt(request.getParameter("id"));
        touristService.deleteTourist(touristId);
        return new ModelAndView("redirect:/tourists");
    }

    @RequestMapping(value = "/getAllTourists", method = RequestMethod.GET)
    public ModelAndView getAllTourists(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Tour tour = tourService.getTour(id);
        Tourist tourist = new Tourist();
        List<Tourist> touristList = touristService.getAllTourists();
        ModelAndView modelAndView = new ModelAndView("bookTourForExistingUserFrm");
        modelAndView.addObject("touristList", touristList);
        modelAndView.addObject("tourist", tourist);
        modelAndView.addObject("tour", tour);
        return modelAndView;
    }

    /*mapping for ajax request*/
    @RequestMapping(value = "/getTourist", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ModelAndView getTourist(@RequestParam Integer id, @RequestParam Integer tourId, ModelMap model) {
        System.out.println("getTourist");
        Tour tour = tourService.getTour(tourId);
        Tourist tourist = touristService.getTourist(id);
        List<Tour> tourList = tourist.getTours();
        Iterator<Tour> tourIterator = tourList.listIterator();
        while (tourIterator.hasNext()) {
            Tour tourit = tourIterator.next();
            if (tourit.getId() == tourId) {
                tourList.remove(tourit);
            }
        }
        tourist.getTours().add(tour);
        List<Address> addressesList = new LinkedList<Address>();
        addressesList.addAll(tourist.getAddressList());
        tourist.setAddressList(addressesList);
        model.addAttribute("tourist", tourist);
        return new ModelAndView("editJSPForm");
    }
    @RequestMapping(value = "/viewTourist",method = RequestMethod.GET)
    public ModelAndView viewTourist(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Tourist tourist = touristService.getTourist(id);
        ModelAndView modelAndView = new ModelAndView("viewTourist");
        modelAndView.addObject("tourist",tourist);
        return modelAndView;
    }
    @RequestMapping(value = "/searchTourist",method = RequestMethod.GET)
    public @ResponseBody ModelAndView searchTourist(HttpServletRequest request){
        String name = request.getParameter("name");
        List touristList = touristService.searchTourist(name);
        ModelAndView modelAndView = new ModelAndView("tourists");
        modelAndView.addObject("touristList", touristList);
        return modelAndView;
    }
}