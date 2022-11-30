package com.Cattyreminder.cattyreminder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Boolean state;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "segment_id")
    private Segment segment;


}
