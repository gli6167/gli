package com.example.gli.exer12.exer1;

/**
 * @author gsuiy
 * @create 2022-05-01 19:55
 *
 * 开发一个泛型Apple类，要求有一个重量属性weight在测试类中实例化不同的泛型对象，
 * 要求对象a1的这一属性是String类型，对象a2的这一属性是Integer型，
 * a3的这一属性是Double型。分别为a1，a2，a3的重量属性赋值为：”500克”，500,500.0，
 * 在测试类中通过对象调用访问器得到属性值并输出。另外思考，为什么a2和a3的属性需要是Integer和Double而不是int和double？
 */
public class Apple <E>{
    private E weight;
    public Apple(){

    }
    public Apple(E weight){
        this.weight = weight;
    }

    public E getWeight() {
        return weight;
    }

    public void setWeight(E weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
