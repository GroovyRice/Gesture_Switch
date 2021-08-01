package com.DucTronics.GestureSwitch;

public class Gestures {
    private String swipeUp;
    private String swipeDown;
    private String swipeLeft;
    private String swipeRight;

    private int swipeUpNum;
    private int swipeDownNum;
    private int swipeLeftNum;
    private int swipeRightNum;

    public Gestures() {
        String text = "Null";
        int num = 0;
        swipeUp = text;
        swipeDown = text;
        swipeLeft = text;
        swipeRight = text;
        swipeUpNum = num;
        swipeDownNum = num;
        swipeLeftNum = num;
        swipeRightNum = num;
    }

    public String getSwipeUp() { return swipeUp; }

    public void setSwipeUp(String swipeUp) {
        this.swipeUp = swipeUp;
    }

    public String getSwipeDown() {
        return swipeDown;
    }

    public void setSwipeDown(String swipeDown) {
        this.swipeDown = swipeDown;
    }

    public String getSwipeLeft() {
        return swipeLeft;
    }

    public void setSwipeLeft(String swipeLeft) {
        this.swipeLeft = swipeLeft;
    }

    public String getSwipeRight() {
        return swipeRight;
    }

    public void setSwipeRight(String swipeRight) {
        this.swipeRight = swipeRight;
    }

    public int getSwipeUpNum() { return swipeUpNum; }

    public void setSwipeUpNum(int swipeUpNum) { this.swipeUpNum = swipeUpNum; }

    public int getSwipeDownNum() { return swipeDownNum; }

    public void setSwipeDownNum(int swipeDownNum) { this.swipeDownNum = swipeDownNum; }

    public int getSwipeLeftNum() { return swipeLeftNum; }

    public void setSwipeLeftNum(int swipeLeftNum) { this.swipeLeftNum = swipeLeftNum; }

    public int getSwipeRightNum() { return swipeRightNum; }

    public void setSwipeRightNum(int swipeRightNum) { this.swipeRightNum = swipeRightNum; }
}
