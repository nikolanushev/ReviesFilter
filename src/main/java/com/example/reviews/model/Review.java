package com.example.reviews.model;

import lombok.Data;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {

    public Review() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewId;

    private String reviewFullText;

    private String reviewText;

    private Integer numLikes;

    private Integer numComments;

    private Integer numShares;

    private Integer rating;

    private String reviewCreatedOn;

    private String reviewCreatedOnDate;

    private Long reviewCreatedOnTime;

    private Long reviewerId;

    private String reviewerUrl;

    private String reviewerName;

    private String reviewerEmail;

    private String sourceType;

    private boolean isVerified;

    private String source;

    private String sourceName;

    private String sourceId;

    @OneToMany
    private List<Tag> tags;

    private String href;

    private String logoHref;

    @OneToMany
    private List<Photo> photos;

    public Review(Long id, String reviewId, String reviewFullText, String reviewText, Integer numLikes, Integer numComments, Integer numShares,
                  Integer rating, String reviewCreatedOn, String reviewCreatedOnDate, Long reviewCreatedOnTime, Long reviewerId, String reviewerUrl,
                  String reviewerName, String reviewerEmail, String sourceType, boolean isVerified, String source, String sourceName,
                  String sourceId, List<Tag> tags, String href, String logoHref, List<Photo> photos) {
        this.id = id;
        this.reviewId = reviewId;
        this.reviewFullText = reviewFullText;
        this.reviewText = reviewText;
        this.numLikes = numLikes;
        this.numComments = numComments;
        this.numShares = numShares;
        this.rating = rating;
        this.reviewCreatedOn = reviewCreatedOn;
        this.reviewCreatedOnDate = reviewCreatedOnDate;
        this.reviewCreatedOnTime = reviewCreatedOnTime;
        this.reviewerId = reviewerId;
        this.reviewerUrl = reviewerUrl;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.sourceType = sourceType;
        this.isVerified = isVerified;
        this.source = source;
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.tags = tags;
        this.href = href;
        this.logoHref = logoHref;
        this.photos = photos;
    }

}

