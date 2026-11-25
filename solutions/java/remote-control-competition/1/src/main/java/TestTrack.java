import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        // ProductionRemoteControlCar 클래스에 Comparable<T> 인터페이스 구현
        // 승리 횟수 내림차순으로 정렬해서 반환하는 ranked
        List<ProductionRemoteControlCar> rankedCars = new ArrayList<>(cars);
        Collections.sort(rankedCars);
        return rankedCars;
    }
}
