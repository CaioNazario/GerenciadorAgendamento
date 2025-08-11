    package com.projetos.gerenciador.client;


    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import jakarta.validation.Valid;




    @RestController
    @RequestMapping("/api/users")
    public class ClientController {

        ClientService clientService;

        public ClientController(ClientService clientService) {
            this.clientService = clientService;
        }
        @PostMapping("/register")
        public ResponseEntity<CreateClientResponse> createUser (@RequestBody @Valid CreateClientRequest createClientRequest){
            Client createClient = clientService.createUser(createClientRequest);

            return ResponseEntity.status(201).body(new CreateClientResponse(createClient.getId(), createClient.getUsername(),
                    createClient.getEmail()));
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
            clientService.deleteUser(id);
            return ResponseEntity.status(200).build();
        }
    }