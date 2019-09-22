class Father{
       private String name = "Zhangjun";
       class Child{
        public void introFather(){
        System.out.println("My Father name is"+ name);
}
}
}
public class Example02{
      public static void main(String[] args){
  Father.Child c=new Father().new Child();
 c.introFather();
}
}
