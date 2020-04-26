package com.dbapresents.datingplatform.profile;

import com.dbapresents.datingplatform.breed.Breed;

import javax.persistence.*;

@Entity(name = "PROFILES")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long id;

    @Column(name = "PRO_NAME")
    private String name;

    @Column(name = "PRO_HEIGHT")
    private Integer height;

    @Column(name = "PRO_WEIGHT")
    private Integer weight;

    @Column(name = "PRO_DESCRIPTION")
    private String description;

    @Column(name = "PRO_IMAGE_URL")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "PRO_BRE_ID")
    private Breed breed;

    @Column(name = "PRO_GENDER")
    private Character gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }
}
