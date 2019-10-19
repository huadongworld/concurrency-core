package com.hd.thread.stop;

/**
 * run无法抛出checked Exception，只能用try/catch
 *
 * @author HuaDong
 * @date 2019/10/19 21:53
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(() ->  {
            try {
                throw new Exception();
            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }
}
