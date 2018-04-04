package com.voyager.controller;

import com.voyager.model.Tour;
import com.voyager.model.Tourist;
import com.voyager.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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


    @RequestMapping(value="/newTourist",method = RequestMethod.GET)
    public ModelAndView newTourist(ModelAndView modelAndView){
        Tourist tourist = new Tourist();
        modelAndView.addObject("tourist",tourist);
        modelAndView.setViewName("touristForm");
        return modelAndView;
    }
    @RequestMapping(value = "/saveTourist", method = RequestMethod.POST)
    public ModelAndView saveTourist(ModelAndView modelAndView,Model model, @Valid Tourist tourist, BindingResult result){
        System.out.println("save tourist");
        touristService.addTourist(tourist);
        return new ModelAndView("redirect:/tourists");
    }
    @RequestMapping(value = "/tourists", method = RequestMethod.GET)
    public ModelAndView getTourists(ModelAndView modelAndView){
        List<Tourist> touristList = touristService.getAllTourists();
        System.out.println("tourists");
        System.out.println(touristList);
        modelAndView.addObject("touristList",touristList);
        modelAndView.setViewName("tourists");
        return modelAndView;
    }
}
