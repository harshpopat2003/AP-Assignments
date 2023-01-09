import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;




class Student {

    Placement p = new Placement();
//    ArrayList<Student> students = new ArrayList<>();

    //ArrayList<Student> registeredStudents = new ArrayList<Student>();
    public String name;
    public Integer rollno;
    public String branch;
    public Float cgpa;
    public String placed;
    public String want_to_sit;
    public String regiterationtime;
    public String companyname;
    public Integer ctcgot;

    public Student(String name, int roll, double cgpa, String branch, boolean placement_status, boolean sit_for_placement, String regiterationtime, String companyname,int ctcgot) {
        this.name = name;
        this.rollno = roll;
        this.cgpa = (float) cgpa;
        this.branch = branch;
        if (placement_status) {
            this.placed = "offered";
        } else {
            this.placed = "unoffered";
        }
        if (sit_for_placement) {
            this.want_to_sit = "yes";
        } else {
            this.want_to_sit = "no";
        }
        this.regiterationtime = regiterationtime;
        this.companyname = companyname;
        this.ctcgot = 0;
    }

    public Student(){}

    public void mainmenu() {
        System.out.println("=====================================");
        System.out.println("Choose the Student Query to perform :");
        System.out.println("1. Enter as a Student(Give Student Name and Roll Number)");
        System.out.println("2. Add Students");
        System.out.println("3. Exit");
        System.out.println("=====================================");
        System.out.println("Enter your choice: ");

    }

//    public checkeligibility(){
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).placed.equals("unoffered") && students.get(i).want_to_sit.equals("yes")) {
//                for (int j =0; j < companies.size(); j++) {
//                    if (students.get(i).cgpa >= companies.get(j).cgpaneeded && students.get(i).ctcgot < companies.get(j).pack) {
//                        students.get(i).ctcgot = companies.get(j).pack;
//                        students.get(i).companyname = companies.get(j).Companyname;
//                        students.get(i).placed = "offered";
//                        break;
//                    }
//                }
//
//            }
//        }
//    }

    public void Studentmenu() {
        int choice;
        while (true) {
            mainmenu();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter the Student Name: ");
                String name = sc.next();
                System.out.println("Enter the Student Roll Number: ");
                int roll = sc.nextInt();
                int choice1 = 0;
                do {
                    for (int i = 0; i < p.students.size(); i++) {
                        if (p.students.get(i).name.equals(name) && p.students.get(i).rollno == roll) {
                            System.out.println("Welcome " + name + "!!!");
                            System.out.println("1. Register for Placement Drive");
                            System.out.println("2. Register for Company");
                            System.out.println("3. Get all Available Companies");
                            System.out.println("4. Get current Status");
                            System.out.println("5. Update CGPA");
                            System.out.println("6. Accept Offer");
                            System.out.println("7. Reject Offer");
                            System.out.println("8. Back");
                            System.out.println("=====================================");
                            System.out.println("Enter your choice: ");
                            choice1 = sc.nextInt();
                            switch (choice1) {
                                case 1 -> {
                                    //for checking with local date and time
//                                   LocalDateTime myDateObj = LocalDateTime.now();
//                                   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
//                                   String formattedDate = myDateObj.format(myFormatObj);
//                                   //separator
//                                      String[] date = formattedDate.split(" ");
//                                        String[] nowdate1 = date[0].split("/");
                                    //if (p.placements_std > formattedDate) {// left to do this checking condition // output : September 25 2022 07:21
                                    System.out.println("Are you sure you want to register for Placement Drive? (yes/no)");
                                    String choice2 = sc.next();
                                    if (choice2.equals("yes")) {
                                        for (int j = 0; i < p.students.size(); i++) {
                                            if (p.students.get(j).name.equals(name)) {
                                                if (p.students.get(j).placed.equals("offered")) {
                                                    System.out.println("You have already been offered a job ");
                                                } else {
                                                    p.students.get(j).placed = "unoffered";
                                                    p.students.get(j).want_to_sit = "yes";
                                                    //System.out.println("Enter the date in format Month(eg : 03) Date Year,hour:minute");
                                                    //sperate the date and time
//                                                    String datetime = sc.next();
//                                                    String[] date = datetime.split(",");
//                                                    String[] time = date[1].split(":");
//                                                    String[] month = date[0].split(" ");
//                                                    int month1 = Integer.parseInt(month[0]);
//                                                    int date1 = Integer.parseInt(month[1]);
//                                                    int year = Integer.parseInt(month[2]);
//                                                    int hour = Integer.parseInt(time[0]);
//                                                    int minute = Integer.parseInt(time[1]);
//                                                    p.students.get(i).regiterationtime= month1 + " " + date1 + " " + year + "," + hour + ":" + minute;
                                                    p.students.get(j).regiterationtime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // change this format
                                                    System.out.println("You have been registered for Placement Drive");
                                                }

                                                System.out.println(p.students.get(i).name + " Registered for Placement Drive");
                                            }
                                        }
                                    } else {
                                        System.out.println("You have not registered for Placement Drive or invalid answer");
                                    }
                                    //}
                                }

                                case 2 -> {
                                    System.out.println("Enter company Name: ");
                                    String company = sc.next();
                                    System.out.println("Are you sure you want to register for " + company + "? (yes/no)");
                                    String choice2 = sc.next();
                                    if (choice2.equals("yes")) {
                                        for (int f = 0; f < p.students.size(); f++) {
                                            if (p.students.get(f).placed.equals("unoffered") && p.students.get(f).want_to_sit.equals("yes")) {
                                                for (int j = 0; j < p.companies.size(); j++) {
                                                    if (p.students.get(f).cgpa >= p.companies.get(j).cgpaneeded && p.students.get(f).ctcgot < p.companies.get(j).pack) {
                                                        p.students.get(f).ctcgot = p.companies.get(j).pack;
                                                        p.students.get(f).companyname = p.companies.get(j).Companyname;
                                                        p.students.get(f).placed = "offered";
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid answer");
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Available Companies are: ");
                                    for (int h = 0; h < p.companies.size(); h++) {
                                        if (p.companies.get(h).register_for_placement_drive.equals("yes")) {
                                            System.out.println(h + 1 + ".");
                                            System.out.println("Company Name: " + p.companies.get(h).Companyname);
                                            System.out.println("Company Role: " + p.companies.get(h).role);
                                            System.out.println("Company Package: " + p.companies.get(h).pack);
                                            System.out.println("Company CGPA Criteria :" + p.companies.get(h).cgpaneeded);
                                            System.out.println("Company Got Student :" + p.companies.get(h).gotstd);
                                            System.out.println("=====================================");
                                        }
                                    }
                                    int choice69 = sc.nextInt();
                                    // add registration time and date here
                                    if (p.companies.get(choice69+1).gotstd.equals("no")) {
                                        if (p.companies.get(choice69+1).register_for_placement_drive.equals("yes")) {
                                            System.out.println("You have Registered for:  " + p.companies.get(choice69).Companyname);
                                            LocalDateTime myDateObj = LocalDateTime.now();
                                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm");
                                            String formattedDate = myDateObj.format(myFormatObj);

                                            System.out.println("Registered on: " + formattedDate);
                                            p.students.get(i).regiterationtime = formattedDate;
                                            p.students.get(i).companyname = p.companies.get(choice69).Companyname;
                                            System.out.println("Registration Successful");
                                            System.out.println("=====================================");
                                            System.out.println("Your Details are: ");
                                            System.out.println("Name: " + p.students.get(i).name);
                                            System.out.println("Roll Number: " + p.students.get(i).rollno);
                                            System.out.println("Branch: " + p.students.get(i).branch);
                                            System.out.println("CGPA: " + p.students.get(i).cgpa);
                                        } else {
                                            System.out.println("Company already got a student ");
                                        }
                                    }
                                }
                                case 4 -> {
                                    System.out.println("Your current status is: ");
                                    System.out.println("Name: " + p.students.get(i).name);
                                    System.out.println("Roll Number: " + p.students.get(i).rollno);
                                    System.out.println("Branch: " + p.students.get(i).branch);
                                    System.out.println("CGPA: " + p.students.get(i).cgpa);
                                    System.out.println("Placement Status: " + p.students.get(i).placed);
                                    System.out.println("Registered for Placement Drive: " + p.students.get(i).want_to_sit);
                                    System.out.println("Registered for Company: " + p.students.get(i).companyname);
                                    System.out.println("Registered on: " + p.students.get(i).regiterationtime);
                                    System.out.println("=====================================");
                                    if (p.students.get(i).placed.equals("offered")) {
                                        System.out.println("You have been offered a job ");
                                        System.out.println("Company Name: " + p.students.get(i).companyname);
                                        System.out.println("Package: " + p.students.get(i).ctcgot);
                                    }
                                }
                                case 5 -> {
                                    System.out.println("Enter your new CGPA: ");
                                    p.students.get(i).cgpa = sc.nextFloat();
                                    System.out.println("Your CGPA has been updated");
                                }
                                case 6 -> {
                                    if (p.students.get(i).placed == "offered") {
                                        System.out.println("Enter ");
                                        System.out.println("Are you sure you want to accept the offer? (yes/no)");
                                        String choice2 = sc.next();
                                        if (choice2.equals("yes")) {
                                            p.students.get(i).placed = "placed";
                                            System.out.println("Congratulations! You have been placed");
                                        }
                                    } else {
                                        System.out.println("Invalid answer");
                                    }
                                }
                                case 7 -> {
                                    System.out.println("Are you sure you want to reject the offer? (Y/N)");
                                    String choice2 = sc.next();
                                    if (choice2.equals("yes")) {
                                        p.students.get(i).placed = "unoffered";
                                        p.students.get(i).companyname = "none";
                                        System.out.println("You have rejected the offer ");

                                        }
                                     else {
                                        System.out.println("Invalid answer");
                                    }
                                }
                            }
                        }
                    }
                }
                while (choice1 != 8);
            } else if (choice == 2) {
                System.out.println("Enter the number of Students to be added: ");
                int n = sc.nextInt();
                System.out.println("Please add Students Name,Roll Number,CGPA,Branch");
                for (int i = 0; i < n; i++) {
                    String stdname = sc.next();
                    int stdroll = sc.nextInt();
                    double cgpa = sc.nextDouble();
                    String branch = sc.next();
                    boolean placement_status = false; // not placed
                    boolean sit_for_placement = false; // if the student wants to sit for placement or not
                    String regiterationtime = "null";
                    String companyname = "null";
                    int ctcgot = 0;
                    System.out.println(" ");
                    Student std = new Student(stdname, stdroll, cgpa, branch, placement_status, sit_for_placement, regiterationtime, companyname,ctcgot);
                    p.students.add(std);
                }

            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
class Company {

    Placement p = new Placement();

    public String Companyname;
    public String role;
    public Integer pack;
    public Float cgpaneeded;
    public String gotstd;
    public String register_for_placement_drive;

    public String registerationtime;
    public Company(String name, String role, Integer pack, Float cgpaneeded, String gotstd, String register_for_placement_drive,String registerationtime) {
        this.Companyname = name;
        this.role = role;
        this.pack = pack;
        this.cgpaneeded = cgpaneeded;
        this.gotstd = gotstd;
        this.register_for_placement_drive = register_for_placement_drive;
        this.registerationtime = registerationtime;
    }

    public Company() {

    }

    public void menu() {
        System.out.println("Choose the Company Query you want to perform");
        System.out.println("1. Add Company and Details");
        System.out.println("2. Choose Company");
        System.out.println("3. Get Available Companies");
        System.out.println("4. Exit");
    }
    public void getCompanyProcessResults() {
        for (int i = 0; i < p.companies.size(); i++) {
            System.out.println("Company Name: " + p.companies.get(i).Companyname);
            System.out.println("Company got student: " + p.companies.get(i).gotstd);
        }
    }

    public void Companymenu() {
        int choice;
        do{
            menu();
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the Company Name: ");
                    String name = sc.next();
                    System.out.println("Enter the Company Role: ");
                    String role = sc.next();
                    System.out.println("Enter the Company Package: ");
                    Integer pack = Integer.valueOf(sc.next());
                    System.out.println("Enter the Company CGPA: ");
                    Float cgpaneeded = Float.valueOf(sc.next());
                    String gotstd = "no";
                    String register_for_placement_drive = "no";
                    String registerationtime = "null";
                    Company comp = new Company(name, role, pack, cgpaneeded, gotstd, register_for_placement_drive,registerationtime);
                    p.companies.add(comp);
                    System.out.println("Company Added Successfully");
                }
                case 2 -> {
                    // get to choose company from name
                    System.out.println("Enter the Company Name: ");
                    String name = sc.next();
                    for (int i = 0; i < p.companies.size(); i++) {
                        if (p.companies.get(i).Companyname.equals(name)) {
                            int choice1;
                            do {
                                System.out.println("Company Name: " + p.companies.get(i).Companyname);
                                System.out.println("Choose the Company Query you want to perform");
                                System.out.println("1. Update Role");
                                System.out.println("2. Update Package");
                                System.out.println("3. Update CGPA");
                                System.out.println("4. Register to Institute Drive");
                                System.out.println("5. Back");
                                System.out.println("Enter your choice: ");
                                choice1 = sc.nextInt();
                                switch (choice1) {
                                    case 1 -> {
                                        System.out.println("Enter the Company Role: ");
                                        p.companies.get(i).role = sc.next();
                                        System.out.println("Company Role Updated Successfully");
                                    }
                                    case 2 -> {
                                        System.out.println("Enter the Company Package: ");
                                        p.companies.get(i).pack = Integer.valueOf(sc.next());
                                        System.out.println("Company Package Updated Successfully");
                                    }
                                    case 3 -> {
                                        System.out.println("Enter the Company CGPA: ");
                                        p.companies.get(i).cgpaneeded = Float.valueOf(sc.next());
                                        System.out.println("Company CGPA Updated Successfully");
                                    }
                                    case 4 -> {
                                        System.out.println("Placement Drive ");
//                                        System.out.println("Enter the date in format Month(eg : 03) Date Year,hour:minute");
//                                        //sperate the date and time
//                                        String datetime = sc.next();
//                                        String[] date = datetime.split(",");
//                                        String[] time = date[1].split(":");
//                                        String[] month = date[0].split(" ");
//                                        int month1 = Integer.parseInt(month[0]);
//                                        int date1 = Integer.parseInt(month[1]);
//                                        int year = Integer.parseInt(month[2]);
//                                        int hour = Integer.parseInt(time[0]);
//                                        int minute = Integer.parseInt(time[1]);
//                                        p.companies.get(i).registerationtime= String.valueOf(month1+" "+date1+" "+year +"," + hour +":"+ minute);


                                        //p.companies.get(i).registerationtime = sc.next();

                                        //System.out.println("Please the date and time in the format dd/mm/yyyy hh:mm");
                                        p.companies.get(i).registerationtime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
                                        p.companies.get(i).register_for_placement_drive = "yes";
                                        //left to add date and time of drive
                                        System.out.println("Company Registered for Placement Drive Successfully");
                                    }
//                                        default -> System.out.println("Invalid Choice");
                                }
                            } while (choice1 != 5);

                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < p.companies.size(); i++) {
                        System.out.println("Company Name: " + p.companies.get(i).Companyname);
                        System.out.println("Company Role: " + p.companies.get(i).role);
                        System.out.println("Company Package: " + p.companies.get(i).pack);
                        System.out.println("Company CGPA: " + p.companies.get(i).cgpaneeded);
                        System.out.println("Company Placement Drive: " + p.companies.get(i).register_for_placement_drive);
                        System.out.println("Company got student: " + p.companies.get(i).gotstd);
                        System.out.println("===================================================");

                    }
                }
//                    default -> System.out.println("Invalid Choice");
            }
        }
        while(choice!=4);
    }
}
class Placement {
    String starttime_cmp;
    public String getStarttime_cmp() {
        return starttime_cmp;
    }
    String endtime_cmp;
    public String getEndtime_cmp() {
        return endtime_cmp;
    }
    String starttime_std;
    public String getStarttime_std() {
        return starttime_std;
    }
    String endtime_std;
    public String getEndtime_std() {
        return endtime_std;
    }


    public static ArrayList<Company> companies = new ArrayList<>();
    public ArrayList<Company> getCompanies() {return companies;}

    public void setCompanies(ArrayList<Company> companies) {this.companies = companies;}

    public static ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {return students;}

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public String starttime;
    public String endtime;

    ArrayList<Placement> placements_std = new ArrayList<Placement>();
    ArrayList<Placement> placements_comp = new ArrayList<Placement>();

    public Placement(String starttime, String endtime) {
        this.starttime=starttime;
        this.endtime=endtime;
    }

    public Placement() {

    }

    public void getNumberOfStudent() {

        System.out.println("Number of Student Registration: " + students.size());

    }
    public void getNumberOfCompany() {
        System.out.println("Number of Company Registration: " + companies.size());
    }
    public void getNumberOfOfferedUnofferedBlocked() {
        int offered = 0;
        int unoffered = 0;
        int blocked = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).placed.equals("offered")) {
                offered++;
            } else if (students.get(i).placed.equals("unoffered")) {
                unoffered++;
            } else if (students.get(i).placed.equals("blocked")) {
                blocked++;
            }
        }
        System.out.println("Number of students offered: " + offered);
        System.out.println("Number of students unoffered: " + unoffered);
        System.out.println("Number of students blocked: " + blocked);
    }

    public void getStudentDetails(int roll) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollno == roll) {
                System.out.println("Name: " + students.get(i).name);
                System.out.println("Roll Number: " + students.get(i).rollno);
                System.out.println("Branch: " + students.get(i).branch);
                System.out.println("CGPA: " + students.get(i).cgpa);
                System.out.println("Placed: " + students.get(i).placed);
                System.out.println("Want to sit: " + students.get(i).want_to_sit);
            }
        }
    }
    public void getCompanyDetails(String name) {
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).Companyname.equals(name)) {
                System.out.println("Name: " + companies.get(i).Companyname);
                System.out.println("Company Role Offering: " + companies.get(i).role);
                System.out.println("Company Package: " + companies.get(i).pack);
                System.out.println("Company CGPA :" + companies.get(i).cgpaneeded);
                System.out.println("Company got student: " + companies.get(i).gotstd);
            }
        }
    }
    public void getAveragePackage() {
        int sum = 0;
        for (int i = 0; i < companies.size(); i++) {
            sum += Integer.parseInt(String.valueOf(companies.get(i).pack));
        }
        System.out.println("Average Package: " + sum / companies.size());

    }
    public void getCompanyProcessResults() { // chage this to needed one and got one
        for (int i = 0; i < companies.size(); i++) {
            System.out.println("===================================================");
            System.out.println("Company Name: " + companies.get(i).Companyname);
            System.out.println("Company got student: " + companies.get(i).gotstd);
        }
    }

    public void placement(){
        System.out.println("=====================================");
        System.out.println("Welcome to IIITD Placement Cell");
        System.out.println("=====================================");
        System.out.println("1. Open Student Registration");
        System.out.println("2. Open Company Registration");
        System.out.println("3. Get number of Student Registerstion");
        System.out.println("4. Get number of Company Registration");
        System.out.println("5. Get Number of Offered/Unoffered/Blocked Students");
        System.out.println("6. Get Student Details");
        System.out.println("7. Get Company Details");
        System.out.println("8. Get Average Package");
        System.out.println("9. Get Company Process Results");
        System.out.println("10. Back");
        System.out.println("=====================================");
    }

    public void OpenComapanyRegiterations(){
        System.out.println("FIll in the details: ");
        System.out.println("1. Set opening time for company registration");
        System.out.println("2. Set closing time for company registration");
        System.out.println("Enter the date in format Month(eg : 03) Date Year,hour:minute");
        Scanner sc = new Scanner(System.in);
        starttime_cmp=sc.nextLine();
        endtime_cmp=sc.nextLine();
        //Placement place_comp = new Placement(starttime_cmp,endtime_cmp);
        //placements_comp.add(place_comp);
        System.out.println("Company Registration is Opened");

        //System.out.println("Enter the date in format Month(eg : 03) Date Year,hour:minute");
        //sperate the date and time
//        String datetime = sc.next();
//        String[] date = datetime.split(",");
//        String[] time = date[1].split(":");
//        String[] month = date[0].split(" ");
//        int month1 = Integer.parseInt(month[0]);
//        int date1 = Integer.parseInt(month[1]);
//        int year = Integer.parseInt(month[2]);
//        int hour = Integer.parseInt(time[0]);
//        int minute = Integer.parseInt(time[1]);
//        p.companies.get(i).registerationtime= String.valueOf(month1+" "+date1+" "+year +"," + hour +":"+ minute);

        //System.out.println(formattedDate);

        //left to add shomwhere
//        if (starttime.equals(dtf.format(now))){  // for checking if comapny registeration is open or not
//            System.out.println("Company Registration is open");
//        }
//        else if (endtime.equals(dtf.format(now))){
//            System.out.println("Company Registration is closed");
//        }
//        else{
//            System.out.println("Company Registration is not open");
//        }
        //System.out.println("Company Registration is open from "+starttime+" to "+endtime);
    }
    public void OpenStudentRegiterations() {
        System.out.println("Fill in the details: ");
        System.out.println("1. Set opening time for student registration");
        System.out.println("2. Set closing time for student registration");
        System.out.println("Enter the date and time in format dd/mm/yyyy hh:mm");
        Scanner sc = new Scanner(System.in);
        starttime_std = sc.nextLine();
        endtime_std = sc.nextLine();

//        //divide the string into date and time
//        String[] arr1 = starttime.split(" ");
//        String startdate = arr1[0];
//        String time = arr1[1];
//        String endtime = sc.nextLine();
//        String[] arr2 = endtime.split(" ");
//        String enddate = arr2[0];
//        Placement place_std = new Placement(startdate,enddate);
//        placements_std.add(place_std);
//        System.out.println(startdate);
//        System.out.println(enddate);
        //for checking with local date and time
//            LocalDateTime myDateObj = LocalDateTime.now();
//            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm");
//
//            String formattedDate = myDateObj.format(myFormatObj);
//            System.out.println("After Formatting: " + formattedDate);
        // output : September 25 2022 07:21

        //System.out.println("Student Registration is open from "+starttime+" to "+endtime);
    }
    public void Placementmenu() {
        int choice;
        do {
            placement();
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {

                case 1 -> OpenStudentRegiterations();
                case 2 -> OpenComapanyRegiterations();
                case 3 -> getNumberOfStudent(); // done
                case 4 -> getNumberOfCompany(); //done
                case 5 -> getNumberOfOfferedUnofferedBlocked(); // left to be done
                case 6 -> {

                    System.out.println("Enter the Roll Number of the Student: ");
                    //Scanner sc = new Scanner(System.in);
                    int rollno = sc.nextInt();
                    getStudentDetails(rollno); //done

                }
                case 7 -> {
                    System.out.println("Enter the Company Name: ");
                    Scanner sac = new Scanner(System.in);
                    String name = sac.nextLine();
                    getCompanyDetails(name); //done
                }
                case 8 -> getAveragePackage(); //done
                case 9 -> getCompanyProcessResults(); //done
                //default -> System.out.println("Invalid Choice");
            }
        }
        while (choice != 10);
    }
}
public class Main {
    static Placement p = new Placement();
    static Company c = new Company();
    static Student s = new Student();


    //ArrayList<Student> students = new ArrayList<Student>();

    //ArrayList<Company> companies = new ArrayList<Company>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Welcome to Placement Management System");
            System.out.println("=====================================");
            System.out.println("1. Enter the Application");
            System.out.println("2. Exit the Application");
            System.out.println("=====================================");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                int choice1;
                do {
                    System.out.println("Choose the Mode you want to enter in :");
                    System.out.println("1. Enter as Student");
                    System.out.println("2. Enter as Company");
                    System.out.println("3. Enter as Placement Officer");
                    System.out.println("4. Return to main Application");
                    System.out.println("=====================================");
                    System.out.println("Enter your choice: ");
                    choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1 -> s.Studentmenu();
                        case 2 -> c.Companymenu();
                        case 3 -> p.Placementmenu();
//                        default -> System.out.println("Invalid Choice");
                    }
                }
                while (choice1 != 4);
            }

        }
        while (choice != 2);
        {
            System.out.println("Thank you");
            System.exit(0);
        }
    }
}
