package me.dev.motospring.model;

public class Car {
    private String model;
    private Make make;
    private RacingTeam racingTeam;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public RacingTeam getRacingTeam() {
        return racingTeam;
    }

    public void setRacingTeam(RacingTeam racingTeam) {
        this.racingTeam = racingTeam;
    }
}
