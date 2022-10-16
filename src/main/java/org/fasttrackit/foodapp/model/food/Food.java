package org.fasttrackit.foodapp.model.food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String place;
    @Column
    private long dailyconsumable;
    @Column
    private double dailyaverage;
    @Column
    private String city;
    @Transient
    private List<String> category;
}
