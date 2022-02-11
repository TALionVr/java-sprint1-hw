package github.trofimov;

import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    Converter converter = new Converter();
    HashMap<Integer, ArrayList<Integer>> monthToData;

    public StepTracker() {
        monthToData = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            ArrayList<Integer> numb = new ArrayList<>();
            for (int j = 0; j < 30; j++) {
                numb.add(0);
            }
            monthToData.put(i, numb);
        }
    }

    void dataEntry(int numberOfMonth, int day, int numberOfStep) {
        ArrayList<Integer> expenses = monthToData.get(numberOfMonth);
        expenses.set((day - 1), numberOfStep);
    }

    void statistics(int numberOfMonth, Integer aspiration) {
        int day = 1;
        System.out.println("Статистика за " + nameOfMonth(numberOfMonth) + ": ");
        for (Integer steps : monthToData.get(numberOfMonth)) {
            System.out.print(day + " день: " + steps + ", ");
            day++;
        }
        System.out.println("Общее количество шагов за месяц: " + sumStepInMonth(numberOfMonth));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepInMonth(numberOfMonth));
        System.out.println("Среднее количество шагов: " + averageStepInMonth(numberOfMonth));
        System.out.println("Пройденная дистанция (в км): " + converter.distance(sumStepInMonth(numberOfMonth)));
        System.out.println("Количество сожжённых килокалорий: " +
                converter.numberCaloriesBurned(sumStepInMonth(numberOfMonth)));
        System.out.println("Лучшая серия: " + bestSeries(numberOfMonth, aspiration));
    }

    String nameOfMonth(int numberOfMonth) {
        HashMap<Integer, String> nameOfMonth = new HashMap<>();
        nameOfMonth.put(1, "Январь");
        nameOfMonth.put(2, "Февраль");
        nameOfMonth.put(3, "Март");
        nameOfMonth.put(4, "Апрель");
        nameOfMonth.put(5, "Май");
        nameOfMonth.put(6, "Июнь");
        nameOfMonth.put(7, "Июль");
        nameOfMonth.put(8, "Август");
        nameOfMonth.put(9, "Сентябрь");
        nameOfMonth.put(10, "Октябрь");
        nameOfMonth.put(11, "Ноябрь");
        nameOfMonth.put(12, "Декабрь");
        return nameOfMonth.get(numberOfMonth);
    }


    int maxStepInMonth(int numberOfMonth) {    //Максимум шагов в день
        int maxStep = 0;
        for (Integer steps : monthToData.get(numberOfMonth)) {
            if (steps > maxStep) {
                maxStep = steps;
            }
        }
        return maxStep;
    }

    int averageStepInMonth(int numberOfMonth) {    //Среднее кол-во шагов
        int averageStep = 0;
        for (Integer steps : monthToData.get(numberOfMonth)) {
            averageStep += steps;
        }
        return averageStep / monthToData.get(numberOfMonth).size();
    }

    int sumStepInMonth(int numberOfMonth) {    //Сумма шагов
        int sumStep = 0;
        for (Integer sum : monthToData.get(numberOfMonth)) {
            sumStep += sum;
        }
        return sumStep;
    }

    int bestSeries(int numberOfMonth, Integer aspiration) {    //Лучшая серия
        int bestDays = 0;
        int best = 0;
        for (Integer steps : monthToData.get(numberOfMonth)) {
            if (steps >= aspiration) {
                bestDays++;
            } else {
                bestDays = 0;
            }
            if (bestDays > best) {
                best = bestDays;
            }
        }
        return best;
    }


}
