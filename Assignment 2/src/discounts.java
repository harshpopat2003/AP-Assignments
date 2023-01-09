public class discounts {
    private String discountproductid;
    private String discountproductname;
    private double discountelite;
    private double discountprime;
    private double discountnormal;

    public discounts(String discountproductid, String discountproductname, double discountelite, double discountprime, double discountnormal) {
        this.discountproductid = discountproductid;
        this.discountproductname = discountproductname;
        this.discountelite = discountelite;
        this.discountprime = discountprime;
        this.discountnormal = discountnormal;
    }
}
