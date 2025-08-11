package com.projetos.gerenciador.serviceprovider;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CreateProviderResponse> createProvider(@RequestBody @Valid CreateProviderRequest createProviderRequest){
        Provider createUser = providerService.createUser(createProviderRequest);

        return  ResponseEntity.status(201).body(new CreateProviderResponse(createUser.getId(), createUser.getUsername(),
                createUser.getEmail()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        providerService.deleteUser(id);
        return ResponseEntity.status(204).build();
    }
}
