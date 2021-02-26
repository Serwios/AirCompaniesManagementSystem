package Controller;

import java.util.List;

import java.util.logging.Logger;

import Entities.AirCompany;
import Entities.Airplane;
import Sevices.AirCompanyService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EndpointController {
    AirCompanyService airCompanyService;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EndpointController.class);

    @GetMapping("/create")
    public AirCompany createAirCompany(@RequestBody AirCompany airCompany) {
        return airCompanyService.addAirCompany(airCompany);
    }

    @GetMapping("/airCompanies")
    public List getAllAirCompanies() {
        return airCompanyService.listAirCompanies();
    }

    @GetMapping("/airCompany/{id}")
    public AirCompany getAirCompanyById(@PathVariable(value = "id") Long id) {
        try {
            return airCompanyService.getAirCompanyById(id);
        } catch (Exception e) {
            LOGGER.info("There is no AirCompany with this id");
            return null;
        }
    }

    @PutMapping("/airCompany/{id}")
    public AirCompany updateAirCompany(@PathVariable(value = "id") Long id, @RequestBody AirCompany airCompanyDetails) {
        AirCompany airCompany = airCompanyService.getAirCompanyById(id);
        airCompany.setCompanyType(airCompanyDetails.getType());
        airCompany.setName(airCompany.getName());
        airCompany.setFoundedAt(airCompanyDetails.getFoundedAt());

        return airCompany;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAirCompany(@PathVariable(value = "id") Long id) {
        airCompanyService.removeAirCompany(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/moveAirPlaneToCompany/{AirCompanyId}/{AirPlaneId}")
    public Airplane moveAirPlaneToCompany(@RequestBody Airplane airplane,
                                          @RequestBody AirCompany airCompany) {

        return airCompanyService.moveAirPlaneBetweenCompanies(airplane, airCompany);
    }
}
