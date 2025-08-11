package com.projetos.gerenciador.serviceprovider;

import com.projetos.gerenciador.exception.BusinessException;
import com.projetos.gerenciador.exception.ErrCode;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider createUser(CreateProviderRequest createProviderRequest) {
        if (providerRepository.findByEmail(createProviderRequest.email()).isPresent()) {
            throw new BusinessException(ErrCode.EMAIL_ALREADY_EXISTS);
        }
        Provider newProvider = new Provider();
        newProvider.setUsername(createProviderRequest.name());
        newProvider.setEmail(createProviderRequest.email());
        newProvider.setPassword(createProviderRequest.password());
        return providerRepository.save(newProvider);
    }
    public void deleteUser(Long id) {
        if (providerRepository.findById(id).isEmpty()) {
            throw new BusinessException(ErrCode.USER_NOTFOUND);
        }
        providerRepository.deleteById(id);
    }
}

