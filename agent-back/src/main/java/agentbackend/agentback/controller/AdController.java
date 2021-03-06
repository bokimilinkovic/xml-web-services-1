package agentbackend.agentback.controller;

import agentbackend.agentback.controller.dto.AdClientDTO;
import agentbackend.agentback.controller.dto.AdDTO;
import agentbackend.agentback.model.Ad;
import agentbackend.agentback.service.AdService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AdController {

    @Autowired
    private AdService adService;

    // Kreiranje ad-a
    @PostMapping(value = "/api/ad", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createAd(@RequestBody AdDTO adDTO, Principal user) throws JSONException {
        int response = adService.createAd(adDTO, user.getName());
        if (response == 200)
            return ResponseEntity.ok("Ad successfully created!");
        else if (response == 402)
            return ResponseEntity.status(402).body("You have already created 3 ads!");
        else
            return ResponseEntity.status(400).body("Could not accept");

    }

    // Provera da li je ad userov
    @PostMapping(value = "/api/ad/check", produces = "application/json", consumes = "application/json")
    public Boolean checkAd(@RequestBody JSONObject object, Principal user) throws JSONException {

        if (adService.checkAds(object, user.getName()))
            return true;
        else
            return false;
    }

    // Activate ad-a
    @PutMapping(value = "/api/ad/activate/{id}")
    public ResponseEntity<String> activateAd(@PathVariable(value = "id") Long id, Principal user) {

        if (adService.activateAd(id, user.getName()))
            return ResponseEntity.ok("Ad successfully activated!");
        else
            return ResponseEntity.status(400).body("Could not accept");

    }

    // Deactivate ad-a
    @DeleteMapping(value = "/api/ad/deactivate/{id}")
    public ResponseEntity<String> deactivateAd(@PathVariable(value = "id") Long id, Principal user) {

        if (adService.deactivateAd(id, user.getName()))
            return ResponseEntity.ok("Ad successfully deactivated!");
        else
            return ResponseEntity.status(400).body("Could not accept");

    }


    // Izmena ad-a
    @PutMapping(value = "/api/ad/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> editAd(@PathVariable(value = "id") Long id, @RequestBody AdDTO adDTO, Principal user) throws JSONException {

        if (adService.editAd(id, adDTO, user.getName()))
            return ResponseEntity.ok("Ad successfully edited!");
        else
            return ResponseEntity.status(400).body("Could not accept");

    }

    // Svi adovi clienta
    @GetMapping(value = "/api/ad/client")
    public ResponseEntity<List<AdClientDTO>> getClientAds(Principal user) {
        List<AdClientDTO> ads = adService.getClientAds(user.getName());
        return ResponseEntity.ok(ads);
    }

    @GetMapping(value = "/api/ad")
    public ResponseEntity<List<Ad>> getAll() {
        List<Ad> ads = adService.getAll();
        return ResponseEntity.ok(ads);
    }

    @GetMapping(value = "/api/ad/{id}")
    public ResponseEntity<AdClientDTO> getAd(@PathVariable("id") Long id) {
        AdClientDTO ad = adService.getAdById(id);
        return ResponseEntity.ok(ad);
    }

    // Id Ad
    @GetMapping(value = "/ad/check/{id}")
    public ResponseEntity<Boolean> getAdById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(adService.getCheckAd(id));
    }

    @GetMapping(value = "/api/ad/active/{id}")
    public ResponseEntity<Boolean> getStatus(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(adService.getStatus(id));
    }
}
