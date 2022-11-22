package it.contrader.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column (name = "title")
    private String title;

    @NonNull
    @Column (name = "description")
    private String description;

    @NonNull
    @Column (name = "price")
    private Float price;

    @NonNull
    @Column (name = "discount")
    private float discount;

    @NonNull
    @Column (name = "start_discount_date")
    private LocalDate startDiscountDate;

    @NonNull
    @Column (name = "end_discount_date")
    private LocalDate endDiscountDate;

    @Column (name = "order_date")
    @CreationTimestamp
    private LocalDate orderDate;

    @NonNull
    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn (name = "user_id")
    private User user;

    @NonNull
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "center_id")
    private Center center;

    @NonNull
    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "product_id")
    private Product product;

}
