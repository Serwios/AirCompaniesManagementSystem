package Dao;

import Entities.AirCompany;
import java.util.List;

public interface AirCompanyDao {
    public void addAirCompany(AirCompany airCompany);
    public void updateAirCompany(AirCompany airCompany);
    public void removeAirCompany(Long id);
    public AirCompany getAirCompanyById(Long id);
    public List<AirCompany> listAirCompanies();
}
