package bo.edu.ucb.SakilaBackend.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Rental {

    private Integer rentalId;
    private Date rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private Date returnDate;
    private Integer staffId;
    private Date lastUpdate;

    public Rental() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return rentalId.equals(rental.rentalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId);
    }

    @Override
    public String toString() {
        return "Id: '" + rentalId + '\n' +
        " Rental Date: '" + rentalId + '\n' +
        " Return Date: '" + returnDate + '\n';

    }

    public Integer getrentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Date getrentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getReturnDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(this.returnDate);
        return date;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
