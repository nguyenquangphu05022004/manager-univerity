package com.example.Service;

public interface IRequestService<T> extends GenericService<T>{
    T request(T t);
    T request(Long id);
}
