package org.example.dbTesting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "courier_info", schema = "main", catalog = "")
public class CourierInfoEntity {

    @Id
    @Column(name = "courier_id")
    private short courierId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "delivery_type")
    private String deliveryType;


    public short getCourierId() {
        return courierId;
    }

    public void setCourierId(short courierId) {
        this.courierId = courierId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourierInfoEntity that = (CourierInfoEntity) o;
        return courierId == that.courierId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(deliveryType, that.deliveryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courierId, firstName, lastName, phoneNumber, deliveryType);
    }
}
