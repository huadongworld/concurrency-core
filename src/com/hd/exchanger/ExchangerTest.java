package com.hd.exchanger;

import org.junit.Test;

import java.util.concurrent.Exchanger;

/**
 * @author HuaDong
 * @date 2020/3/15 15:43
 */
public class ExchangerTest {

    @Test
    public void demo() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        People li = new People("小李家", "铁锹", exchanger);
        People gang = new People("小刚家", "锤子", exchanger);
        li.start();
        gang.start();

        Thread.sleep(100);
        System.out.println(li.getName() + " has " + li.getTool());
        System.out.println(gang.getName() + " has " + gang.getTool());

    }

    static class People extends Thread {

        private String tool;
        private final Exchanger<String> exchanger;

        People(String name, String tool, Exchanger<String> exchanger) {
            super(name);
            this.tool = tool;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            //交换工具
            try {
                tool = exchanger.exchange(tool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String getTool() {
            return tool;
        }
    }
}
