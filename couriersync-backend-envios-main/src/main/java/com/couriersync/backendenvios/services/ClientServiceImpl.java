package com.couriersync.backendenvios.services;

import com.couriersync.backendenvios.dtos.ClientRequestDTO;
import com.couriersync.backendenvios.dtos.ClientResponseDTO;
import com.couriersync.backendenvios.entities.Client;
import com.couriersync.backendenvios.mappers.ClientMapper;
import com.couriersync.backendenvios.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO requestDTO) {
        if (clientRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Client with email " + requestDTO.getEmail() + " already exists.");
        }

        Client client = ClientMapper.FromDtoToEntity(requestDTO);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.FromEntityToDto(savedClient);
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::FromEntityToDto)
                .collect(Collectors.toList());
    }
}