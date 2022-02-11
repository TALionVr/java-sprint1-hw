package github.trofimov;

public class Converter {

    double distance(double sumStep) {
        return sumStep * 75 / 100000;
    }

    double numberCaloriesBurned(double sumStep) {
        return sumStep * 50 / 1000;
    }

}