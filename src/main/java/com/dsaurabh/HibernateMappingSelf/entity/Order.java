package com.dsaurabh.HibernateMappingSelf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.List;

/**
 *
 * order                        books
 * 1                               N
 * 1                                1
 * ---------------------------------------
 * 1                                N
 *
 *
 * order                            user
 * 1                                    1
 * N                                    1
 *-------------------------------------------------
 * N                                    1
 *
 *
 */



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Order {

    @Id
    @GeneratedValue
    private UUID orderId;

    @ManyToOne
    @JoinColumn
    private User user;


    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<Books> booksList;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    private Double orderAmount;



}
