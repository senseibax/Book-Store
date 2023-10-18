package kz.sensei.crudlab1.Controller;

import kz.sensei.crudlab1.Model.Store;
import kz.sensei.crudlab1.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public List<Store> getAllStore(){
        return storeService.takeAllStore();
    }

    @PostMapping("/")
    public ResponseEntity<Store> createStore(@RequestBody Store store){
        storeService.createStore(store);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Store> getById(@PathVariable Long id){
        return storeService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateStore(@PathVariable Long id, @RequestBody Store store){
        storeService.updateStore(id, store);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id){
        storeService.deleteStore(id);
    }

    @GetMapping("/search")
    public List<Store> serachStores(@RequestParam String keyword){
        return storeService.searchStore(keyword);
    }

}
