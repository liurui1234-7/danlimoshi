class Single{
         private Single(){}
         public static final Single INSTAANCE=new Single();
}
class Example{
       public static void main(String[] args){
        Single s1=Single.INSTAANCE;
        Single s2=Single.INSTAANCE;
        System.out.println(s1==s2);
}
}

