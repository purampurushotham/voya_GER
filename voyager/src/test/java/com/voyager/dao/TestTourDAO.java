package com.voyager.dao;

import com.voyager.dao.TourDAO;
import com.voyager.model.Tour;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.RuntimeErrorException;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class TestTourDAO{

    @Mock
    TourDAO tourDAO;

    @InjectMocks
    TourDAOImpl tourDAOImpl;
    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testAddTour(){
        Tour tour = new Tour();
        tour.setId(1);
        tour.setPackageType("com/voyager/test");
        tour.setPrice(1000);
        tour.setPlaceName("com/voyager/test");
        Assert.assertNotNull(tourDAO);
        doThrow(RuntimeException.class).when(tourDAO).addTour(tour);
        tourDAOImpl.addTour(any(Tour.class));
        verify(tourDAOImpl, atLeastOnce()).getAllTours();
    }
}
/*    public void addTour(Tour tour);
    public List<Tour> getAllTours();
    public void deleteTour(Integer Id);
    public Tour updateTour(Tour tour);
    public Tour getTour(Integer Id);
    public List<Tour> searchPackages(String pName);*/
