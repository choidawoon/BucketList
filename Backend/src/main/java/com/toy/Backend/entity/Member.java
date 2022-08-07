package com.toy.Backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column(length = 15)
    private String id;

    private String image;

    @Column(length = 20)
    @NotNull
    private String name;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    @NotNull
    private boolean isDeleted;

//    private String refreshToken;
}
