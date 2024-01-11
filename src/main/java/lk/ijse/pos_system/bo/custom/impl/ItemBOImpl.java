package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.ItemBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();

            itemDAO.add(modelMapper.map(itemDTO , Item.class) , session);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }

    }

    @Override
    public ItemDTO searchItem(String id) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();

            Item item = itemDAO.search(id, session);
            transaction.commit();
            return modelMapper.map(item , ItemDTO.class);
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }

    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();

            itemDAO.update(modelMapper.map(itemDTO , Item.class) , session);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();

            itemDAO.delete(id , session);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }
    }

    @Override
    public List<ItemDTO> getAllItems() throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();

            List<Item> itemList = itemDAO.getAll(session);

            transaction.commit();

            List<ItemDTO> itemDTOList = new ArrayList<>();

            for (Item item : itemList) {
                itemDTOList.add(modelMapper.map(item , ItemDTO.class));

            }

            return itemDTOList;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }


    }

}
