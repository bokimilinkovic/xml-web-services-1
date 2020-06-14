package team10.codebook.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team10.codebook.models.dto.CarDTO;
import team10.codebook.models.dto.UpdateCarDTO;

import java.util.List;

@FeignClient(name = "cars-ads")
public interface CarsAdsProxy {
    @GetMapping("/cars/brands/{brand}")
    public ResponseEntity<List<CarDTO>> getCarsByBrand(@PathVariable String brand, @RequestHeader("Authorization") String auth);

    @GetMapping("/cars/class/{carClass}")
    public ResponseEntity<List<CarDTO>>getCarsByCarClass(@PathVariable String carClass, @RequestHeader("Authorization") String auth);

    @GetMapping("/cars/models/{model}")
    public ResponseEntity<List<CarDTO>>getCarsByModel(@PathVariable String model, @RequestHeader("Authorization") String auth);

    @GetMapping("/cars/fuels/{fuel}")
    public ResponseEntity<List<CarDTO>>getCarsByFuel(@PathVariable String fuel, @RequestHeader("Authorization") String auth);

    @GetMapping("/cars/transmissions/{transmission}")
    public ResponseEntity<List<CarDTO>>getCarsByTransmission(@PathVariable String transmission, @RequestHeader("Authorization") String auth);

    @PutMapping(value = "cars/{id}")
    public ResponseEntity<String>updateCar(@RequestBody UpdateCarDTO updateCarDTO, @PathVariable Long id, @RequestHeader("Authorization") String auth);
}