package com.voyager.service;

import com.voyager.model.Tour;

import java.util.List;

public interface TourService {
    public List<Tour> getAllTours();
    public void addTour(Tour tour);
    public Tour getTour(Integer tourId);
    public void deleteTour(Integer tourId);
    public Tour updateTour(Tour tour);
    public List<Tour> searchPackages(String pName);
}
