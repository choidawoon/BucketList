package com.toy.Backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@DynamicInsert
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

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer position;

    @Column(columnDefinition = "TINYINT", nullable = false)
    @ColumnDefault("0")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    public void changeCount(Integer count){this.count = count;}

    public void changeStatus(Integer status){this.status = status;}

    public void changePosition(Integer position){this.position = position;}
}
