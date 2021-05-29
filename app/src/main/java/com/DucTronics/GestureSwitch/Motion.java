package com.DucTronics.GestureSwitch;

public class Motion {
    private String newMotion;
    private String previousMotion;


    public Motion(String passIn) {
        newMotion = "NULL";
        previousMotion = "NULL";
    }

    public Motion() {}

    public String getNewMotion() {
        return newMotion;
    }

    public String getPreviousMotion() {
        return previousMotion;
    }

    public void setNewMotion(String newMotion) {
        this.newMotion = newMotion;
    }

    public void setPreviousMotion(String previousMotion) {
        this.previousMotion = previousMotion;
    }
}
