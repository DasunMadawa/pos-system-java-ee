package lk.ijse.pos_system.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.CustomerBO;
import lk.ijse.pos_system.bo.custom.HomeBO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.dto.HomeDTO;
import lk.ijse.pos_system.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "home_servlet", urlPatterns = "/home_servlet")
public class HomeController extends HttpServlet {
    private HomeBO homeBO = (HomeBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.HOME);
    private final static Logger logger = LoggerFactory.getLogger("lk.ijse.pos_system.custom");
    private Jsonb jsonb = JsonbBuilder.create();
    private ResponseDTO responseDTO = new ResponseDTO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try {
            HomeDTO homeDTO = new HomeDTO(homeBO.calcItems(), homeBO.calcCustomers(), homeBO.calcOrders(), homeBO.calcSales());

            responseDTO.setCode(HttpServletResponse.SC_OK);
            responseDTO.setMessage("Success");
            responseDTO.setContent(homeDTO);

            logger.info("Home Details Fetched!");

        } catch (Exception e) {
//                e.printStackTrace();

            responseDTO.setCode(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            responseDTO.setMessage("Can't gather Data !");
            responseDTO.setContent(null);

            resp.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            logger.error("Home Details Not Fetched!");

        }

        resp.getWriter().write(jsonb.toJson(responseDTO));


    }

}
