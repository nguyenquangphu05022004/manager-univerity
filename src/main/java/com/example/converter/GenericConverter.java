package com.example.converter;

import java.util.List;
import java.util.Set;

public interface GenericConverter <E, D>{
    E toEntity(D dto);
    D toDto(E entity);
    E toEntity(E entity, D dto);
    D toDto(D dto, E entity);
    List<D> dtoList(List<E> entityList);
}
