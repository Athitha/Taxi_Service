package trackride;

/**
 * Created by sheebanshaikh on 8/16/16.
 */

public class Itinerary implements TrackStatus {

    @Override
    public void update() {
        for (int ik = 0; ik < 5; ik++) {
            System.out.print(" - ");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("|In Transit|");
    }

    @Override
    public void onStartNotify() {
        System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------");
        for (int ik = 0; ik < 5; ik++) {
            System.out.print(" - ");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("|Ride is arriving in 5 minutes.|");
    }

    @Override
    public void onEndNotify() {
        for (int ik = 0; ik < 5; ik++) {
            System.out.print(" - ");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("|Drop Off. Trip Finished|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }
}