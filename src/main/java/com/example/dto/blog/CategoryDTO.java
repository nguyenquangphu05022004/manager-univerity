package com.example.dto.blog;


import com.example.dto.GenericDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@SuperBuilder(toBuilder = true)
public class CategoryDTO extends GenericDTO {
    private String code;
    private String name;
    private List<BlogDTO> blogDTOS;
}
