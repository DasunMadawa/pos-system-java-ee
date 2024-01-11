package lk.ijse.pos_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Data
//@ToString
public class Customer {
    @Id
    private String cId;
    private String cName;
    private String cAddress;
    private double cSalary;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
    private List<Order_t> orders;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public double getcSalary() {
        return cSalary;
    }

    public void setcSalary(double cSalary) {
        this.cSalary = cSalary;
    }

    public List<Order_t> getOrders() {
        return orders;
    }

    public void setOrders(List<Order_t> orders) {
        this.orders = orders;
    }
}
