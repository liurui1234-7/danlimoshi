interface Animal{
      void shout();
}
class Cat implements Animal{
     public void shout(){
        System.out.println("����.....");
}
}
class Dog implements Animal{
public void shout(){
   System.out.println("����");
}
}
public class duotai{
      public static void main(String[] args){   
       Animal an1=new Cat();
       Animal an2=new Dog();
       animalshout(an1);
       animalshout(an2);
       }
      public static void animalshout(Animal an){
        an.shout();
}
}