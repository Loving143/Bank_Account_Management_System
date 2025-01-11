package com.bank.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bank.exception.BadRequestException;

@Component
public class FetchHelper {

    public <T> T fetchById(JpaRepository<T, Integer> repository, Integer id, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException(entityName + " not found for ID: " + id));
    }
}
