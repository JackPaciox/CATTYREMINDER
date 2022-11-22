package it.contrader.model;

import it.contrader.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "centers")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String address;

    private String zipcode;

    private String city;

    private String province;

    private String phone;

    private String email;

    @Column(name = "website")
    private String webSite;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    protected User user;

    @OneToMany(mappedBy = "center", cascade = CascadeType.MERGE)
    protected List<Product> products;
}