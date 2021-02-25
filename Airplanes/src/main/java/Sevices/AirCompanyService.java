package Sevices;

import Entities.AirCompany;
import java.util.List;

public interface AirCompanyService {
    public void addAirCompany(AirCompany airCompany);
    public void updateAirCompany(AirCompany airCompany);
    public void removeAirCompany(Long id);
    public AirCompany getAirCompanyById(Long id);
    public List<AirCompany> listAirCompanies();
}
