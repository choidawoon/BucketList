package com.toy.Backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bucketlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne //@ManyToOne이 붙은 엔티티가 M이고 반대 엔티티가 1
    @JoinColumn(name = "MEMBER_ID")
    @NotNull
    private Member member;

    @Column(length = 45)
    @NotNull
    private String title;

    @Column(length = 45)
    @NotNull
    private String content;

    @Column(columnDefinition = "TINYINT")
    @NotNull
    private Integer type;

    @Column(length = 10)
    @NotNull
    private String category;

    private Integer totalCount;

    private Integer count;

    @Column(columnDefinition = "TINYINT")
    @ColumnDefault("0")
    @NotNull
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "POST_ID")
    private Post post;
}
