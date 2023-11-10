package com.example.dto.blog;

import com.example.dto.GenericDTO;
import com.example.dto.StudentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BlogDTO extends GenericDTO {
    private String title;
    private String content;
    private String shortDescription;
    private String thumbnail;
    private Integer likeBlog;
    private Set<Long> categoryIds ;
    private Set<String> categoryNames;
    private List<CommentDTO> commentDTOS;
    private StudentDTO studentDTO;
    private Boolean approval;
}
