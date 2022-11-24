package com.example.librarymanagement.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @SequenceGenerator(name = "publisher_sequence", sequenceName = "publisher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "publisher_sequence")

    @Column(name = "id")
    private Long id;

    @Column(name = "publisher_name")
    private String publisherName;

    public Publisher( String publisherName) {
        this.publisherName = publisherName;
    }

    public Publisher(Long id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }

    public Publisher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
