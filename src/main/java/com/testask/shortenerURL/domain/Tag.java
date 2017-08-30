package com.testask.shortenerURL.domain;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Long idTag;

    @Column(name = "name_tag")
    private String nameTag;

    public Long getIdTag() {
        return idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "idTag=" + idTag +
                ", nameTag='" + nameTag + '\'' +
                '}';
    }
}
