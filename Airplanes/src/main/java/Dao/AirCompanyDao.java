package Dao;

import Entities.AirCompany;
import java.util.List;

public interface AirCompanyDao {
    AirCompany addAirCompany(AirCompany airCompany);
    void updateAirCompany(AirCompany airCompany);
    void removeAirCompany(Long id);
    AirCompany getAirCompanyById(Long id);
    List<AirCompany> listAirCompanies();
}
