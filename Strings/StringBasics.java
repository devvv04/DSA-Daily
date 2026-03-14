package Strings;

public class StringBasics {
      public static void main(String[] args) {
      String s = "12345" ;
    //   int digit = s.charAt(2)-0;
    //   System.out.println(digit);
    String s1 = new String("hellodev");
    for(int i=0;i<s1.length();i++){
        System.out.println(s1.charAt(i));
    }
    
    System.out.println(s.equals(s1));
    
    System.out.println(s1.substring(0,2));
    
    String s3 = "hello dev verma";
    System.out.println(s3.contains("lo dev"));
    
    String s4 = "aaaaaa";
    System.out.println(s4.indexOf('a'));
    System.out.println(s4.lastIndexOf('a'));
    
    System.out.println(s4.toUpperCase());
    
    String s5 = new String("my name is dev verma. How are you");
    String[] arr = s5.split(" ");
    for(String a : arr){
        System.out.println(a);
    }
    
    System.out.println(s3+" "+s4);
    System.out.println(s3.concat(s4));
    
    
    String s6 = "heloo";
    StringBuilder sb = new StringBuilder(s6);
    sb.append(" world");
    System.out.println(sb.toString());
    System.out.println(sb.reverse().toString());
    
    StringBuilder sb1 = new StringBuilder("234");
    System.out.println(sb1.reverse().toString());
    
    String s7 = "5467";
    for(int i=0;i<s7.length();i++){
        int digit = s7.charAt(i)-'0';
        System.out.println(digit);
        
    }
    
    // System.out.println('c');
    int y = 123;
    String s8 = String.valueOf(y);
    System.out.println(s8);
    
    String s9 = "5346673";
    int num = Integer.parseInt(s9);
    if(num % 2 != 0) System.out.println("odd");
    
    }
}
