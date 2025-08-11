package com.projetos.gerenciador.client;

import com.projetos.gerenciador.exception.ErrCode;
import com.projetos.gerenciador.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;
    }

    public Client createUser(CreateClientRequest createClientRequest) {

        if (clientRepository.findByEmail(createClientRequest.email()).isPresent()) {
            throw new BusinessException(ErrCode.EMAIL_ALREADY_EXISTS);
        }
        Client newClient = new Client();
        newClient.setUsername(createClientRequest.name());
        return clientRepository.save(newClient);
    }

    public void deleteUser(Long id) {

        if (clientRepository.findById(id).isEmpty()) {
            throw new BusinessException(ErrCode.USER_NOTFOUND);

        }
        clientRepository.deleteById(id);
    }
    public List<Client> findAllUsers(){
        List<Client> clients = clientRepository.findAll();
        return clients;


    }



}