package paymentManagement;

/**
 * Created by AAnantharamu on 8/14/16.
 */


public interface Payment {

    public static final Double BASE_FARE = 5.41;

    public double generateBill(Double distance);

}
