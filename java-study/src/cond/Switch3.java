package cond;

public class Switch3 {

    public static void main(String[] args) {
        int grade = 1;

        int coupon;
        switch (2) {
            case 1:
                coupon = 1000;
                break;
            case 2:     //break가 없으면, 다음 case코드까지 수행됨. break 나올때까지.
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
