package com.spring.dao.hibernate;

import com.spring.dao.IEmployeDao;
import domaine.Employe;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HibernateEmployeDaoSupport2 extends HibernateDaoSupport implements IEmployeDao {

    @Override
    @Transactional(readOnly = false)
    public void saveEmploye(Employe employe) {
        this.getHibernateTemplate().saveOrUpdate(employe);
    }

    @Override
    @Transactional(readOnly = true)
    public Employe getEmployeById(int id) {
        return this.getHibernateTemplate().get(Employe.class,id); //version template h5
    }

    @Override
    @Transactional(readOnly = true)
    public Employe getEmployeByLogin(String login) {
        Criterion c =  Restrictions.eq("login",login);
        DetachedCriteria dc = DetachedCriteria.forClass(Employe.class).add(c);
        List<Employe> list = (List<Employe>) this.getHibernateTemplate().findByCriteria(dc);
        return list.get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public int getEmployeCount() {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employe> getAllEmployes() {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteEmploye(int id) {
        return 0;
    }
}
