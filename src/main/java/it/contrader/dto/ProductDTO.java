package it.contrader.dto;

import it.contrader.model.Center;
import lombok.*;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private float price;
    @NonNull
    private float discount;
    @NonNull
    private int qty;
    @NonNull
    private LocalDate startDiscountDate;
    @NonNull
    private LocalDate endDiscountDate;

    private boolean deleted = false;

    private LocalDate createdAt;

    private LocalDate updatedAt;
    @NonNull
    private CenterDTO center;

    public ProductDTO(long id, @NonNull String title, @NonNull String description, float price, float discount, int qty, @NonNull LocalDate startDiscountDate, @NonNull LocalDate endDiscountDate, @NonNull CenterDTO center) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.qty = qty;
        this.startDiscountDate = startDiscountDate;
        this.endDiscountDate = endDiscountDate;
        this.center = center;
        this.setDeleted(false) ;
    }
}
