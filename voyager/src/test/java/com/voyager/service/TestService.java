package com.voyager.service;

import com.voyager.dao.TourDAO;
import com.voyager.model.Tour;
import com.voyager.service.TourServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class TestService {
    @Mock
    TourDAO tourDAO;

    @InjectMocks
    TourServiceImpl tourService;

    @Spy
    List<Tour> tourList = new ArrayList<Tour>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        tourList = getTourList();
    }
    @Test
    public void addTour(){
        doNothing().when(tourDAO).addTour(any(Tour.class));
        tourService.addTour(any(Tour.class));
        verify(tourDAO,atLeastOnce()).addTour(any(Tour.class));
    }
    @Test
    public void deleteTour(){
        doNothing().when(tourDAO).deleteTour(anyInt());
        tourService.deleteTour(anyInt());
        verify(tourDAO,atLeastOnce()).deleteTour(anyInt());
    }
    @Test
    public void updateTour(){
        Tour tour = tourList.get(0);
        when(tourDAO.updateTour(anyObject())).thenReturn(tour);
        tourService.updateTour(anyObject());
        verify(tourDAO,atLeastOnce()).updateTour(anyObject());
    }
    @Test
    public void getTour(){
        Tour tour = tourList.get(0);
        when(tourDAO.getTour(anyInt())).thenReturn(tour);
        Assert.assertEquals(tourService.getTour(anyInt()),tour);
    }
    @Test
    public void getAllTours(){
        when(tourDAO.getAllTours()).thenReturn(tourList);
        Assert.assertEquals(tourService.getAllTours(),tourList);
    }
    @Test
    public void searchPackages(){
        when(tourDAO.searchPackages(anyString())).thenReturn(tourList);
        tourService.searchPackages(anyString());
        verify(tourDAO,atLeastOnce()).searchPackages(anyString());
    }
    public List<Tour> getTourList(){
        Tour tour = new Tour();
        tour.setId(1);
        tour.setPackageType("com/voyager/test");
        tour.setPrice(1000);
        tour.setPlaceName("com/voyager/test");
        Tour tour1 = new Tour();
        tour1.setId(1);
        tour1.setPackageType("com/voyager/test");
        tour1.setPrice(1000);
        tour1.setPlaceName("com/voyager/test");
        tourList.add(tour);
        tourList.add(tour1);
        return tourList;
    }
}
