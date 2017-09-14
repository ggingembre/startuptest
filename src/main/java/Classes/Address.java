package Classes;

/**
 * Created by Guillaume Gingembre on 14/09/2017.
 */
public class Address {

    private String town;
    private Region region;
    private Country country;
    private long addressId;

    public Address(){}

    public Address(String town, Region region, Country country, long addressId) {
        this.town = town;
        this.region = region;
        this.country = country;
        this.addressId = addressId;

    }

    // Question: as we put the object in the project and business plan objects, we do not need a reference with
    // an ID, correct?

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "town='" + town + '\'' +
                ", region=" + region +
                ", country=" + country +
                ", addressId=" + addressId +
                '}';
    }
}
