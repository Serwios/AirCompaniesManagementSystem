package Dao;

import Entities.AirCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

// Maybe you should write SERVICES.
// TODO: Write services 16:56
// https://www.youtube.com/watch?v=e7swABdqOS4

@Repository
public class AirCompanyDaoImpl implements AirCompanyDao {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AirCompanyDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAirCompany(AirCompany airCompany) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(airCompany);
        LOGGER.info("AirCompany successful added! AirCompany details: " + airCompany);
    }

    @Override
    public void updateAirCompany(AirCompany airCompany) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(airCompany);
        LOGGER.info("AirCompany successful updated! AirCompany details: " + airCompany);
    }

    @Override
    public void removeAirCompany(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        AirCompany airCompany = session.load(AirCompany.class, id);

        if (airCompany != null) {
            session.delete(airCompany);
        }

        LOGGER.info("AirCompany successful deleted" + airCompany);
    }

    @Override
    public AirCompany getAirCompanyById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        AirCompany airCompany = session.load(AirCompany.class, id);
        LOGGER.info("AirCompany successful got" + airCompany);

        return airCompany;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AirCompany> listAirCompanies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AirCompany> airCompaniesList = session.createQuery("from AirCompany").list();

        for (AirCompany air: airCompaniesList) {
            LOGGER.info("AirCompaniesList: " + air);
        }

        return airCompaniesList;
    }
}