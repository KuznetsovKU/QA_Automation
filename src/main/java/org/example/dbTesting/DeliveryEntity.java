package org.example.dbTesting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "delivery", schema = "main", catalog = "")
public class DeliveryEntity {

    @Id
    @Column(name = "delivery_id")
    private short deliveryId;

    @Column(name = "date_arrived")
    private String dateArrived;

    @Column(name = "taken")
    private String taken;

    @Column(name = "payment_method")
    private String paymentMethod;


    public short getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(short deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryEntity that = (DeliveryEntity) o;
        return deliveryId == that.deliveryId && Objects.equals(dateArrived, that.dateArrived) && Objects.equals(taken, that.taken) && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, dateArrived, taken, paymentMethod);
    }
}
