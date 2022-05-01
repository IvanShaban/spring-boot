package com.example.servingwebcontent.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("USERS")
public class User {
    @Id
    private Long id;
    private String name;
    private Sex sex;
    private String email;
}
