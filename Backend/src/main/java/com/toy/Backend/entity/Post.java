package com.toy.Backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @NotNull
    private String content;

    @Column(name = "create_date", insertable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @NotNull
    private Member member;

    @ManyToOne
    @JoinColumn(name = "bucketlist_id")
    private Bucketlist bucketlist;

    @OneToMany(mappedBy = "post")
    List<PostImage> images = new ArrayList<>();

    public void changeTitle(String title){this.title = title;}

    public void changeContent(String content){this.content = content;}


}
