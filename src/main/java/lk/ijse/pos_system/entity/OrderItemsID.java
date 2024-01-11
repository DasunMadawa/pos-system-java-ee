package lk.ijse.pos_system.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class OrderItemsID implements Serializable {
    private String order_t;
    private String item;

}
