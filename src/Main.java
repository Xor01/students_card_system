import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static String currency = "SAR";
    private static final ArrayList<Student> STUDENT_ARRAY_LIST = new ArrayList<>();
    private static int choice;
    private static int currentStudent = -1;
    private static double amount = 0;
    private static final String [] studentDetailsArray = new String[3];
    private static String temp = "";
    private static final Scanner inp = new Scanner(System.in);
    public static void main(String[] args) throws Exception {



    do {
        System.out.print("Current Student ID: ");
        System.out.println( aStudentExist()  ?  
                            STUDENT_ARRAY_LIST.get(currentStudent).getId()  : "None");
        System.out.println(
                "1. Student Options Tab.\n"   +
                "2. Fees Options Tab .\n"     +
                "3. Access Options Tab.\n"    +
                "4. Get Balance.\n"           +
                "5. Deposit Options Tab.\n"   +
                "6. Withdraws Options Tab.\n" +
                "7. SCS Status Options.\n"    +
                "0. To Exit.\n"
            );
        System.out.print("Enter Your choice: ");
        choice = inp.nextInt();
        
        
        switch (choice) {
            case 1:
            System.out.println(
            "1. Add a New Student.\n"       +
            "2. Change Current Student.\n"     +
            "3. List Current Student Details.\n"        +
            "4. List All Student Details.\n"        +
            "99. To Exit From This Menu.\n" +
            "0. To Exit From The Program.\n"
            );
            System.out.print("Enter Your choice: ");
            choice = inp.nextInt();
            
            switch(choice){
                case 1:
                createStudent();
                    break;
                case 2:
                    changeCurrentStudent();
                    break;
                case 3:
                    if (!aStudentExist()) 
                            {System.out.println("Add Student First");}
                        else                        
                            System.out.println(STUDENT_ARRAY_LIST.get(currentStudent));
                    break;
                case 4:
                    listStudents(STUDENT_ARRAY_LIST);
                    break;
            }
            break;
            
            case 2:
                System.out.println(
                    "1. Add a Fee to Student.\n"    +
                    "2. Print All Student Fees\n"   +
                    "99. To Exit From This Menu.\n" +
                    "0. To Exit From The Program.\n"
                );
                System.out.print("Enter Your choice: ");
                choice = inp.nextInt();
                switch (choice) {
                    case 1:
                        addFee();
                        break;
                    case 2:
                    if (!aStudentExist())
                        {System.out.println("Add Student First");}
                    else
                        STUDENT_ARRAY_LIST.get(currentStudent).listFees();
                    break;
                }
                break;
                                
            case 3:
                System.out.println(
                    "1. Access a Place.\n" +
                    "2. Print All Accessed Places.\n" +
                    "99. To Exit From This Menu.\n" +
                    "0. To Exit From The Program.\n"
                );
                System.out.print("Enter Your choice: ");
                choice = inp.nextInt();
                switch (choice) {
                    case 1:
                        access();
                        break;
                    case 2:
                    if (!aStudentExist())
                        {System.out.println("Add Student First");}
                    else
                        STUDENT_ARRAY_LIST.get(currentStudent).listAccess();
                        break;
                }
                break;
            case 4:
                if (!aStudentExist()) 
                {System.out.println("Add Student First");}
            else
                System.out.printf("Your Balance: %.2f %s\n",
                STUDENT_ARRAY_LIST.get(currentStudent).getBalance(), currency);
                break;
            case 5:
                System.out.println(
                    "1. Deposit To Account.\n" +
                    "2. Print All Deposits from the Account.\n" +
                    "99. To Exit From This Menu.\n" +
                    "0. To Exit From The Program.\n"
                );
                System.out.print("Enter Your choice: ");
                choice = inp.nextInt();
                switch (choice) {
                    case 1:
                    deposit();
                        break;
                    case 2:
                    if (!aStudentExist()) 
                        {System.out.println("Add Student First");}
                    else
                    STUDENT_ARRAY_LIST.get(currentStudent).listDeposit();
                        break;
                }
                break;
            case 6:
                System.out.println(
                    "1. Withdraw From Account.\n" +
                    "2. Print All Withdraws from Account.\n" +
                    "99. To Exit From This Menu.\n" +
                    "0. To Exit From The Program.\n"
                );
                System.out.print("Enter Your choice: ");
                choice = inp.nextInt();
                switch (choice) {
                    case 1:
                    withdraw();
                        break;
                    case 2:
                    if (!aStudentExist())
                        {System.out.println("Add Student First");}
                    else
                    STUDENT_ARRAY_LIST.get(currentStudent).listWithdraws();
                        break;
                }
                break;
            case 7:
                System.out.println(
                    "1. Check Card Status.\n" +
                    "2. Active Card.\n" +
                    "3. Deactivate Card.\n" +
                    "99. To Exit From This Menu.\n" +
                    "0. To Exit From The Program.\n"
                );
                System.out.print("Enter Your choice: ");
                choice = inp.nextInt();
                switch (choice) {


                    case 1:
                        if (!aStudentExist()){System.out.println("Add Student First");}
                        
                        else {

                            if (STUDENT_ARRAY_LIST.get(currentStudent).getCardStatus()) {
                                System.out.println("The Card is Active.");
                            } 
                            else {
                                System.out.println("This Card is Not Active");
                            }
                        }
                        break;
                    case 2:
                        if (!aStudentExist()){System.out.println("Add Student First");}
                        
                        else {

                            if (STUDENT_ARRAY_LIST.get(currentStudent).getCardStatus()) {
                                System.out.println("The Card is Already Active.");
                            } 
                            else {
                                STUDENT_ARRAY_LIST.get(currentStudent).activateCard();
                                System.out.println("This Card Has been Activated Successfully");
                            }
                        }
                        break;
                    case 3:
                    if (!aStudentExist()){System.out.println("Add Student First");}
                    
                    else {

                        if (!STUDENT_ARRAY_LIST.get(currentStudent).getCardStatus()) {
                            System.out.println("The Card is Already Active.");
                        } 
                        else {
                            STUDENT_ARRAY_LIST.get(currentStudent).deActivateCard();
                            System.out.println("This Card Has been Deactivated Successfully");
                        }
                    }
    
                        break;
                }
                break;
            case 0:
                terminateProgram();
            default:
                System.out.println("Wrong Choice!");
                break;
        }
    
        clearScreen();  
    
    } while (choice != 0);
    inp.close();
}
private static boolean aStudentExist(){
    return currentStudent >= 0;
}

