package spring.boot.capston2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.capston2.Model.Plants;
@Repository
public interface PlantsRepository extends JpaRepository<Plants, Integer> {
    Plants findPlantsById(Integer id);
}
