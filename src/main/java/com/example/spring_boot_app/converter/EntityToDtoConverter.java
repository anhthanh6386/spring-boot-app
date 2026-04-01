package com.example.spring_boot_app.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
// Assuming you have Entity and DTO classes defined

@Service
public class EntityToDtoConverter {
    // Method to convert a single Entity to a DTO
    public static <E, D> void convertEntityToDto(E entity, D dto) {
        BeanUtils.copyProperties(entity, dto);
    }
}
