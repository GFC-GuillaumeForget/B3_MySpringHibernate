import com.spring.dao.IEmployeDao;
import domaine.Employe;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("TEST 1 : via TemplateDao");
        executeTestModeTemplateDao();

    }
    private static void executeTestModeTemplateDao() throws InterruptedException {
        //Consolider data
        Employe emp = new Employe("monLogin","ffçgf78f","Paul",
                "Simon","toto@gmail.com","CDP");

        //chargement context
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring-data.xml");
        //chargement du context dans class d'interface
        IEmployeDao springHibernateDao = (IEmployeDao) appContext.getBean("hibernateEmployeTemplateDao");

        //Premier test : sauver
        springHibernateDao.saveEmploye(emp);
        System.out.println ("J'ai sauvé mon employé!") ;

        //2e test : chercher l'employe n° XXX


    }

}
