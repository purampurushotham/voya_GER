package com.voyager.dao;

import com.voyager.model.Tour;

import java.util.List;

public interface TourDAO {
    public void addTour(Tour tour);
    public List<Tour> getAllTours();
    public void deleteTour(Integer Id);
    public Tour updateTour(Tour tour);
    public Tour getTour(Integer Id);
    public List<Tour> searchPackages(String pName);
}
