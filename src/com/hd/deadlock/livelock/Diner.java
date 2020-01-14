package com.hd.deadlock.livelock;

import java.util.Random;

/**
 * @author HuaDong
 * @date 2019/11/15 15:53
 */
public class Diner {

    /**
     * 吃饭的人
     */
    private String name;
    /**
     * 是否饥饿
     */
    private boolean isHungry;

    public Diner(String name) {
        this.name = name;
        isHungry = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    /**
     * 方法里面描述的是吃饭的事
     *
     * @param spoon 勺子
     * @param spouse 夫妻对方
     */
    public void eatWith(Spoon spoon, Diner spouse) {
        while (isHungry) {
            //如果勺子不是自己的，则等一会儿，等对方吃完
            if (spoon.getOwner() != this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            Random random = new Random();
            //先检查对方是否饥饿，如果对方饥饿的话先把勺子交给对方，让对方先吃
            if (spouse.isHungry && random.nextInt(10) < 9) {
                System.out.println(name + ": 亲爱的" + spouse.name + "你先吃吧");
                spoon.setOwner(spouse);
                continue;
            }

            //开始使用勺子吃饭
            spoon.use();
            //吃完后把自己的状态改成非饥饿状态
            isHungry = false;
            System.out.println(name + ": 我吃完了");
            //同时把勺子直接给到对方
            spoon.setOwner(spouse);
        }
    }
}
