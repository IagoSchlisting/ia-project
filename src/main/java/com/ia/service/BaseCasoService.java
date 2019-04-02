package com.ia.service;

import com.ia.models.BaseDeCaso;

import java.util.List;

public interface BaseCasoService {

    public void addCaso(BaseDeCaso caso);
    public List<BaseDeCaso> listCasos();
    public BaseDeCaso getCasoById(int id);
    public void removeCaso(int id);

}
