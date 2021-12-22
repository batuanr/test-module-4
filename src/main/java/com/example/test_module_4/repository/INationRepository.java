package com.example.test_module_4.repository;

import com.example.test_module_4.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends JpaRepository<Nation, Long> {
}
