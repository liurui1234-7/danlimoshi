 interface Fruit{
      void grow();
      void  harvest();
      void  plant();
}
 class Apple implements Fruit{
     public void grow(){
        System.out.println("Apple is growing");
}
     public void harvest(){
         System.out.println("Apple has been harvested");
}
     public void plant(){
         System.out.println("Apple has been planted");
}
}
 class Grape implements Fruit{
     public void grow(){
      System.out.println("Grape is growing");
}
     public void harvest(){
      System.out.println("Grape has been harvested");
}
     public void plant(){
     System.out.println("Grape has been planted");
}
}
class Strawberry implements Fruit{
     public void grow(){
      System.out.println("Strawberry is growing");
}
     public void harvest(){
      System.out.println("Strawberry has been harvested");
}
     public void plant(){
     System.out.println("Strawberry has been planted");
}
}
 interface FruitGardener{
    public Fruit factory();
}
class Applefactory implements FruitGardener{
    public Fruit factory(){
     return new Apple();
}
}
class Grapefactory implements FruitGardener{
     public Fruit factory(){
     return new Grape();
}
}
class Strawberryfactory implements FruitGardener{
     public Fruit factory(){
     return new Strawberry();
}
}
public class gongchangfangfa{
    public static void main(String[] args){
   FruitGardener f=new Applefactory();//首先获得工厂
    Fruit apple=f.factory();//通过工厂来获得apple对象
     apple.grow();

}
}

