public class JedliksToyCar {
    // 100% > 20미터 이동 > 1% 감소
    // 0% > Battery empty
    private int meters = 0;
    private int percentage = 100;

    // 1. 자동차 인스턴스 반환
    public static JedliksToyCar buy(){
        return new JedliksToyCar();
    }

    // 2. 주행 거리 표시
    public String distanceDisplay(){
        return "Driven "+ meters + " meters";
    }

    // 3. 배터리 잔량 표시
    public String batteryDisplay(){
        if (percentage > 0) return "Battery at " + percentage + "%";
        else return "Battery empty";
    }

    // 4. 운전 시 주행 거리 갱신
    public void drive(){
        // 6. 배터리 방전 시 운전 불가
        if(percentage == 0) batteryDisplay();
        else {
            meters += 20;
            // 5. 배터리 잔량 갱신
            percentage -= 1;
        }
    }


}
