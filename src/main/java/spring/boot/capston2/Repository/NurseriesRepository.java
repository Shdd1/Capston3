package spring.boot.capston2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.capston2.Model.Nurseries;
@Repository
public interface NurseriesRepository extends JpaRepository<Nurseries, Integer> {
    Nurseries findNurseriesById(Integer id);
}
