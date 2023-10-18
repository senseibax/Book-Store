package kz.sensei.crudlab1.service;

import kz.sensei.crudlab1.Model.Book;
import kz.sensei.crudlab1.Model.Store;
import kz.sensei.crudlab1.Repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> takeAllStore(){
        return storeRepository.findAll();
    }

    public Optional<Store> findById(Long id){
        return storeRepository.findById(id);
    }

    public void createStore(Store store){
        storeRepository.save(store);
    }

    public void deleteStore(Long id){
        storeRepository.deleteById(id);
    }

    public void updateStore(Long id, Store updatedStore){
        Store store = storeRepository.getOne(id);
        store.setName(updatedStore.getName());
        store.setEmail(updatedStore.getEmail());
        store.setPhoneNumber(updatedStore.getPhoneNumber());
        storeRepository.save(store);
    }

    public List<Store> searchStore(String name){
        return storeRepository.findByName(name);
    }
}
