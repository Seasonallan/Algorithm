package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

import java.util.ArrayList;

public class Algorithm033 extends AlgorithmOther {

    @Override
    public String getName() {
        return "033-丑数";
    }

    @Override
    public String getDesc() {
        return "把只包含质因子2、3和5的数称作丑数（Ugly Number）。" +
                "例如6、8都是丑数，但14不是，因为它包含质因子7。 " +
                "习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。";
    }

    int n = 4;
    @Override
    public String prepare() {
        return n+"";
    }

    @Override
    public void execute() {
        res = getUglyNumberAt(n);
    }

    int res;
    @Override
    public String verify() {
        return "" + res;
    }

    public int getUglyNumberAt(int n)
    {
        if(n == 0) return 0;
        ArrayList<Integer> array=new ArrayList<Integer>();
        //因为1是丑数，先将1添加进来
        array.add(1);
        int i2 = 0,i3 = 0,i5 = 0;
        while(array.size() < n)
        {
            int m2 = array.get(i2)*2;
            int m3 = array.get(i3)*3;
            int m5 = array.get(i5)*5;
            //将三个数中的最小值添加进来
            int min = Math.min(m2 , Math.min( m3 , m5 ) );
            array.add(min);
            if(min == m2)i2++;
            if(min == m3)i3++;
            if(min == m5)i5++;
        }
        return array.get( array.size() - 1 );
    }

    //判断是否是丑数
    public boolean isUglyNumber(int number){
        while(number % 2 == 0)
            number /= 2;
        while(number % 3 == 0)
            number /= 3;
        while(number % 5 == 0)
            number /= 5;
        return (number == 1) ? true : false;
    }

}
