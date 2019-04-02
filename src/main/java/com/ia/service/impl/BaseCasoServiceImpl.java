package com.ia.service.impl;

import com.ia.dao.BaseCasoDao;
import com.ia.models.BaseDeCaso;
import com.ia.service.BaseCasoService;

import javax.annotation.Resource;
import java.util.List;

public class BaseCasoServiceImpl implements BaseCasoService {

    @Resource
    private BaseCasoDao baseCasoDao;

    @Override
    public void addCaso(BaseDeCaso caso){
        this.baseCasoDao.addCaso(caso);
    }
    @Override
    public List<BaseDeCaso> listCasos(){
        return this.baseCasoDao.listCasos();
    }
    @Override
    public BaseDeCaso getCasoById(int id){
        return this.baseCasoDao.getCasoById(id);
    }
    @Override
    public void removeCaso(int id){
        this.baseCasoDao.removeCaso(id);
    }

}
