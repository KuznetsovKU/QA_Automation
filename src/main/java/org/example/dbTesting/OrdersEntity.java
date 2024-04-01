package org.example.dbTesting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "main", catalog = "")
public class OrdersEntity {

    @Id
    @Column(name = "order_id")
    private short orderId;

    @Column(name = "date_get")
    private String dateGet;

    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    public String getDateGet() {
        return dateGet;
    }

    public void setDateGet(String dateGet) {
        this.dateGet = dateGet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderId == that.orderId && Objects.equals(dateGet, that.dateGet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, dateGet);
    }
}
