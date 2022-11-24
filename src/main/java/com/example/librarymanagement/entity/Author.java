package com.example.librarymanagement.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "author_sequence")

    @Column(name = "id")
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "description")
    private String description;

    public Author( String authorName, String description) {
        this.authorName = authorName;
        this.description = description;
    }

    public Author(Long id, String authorName, String description) {
        this.id = id;
        this.authorName = authorName;
        this.description = description;
    }

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
