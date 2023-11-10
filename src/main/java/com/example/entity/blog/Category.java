package com.example.entity.blog;

import com.example.entity.Base;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Category  extends Base {
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Blog> blogs;
}
