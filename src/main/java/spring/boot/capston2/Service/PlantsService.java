package spring.boot.capston2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.capston2.API.ApiException;
import spring.boot.capston2.Model.Farmers;
import spring.boot.capston2.Model.Nurseries;
import spring.boot.capston2.Model.Orders;
import spring.boot.capston2.Model.Plants;
import spring.boot.capston2.Repository.FarmersRepository;
import spring.boot.capston2.Repository.NurseriesRepository;
import spring.boot.capston2.Repository.OrdersRepository;
import spring.boot.capston2.Repository.PlantsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantsService {
    private final PlantsRepository plantsRepository;
    private final FarmersRepository farmersRepository;
    private final NurseriesRepository nurseriesRepository;
    private final OrdersRepository ordersRepository;

    public List<Plants> getAllPlants() {
        return plantsRepository.findAll();
    }

    public void addPlant(Plants plants) {
        plantsRepository.save(plants);
    }

    public void updatePlant(Plants plants, Integer id) {
        Plants plant = plantsRepository.findPlantsById(id);
        if (plant == null) {
            throw new ApiException("Plant not found");
        }
        plant.setName(plants.getName());
        plant.setDescription(plants.getDescription());
        plant.setPlantingSeason(plants.getPlantingSeason());
        plant.setLightRequirements(plants.getLightRequirements());
        plant.setCategory(plants.getCategory());
        plant.setPrice(plants.getPrice());
        plant.setSoilTypeRequirements(plants.getSoilTypeRequirements());
        plant.setTemperatureRequirements(plants.getTemperatureRequirements());
        plant.setStock(plants.getStock());
        plant.setWaterRequirements(plants.getWaterRequirements());
        plant.setGrowthTime(plants.getGrowthTime());

        plantsRepository.save(plant);
    }

    public void deletePlants(Integer id) {
        Plants plants = plantsRepository.findPlantsById(id);
        if (plants == null) {
            throw new ApiException("Plants not found");
        }
        plantsRepository.delete(plants);
    }

    public void assignFarmer(Integer id, Integer farmerId) {
        Plants plants = plantsRepository.findPlantsById(id);
        Farmers farmers = farmersRepository.findFarmersById(farmerId);
        if (plants == null) {
            throw new ApiException("plants not found");
        }
        if (farmers == null) {
            throw new ApiException("farmers not found");
        }
        plants.setFarmers(farmers);

        plantsRepository.save(plants);
    }

    public void assignNurseries(Integer id, Integer nurseriesId) {
        Plants plants = plantsRepository.findPlantsById(id);
        Nurseries nurseries = nurseriesRepository.findNurseriesById(nurseriesId);
        if (plants == null) {
            throw new ApiException("Plants not found");
        }
        if (nurseries == null) {
            throw new ApiException("nurseries not found");
        }
        plants.setNurseries(nurseries);

        plantsRepository.save(plants);
    }

    public void assignOrderToPlant(Integer id, Integer orderId) {
        Plants plants = plantsRepository.findPlantsById(id);
        Orders orders = ordersRepository.findOrdersById(orderId);
        if (plants == null) {
            throw new ApiException("plants not found");
        }
        if (orders == null) {
            throw new ApiException("orders not found");
        }
        plants.getOrders().add(orders);
        orders.getPlants().add(plants);

        ordersRepository.save(orders);
        plantsRepository.save(plants);
    }
}
