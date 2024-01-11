package lk.ijse.pos_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Data
//@ToString
@Getter
@Setter
public class Order_t {
    @Id
    private String oId;
    private String oDate;
    private double oTotal;
    private double oSubTotal;
    private int oDiscount;
    private double oBalance;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToMany(mappedBy = "order_t" , cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

}
