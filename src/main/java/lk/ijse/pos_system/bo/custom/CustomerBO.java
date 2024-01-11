package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception;
    public CustomerDTO searchCustomer(String id) throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;
    public boolean deleteCustomer(String id) throws Exception;
    public List<CustomerDTO> getAllCustomers() throws Exception;

}
