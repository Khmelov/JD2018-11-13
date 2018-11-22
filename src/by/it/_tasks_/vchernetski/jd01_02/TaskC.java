package by.it._tasks_.vchernetski.jd01_02;

import java.util.Scanner;

public class TaskC {
   private static int[][] step1(int n){
       int[][] mas = new int[n][n];
       boolean b = true;
       while(b)
       {
            boolean c=false, a=false;
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   mas[i][j] = (int)(Math.random()*(2*n+1))-n;
               }
           }
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   if(mas[i][j]==n) a=true;
                   if(mas[i][j]==-n) c=true;
               }
           }
           b=!(a&c);
       }
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               System.out.print(mas[i][j]+ " ");
           }
           System.out.println();
       }
       return mas;
   }
   private static int step2(int[][] mas)
   {
       int sum=0;
       for (int i = 0; i <mas.length ; i++) {
           int a=0;
           int b=0;
           for (int j = 0; j <mas[i].length ; j++) {
               if(mas[i][j]>=0){
                   a=j;
                   break;}
           }
           for (int j = a+1; j <mas[i].length ; j++) {
               if(mas[i][j]>=0){
                   b=j;
                   break;}
           }
           if(b-a<=1) break;
           for (int j = a+1; j < b ; j++) {
               sum+=mas[i][j];
           }
           }

       System.out.println(sum);
       return sum;
   }
 //  private static int[][] foo(int[][]mas,int max){
//       int[][] masred = new int[mas.length-1][mas.length-1];
//       int a=0;
//       int b=0;
//       boolean m =false, n =false;
//       for (int i = 0; i <mas.length ; i++) {
//           for (int j = 0; j <mas[i].length ; j++) {
//               if(mas[i][j]==max) {
//                   a=i;
//                   b=j;
//                   m=true;
//                   n= true;
//                   break;
//               }
//           }
//           if(n){break;}
//       }
//
//       System.out.println("индексы" +a + " " +b);
//       if(m){
//       int q=0;
//       for (int i = 0; i <mas.length ; i++) {
//           if(i==a) {
//               continue;}
//           for (int j = 0; j <mas[i].length ; j++) {
//               if(j<b) {
//                   masred[q][j]=mas[i][j];
//               } else if(j>b) masred[q][j-1]=mas[i][j];
//               else continue;
//           }
//           q++;
//       }
//       for (int i = 0; i <masred.length ; i++) {
//           for (int j = 0; j <masred[i].length ; j++) {
//               System.out.print(masred[i][j]+" ");
//           }
//           System.out.println();
//       }
//       return masred;}
//       else {return mas;}
//       for (int i = 0; i <mas.length; i++) {
//           for (int j = 0; j <mas.length ; j++) {
//               if(mas[i][j]==max){
//                   for (int k = 0; k <mas[i].length ; k++) {
//                       if(mas[i][k]!=max) mas[i][k]=0;
//                   }
//               }
//           }
//       }
//       System.out.println("new");
//       for (int i = 0; i <mas.length; i++) {
//           for (int j = 0; j <mas[i].length ; j++) {
//               System.out.println(mas[i][j]+" ");
//           }
//       }
//       return mas;
//   }
   private static int[][] step3(int [][] mas)
   {
       int max=0;
//       int c=0;
//       for (int i = 0; i <mas.length ; i++) {
//           for (int j = 0; j <mas[i].length ; j++) {
//               if(max<mas[i][j]) max = mas[i][j];
//           }
//       }
//       System.out.println("max"+max);
//       for (int i = 0; i <mas.length ; i++) {
//           for (int j = 0; j <mas[i].length ; j++) {
//               if(max==mas[i][j]) c++;
//           }
//       }
//       System.out.println("количество"+c+"\n");
//       int[][] mas = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
//       for (int i = 0; i <m4.length ; i++) {
//           for (int j = 0; j <m4.length ; j++) {
//               if(max==mas[i][j]) c++;
//           }
//       }
//       System.out.println("количество"+c+"\n");
//       int[][] masfin;
//       int[][] masred=m4;
//       int l=2;
//       while (l<=c){
//           masred=foo(masred,max,c);
//           l++;
//       }
//       masfin=masred;
//       for (int i = 0; i <mas.length-c ; i++) {
//           for (int j = 0; j <mas.length-c ; j++) {
//               System.out.print(masfin[i][j]+" ");
//           }
//           System.out.println();
//       }
       for (int i = 0; i <mas.length ; i++) {
           for (int j = 0; j <mas[i].length ; j++) {
               if(max<mas[i][j]) max = mas[i][j];
           }
       }
       int a=0;
       int c=0;
       boolean b=false;
       char[][] ch=new char[mas.length][mas.length];
       for (int i = 0; i <ch.length ; i++) {
           for (int j = 0; j <ch[i].length ; j++) {
               ch[i][j]='y';
           }
       }
       //System.out.println("max  " + max);
       for (int i = 0; i <mas.length ; i++) {
           b=false;
           for (int j = 0; j <mas[i].length ; j++) {
               if(mas[i][j]==max){
                   b=true;
                   ch[i][j]='d';
                   a=j;
                   for (int k = 0; k <ch.length ; k++) {
                       ch[i][k]='d';
                   }
                   for (int k = 0; k <ch.length ; k++) {
                       ch[k][a]='d';
                   }
//                   for (int k = 0; k <mas[i].length ; k++) {
//                       if(mas[i][k]!=max){ch[i][k]='d';}
//                   }
//                   for (int k = 0; k <mas.length ; k++) {
//                       if(mas[k][a]!=max){ch[k][a]='d';}
//                   }
               }
           }
           if(b) c++;
       }
//
       a=0;
       b=false;
       for (int i = 0; i <mas.length ; i++) {
           b=false;
           for (int j = 0; j <mas[i].length ; j++) {
               if(mas[j][i]==max){
                   b=true;
               }
           }
           if(b) a++;
       }
      // System.out.println("c   "+c+"     a    "+a);
//       for (int i = 0; i <ch.length ; i++) {
//           for (int j = 0; j <ch.length ; j++) {
//               System.out.print(ch[i][j]+" ");
//           }
//           System.out.println();
//       }
       int [][] masfin=new int[mas.length-c][mas.length-a];
       int q=0;
       int w,z;
       for (int i = 0; i <mas.length ; i++) {
          w=0;
          z=0;
           for (int j = 0; j <mas.length ; j++) {
               if(ch[i][j]=='y'){
                   z++;
                   masfin[q][w]=mas[i][j];
               }
               w++;
               if(ch[i][j]=='d'){
                   w--;
               }

           }
           if(z==0){q--;}
          q++;
       }
       for (int i = 0; i <masfin.length ; i++) {
           for (int j = 0; j <masfin[i].length ; j++) {
               System.out.print(masfin[i][j]+" ");
           }
           System.out.println();
       }
       return masfin;
   }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum;
        int [][] mas= step1(n);
        sum=step2(mas);
        mas = step3(mas);
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas.length ; j++) {
                System.out.print(mas[i][j]+" ");
            }
            System.out.println();
        }
    }
}
