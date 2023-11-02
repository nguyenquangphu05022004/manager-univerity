package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.GroupConverter;
import com.example.dto.GroupDTO;
import com.example.entity.Group;
import com.example.repository.GroupRepository;
import com.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("groupOfService")
public class GroupService implements GenericService<GroupDTO> {


    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupConverter groupConverter;
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public GroupDTO save(GroupDTO object) {
        Group group = new Group();
        if(object.getId() != null) {
            Group old = groupRepository.findOne(object.getId());
            group = groupConverter.toEntity(old, object);
        } else {
            group = groupConverter.toEntity(object);
        }
        return groupConverter.toDto(groupRepository.save(group));
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<GroupDTO> list() {
        List<Group> listGroups = groupRepository.findAll();
        return groupConverter.dtoList(listGroups);
    }

    @Override
    public GroupDTO getById(Long id) {
        return null;
    }

    @Override
    public List<GroupDTO> getByCode(String code) {
        return null;
    }
}
