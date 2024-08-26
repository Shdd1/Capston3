package spring.boot.capston2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.capston2.API.ApiException;
import spring.boot.capston2.Model.Farmers;
import spring.boot.capston2.Model.Nurseries;
import spring.boot.capston2.Repository.FarmersRepository;
import spring.boot.capston2.Repository.NurseriesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseriesService {
    private final NurseriesRepository nurseriesRepository;
    private final FarmersRepository farmersRepository;

    public List<Nurseries> getAllNurseries() {
        return nurseriesRepository.findAll();
    }
    public void addNurseries(Nurseries nurseries){
        nurseriesRepository.save(nurseries);
    }
    public void updateNurseries(Nurseries nurseries,Integer id){
        Nurseries nurseries1 = nurseriesRepository.findNurseriesById(id);
        if (nurseries1 == null){
            throw new ApiException("Nurseries not found");
        }
        nurseries1.setName(nurseries.getName());
        nurseries1.setAddress(nurseries.getAddress());
        nurseries1.setPhone_number(nurseries.getPhone_number());
        nurseries1.setTypeOfPlants(nurseries.getTypeOfPlants());
        nurseries1.setRegistration_date(nurseries.getRegistration_date());

        nurseriesRepository.save(nurseries1);
    }
    public void deleteNurseries(Integer id){
        Nurseries nurseries = nurseriesRepository.findNurseriesById(id);
        if(nurseries == null){
            throw new ApiException("Nurseries not found");
        }
        nurseriesRepository.delete(nurseries);
    }

    public void assignFarmer(Integer id,Integer farmerId){
        Nurseries nurseries = nurseriesRepository.findNurseriesById(id);
        Farmers farmers = farmersRepository.findFarmersById(farmerId);
        if (nurseries==null){
            throw new ApiException("Nurseries not found");
        }
        if (farmers==null){
            throw new ApiException("farmers not found");
        }
        nurseries.setFarmers(farmers);

        nurseriesRepository.save(nurseries);
    }
}
