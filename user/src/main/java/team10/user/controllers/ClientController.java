package team10.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team10.user.models.dto.ClientDTO;
import team10.user.models.dto.NewAgentDTO;
import team10.user.models.dto.NewCompanyDTO;
import team10.user.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("client-control")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    @PreAuthorize("hasAuthority('READ_CLIENTS')")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> retVal = clientService.getAll();
        if (retVal != null)
            return ResponseEntity.ok(retVal);
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/block/{email}")
    @PreAuthorize("hasAuthority('UPDATE_CLIENT_BLOCK')")
    public ResponseEntity<String> blockClient(@PathVariable("email") String email) {
        if (clientService.block(email))
            return ResponseEntity.ok("Operation successful!");
        return ResponseEntity.badRequest().body("Invalid request");
    }

    @PutMapping("/activate/{email}")
    @PreAuthorize("hasAuthority('UPDATE_CLIENT_BLOCK')")
    public ResponseEntity<String> activateClient(@PathVariable("email") String email) {
        if (clientService.activate(email))
            return ResponseEntity.ok("Operation successful!");
        return ResponseEntity.badRequest().body("Invalid request");
    }

    @DeleteMapping("/{email}")
    @PreAuthorize("hasAuthority('DELETE_CLIENT')")
    public ResponseEntity<String> deleteClient(@PathVariable("email") String email) {
        if (clientService.delete(email))
            return ResponseEntity.ok("Operation successful!");
        return ResponseEntity.badRequest().body("Invalid request");
    }

    @PostMapping("/company")
    @PreAuthorize("hasAuthority('ADD_COMPANY')")
    public ResponseEntity<String> registerCompany(@RequestBody NewCompanyDTO newCompanyDTO) {
        if (clientService.registerCompany(newCompanyDTO))
            return ResponseEntity.ok("Operation successful!");
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/agent")
    @PreAuthorize("hasAuthority('ADD_AGENT')")
    public ResponseEntity<String> registerAgent(@RequestBody NewAgentDTO newAgentDTO) {
        if (clientService.registerAgent(newAgentDTO))
            return ResponseEntity.ok("Operation successful!");
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping(value = "/user/{email}")
    @PreAuthorize("hasAuthority('MASTER')")
    public ResponseEntity<Long> getUserId(@PathVariable("email") String email) {
        Long id  = clientService.getUserId(email);
        if (id != null)
            return ResponseEntity.ok(id);
        return ResponseEntity.badRequest().body(null);
    }

}
