package org.example.states;

import org.example.Lab08;

public interface State {
    public Lab08 getLab08();
    public String getShift();
    public void changeSpeed(int speed);
}
