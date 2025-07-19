package com.projetos.gerenciador.user;

import com.projetos.gerenciador.exception.ErrorCode;
import com.projetos.gerenciador.exception.BusinessException;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        return userRepository.save(user);
    }

    public void  deleteUser (Long id) {

        if (!userRepository.existsById(id)) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);

    }


}

