package com.voyager.service;

import com.voyager.dao.TouristDAO;
import com.voyager.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TouristServiceImpl implements TouristService {

    @Autowired
    private TouristDAO touristDAO;

    @Override
    @Transactional
    public List<Tourist> getAllTourists() { return touristDAO.getAllTourists(); }

    @Override
    @Transactional
    public void addTourist(Tourist tourist) { touristDAO.addTourist(tourist); }

    @Override
    @Transactional
    public Tourist getTourist(Integer touristId) { return touristDAO.getTourist(touristId); }

    @Override
    @Transactional
    public void deleteTourist(Integer touristId) { touristDAO.deleteTourist(touristId); }

    @Override
    @Transactional
    public Tourist updateTourist(Tourist tourist) { return touristDAO.updateTourist(tourist); }
}
