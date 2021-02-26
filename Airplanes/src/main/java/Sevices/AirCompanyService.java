package Sevices;

import Entities.AirCompany;
import Entities.Airplane;

import java.util.List;

public interface AirCompanyService {
    public AirCompany addAirCompany(AirCompany airCompany);
    public void updateAirCompany(AirCompany airCompany);
    public void removeAirCompany(Long id);
    public AirCompany getAirCompanyById(Long id);
    public List<AirCompany> listAirCompanies();
    public Airplane moveAirPlaneBetweenCompanies(Airplane airplane, AirCompany airCompany);
}
