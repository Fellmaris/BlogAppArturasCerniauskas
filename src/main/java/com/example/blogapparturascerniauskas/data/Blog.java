package com.example.blogapparturascerniauskas.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name="blogs")
public class Blog extends User{
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @NotNull
    private Date creationdate = java.util.Calendar.getInstance().getTime();
    @NotBlank
    @Size (min = 1, message = "{validation.size.blog.name}")
    private String name;
    @NotBlank
    @Size (min = 1, message = "{validation.size.blog.body}")
    @Column (columnDefinition = "text")
    private String body;
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments;

    public void addComment (Comment comment) {
       if(comments == null) {
            comments = new HashSet<>();
        }
        comments.add(comment);
    }
}
