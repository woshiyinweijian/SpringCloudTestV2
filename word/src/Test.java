import java.util.Arrays;

public class Test {


    public static void main(String[] args) {


        int[] numbers = {1,7,3,2,8,9,4};

        int temp = 0;
        int size = numbers.length;
        int j =  0;

        for(int i = 0 ; i < size ; i++)
        {
            temp = numbers[i];
            for(j = i ; j > 0 && temp < numbers[j-1] ; j --)
            {
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
        }


        Arrays.stream(numbers).forEach(System.out::println);
    }
}

// 单例模式

/*
class A{

    private static A a;
    private A(){};

    public static A getA(){
        if(a ==  null){
            synchronized (A.class){
                if (a == null){
                    a = new A();
                }
            }
        }
        return a;
    }
}*/

// 工厂方法模式

interface A{
    public void say();
}

class B implements A{

    @Override
    public void say() {
        System.out.println("BBBBB");
    }
}

interface F{
    public A makeA();
}

class Fb implements F{

    @Override
    public A makeA() {
        return new B();
    }
}