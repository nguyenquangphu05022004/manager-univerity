package com.example.dto.blog;

import com.example.dto.GenericDTO;
import com.example.dto.StudentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class CommentDTO extends GenericDTO {
    private Integer likeComment;
    private String content;
    private BlogDTO blogDTO;
    private StudentDTO studentDTO;
}
