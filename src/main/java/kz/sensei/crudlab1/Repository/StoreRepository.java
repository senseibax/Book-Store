package kz.sensei.crudlab1.Repository;

import kz.sensei.crudlab1.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByName(String name);
}
