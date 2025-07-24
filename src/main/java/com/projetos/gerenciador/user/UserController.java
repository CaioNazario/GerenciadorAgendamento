    package com.projetos.gerenciador.user;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import jakarta.validation.Valid;


    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @Autowired
        UserService userService;
        @Autowired
        UserRepository userRepository;

        @PostMapping("/register")
        public ResponseEntity<CreateUserResponse> createUser (@RequestBody @Valid CreateUserRequest createUserRequest){
            User createUser = userService.createUser(createUserRequest);

            return ResponseEntity.status(201).body(new CreateUserResponse(createUser.getId(), createUser.getUsername(),
                    createUser.getEmail()));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable Long id){
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


        }

    }