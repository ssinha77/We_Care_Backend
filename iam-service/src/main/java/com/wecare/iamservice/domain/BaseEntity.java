package com.wecare.iamservice.domain;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
public class BaseEntity {

    @Id
    String id;

    @NonNull
    @Size(min = 3,max = 50)
    String name;

    @NotNull
    @Size(min = 5,max = 10)
    String password;

    @NotNull
    @Size(max = 10, min = 10)
    String mobile;

    @NotNull
    Gender gender;

    @NotNull
    String dateOfBirth;

}
