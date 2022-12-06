package com.dsaurabh.HibernateMappingSelf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.List;

/**
 *  user                                books
 *  1                                       N
 *  1                                       1
 *  --------------------------------------------
 *  1                                          N
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID userId;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Books> booksList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> orderList;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
