package com.example.blogapparturascerniauskas.data;

import com.example.blogapparturascerniauskas.misc.CurrentTime;
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
public class Blog{
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @NotNull
    private String creationdate = CurrentTime.getTime();
    @NotBlank
    @Size (min = 1, message = "{validation.size.blog.name}")
    private String name;
    @NotBlank
    @Size (min = 1, message = "{validation.size.blog.body}")
    @Column (columnDefinition = "text")
    private String body;
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;

    public void addComment (Comment comment) {
       if(comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }
}
