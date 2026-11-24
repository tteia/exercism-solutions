class NeedForSpeed {
    // 속도에 해당하는만큼 이동, 배터리 소모량만큼 소모
    // 배터리가 소모량보다 낮으면 이동 X
    private int speed;
    private int batteryDrain;
    private int distanceDriven = 0;
    private int batteryPercentage = 100;

    public int getSpeed(){
        return speed;
    }
    public int getBatteryDrain(){
        return batteryDrain;
    }
    // 1. 인스턴스 생성
    public NeedForSpeed(int speed, int batteryDrain){
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    // 3. 자동차 운전하기
    public void drive(){
        if(!batteryDrained()){
            distanceDriven += speed;
            batteryPercentage -= batteryDrain;
        }
    }

    public int distanceDriven(){
        return distanceDriven;
    }

    // 4. 방전된 배터리 확인
    public boolean batteryDrained(){
        return batteryPercentage < batteryDrain;
    }

    // 5. Nitro
    public static NeedForSpeed nitro(){
        return new NeedForSpeed(50, 4);
    }


}

class RaceTrack {
    private int distance;

    // 2. 경주 트랙 만들기
    public RaceTrack(int distance){
        this.distance = distance;
    }

    // 6. 완주 여부
    public boolean canFinishRace(NeedForSpeed car){
        int maxDrives = 100 / car.getBatteryDrain();
        int maxDistance = maxDrives * car.getSpeed();

        return maxDistance >= this.distance;
    }
}
