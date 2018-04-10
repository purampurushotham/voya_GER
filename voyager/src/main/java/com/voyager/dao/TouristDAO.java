package com.voyager.dao;

import com.voyager.model.Tourist;

import java.util.List;

public interface TouristDAO {
    public void addTourist(Tourist tourist);
    public List<Tourist> getAllTourists();
    public void deleteTourist(Integer Id);
    public Tourist updateTourist(Tourist tour);
    public Tourist getTourist(Integer Id);
    public List<Tourist> searchTourist(String name);
}

