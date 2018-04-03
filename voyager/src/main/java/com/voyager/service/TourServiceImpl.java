package com.voyager.service;

import com.voyager.dao.TourDAO;
import com.voyager.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDAO tourDAO;


    @Override
    @Transactional
    public List<Tour> getAllTours() {
        return tourDAO.getAllTours();
    }
    @Override
    @Transactional
    public void addTour(Tour tour) {
        tourDAO.addTour(tour);
    }
    @Override
    @Transactional
    public Tour getTour(Integer tourId) {
        return tourDAO.getTour(tourId);

    }
    @Override
    @Transactional
    public void deleteTour(Integer tourId) {
        tourDAO.deleteTour(tourId);
    }
    @Override
    @Transactional
    public Tour updateTour(Tour tour) {
        return tourDAO.updateTour(tour);
    }

    public void setEmployeeDAO(TourDAO tourDAO) {
        this.tourDAO = tourDAO;
    }
}
