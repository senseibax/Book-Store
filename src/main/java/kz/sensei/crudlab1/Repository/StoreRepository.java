package kz.sensei.crudlab1.Repository;

import kz.sensei.crudlab1.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
