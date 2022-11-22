package it.contrader.model;

import it.contrader.dto.CenterDTO;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "title")
    @NonNull
    private String title;

    @Column (name = "description")
    @NonNull
    private String description;

    @Column (name = "price")
    @NonNull
    private float price;

    @Column (name = "discount")
    @NonNull
    private float discount;

    @Column (name = "quantity")
    @NonNull
    private int qty;

    @Column (name = "start_discount_date")
    @NonNull
    private LocalDate startDiscountDate;

    @Column (name = "end_discount_date")
    @NonNull
    private LocalDate endDiscountDate;

    @Column (name = "deleted")
    private boolean deleted = false;

    @Column (name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Column (name = "updated_at", updatable = false, insertable = false)
    private LocalDate updatedAt;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "center_id")
    @NonNull
    protected Center center;


    public Product(long id, @NonNull String title, @NonNull String description, float price, float discount, int qty, @NonNull LocalDate startDiscountDate, @NonNull LocalDate endDiscountDate, @NonNull Center center) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.qty = qty;
        this.startDiscountDate = startDiscountDate;
        this.endDiscountDate = endDiscountDate;
        this.center = center;
    }
}
