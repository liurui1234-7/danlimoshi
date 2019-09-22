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
 class FruitGardener{
         public static Fruit factory(String which) {
              if(which.equalsIgnoreCase("apple")){
                    return new Apple();
              }else if(which.equalsIgnoreCase("strawberry")){
                    return new Strawberry();
              }else{
                     return new Grape();
              }
}
}
public class jiandanmoshi{
    public static void main(String[] args){
     FruitGardener fg=new FruitGardener();
     Fruit ap=fg.factory("Apple");
     ap.grow();
     Fruit gp=fg.factory("Grape");
     gp.plant();
}
}
