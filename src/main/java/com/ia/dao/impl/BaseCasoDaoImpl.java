package com.ia.dao.impl;

import com.ia.dao.BaseCasoDao;
import com.ia.models.BaseDeCaso;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseCasoDaoImpl extends HibernateDaoSupport implements BaseCasoDao {

    @Transactional
    @Override
    public void addCaso(BaseDeCaso caso){
        this.getHibernateTemplate().save(caso);
    }
    @Override
    public List<BaseDeCaso> listCasos(){
        return(List<BaseDeCaso>) this.getHibernateTemplate().find("from com.ia.models.BaseDeCaso");
    }
    @Override
    public BaseDeCaso getCasoById(int id){
        return this.getHibernateTemplate().get(BaseDeCaso.class, id);
    }
    @Transactional
    @Override
    public void removeCaso(int id){
        this.getHibernateTemplate().delete(this.getCasoById(id));
    }
}
