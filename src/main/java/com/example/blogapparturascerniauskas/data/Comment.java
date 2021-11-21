package com.example.blogapparturascerniauskas.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
public class Comment extends User{

    @Id
    @NotBlank
    private String comment;
    private String username = super.getUsername();

}
