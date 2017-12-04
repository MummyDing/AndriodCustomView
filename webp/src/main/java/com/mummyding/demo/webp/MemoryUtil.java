package com.mummyding.demo.webp;

/**
 * Created by dingqinying on 2017/12/4.
 */

public class MemoryUtil {

    public static double getAllocatedMemory() {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() ) / 1048576.0;
    }

}
