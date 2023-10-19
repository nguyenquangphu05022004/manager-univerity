package com.example.api;

import com.example.Service.imp.GroupService;
import com.example.dto.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class GroupController
{

    @Autowired
    private GroupService groupService;
    @PostMapping("/api/groups")
    public GroupDTO addGroup(@RequestBody GroupDTO groupDTO) {
            return groupService.save(groupDTO);
    }
    @GetMapping("/api/groups")
    public List<GroupDTO> getListGroup() {
        return groupService.list();
    }
}
