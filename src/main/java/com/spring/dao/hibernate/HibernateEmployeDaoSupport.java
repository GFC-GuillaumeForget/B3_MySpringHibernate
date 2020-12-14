package com.spring.dao.hibernate;

import com.spring.dao.IEmployeDao;
import domaine.Employe;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class HibernateEmployeDaoSupport extends HibernateDaoSupport implements IEmployeDao {
    @Override
    @Transactional(readOnly = false)
    public void saveEmploye(Employe employe) {
        this.getHibernateTemplate().saveOrUpdate(employe);
    }

    @Override
    @Transactional(readOnly = true)
    public Employe getEmployeById(int id) {
        return this.getHibernateTemplate().get(Employe.class,id);
    }

    @Override
    @Transactional(readOnly = true)
    public Employe getEmployeByLogin(String login) {
        Criterion c =  Restrictions.eq("login",login);
        DetachedCriteria dc = DetachedCriteria.forClass(Employe.class).add(c);
        List<Employe> list = (List<Employe>) getHibernateTemplate().findByCriteria(dc);
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

    @Override
    public int deleteEmploye(int id) {
        return 0;
    }
}
