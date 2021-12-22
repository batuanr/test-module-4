package com.example.test_module_4.service.nation;

import com.example.test_module_4.model.Nation;
import com.example.test_module_4.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationService implements INationService{
    @Autowired
    INationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Nation nation) {

    }

    @Override
    public void remove(Long id) {

    }
}
