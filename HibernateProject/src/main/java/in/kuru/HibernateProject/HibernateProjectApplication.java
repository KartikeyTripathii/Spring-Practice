package in.kuru.HibernateProject;

import jakarta.transaction.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class HibernateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);

        Configuration cfg= new Configuration();
        cfg.configure("/in/kuru/HibernateProject/config/hibernate.cfg.xml");

        SessionFactory sessionFactory= cfg.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.begintransaction();

	}

}
