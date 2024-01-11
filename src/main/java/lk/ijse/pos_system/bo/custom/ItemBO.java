package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {
    public boolean addItem(ItemDTO itemDTO) throws Exception;
    public ItemDTO searchItem(String id) throws Exception;
    public boolean updateItem(ItemDTO itemDTO) throws Exception;
    public boolean deleteItem(String id) throws Exception;
    public List<ItemDTO> getAllItems() throws Exception;

}
