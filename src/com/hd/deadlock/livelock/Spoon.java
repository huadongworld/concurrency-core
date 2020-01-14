package com.hd.deadlock.livelock;

/**
 * 调羹
 *
 * @author HuaDong
 * @date 2019/11/15 15:52
 */
public class Spoon {

    private Diner owner;

    public Spoon(Diner owner) {
        this.owner = owner;
    }

    public Diner getOwner() {
        return owner;
    }

    public void setOwner(Diner owner) {
        this.owner = owner;
    }

    public synchronized void use() {
        System.out.printf("%s吃完了!", owner.getName());
    }
}
