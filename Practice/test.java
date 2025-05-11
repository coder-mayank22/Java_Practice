package Practice;
import java.util.Scanner;
class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter number of students: ");
        n = sc.nextInt();
        sc.nextLine(); //Consume newline character left by nextInt()

        String name[] = new String[n];
        int P[] = new int[n];
        int C[] = new int[n];
        int M[] = new int[n];
        double avg[] = new double[n];
        int i;
        for(i=0; i<n; i++){
            System.out.print("Enter name of student: ");
            name[i] = sc.nextLine();

            System.out.print("Marks in Physics: ");
            P[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Marks in Chemistry: ");
            C[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Marks in Maths: ");
            M[i] = sc.nextInt();
            sc.nextLine();

            avg[i] = (P[i]+C[i]+M[i])/3.0;
        }

        double max = 0;
        int pos=0;
        for(i=0; i<n; i++){
            if(avg[i]>max){
                max = avg[i];
                pos = i;
            }
        }

        System.out.println("Class topper is: "+name[pos]);
        sc.close();
    }
}
