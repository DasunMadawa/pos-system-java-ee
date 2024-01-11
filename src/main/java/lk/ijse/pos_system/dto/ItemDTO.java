package lk.ijse.pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private String iCode;
    private String iName;
    private double iPrice;
    private int iQty;

}
