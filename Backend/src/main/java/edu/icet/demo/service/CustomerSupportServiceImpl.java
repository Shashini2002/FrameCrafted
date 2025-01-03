package edu.icet.demo.service;

import edu.icet.demo.dto.CustomerSupport;

import edu.icet.demo.entity.CustomerSupportEntity;

import edu.icet.demo.repository.CustomerSupportRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerSupportServiceImpl implements CustomerSupportService{
    private final CustomerSupportRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<CustomerSupport> getAllCustomerSupport() {
        return repository.findAll().stream()
                .map(CustomerSupportEntity->mapper.map(CustomerSupportEntity,CustomerSupport.class))
                .collect(Collectors.toList());

    }

    @Override
    public void addCustomerSupport(CustomerSupport customerSupport) {
        System.out.println("Incoming Order DTO: " + customerSupport);
        try {
            CustomerSupportEntity entity = mapper.map(customerSupport, CustomerSupportEntity.class);
            System.out.println("Mapped Entity: " + entity);
            repository.save(entity);
        } catch (Exception e) {
            System.err.println("Mapping or Saving Failed: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateCustomerSupport(CustomerSupport customerSupport) {

    }
}
