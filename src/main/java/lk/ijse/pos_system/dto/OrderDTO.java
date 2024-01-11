package lk.ijse.pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String oId;
    private String oDate;
    private double oTotal;
    private double oSubTotal;
    private int oDiscount;
    private double oBalance;

    private List<ItemDTO> Items;
    private CustomerDTO customerDTO;

}