private static void createStudent(){
    System.out.print("Enter Student Name: ");
    studentDetailsArray[0] = inp.nextLine();
    studentDetailsArray[0] = inp.nextLine(); // to overcome \n from choice

    System.out.print("Enter Student College: ");
    studentDetailsArray[1] = inp.nextLine();

    System.out.print("Enter Student Department: ");
    studentDetailsArray[2] = inp.nextLine();
    temp = createId(STUDENT_ARRAY_LIST);
    STUDENT_ARRAY_LIST.add(new Student(studentDetailsArray[0], studentDetailsArray[1], studentDetailsArray[2], temp));
    currentStudent +=1;
    System.out.println("Student Has Been Created");
    System.out.println("With the ID: " + temp);
}

private static void addFee(){
    if (!aStudentExist()) {System.out.println("Add a Student First"); return;}
    System.out.print("Enter Fee Name: ");
    temp = inp.nextLine();
    temp = inp.nextLine();
    
    System.out.print("Enter Fee Cost: ");
    amount = inp.nextDouble();
    STUDENT_ARRAY_LIST.get(currentStudent).addFee(temp, amount);
}

private static String createId(ArrayList<Student> std){
    
    Random rnd = new Random();
    Integer n = 1000000 + rnd.nextInt(9000000);
    String id = "000111" + n.toString();

    while(checkIdExist(id, std))
    {
        n = 1000000 + rnd.nextInt(9000000);
        id = "000111" + n.toString();
    }
    return id;
}

private static void access(){
    if (!aStudentExist()) {System.out.println("Add a Student First"); return;}
    System.out.print("Enter The Name of the place to access: ");
    temp = inp.nextLine();
    temp = inp.nextLine();
    System.out.println("Scan: " + STUDENT_ARRAY_LIST.get(currentStudent).getBarcode());
    STUDENT_ARRAY_LIST.get(currentStudent).addAccess(temp);
}

private static void changeCurrentStudent(){
    if (!aStudentExist()) {System.out.println("Add a Student First"); return;}
    
    System.out.print("Enter The ID For The Student To Change To: ");
    temp = inp.next();
    
    int tmp = getStudentIndex(temp);
    
    if (tmp == -1 || tmp == currentStudent) {
        System.out.println("Current Student has not been changed");
    } 
    else {
        System.out.println("Current Student has been changed");
        currentStudent = tmp;
    }

}

private static boolean checkIdExist(String id, ArrayList<Student> std){

    boolean exist = false;
    
    for (Student stu : std) {
        
        if (stu.getId().equals(id)) {
            exist = true;
            break;
        }
    }

    return exist;

}

private static void deposit(){
    if (!aStudentExist()) {System.out.println("Add a Student First"); return;}
    System.out.print("Enter an Amount to Deposit: ");
    amount = inp.nextDouble();
    STUDENT_ARRAY_LIST.get(currentStudent).deposit(amount);
}

private static void withdraw(){
    if (!aStudentExist()) {System.out.println("Add a Student First"); return;}
    System.out.print("Enter an Amount to Withdraw: ");
    amount = inp.nextDouble();
    STUDENT_ARRAY_LIST.get(currentStudent).withdraw(amount);
}

private static void listStudents(ArrayList<Student> std){
    if (!aStudentExist()) {System.out.println("Add a Student First"); return;}
    for (Student st : std) {
        System.out.println(st);
        System.out.println("-------------------------");
    }
}

private static int getStudentIndex(String id){
    
    int index = -1;
    
    for (Student st : STUDENT_ARRAY_LIST) {
        
        if (id.equals(st.getId())) {
            index = STUDENT_ARRAY_LIST.indexOf(st);
            break;
        }
    }
        return index;
    }

    private static void terminateProgram(){
        System.out.print("Have a Nice Day...");
        System.exit(0);
    }

    private static void clearScreen() throws IOException{
        System.out.print("Press Enter to continue...");
            System.in.read();
            System.out.print("\033[H\033[2J");  
            System.out.flush();
    }
}