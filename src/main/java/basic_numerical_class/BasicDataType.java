package basic_numerical_class;

/**
 * byte类型整数:占8位，表数范围为-128-127 </br>
 * short类型整数:占16位，-32768(-2^15)~32767(2^15-1)</br>
 * int类型整数：占32位(整数值默认为int类型) -2147483648(-2^31)~2147483647(2^31)</br>
 * long类型整数：占64位 </br>
 * double浮点数:8字节，64位 </br>
 * float浮点数:4字节，32位</br>
 * 进制:2进制0b或0B,8进制为0, 16进制为0x或0X </br>
 * 定义32位或64位整数时，最高位是符号位
 * 
 * @author huanghao
 *
 */
public class BasicDataType {
    // 此处数值在byte类型范围内，会变为对应类型
    byte a = 1;
    // 此处不会转为long型整数
    // int c = 999999955599;

    // 此处值为-1(补码形式存在于计算机中)负数去反码+1(符号位保持不变)即为0B1000...1
    static int d = 0B11111111111111111111111111111111;

    double e = 233424423d;

    public static void main(String[] args) {
        System.out.println(d);
    }
}
