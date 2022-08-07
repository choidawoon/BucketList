package com.toy.Backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @NotNull
    private Member member;

    @ManyToOne
    @JoinColumn(name = "BUCKETLIST_ID")
    @NotNull
    private Bucketlist bucketlist;
}
