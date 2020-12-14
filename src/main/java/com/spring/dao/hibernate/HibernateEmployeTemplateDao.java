package com.spring.dao.hibernate;


import com.spring.dao.IEmployeDao;
import domaine.Employe;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public class HibernateEmployeTemplateDao implements IEmployeDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate template){
        this.hibernateTemplate = template;
    }

    @Override
    public void saveEmploye(Employe employe) {
        hibernateTemplate.saveOrUpdate(employe);
    }

    @Override
    public Employe getEmployeById(int id) {
        return hibernateTemplate.get(Employe.class,id); //version template h5
        //old versions
       //List res =  hibernateTemplate.find("from Employe where id=" + id);
       // return res.size()>0 ? res.get(0) :  null;
    }

    @Override
    public Employe getEmployeByLogin(String login) {
       Criterion c =  Restrictions.eq("login",login);
       DetachedCriteria dc = DetachedCriteria.forClass(Employe.class).add(c);
        List<Employe> list = (List<Employe>) hibernateTemplate.findByCriteria(dc);
        return list.get(0);
    }

    @Override
    public int getEmployeCount() {
        List<Employe> list = hibernateTemplate.loadAll(Employe.class);
        return list.size();


    }

    @Override
    public List<Employe> getAllEmployes() {
        List<Employe> list = hibernateTemplate.loadAll(Employe.class);
        return  list;
    }

    @Override
    @Transactional
    public int deleteEmploye(int id) {
        Employe e = hibernateTemplate.get(Employe.class,id);
        hibernateTemplate.delete(e);
        //hibernateTemplate.flush();

        return 1;
    }

}
