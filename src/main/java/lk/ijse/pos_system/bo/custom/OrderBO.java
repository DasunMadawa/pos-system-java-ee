package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.OrderDTO;

import java.util.List;

public interface OrderBO extends SuperBO {
    public boolean addOrder(OrderDTO orderDTO) throws Exception;
    public OrderDTO searchOrder(String id) throws Exception;
    public List<OrderDTO> getAllOrders() throws Exception;

}
