package com.example.blogapparturascerniauskas.data;

import com.example.blogapparturascerniauskas.misc.CurrentTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "comments")
public class Comment{
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "blog_id")
    private Blog blog;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    private String creationDate = CurrentTime.getTime();
    private String comment;

}
