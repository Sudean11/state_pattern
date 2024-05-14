package org.example.states;

import org.example.Lab08;

public class ParkedState implements State {
    Lab08 lab08;
    String gear = "Parked State";
    public ParkedState(Lab08 lab08){
        this.lab08 = lab08;
    }

    public String getGear() {
        return gear;
    }

    public Lab08 getLab08() {
        return lab08;
    }
    @Override
    public String getShift() {
        return gear;
    }

    @Override
    public void changeSpeed(int speed) {
        if(speed == 0){
            lab08.setState(lab08.getParkedState());
        }
        if (speed > 0) {
            getLab08().setState(getLab08().getGear1());
            lab08.getGearState().changeSpeed(speed);
        }
    }
}
