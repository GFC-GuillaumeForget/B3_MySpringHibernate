package com.spring.dao.hibernate;

import com.spring.dao.IEmployeDao2;
import domaine.Employe;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class HibernateEmployeTemplateDao2 implements IEmployeDao2 {

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
        return hibernateTemplate.get(Employe.class, id);
    }

    @Override
    public Employe getEmployeByLogin(String login) {
        // methode utiliser Criterion
        Criterion c =  Restrictions.eq("login",login);
        DetachedCriteria criteria =  DetachedCriteria.forClass(Employe.class).add(c);
        List<Employe> list = (List<Employe>) hibernateTemplate.findByCriteria(criteria);

        return list.get(0);
    }

    @Override
    public int getEmployeCount() {
        return 0;
    }

    @Override
    public List<Employe> getAllEmployes() {
        return null;
    }
}
