package com.example.entity.blog;

import com.example.entity.Base;
import com.example.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "blog")
@NoArgsConstructor
@Getter
@SuperBuilder(toBuilder = true)
public class Blog extends Base {
    @Column(name = "title")
    private String title;
    @Column(name = "content", columnDefinition = "NTEXT")
    private String content;
    @Column(name = "shortdescription")
    private String shortDescription;
    @Column(name = "thumnail")
    private String thumbnail;
    @Column(name = "likeBlog")
    private Integer likeBlog;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "approval")
    private Boolean approval;


    @ManyToMany
    @JoinTable(name = "blog_category",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;


    //TODO: phần về góc chia sẻ học tập của sinh viên
}
