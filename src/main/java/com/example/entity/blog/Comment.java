package com.example.entity.blog;

import com.example.entity.Base;
import com.example.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Comment extends Base {
    @Column(name = "content", columnDefinition = "NTEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "likeComment")
    private Integer likeComment;
}
