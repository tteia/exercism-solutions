public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double success;
        if(speed < 5) success = 1.0;
        else if(speed < 9) success = 0.9;
        else if(speed == 9) success = 0.8;
        else success = 0.77;

        return speed * 221 * success;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
