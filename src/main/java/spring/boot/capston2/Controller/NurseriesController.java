package spring.boot.capston2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.capston2.Model.Nurseries;
import spring.boot.capston2.Service.NurseriesService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/nurseries")
public class NurseriesController {
    private final NurseriesService nurseriesService;
    @GetMapping("/get")
    public ResponseEntity getAllNurseries(){
        return ResponseEntity.status(200).body(nurseriesService.getAllNurseries());
    }
    @PostMapping("/add")
    public ResponseEntity addNurseries(@Valid @RequestBody Nurseries nurseries){
        nurseriesService.addNurseries(nurseries);
        return ResponseEntity.status(200).body("Nurseries add successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateNurseries(@Valid @RequestBody Nurseries nurseries,@PathVariable Integer id){
        nurseriesService.updateNurseries(nurseries,id);
        return ResponseEntity.status(200).body("Nurseries update successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNurseries(@PathVariable Integer id){
        nurseriesService.deleteNurseries(id);
        return ResponseEntity.status(200).body("Nurseries delete successfully");
    }
    @PutMapping("/assignNurseriesToFarmers/{id}")
    public ResponseEntity assignNurseriesToFarmers(@PathVariable Integer id , @RequestParam Integer farmersId){
        nurseriesService.assignFarmer(id, farmersId);
        return ResponseEntity.status(200).body("Assign Nurseries To Farmers successfully");
    }
}
