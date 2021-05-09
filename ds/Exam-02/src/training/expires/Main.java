package training.expires;

public class Main {

    public static void main(String[] args) {
        BigNumber number1 = new BigNumber("123456");
        BigNumber number2 = new BigNumber("123");

        System.out.println(number1);

        System.out.println(number1.convertToString());


        System.out.println(BigNumber.add(number1, number2));


    }
}
