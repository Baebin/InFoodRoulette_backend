package com.inha.nit.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "food")
public class Food {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    // Name
    @Column(nullable = false)
    private String food;

    // Korea, China, Japan, Western
    @Builder.Default
    @Column(nullable = false)
    private int type = 0;

    // 1 ~ 5
    @Builder.Default
    @Column(nullable = false)
    private int rate = 0;

    // 1: true, 2: false
    @Builder.Default
    @Column(nullable = false)
    private int delivery = 0;

    public Food() {}
}
