package bo.edu.ucb.SakilaBackend.dto;

import java.util.Objects;

public class Address {

    private Integer addressId;
    private String address;
    
    public Address() {
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId.equals(address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address [address=" + address + ", addressId=" + addressId + "]";
    }

    
    
}
