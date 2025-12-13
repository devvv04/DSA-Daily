
import java.util.Scanner;
class star_patterns {
    public void pat5(int n){
         for (int i =0;i<n;i++){
           for (int j =0;j<(n-i);j++){
               System.out.print("*");
           }
           System.out.println();
       }
    }
    
    public void pat6(int n){
        for(int i =0;i<n;i++){
            for(int j =1;j<(n-i+1);j++){
            System.out.print(j);
        }
        System.out.println();
    }
    }
    
    public void pat7(int n){
        for (int i =1 ;i<=n;i++){
            for(int s=0;s<(n-i);s++){
                System.out.print(" ");
            }
            for(int j=0;j<(2*i-1);j++){
                System.out.print("*");
            }
             for(int s=0;s<(n-i);s++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void pat8(int n){
        for(int i =1;i<=n;i++){
            for(int s=0;s<(i-1);s++){
                System.out.print(" ");
            }
            for(int j =0;j<(2*n-2*i+1);j++){
                System.out.print("*");
            }
            for(int s=0;s<(i-1);s++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void pat9(int n){
         for (int i =1 ;i<=n;i++){
            for(int s=0;s<(n-i);s++){
                System.out.print(" ");
            }
            for(int j=0;j<(2*i-1);j++){
                System.out.print("*");
            }
             for(int s=0;s<(n-i);s++){
                System.out.print(" ");
            }
            System.out.println();
        }
         for(int i =1;i<=n;i++){
            for(int s=0;s<(i-1);s++){
                System.out.print(" ");
            }
            for(int j =0;j<(2*n-2*i+1);j++){
                System.out.print("*");
            }
            for(int s=0;s<(i-1);s++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void pat10(int n){
        for(int i =1;i<=(n*2-1);i++){
            int stars = i;
            if(i>n){
                stars = 2*n-i;
            }
            for(int j=0;j<stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void revise1(int a){
        for(int i=1;i<=a;i++){
            for(int s=0;s<(a-i);s++){
                System.out.print(" ");
            }
            for(int j=0;j<(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
   }
public void revise2(int a){
    for (int i =1;i<=2*a-1;i++){
            int stars = i;
            if(i>a){stars = (2*a-i); }
            for(int j =0;j<stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }} 
public void pat11(int a){
    for (int i =0;i<a;i++){
            int start;
            if(i % 2 ==0){
                start = 1;
            }else{
                start = 0;
            }
            for(int j =0;j<=i;j++){
                System.out.print(start);
                start = 1-start;
            }
            System.out.println();
        }
}    
   public void pat12(int a){
       for (int i =1;i<=a;i++){
            for(int j =1;j<=i;j++){
                System.out.print(j);
            }
            for(int s=0;s<(2*a-2*i);s++){
                System.out.print(" ");
            }
            for(int j =i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
   }
  public void pat13(int a){
       int num = 1;
       for(int i =1;i<=a;i++){
           for(int j =1;j<=i;j++){
              System.out.print(" "+num);
              num= num+1;
           }
           System.out.println();
       }
  }
  public void pat14(int a){
       for(int i=0;i<a;i++){
        for (char j ='A';j<='A'+i;j++){
            System.out.print(j);
        }
        System.out.println();
    }
  }
   public void pat15(int a){
       for(int i =0;i<a;i++){
       for(char j='A';j<'A'+(a-i);j++){
           System.out.print(j);
       }
       System.out.println();
   }
   }
   
   public void pat16(int a){
       for (int i = 1;i<=a;i++){
      char ch = (char)('A'+i-1);
      for(int j =0;j<i;j++){
          System.out.print(ch);
      }
      System.out.println();
  }
  
  
   }
   
   public void pat16my(char c){
      for (char i = 'A';i<=c;i++){
      for(char j ='A';j<=i;j++){
          System.out.print(i);
      }
      System.out.println();
  }
  }

  public void pat17(int a){
        for(int i=0;i<a;i++){
             char ch ='A';
             int breakpoint = (2*i+1) / 2; 
            for(int s = 0;s<a-i;s++){
                System.out.print(" ");
            }
            for(int j =1;j<=(2*i+1);j++){
                System.out.print(ch);
                if(j<=breakpoint){
                    ch++;
                }else{
                    ch--;
                }
            }
            
            for(int s = 0;s<a-i;s++){
                System.out.print(" ");
            }
            System.out.println();        
        }
    }
    public void pat18(int a){
        for(int i =0;i<a;i++){
         for(char j=(char)('Z'-i);j<='Z';j++){
             System.out.print(" "+j);
             
         }
         System.out.println();
     }  
    }
    public void pat19(int a){
        for(int i = 0;i<a;i++){
            //star
            for(int j =i;j<a;j++){
                System.out.print("*");
            }
            //space
            for(int s=0;s<2*i;s++){
                System.out.print(" ");
            }
            //star
             for(int j =i;j<a;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        for(int i =1;i<=a;i++){
            //star
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            //space
            for(int s=0;s<2*a-2*i;s++){
                System.out.print(" ");
            }
            //star
             for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void pat20(int a){
        for(int i=1;i<=2*a-1;i++){
            //star
            int start = i;
            if(i>a){
                    start = 2*a-i;
                }
            for(int j=1;j<=start;j++){
                System.out.print("*");
            }
            //space
            int sp = 2*a-2*i;
            if(i>a){
                sp = i-(2*a-i);
            }
            for(int s=0;s<sp;s++){
                System.out.print(" ");
            }
            
            //star
            for(int j=1;j<=start;j++){
                System.out.print("*");
            }
            
           System.out.println();  
        }
       
    }
    public void pat21(int a){
         for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                if(i==0||j==0||j==a-1||i==a-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
     System.out.println();
        }
    }
    public void pat22(int a){
         for(int i=0;i<2*a-1;i++){
          for(int j =0;j<2*a-1;j++){
              int left = j;
              int right = (2*a-2)-j;
              int top = i;
              int bottom = (2*a-2)-i;
              System.out.print(a - Math.min(Math.min(left,right),Math.min(top,bottom)));
          }
          System.out.println();
      }
    }
    
    public static void main(String[] args) {
      star_patterns m = new star_patterns();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number: ");
    //   int a = sc.nextInt();
      
      char y = sc.next().charAt(0);
       
       m.pat16my(y);
      
    
    sc.close();
    }
    
}




