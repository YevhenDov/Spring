package com.company.repository;

import com.company.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerEntityRepository extends JpaRepository<ProducerEntity, Long> {
    ProducerEntity findByName(String name);
}
