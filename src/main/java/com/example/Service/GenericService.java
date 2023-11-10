package com.example.Service;

import java.util.List;

public interface GenericService <T>{
    T save(T object);
    void delete(Long[] ids);
    List<T> list();

}
