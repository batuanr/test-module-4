package com.example.test_module_4.service.city;

import com.example.test_module_4.model.City;
import com.example.test_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGeneralService<City> {
    Page<City> findAll(Pageable pageable);
}
