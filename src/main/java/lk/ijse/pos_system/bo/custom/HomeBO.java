package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.CustomerDTO;

public interface HomeBO extends SuperBO {
    int calcItems() throws Exception;
    int calcCustomers() throws Exception;
    int calcOrders() throws Exception;
    double calcSales() throws Exception;
}
