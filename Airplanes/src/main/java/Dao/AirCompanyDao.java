package Dao;

import Entities.AirCompany;
import Entities.Flight;

import java.util.List;

public interface AirCompanyDao {
    AirCompany addAirCompany(AirCompany airCompany);
    void updateAirCompany(AirCompany airCompany);
    void removeAirCompany(Long id);
    AirCompany getAirCompanyById(Long id);
    List<AirCompany> listAirCompanies();
    public List<Flight> findAllAirCompanyFlightByStatus(String status);
}
