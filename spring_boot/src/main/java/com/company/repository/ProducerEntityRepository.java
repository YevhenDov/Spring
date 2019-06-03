package com.company.repository;

import com.company.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerEntityRepository extends JpaRepository<ProducerEntity, Long> {
     Optional<ProducerEntity> findByName(String name);
}
