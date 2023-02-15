package com.wecare.coachservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
@Getter
@Setter
@ToString
public class Coach extends BaseEntity {

    @NotNull
    @Size(min = 10,max = 50)
    private String speciality;

}

