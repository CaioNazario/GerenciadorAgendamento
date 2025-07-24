package com.projetos.gerenciador.user;

import com.projetos.gerenciador.exception.ErrCode;
import com.projetos.gerenciador.exception.BusinessException;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest createUserRequest) {

        if (userRepository.findByEmail(createUserRequest.email()).isPresent()) {
            throw new BusinessException(ErrCode.EMAIL_ALREADY_EXISTS);
        }
        User newUser = new User();
        newUser.setUsername(createUserRequest.name());
        newUser.setEmail(createUserRequest.email());
        newUser.setPassword(createUserRequest.password());
        return userRepository.save(newUser);
    }

    public void  deleteUser (Long id) {

        if (!userRepository.existsById(id)) {
            throw new BusinessException(ErrCode.USER_NOTFOUND);
        }
        userRepository.deleteById(id);
    }


}