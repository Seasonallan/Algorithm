package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmBitOp;

public class Algorithm040 extends AlgorithmBitOp {

    @Override
    public String getName() {
        return "040-数组中只出现一次的数字";
    }

    @Override
    public String getDesc() {
        return "一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。";
    }

    Integer[] input = {1,2,2,3,67,3,4,4,1,23};
    @Override
    public String prepare() {
        return logArray(input);
    }

    Integer[] res;
    @Override
    public void execute() {
        res = getNumAppearsOnceWhen2(input);
    }

    @Override
    public String verify() {
        return logArray(res);
    }

    /**
     * 数组有两个数字只出现一次
     * @param array
     * @return
     */
    public Integer[] getNumAppearsOnceWhen2(Integer[] array) {
        int num1 = 0, num2 = 0;
        //对所有元素使用异或操作，那么得到的结果就是两个出现一次的元素的异或结果。
        int res = getNumAppearsOnce(array);

        int index=0;
        while(true){
            //因为这两个元素不相等，所以异或的结果肯定不是0，
            //在异或的结果中找到最后一个1的位置
            if((res>>index&1)==1){
                break;
            }
            index++;
        }
        for (int i=0;i<array.length;i++){
            //将原数组元素分为两组，一组该位全为1，另一组该位全为0。
            if((array[i]>>index &1)==1){
                num1 ^=array[i];
            }
            else num2 ^=array[i];
        }
        return new Integer[]{num1, num2};
    }

    /**
     * 数组只有一个数字只出现一次
     * @param array
     * @return
     */
    public int getNumAppearsOnce(Integer[] array){
        int result = 0;
        for(int i=0;i<array.length;i++){
            result ^= array[i];
        }
        return result;
    }


}
