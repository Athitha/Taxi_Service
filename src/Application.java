import com.google.common.collect.Maps;
import parkingManangement.DeAllocateParking;
import parkingManangement.GenerateAllocation;
import parkingManangement.ManageParking;
import parkingManangement.ParkingAllocation;
import paymentManagement.CardPay;
import paymentManagement.CreditPayment;
import rideManagement.*;
import routingManagement.ProcessRouting;
import routingManagement.TaxiX;
import trackride.Itinerary;
import trackride.TrackStatus;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by AAnantharamu on 8/14/16.
 */


public class Application {

    public static void main(String args[]) {

        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner s = new Scanner(System.in);
        b: do
        {
            int ch = mainMenu();
            switch (ch)
            {
                case 1:
                    signupMenu(s);
                    break;   // Sign Up

                case 2:
                    signInMenu(s);
                    c:do
                    {
                        int ch1 = bookRideUpdateMenu();

                        switch (ch1) {
                            case 1:
                                sourceAndDestinationMenu();

                                continue c;

                            case 2:
                                updateDetailsMenu();
                                continue c;
                            case 3:
                                ParkingAllocation parkingAllocation = new ManageParking();
                                parkingAllocation.allocationRequest();
                                parkingAllocation = new GenerateAllocation();
                                parkingAllocation.allocationRequest();
                                parkingAllocation = new DeAllocateParking();
                                parkingAllocation.allocationRequest();
                                continue c;

                            case 4:
                                continue b;

                        }
                        break;

                    } while(true);

                case 3: return;


            }

        }while(true);


    }

    private static int bookRideUpdateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n-------------------- MENU ------------------------");
        System.out.println("1)Book a Ride\n"
                + "2)Update Details\n" +
                "3)Allocate Parking\n"
                + "4)Sign Out"
        );
        System.out.println("-------------------------------------------------");
        System.out.println("Enter Your Choice");
        return scanner.nextInt();

    }

    private static int mainMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n================ Online Taxi Booking  =================");
        System.out.println("1)Sign up\n2)Sign In\n3)Exit");
        System.out.println("Enter the Choice: ");
        return scanner.nextInt();
    }


    private static void signInMenu(Scanner s) {
        System.out.println("\n\n======================= Sign In =======================");
        System.out.println("Sign In as: " +
                "\n1. Customer " +
                "\n2. Driver");
        String input = s.next();
        System.out.println("Enter your Email ID: ");
        String email = s.next();
        System.out.println("Enter password: ");
        String S_pass = s.next();
        System.out.println("------------------------------");
        if (input.equals("1")) {
            System.out.println("| \t Signed in as Customer, Welcome - [ " + email + " ] \t |");
        } else {
            System.out.println("| \t Signed in as Driver, Welcome - [ " + email + " ] \t |");
        }
        System.out.println("------------------------------");
    }

    private static void signupMenu(Scanner s) {

        System.out.println("\n\n\n==================== Personal Details =================");
        System.out.println("Enter Your first name: ");
        String name = s.next();
        System.out.println("Enter your Email ID: ");
        String email = s.next();
        System.out.println("Enter password: ");
        String pass = s.next();
        System.out.println("Confirm Password");
        String C_pass = s.next();
        System.out.println("Register as: \n1. Customer \n2. Driver");
        String type = s.next();
        if (type.equals("2")) {
            System.out.println("License Number: ");
            String license = s.next();
            System.out.println("---------------Car Details ---------------");
            System.out.println("Car Name: ");
            s.next();
            System.out.println("Car Number Plate : ");
            s.next();
        }
        System.out.println("Membership: ");
        System.out.println("1. Basic ");
        System.out.println("2. Premium");
        String membership = s.next();
        System.out.println(" \n==================== Card Details ====================");
        System.out.println("Enter the Card type \n1. Credit \n2. Debit ");
        String card_type = s.next();
        System.out.println("Enter Your card Number: ");
        try {
            int card_num = s.nextInt();
        } catch (Exception e) {
            System.out.println(" --- Enter numbers only ---");
        }
        System.out.println("Enter the Expiration Date: ");
        String Exp_date = s.next();
        System.out.println("----------------------------------");
        System.out.println("|\tMember[ " + name + " ] added Successful \t|");
        System.out.println("----------------------------------");

    }

    private static void updateDetailsMenu() {
        System.out.println("-------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your new password: ");
        String curr_pw = scanner.next();
        System.out.println("Confirm your new password: ");
        String con_pass = scanner.next();
        System.out.println("Enter the Card type: \n"
                + "1)Credit\n"
                + "2)Debit");
        String card_type_up = scanner.next();
        System.out.println("Enter Your card Number: ");
        String card_num_up = scanner.next();
        System.out.println("Enter the Expiration Date ");
        String Exp_date_up = scanner.next();
        System.out.println("-------------------------------------------------");
    }

    private static void sourceAndDestinationMenu() {


        Scanner scanner = new Scanner(System.in);
        Map<String, String> sourceVsDestinationMap = Maps.newHashMap();
        ProcessRouting processRouting = new TaxiX();

        String vehicle_type = "";

        System.out.println("\nEnter the number of rides you want to book: ");
        String rideNumber = scanner.next();

        //Accept source and destinations
        for (int i = 0; i < Integer.valueOf(rideNumber); i++) {
            System.out.println("-------------------------------------------------");
            System.out.println("Enter the Source Address: ");
            String source = scanner.next();
            System.out.println("Enter the Destination Address");
            String destination = scanner.next();
            System.out.println("Enter the vehicle type 1. Pool \t2. Taxi-X \t3. Taxi-XL: ");
            vehicle_type = scanner.next();
            System.out.println("-------------------------------------------------");
            sourceVsDestinationMap.put(source, destination);
        }

        //Schedule Rides
        RideState rideState = new WaitingRide();
        rideState.receiveRequest(sourceVsDestinationMap, Integer.valueOf(vehicle_type)); //approve request
        rideState = new ProcessRide();
        rideState.qualifyRequest(sourceVsDestinationMap, Integer.valueOf(vehicle_type)); // Send Request for implementation
        rideState = new FinalizeRide();
        rideState.approveRequest(sourceVsDestinationMap, Integer.valueOf(vehicle_type)); // Qualify Request

        //Routing Algo
        MaintainRequest maintainRequest = new RequestRide(processRouting);
        List<Double> distances = maintainRequest.handleRequests(sourceVsDestinationMap);


        //Live Track Ride
        System.out.println("\n--------------------");
        System.out.println("|\tTrack Ride\t|");
        System.out.print("--------------------");
        TrackStatus trackRide = new Itinerary();
        trackRide.onStartNotify();
        trackRide.update();
        trackRide.onEndNotify();

        //Process Payment
        generateDelay();
        for (Double distance : distances) {
            CardPay payment = new CreditPayment(distance);
        }

        //DenyRide
        maintainRequest = new DenyRide(processRouting);
        maintainRequest.denyRides(distances);


    }

    private static void generateDelay() {
        for (int ik = 0; ik < 5; ik++) {
            System.out.print(" ");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



