package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.IGenericServiceExpand;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.MajorConverter;
import com.example.dto.MajorDTO;
import com.example.entity.Major;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("majorService")
public class MajorService implements GenericService<MajorDTO>, IGenericServiceExpand<MajorDTO> {


    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private MajorConverter converter;

    @Override
    public MajorDTO save(MajorDTO object) {
        Major major = new Major();
        if (object.getId() != null) {
            Major oldMajor = majorRepository.
                    findOneById(object.getId())
                    .orElseThrow(() -> new ResourceNotFoundException
                            ("Không tìm thấy Major với mã: " +
                                    object.getId()));
            major = converter.toEntity(oldMajor, object);
        } else {
            major = converter.toEntity(object);
        }
        return converter.toDto(majorRepository.save(major));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            majorRepository.delete(id);
        }
    }

    @Override
    public List<MajorDTO> list() {
       List<Major> listEntity = majorRepository.findAll();
       List<MajorDTO> listDto = new ArrayList<>();
       for (Major major : listEntity) {
           MajorDTO majorDTO = converter.toDto(major);
           listDto.add(majorDTO);
       }
        return listDto;
    }


    @Override
    public MajorDTO getById(Long id) {
        return converter.toDto(searchBy.findMajorById(id));
    }
}
