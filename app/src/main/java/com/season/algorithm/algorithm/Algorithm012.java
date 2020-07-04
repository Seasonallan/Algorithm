package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmBitOp;

public class Algorithm012 extends AlgorithmBitOp {

    @Override
    public String getName() {
        return "012-数值的整数次方";
    }

    @Override
    public String getDesc() {
        return "给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。";
    }

    double base = 1.2;
    int exponent = 74;
    @Override
    public String prepare() {
        return "" + base +"的"+ exponent+"次方";
    }

    double res;
    @Override
    public void execute() {
        res = power_(base, exponent);
    }

    @Override
    public String verify() {
        log(power(base, exponent) +","+ res);
        return res+"";
    }


    public double power(double base, int exponent) {
        double res = 1.0;
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        if (exponent < 0)
            base = 1.0 / base; //负次方
        while(exponent!=0){
            res *= base;
            exponent = (exponent>0) ? (--exponent) : (++exponent);
        }
        return res;
    }

    /**
     * 3 ^ 999
     * = 3 ^ (512 + 256 + 128 + 64 + 32 + 4 + 2 + 1)
     * = (3 ^ 512) * (3 ^ 256) * (3 ^ 128) * (3 ^ 64) * (3 ^ 32) * (3 ^ 4) * (3 ^ 2) * 3
     * 即>>999的二进制1111100111
     * = (3 ^ 512) * (3 ^ 256) * (3 ^ 128) * (3 ^ 64) * (3 ^ 32) * 1 * 1 *  (3 ^ 4) * (3 * 2) * 3
     * @param base
     * @param exponent
     * @return
     */
    public double power_(double base, int exponent) {
        double res = 1.0;
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        if (exponent < 0)
            base = 1.0 / base; //负次方

        while(exponent != 0) {
            if((exponent & 1) == 1) {
                res *= base;
            }else{
                res *= 1;
            }
            base *= base;//翻倍
            exponent >>= 1;
        }

        return res;
    }

}
