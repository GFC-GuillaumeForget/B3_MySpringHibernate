package com.spring.dao;

import domaine.Employe;

import java.util.List;

public interface IEmployeDao2 {
    public void saveEmploye(Employe employe);
    public Employe getEmployeById(int id);
    public Employe getEmployeByLogin (String login);
    public int getEmployeCount();
    public List<Employe> getAllEmployes();

}
