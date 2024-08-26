package spring.boot.capston2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.capston2.Model.Plants;
import spring.boot.capston2.Service.PlantsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plants")
public class PlantsController {
    private final PlantsService plantsService;

    @GetMapping("/get")
    public ResponseEntity getAllPlants() {
        return ResponseEntity.ok(plantsService.getAllPlants());
    }

    @PostMapping("/add")
    public ResponseEntity addPlants(@Valid @RequestBody Plants plants) {
        plantsService.addPlant(plants);
        return ResponseEntity.status(200).body("Plants added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlants(@Valid @RequestBody Plants plants, @PathVariable Integer id) {
        plantsService.updatePlant(plants, id);
        return ResponseEntity.status(200).body("Plants updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlants(@PathVariable Integer id) {
        plantsService.deletePlants(id);
        return ResponseEntity.status(200).body("Plants deleted successfully");
    }

    @PutMapping("/assignFarmersToPlants/{id}")
    public ResponseEntity assignFarmersToPlants(@PathVariable Integer id, @RequestParam Integer farmersId) {
        plantsService.assignFarmer(id, farmersId);
        return ResponseEntity.status(200).body("assign Farmers To Plants successfully");
    }

    @PutMapping("/assignNurseriesToPlants/{id}")
    public ResponseEntity assignNurseriesToPlants(@PathVariable Integer id, @RequestParam Integer nurseriesId) {
        plantsService.assignNurseries(id, nurseriesId);
        return ResponseEntity.status(200).body("assign Nurseries To Plants successfully");
    }

    @PutMapping("/assignOrderToPlants/{id}")
    public ResponseEntity assignOrderToPlants(@PathVariable Integer id, @RequestParam Integer ordersId) {
        plantsService.assignOrderToPlant(id, ordersId);
        return ResponseEntity.status(200).body("assign Orders To Plants successfully");
    }
}
