package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

public class Algorithm031 extends AlgorithmOther {

    @Override
    public String getName() {
        return "031-整数中1出现的次数（从1到n整数中1出现的次数）";
    }

    /**
     * 特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
     * 但是对于后面问题他就没辙了。
     * @return
     */
    @Override
    public String getDesc() {
        return "求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？";
    }

    int count = 13;
    @Override
    public String prepare() {
        return ""+count;
    }

    @Override
    public void execute() {
        res = NumberOf1Between1AndN_Solution(count);
    }

    int res;
    @Override
    public String verify() {
        return "" + res;
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){
            current = (n/i)%10; //高位数字
            before = n/(i*10); //当前位数字
            after = n-(n/i)*i; //低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before*i;
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if(current == 1)
                count += before * i + after + 1;
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else{
                count += (before + 1) * i;
            }
            //前移一位
            i = i*10;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution_(int n) {
        if(n == 1) return 1;
        int count = 0;
        int i = 1;
        for(i=1;i<=n;i*=10)
        {
            int a = n/i;
            int b = n%i;
            if(a%10==1)
                count=count+(a+8)/10*i+(b+1);
            else
                count=count+(a+8)/10*i;
        }
        return count;
    }



}
