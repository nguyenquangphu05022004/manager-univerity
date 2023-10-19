package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.GroupDTO;
import com.example.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("converterGroup")
public class GroupConverter implements GenericConverter<Group, GroupDTO> {

    @Autowired
    private SubjectConverter subjectConverter;


    @Override
    public Group toEntity(GroupDTO dto) {
        return Group.builder().code(dto.getCode()).build();
    }

    @Override
    public GroupDTO toDto(Group entity) {
        return GroupDTO.builder().code(entity.getCode())
//                .subjectDTOS(subjectConverter.dtoList(entity.getSubjects()))
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .id(entity.getId()).build();
    }

    @Override
    public Group toEntity(Group entity, GroupDTO dto) {
        return entity
                .toBuilder()
                .code(dto.getCode())
                .build();
    }

    @Override
    public GroupDTO toDto(GroupDTO dto, Group entity) {
        return null;
    }

    @Override
    public List<GroupDTO> dtoList(List<Group> entityList) {
        List<GroupDTO> groupDTOS = new ArrayList<>();
        for(Group group : entityList) {
            groupDTOS.add(toDto(group));
        }
        return groupDTOS;
    }



}
