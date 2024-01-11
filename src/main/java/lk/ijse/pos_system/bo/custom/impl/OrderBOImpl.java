package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.OrderBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.dto.OrderDTO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.entity.Order_t;
import lk.ijse.pos_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    ModelMapper modelMapper = new ModelMapper();
//    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
//        Transaction transaction = null;
//
//        try (Session session = FactoryConfiguration.getInstance().getSession()) {
//            transaction = session.beginTransaction();
//
//            for (ItemDTO itemDTO : orderDTO.getItemDTOList()) {
//                Item tempItem = itemDAO.search(itemDTO.getiCode(), session);
//
//                int newQty = tempItem.getiQty() - itemDTO.getiQty();
//
//                if (newQty < 0) {
//                    throw new Exception();
//                }
//                System.out.println(newQty);
//                tempItem.setiQty(newQty);
//
//                itemDAO.update(tempItem , session);
//            }
//            System.out.println(1);
//
//            orderDAO.add(toOrder(orderDTO) , session);
//            System.out.println(2);
//
//            transaction.commit();
//            System.out.println(3);
//            return true;
//        } catch (Exception e) {
//            transaction.rollback();
//            e.printStackTrace();
//            throw new Exception();
//        }
//
//        for (ItemDTO itemDTO : orderDTO.getItems()) {
//            ItemDTO tempItem = itemService.searchItem(itemDTO.getiCode());
//
//            tempItem.setiQty(tempItem.getiQty() - itemDTO.getiQty());
//
//            if (tempItem.getiQty() < 0) {
//                throw new Exception();
//            }
//
//            itemService.updateItem(tempItem);
//
//        }
//        Order_t order_t = modelMapper.map(orderDTO, Order_t.class);
//
//        List<OrderItem> orderItems = new ArrayList<>();
//        for (ItemDTO itemDTO : orderDTO.getItems()) {
//            orderItems.add(
//                    new OrderItem(order_t , modelMapper.map(itemDTO , Item.class ) , itemDTO.getiQty())
//            );
//        }
//
//        order_t.setOrderItems(orderItems);
//
//        orderRepo.save(order_t);
        return true;

    }

    @Override
    public OrderDTO searchOrder(String id) throws Exception {
//        Transaction transaction = null;
//
//        try (Session session = FactoryConfiguration.getInstance().getSession()) {
//            transaction = session.beginTransaction();
//
//            Order_t order_t = orderDAO.search(id, session);
//
//            return toOrderDTO(order_t);
//        } catch (Exception e) {
//            transaction.rollback();
//            throw new Exception();
//        }
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
//        Transaction transaction = null;
//
//        try (Session session = FactoryConfiguration.getInstance().getSession()) {
//            transaction = session.beginTransaction();
//
//            List<Order_t> orderTList = orderDAO.getAll(session);
//            List<OrderDTO> orderDTOList = new ArrayList<>();
//
//            for (Order_t order_t : orderTList) {
//                orderDTOList.add(toOrderDTO(order_t));
//            }
//
//            return orderDTOList;
//        } catch (Exception e) {
//            transaction.rollback();
//            throw new Exception();
//        }

        return null;
    }

//    private ItemDTO toItemDTO(Item item){
//        return new ItemDTO(
//                item.getiCode() ,
//                item.getiName() ,
//                item.getiPrice() ,
//                item.getiQty()
//        );
//
//    }
//
//    private Item toItem(ItemDTO itemDTO){
//        return new Item(
//                itemDTO.getiCode() ,
//                itemDTO.getiName() ,
//                itemDTO.getiPrice() ,
//                itemDTO.getiQty()
//        );
//
//    }
//
//    private CustomerDTO toCustomerDTO(Customer customer) {
//        return new CustomerDTO(
//                customer.getcId(),
//                customer.getcName(),
//                customer.getcAddress(),
//                customer.getcSalary()
//        );
//    }
//
//    private Customer toCustomer(CustomerDTO customerDTO) {
//        return new Customer(
//                customerDTO.getcId(),
//                customerDTO.getcName(),
//                customerDTO.getcAddress(),
//                customerDTO.getcSalary()
//        );
//    }
//
//    private OrderDTO toOrderDTO(Order_t order_t) {
//        List<ItemDTO> itemDTOList = new ArrayList<>();
//
//        for (Item item : order_t.getItems()) {
//            itemDTOList.add(toItemDTO(item));
//        }
//
//        return new OrderDTO(
//                order_t.getoId(),
//                order_t.getoDate(),
//                order_t.getoTotal(),
//                order_t.getoSubTotal(),
//                order_t.getoDiscount(),
//                order_t.getoBalance(),
//                toCustomerDTO(order_t.getCustomer()),
//                itemDTOList
//        );
//    }
//
//    private Order_t toOrder(OrderDTO orderDTO) {
//        List<Item> itemList = new ArrayList<>();
//
//        for (ItemDTO itemDTO : orderDTO.getItemDTOList()) {
//            itemList.add(toItem(itemDTO));
//        }
//
//        return new Order_t(
//                orderDTO.getoId(),
//                orderDTO.getoDate(),
//                orderDTO.getoTotal(),
//                orderDTO.getoSubTotal(),
//                orderDTO.getoDiscount(),
//                orderDTO.getoBalance(),
//                toCustomer(orderDTO.getCustomerDTO()),
//                itemList
//        );
//    }

}
