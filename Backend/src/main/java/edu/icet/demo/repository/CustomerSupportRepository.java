package edu.icet.demo.repository;
import edu.icet.demo.entity.CustomerSupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerSupportRepository extends JpaRepository<CustomerSupportEntity,Integer> {
}
