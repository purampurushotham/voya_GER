package com.voyager.controller;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import com.voyager.controller.ToursController;
import com.voyager.model.Tour;
import com.voyager.service.TourService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppControllerTesrt {


    @Mock
    private TourService tourService;

    @InjectMocks
    private ToursController toursController;

    @Spy
    List<Tour> toursList = new LinkedList<Tour>();

    @Spy
    ModelAndView model;

    @Spy
    MockHttpServletRequest request = new MockHttpServletRequest();

    @Mock
    BindingResult result;

    @BeforeClass
    public void setup(){
        MockitoAnnotations.initMocks(this);
        toursList = getTours();
    }
    @Test
    public void setIndex(){
        Assert.assertEquals(toursController.setIndex(),"redirect:/home");
    }

    @Test
    public void home(){
        model = toursController.home();
        Assert.assertEquals(model.getViewName(),"home");
    }
    @Test
    public void listTours(){
        when(tourService.getAllTours()).thenReturn(toursList);
        String viewName = "tours";
        model = toursController.toursList();
        Assert.assertEquals(model.getViewName(),viewName);
        Assert.assertEquals(model.getModel().get("toursList"), toursList);
        verify(tourService, atLeastOnce()).getAllTours();
    }
    @Test
    public void editController(){
        when(tourService.getTour(toursList.get(0).getId())).thenReturn(toursList.get(0));
        String viewName = "newTourForm";
        String id = Integer.toString(toursList.get(0).getId());
        request.setMethod("GET");
        request.setParameter("id",id);
        model = toursController.editTour(request);
        Assert.assertEquals(model.getViewName(),viewName);
        Assert.assertEquals(model.getModel().get("tour"), toursList.get(0));
        verify(tourService, atLeastOnce()).getTour(toursList.get(0).getId());
    }

    @Test
    public void saveNewTour(){
        Tour tour = new Tour();
        Tour tour1 = toursList.get(1);
        tour.setPackageName("TEST");
        tour.setPlaceName("TEST");
        tour.setPackageType("TEST");
        tour.setPrice(1000);
        tour.setId(0);
        tour1.setId(1);
        Assert.assertEquals(toursController.saveTour(tour), "tours");
        Assert.assertEquals(toursController.saveTour(tour1), "tours");
        verify(tourService, times(1)).addTour(any(Tour.class));
        verify(tourService, times(1)).addTour(any(Tour.class));
    }
    @Test
    public void addNewTourForm(){
        model = toursController.newTour(model);
        Tour tour = (Tour) model.getModel().get("tour");
        Assert.assertNotNull(tour);
        Assert.assertEquals(model.getViewName(),"newTourForm");
    }
    @Test
    public void getaTour(){
        int id = toursList.get(0).getId();
        String paramid = Integer.toString(toursList.get(0).getId());
        Tour tour = toursList.get(0);
        request.setParameter("id",paramid);
        when(tourService.getTour(id)).thenReturn(tour);
        model = toursController.viewTour(request);
        Assert.assertEquals(model.getViewName(),"viewTourForm");
        verify(tourService,atLeastOnce()).getTour(id);
    }
    @Test
    public void searchTour(){
        String keyword = "Test1";
        request.setParameter("term",keyword);
        when(tourService.searchPackages(keyword)).thenReturn(toursList);
        toursList = toursController.searchTour(request);
        Assert.assertEquals(toursList.size(),2);

    }
    @Test
    public void deleteTour(){
        int id = toursList.get(0).getId();
        String paramid = Integer.toString(toursList.get(0).getId());
        Tour tour = toursList.get(0);
        request.setParameter("id",paramid);
        model = toursController.deleteTour(request);
        Assert.assertEquals(model.getViewName(),"redirect:/tours");
        verify(tourService, times(1)).deleteTour(anyInt());
    }
    public List<Tour> getTours(){
        Tour tour1 = new Tour();
        Tour tour2 = new Tour();
        tour1.setPackageName("Test1");
        tour1.setPackageType("TestPackageType1");
        tour1.setPlaceName("TestpalceName1");
        tour1.setPrice(1000);
        tour2.setPackageName("Test1");
        tour2.setPackageType("TestPackageType1");
        tour2.setPlaceName("TestpalceName1");
        tour2.setPrice(1000);
        List tourList = new LinkedList();
        tourList.add(tour1);
        tourList.add(tour2);
        return tourList;
    }
}
