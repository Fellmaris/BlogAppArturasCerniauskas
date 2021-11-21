package com.example.blogapparturascerniauskas.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private String username;
    private String password;
    private String type;
}
