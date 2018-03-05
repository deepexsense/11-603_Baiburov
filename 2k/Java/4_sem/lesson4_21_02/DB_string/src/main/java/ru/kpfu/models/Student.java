package ru.kpfu.models;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder

public class Student {
    private Long id;
    private String name;
    private String surname;

}
