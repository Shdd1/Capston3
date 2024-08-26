package spring.boot.capston2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.capston2.Model.Farmers;
@Repository
public interface FarmersRepository extends JpaRepository<Farmers, Integer> {
    Farmers findFarmersById(Integer id);
}
