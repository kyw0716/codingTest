package sk000801.복습;
import java.util.*;

//32분
//그래도 처음에 어떻게 풀 지 생각하고 들어가서 코드 짜는게 편했던듯
public class 주차요금계산2 {
    //fees[0] = 기본 시간(분) fees[1] = 기본 요금
    //fees[2] = 단위 시간(분) fees[3] = 단위 요금
    // 그래서 전체 요금 =
    // if(기본 시간 fees[0] >= 주어진 시간) =. fees[1]
    // else fees[1]+((주어진시간-fees[0])/fees[2]+1)*fees[3]
    //근데 저 단위 시간 만큼도 안되는데 어쨌든 초과한거니까 1을 더했는데 임시 방편임..
    //차량번호가 작은 자동차부터 값을 반환하도록 ..
    public static int[] solution(int[] fees, String[] records) {
        List<Integer> car = new ArrayList<>();
        Map<Integer, Integer> carInfo = new HashMap<>();
        Map<Integer, Integer> carCount = new HashMap<>();
        for(int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
            int carNum = Integer.parseInt(s[1]);
            if(!car.contains(carNum)) car.add(carNum);
            carCount.put(carNum, carCount.getOrDefault(carNum, 0)+1);

            String[] num = s[0].split(":");
            int h = Integer.parseInt(num[0])*60;
            int m = Integer.parseInt(num[1]);
            int time = h+m;

            if(s[2].equals("IN")) {
                carInfo.put(carNum, carInfo.getOrDefault(carNum, 0)-time);
            } else {
                carInfo.put(carNum, carInfo.getOrDefault(carNum, 0)+time);
            }
        }
        Collections.sort(car);
        for(int i = 0; i < car.size(); i++) {
            int time = carInfo.get(car.get(i));
            int count = carCount.get(car.get(i));
            if(count%2==1) {
                time += 1439;
                carInfo.put(car.get(i), time);
            }
        }

        int[] answer = new int[car.size()];
        for(int i = 0; i < car.size(); i++) {
            int time = carInfo.get(car.get(i));
            if(fees[0] >= time) answer[i] = fees[1];
            else {
                double val = (time-fees[0])/(double)fees[2];
                if(val != (int)val) answer[i] = fees[1] + ((int)val+1)*fees[3];
                else answer[i] = fees[1]+ (int) (val) * fees[3];
                System.out.println(val);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] fees1 = {180, 5000, 10, 600};
        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        
        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        
        int[] res = solution(fees2, records2);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
