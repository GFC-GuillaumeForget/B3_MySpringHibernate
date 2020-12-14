import com.spring.dao.IEmployeDao;
import domaine.Employe;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ANSI_YELLOW + "TEST 1" + ANSI_RESET);
        try{
            executeTestModeTemplateDao();
        }
        catch(Exception e){
            System.out.println(ANSI_RED + "TEST 1 ECHEC" + ANSI_RESET);
        }


        System.out.println(ANSI_YELLOW + "TEST 2" + ANSI_RESET);
        executeTestModeDaoSupport();

    }

    private static void executeTestModeTemplateDao() throws InterruptedException {
        //test charger données
        Employe emp = new Employe("TOTO","ezrzb65-b","christ.","glass","email@mail.com","manager");

        //chargement context
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring-data.xml");

        //chargement du context dans class d'interface
        IEmployeDao springHibernateDao = (IEmployeDao) appContext.getBean("hibernateEmployeTemplateDao");

        //TEST 1 : sauver les données sausues dans 'emp'
        Thread.sleep(1000);
        System.out.println ("Test Save new employee");
        springHibernateDao.saveEmploye(emp);
        System.out.println ("///Saved !");

        //TEST 2 : get row = 4
        Thread.sleep(1000);
        System.out.println ("Get Saved employee");
        Employe e = springHibernateDao.getEmployeById(4);
        System.out.println ("///Here found  !"+ e.getNom() + " :" + e.getEmail());

        //TEST 3 : get lenth
        Thread.sleep(1000);
        System.out.println ("Get Saved Length");
        int len = springHibernateDao.getEmployeCount();
        System.out.println ("///LEB = !"+ len);

        //TEST 3 : get all
        Thread.sleep(1000);
        System.out.println ("Get Saved Length");
        List<Employe> lst= springHibernateDao.getAllEmployes();
        for(Employe val : lst){
            System.out.println ("///Mon Occurence (mail) ");
            System.out.println(val.getEmail());
        }

        //TEST 4 : delete
        Thread.sleep(1000);
        System.out.println ("DELETE 7");
        int result = springHibernateDao.deleteEmploye(7);
        System.out.println ("///6 deleted ");


    }

    private static void executeTestModeDaoSupport() throws InterruptedException{
        //test charger données
        Employe emp = new Employe("guillaumz","ezezeze","guil.","forget","forget@mail.com","cdp");

        //chargement context
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring-data.xml");

        //chargement du context dans class d'interface
        IEmployeDao springHibernateDao = (IEmployeDao) appContext.getBean("hibernateEmployeDaoSupport");

        //TEST 1 : sauver les données sausues dans 'emp'
        Thread.sleep(1000);
        System.out.println ("2.Test Save new employee");
        springHibernateDao.saveEmploye(emp);
        System.out.println ("2.///Saved !");

        //TEST 2 :  getEmployeByLogin
        Thread.sleep(1000);
        System.out.println ("2.Get employee login");
        Employe e = springHibernateDao.getEmployeByLogin("guillaumz");
        System.out.println ("2.///Here found  !"+ e.getNom() + " :" + e.getEmail());
    }
}
