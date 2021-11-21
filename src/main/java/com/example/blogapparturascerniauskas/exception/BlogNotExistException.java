package com.example.blogapparturascerniauskas.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BlogNotExistException extends RuntimeException{
    private final UUID productId;
}
