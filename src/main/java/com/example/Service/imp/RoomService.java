package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.ClassRoomConverter;
import com.example.dto.ClassRoomDTO;
import com.example.entity.ClassRoom;
import com.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roomOfService")
public class RoomService implements GenericService<ClassRoomDTO> {


    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ClassRoomConverter classRoomConverter;
    @Autowired
    private GenericSearchBy searchBy;
    @Override
    public ClassRoomDTO save(ClassRoomDTO object) {
        ClassRoom classRoom = new ClassRoom();
        if(object.getId() != null) {
            ClassRoom oldRoom = searchBy.findClassRoomById(object.getId());
            classRoom = classRoomConverter.toEntity(oldRoom, object);
        } else {
            classRoom = classRoomConverter.toEntity(object);
        }
//        classRoom.toBuilder()
//            .subject(subject);
        return classRoomConverter.toDto(roomRepository.save(classRoom));
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id : ids) {
            roomRepository.delete(id);
        }
    }

    @Override
    public List<ClassRoomDTO> list() {
//        List<ClassRoom> classRooms = roomRepository.findAll();
//        return classRoomConverter.dtoList(classRooms);
        return null;
    }

   
}
