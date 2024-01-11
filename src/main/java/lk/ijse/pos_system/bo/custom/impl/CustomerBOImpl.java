package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.CustomerBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();

            customerDAO.add(modelMapper.map(customerDTO , Customer.class), session);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        try (Session session = FactoryConfiguration.getInstance().getSession()){

            Customer customer = customerDAO.search(id, session);
            return modelMapper.map(customer , CustomerDTO.class);

        } catch (Exception e) {
            throw new Exception();
        }

    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();

            customerDAO.update(modelMapper.map(customerDTO , Customer.class), session);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }

    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        Transaction transaction = null;

        try (Session session = FactoryConfiguration.getInstance().getSession()){
            transaction = session.beginTransaction();

            customerDAO.delete(id, session);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception();
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        try (Session session = FactoryConfiguration.getInstance().getSession()){

            List<Customer> customerList = customerDAO.getAll(session);

            List<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer : customerList) {
                customerDTOList.add(modelMapper.map(customer , CustomerDTO.class));

            }

            return customerDTOList;
        } catch (Exception e) {
            throw new Exception();
        }

    }

}
