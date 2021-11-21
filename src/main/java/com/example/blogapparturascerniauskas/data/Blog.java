package com.example.blogapparturascerniauskas.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="Blogs")
public class Blog extends User{
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @NotBlank
    @Size (min = 1, message = "{validation.size.blog.name}")
    private String name;
    @NotBlank
    @Size (min = 1, message = "{validation.size.blog.body}")
    @Column (columnDefinition = "text")
    private String body;

    private String comments;
}
