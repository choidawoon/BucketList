package com.toy.Backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class BucketlistTagId implements Serializable{

    @ManyToOne
    @JoinColumn(name = "BUCKETLIST_ID")
    private Bucketlist bucketlist;

    @ManyToOne
    @JoinColumn(name = "HASHTAG_ID")
    private Hashtag hashtag;

}
