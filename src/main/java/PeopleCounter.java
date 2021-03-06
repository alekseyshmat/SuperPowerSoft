import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleCounter {

    public int maxCounting(List<Integer> arrivalTime, List<Integer> careTime) {
        List<Integer> result = new ArrayList<Integer>();
        if (arrivalTime.size() == 0)
            System.exit(0);
        else {
            for (int i = 0; i < arrivalTime.size(); i++) {
                //начальное время общего промежутка времени
                int overallStartTime = arrivalTime.get(i);
                //конечное время общего промежутка времени
                int overallEndTime = careTime.get(i);
                int count = 0;
                for (int j = 0; j < careTime.size(); j++) {
                    if (overallStartTime <= careTime.get(j) && arrivalTime.get(j) <= overallEndTime) {
                        count++;
                        if (arrivalTime.get(i) <= arrivalTime.get(j) && careTime.get(i) <= careTime.get(j)) {
                            if (arrivalTime.get(j) <= overallStartTime && careTime.get(i) <= overallEndTime) {
                                overallEndTime = careTime.get(i);
                            } else if (arrivalTime.get(j) >= overallStartTime && careTime.get(i) >= overallEndTime) {
                                overallStartTime = arrivalTime.get(j);
                            } else if (arrivalTime.get(j) >= overallStartTime && careTime.get(i) <= overallEndTime) {
                                overallEndTime = careTime.get(i);
                                overallStartTime = arrivalTime.get(j);
                            }
                        } else if (arrivalTime.get(i) <= arrivalTime.get(j) && careTime.get(i) >= careTime.get(j)) {
                            if (arrivalTime.get(j) <= overallStartTime && careTime.get(j) <= overallEndTime) {
                                overallEndTime = careTime.get(j);
                            } else if (arrivalTime.get(j) >= overallStartTime && careTime.get(j) >= overallEndTime) {
                                overallStartTime = arrivalTime.get(j);
                            } else if (arrivalTime.get(j) >= overallStartTime && careTime.get(j) <= overallEndTime) {
                                overallStartTime = arrivalTime.get(j);
                                overallEndTime = careTime.get(j);
                            }
                        } else if (arrivalTime.get(i) >= arrivalTime.get(j) && careTime.get(i) >= careTime.get(j)) {
                            if (arrivalTime.get(i) <= overallStartTime && careTime.get(j) <= overallEndTime) {
                                overallEndTime = careTime.get(j);
                            } else if (arrivalTime.get(j) >= overallStartTime && careTime.get(j) >= overallEndTime) {
                                overallStartTime = arrivalTime.get(i);
                            } else if (arrivalTime.get(j) >= overallStartTime && careTime.get(j) <= overallEndTime) {
                                overallStartTime = arrivalTime.get(i);
                                overallEndTime = careTime.get(j);
                            }
                        }
                    }
                }
                result.add(count);
            }
        }
        System.out.println("В офисе одновременно находится: " + Collections.max(result) + " сотрудника(ов)");
        return Collections.max(result);
    }
}
