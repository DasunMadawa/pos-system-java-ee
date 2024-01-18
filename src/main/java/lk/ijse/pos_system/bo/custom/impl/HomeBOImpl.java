package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.HomeBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.entity.Orders;
import org.modelmapper.ModelMapper;

import java.util.List;

public class HomeBOImpl implements HomeBO {
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private OrderDAO orderDAO = (OrderDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int calcItems() throws Exception {
        return itemDAO.getAll().size();

    }

    @Override
    public int calcCustomers() throws Exception {
        return customerDAO.getAll().size();
    }

    @Override
    public int calcOrders() throws Exception {
        return orderDAO.getAll().size();

    }

    @Override
    public double calcSales() throws Exception {
        List<Orders> all = orderDAO.getAll();

        double sales = 0;

        for (Orders orders : all) {
            sales+=orders.getOTotal();
        }

        return sales;

    }
}
