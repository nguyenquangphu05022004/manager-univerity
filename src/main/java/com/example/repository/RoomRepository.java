package com.example.repository;

import com.example.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<ClassRoom, Long> {
    Optional<ClassRoom> findOneById(Long id);
}
