public class Race {
    private final int HOURS_IN_RACE = 24;
    private int leaderDistance;
    private String leaderName;

    public void add(Car car) {
        int carDistance = car.speed() * HOURS_IN_RACE;

        if (carDistance >= leaderDistance) {
            leaderDistance = carDistance;
            leaderName = car.name();
        }
    }

    public String getResult() {
        return "Победитель - машина " + leaderName + " с результатом " + leaderDistance + "км.";
    }
}
