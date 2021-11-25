package bo.edu.ucb.SakilaBackend.dto;

import java.util.Objects;

public class Address {

    private Integer addressId;
    private String address;
    private String address2;
    private String district;
    private Integer city_id;
    private String postal_code;
    private String phone;

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

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address [address=" + address + ", address2=" + address2 + ", addressId=" + addressId + ", city_id="
                + city_id + ", district=" + district + ", phone=" + phone + ", postal_code=" + postal_code + "]";
    }
    
}
