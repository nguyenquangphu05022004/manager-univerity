package com.example.api;

import com.example.Service.imp.RoomService;
import com.example.dto.ClassRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class RoomController {


    @Autowired
    private RoomService roomService;

    @GetMapping("/api/rooms")
    public List<ClassRoomDTO> getListRoom() {
        return roomService.list();
    }
    @PostMapping("/api/rooms")
    public ClassRoomDTO addRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        return roomService.save(classRoomDTO);
    }

    @PutMapping("/api/rooms/{id}")
    public ClassRoomDTO updateRoom(@PathVariable("id") Long id, @RequestBody ClassRoomDTO classRoomDTO) {
        return roomService.save(classRoomDTO.toBuilder().id(id).build());
    }
    @DeleteMapping("/api/rooms")
    public void deleteRoom(@RequestBody Long[] ids) {
         roomService.delete(ids);
    }
}
