package com.example.librarymanagement.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE)

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    public Category( String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
