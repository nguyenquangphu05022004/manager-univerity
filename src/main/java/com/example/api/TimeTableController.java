package com.example.api;

import com.example.Service.imp.TimeTableService;
import com.example.dto.TimeTableDTO;
import com.example.entity.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TimeTableController {
    @Autowired
    private TimeTableService timeTableService;
    @PostMapping("/api/time/table")
    public TimeTableDTO addTimeTable(@RequestBody TimeTableDTO timeTableDTO) {
        return timeTableService.save(timeTableDTO);
    }
    @GetMapping("/api/time/table")
    public List<TimeTableDTO> getList() {
        return timeTableService.list();
    }
}
