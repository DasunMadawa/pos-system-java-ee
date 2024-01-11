package lk.ijse.pos_system.servlet;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.CustomerBO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customer_servlet", urlPatterns = "/customer_servlet", loadOnStartup = 1)
public class CustomerServlet extends HttpServlet {
    private CustomerBO customerBO = (CustomerBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    private final static Logger logger = LoggerFactory.getLogger("lk.ijse.pos_system.custom");
    private Jsonb jsonb = JsonbBuilder.create();
    private ResponseDTO responseDTO = new ResponseDTO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            return;
        }
        resp.setContentType("application/json");

        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);
        try {
            customerBO.addCustomer(customerDTO);

            responseDTO.setCode(HttpServletResponse.SC_OK);
            responseDTO.setMessage("Success");
            responseDTO.setContent(customerDTO);

            logger.info("Customer Saved");

        } catch (Exception e) {
            responseDTO.setCode(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            responseDTO.setMessage("Check Duplicate Ids !");
            responseDTO.setContent(customerDTO);

//            e.printStackTrace();

            resp.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            logger.error("Customer not saved : "+e.getMessage());
        }

        resp.getWriter().write(jsonb.toJson(responseDTO));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");

        String cId = req.getParameter("cId");
        resp.setContentType("application/json");

        if (cId != null) {
            try {
                CustomerDTO customerDTO = customerBO.searchCustomer(cId);

                responseDTO.setCode(HttpServletResponse.SC_OK);
                responseDTO.setMessage("Success");
                responseDTO.setContent(customerDTO);

                logger.info("Customer Fetched!");

            } catch (Exception e) {
//                e.printStackTrace();

                responseDTO.setCode(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                responseDTO.setMessage("Can't find customer");
                responseDTO.setContent(null);

                resp.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                logger.error(e.getMessage());

            }

        } else {
            try {
                List<CustomerDTO> allCustomers = customerBO.getAllCustomers();

                responseDTO.setCode(HttpServletResponse.SC_OK);
                responseDTO.setMessage("Success");
                responseDTO.setContent(allCustomers);

                logger.info("Data Fetched!");

            } catch (Exception e) {
//                e.printStackTrace();

                responseDTO.setCode(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);

                resp.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                logger.error(e.getMessage());

            }
        }
        resp.getWriter().write(jsonb.toJson(responseDTO));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put");

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            return;
        }
        resp.setContentType("application/json");

        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);
        try {
            customerBO.updateCustomer(customerDTO);

            responseDTO.setCode(HttpServletResponse.SC_OK);
            responseDTO.setMessage("Success");
            responseDTO.setContent(customerDTO);

            logger.info("Customer Updated");

        } catch (Exception e) {
//            e.printStackTrace();

            responseDTO.setCode(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            responseDTO.setMessage("Check Customer Id");
            responseDTO.setContent(customerDTO);

            logger.error(e.getMessage());
        }

        resp.getWriter().write(jsonb.toJson(responseDTO));


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");

        String cId = req.getParameter("cId");

        if (cId == null) {
            return;
        }
        resp.setContentType("application/json");

        try {
            customerBO.deleteCustomer(cId);

            responseDTO.setCode(HttpServletResponse.SC_OK);
            responseDTO.setMessage("Success");
            responseDTO.setContent(null);

            logger.info("Customer Deleted");
        } catch (Exception e) {
//            e.printStackTrace();

            responseDTO.setCode(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            responseDTO.setMessage("Check Customer Id");
            responseDTO.setContent(null);

            logger.error(e.getMessage());

        }

        resp.getWriter().write(jsonb.toJson(responseDTO));

    }


}
