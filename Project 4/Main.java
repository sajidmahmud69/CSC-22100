package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner input = new Scanner(System.in);

        int x_axis = 0;
        int y_axis = 0;


        System.out.print("Give the x-coordinate of the canvas: ");
        x_axis = input.nextInt();

        System.out.print("Give the y-coordinate of the canvas: ");
        y_axis = input.nextInt();

        Canvas canvas = new Canvas (x_axis, y_axis);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane layout = new StackPane(canvas);

        Scene scene = new Scene( layout);
        primaryStage.setScene(scene);

        primaryStage.show();

        PieChart pc = new PieChart();
        pc.draw(gc, x_axis, y_axis);

    }


    public static void main(String[] args) throws SQLException {

        System.out.println("Connecting to Database....");
        if (ConnectionConfiguration.getConnection() != null) System.out.println("Connection Successful");

        StudentsImpl si = new StudentsImpl();
        CoursesImpl ci = new CoursesImpl();
        ClassesImpl cli = new ClassesImpl();

        si.createStudentsTable();
        ci.createCoursesTable();
        cli.createClassesTable();

        // Student database

        Students s1 = new Students(100000000, "Dennis", "Ritchie", "dennisritchie123@gmail.com", "M");
        Students s2 = new Students(100000001, "Guido", "Rossum", "guidorossum001@yahoo.com", "M");
        Students s3 = new Students(100000002, "Robert", "Gentleman", "gentlemanrob234@gmail.com", "M");
        Students s4 = new Students(100000003, "Yukihiro", "Matsumoto", "matsumotoyukihiro89@outlook.com", "M");
        Students s5 = new Students(100000004, "Rasmus", "Lerdorf", "lerdorfras@yahoo.com", "M");
        Students s6 = new Students(100000005, "Tom", "Riddle", "hewhomustnotbenamed@gmail.com", "M");
        Students s7 = new Students(100000006, "Ada", "Lovelace", "lovelaceada@yahoo.com", "F");
        Students s8 = new Students(100000007, "Grace", "Hopper", "hoppergrace@outlook.com", "F");
        Students s9 = new Students(100000008, "Steve", "Shirley", "shirleysteve@gmail.com", "F");
        Students s10 =new Students(100000009, "Sam", "Fisher", "Samfisher@outlook.com", "M");
        Students s11 =new Students(100000010, "Altair", "La'Ahad", "lahadaltair@yahoo.com", "M");
        Students s12 =new Students(100000011, "Lara", "Croft", "laracroft@gmail.com", "F");
        Students s13 =new Students(100000012, "Elena", "Fisher", "elenaFisher@yahoo.com", "F");
        Students s14 =new Students(100000013, "Nathan", "Drake", "nathandrake@gmail.com", "M");
        Students s15 =new Students(100000014, "Ivy", "Valentine", "ivyvalentine@gmail.com", "F");

//        si.insert(s1);
//        si.insert(s2);
//        si.insert(s3);
//        si.insert(s4);
//        si.insert(s5);
//        si.insert(s6);
//        si.insert(s7);
//        si.insert(s8);
//        si.insert(s9);
//        si.insert(s10);
//        si.insert(s11);
//        si.insert(s12);
//        si.insert(s13);
//        si.insert(s14);
//        si.insert(s15);

        // Course Database

        Courses c1 = new Courses("ART 101", "Intro to Art", "Art");
        Courses c2 = new Courses("CSC 113", "Programming Languages", "Computer Science");
        Courses c3 = new Courses("MAT 203", "Calculus 3", "Math");
        Courses c4 = new Courses ("CSC 221", "Software Design Laboratory", "Computer Science");
        Courses c5 = new Courses ("ENGR 276", "Engineering Economics", "Electrical Engineering");

//        ci.insert(c1);
//        ci.insert(c2);
//        ci.insert(c3);
//        ci.insert(c4);
//        ci.insert(c5);

        // Classes Database

        Classes cl1 = new Classes("CSC 221", 100000004, "P", 2020, "Spring", "B");
        Classes cl2 = new Classes("CSC 221", 100000005, "P", 2020, "Spring", "A");
        Classes cl3 = new Classes("CSC 221", 100000006, "P", 2020, "Spring", "C");
        Classes cl4 = new Classes("CSC 221", 100000009, "R", 2020, "Spring", "W");
        Classes cl5 = new Classes("CSC 221", 100000010, "R", 2020, "Fall", "D");
        Classes cl6 = new Classes("CSC 221", 100000011, "R", 2019, "Fall", "F");
        Classes cl7 = new Classes("ENGR 276",100000012, "AB", 2020, "Summer", "W");
        Classes cl8 = new Classes("ART 101", 100000003, "PR", 2019, "Fall", "F");
        Classes cl9 = new Classes("CSC 113", 100000014, "MN", 2018, "Fall", "C");
        Classes cl10 = new Classes("MAT 203", 100000007,"HBR", 2019, "Summer", "D");
        Classes cl11 = new Classes("ART 101", 100000008, "LM", 2020, "Fall", "A");
        Classes cl12 = new Classes("MAT 203", 100000000,"MR", 2020, "Summer", "C");
        Classes cl13 = new Classes("ENGR 276", 100000001, "K", 2019, "Spring", "F");
        Classes cl14 = new Classes("CSC 113", 100000002, "GH", 2020, "Fall", "A");
        Classes cl15 = new Classes("MAT 203", 100000013, "B", 2020, "Spring", "A");

//        cli.insert(cl1);
//        cli.insert(cl2);
//        cli.insert(cl3);
//        cli.insert(cl4);
//        cli.insert(cl5);
//        cli.insert(cl6);
//        cli.insert(cl7);
//        cli.insert(cl8);
//        cli.insert(cl9);
//        cli.insert(cl10);
//        cli.insert(cl11);
//        cli.insert(cl12);
//        cli.insert(cl13);
//        cli.insert(cl14);
//        cli.insert(cl15);

        JoinTables jt = new JoinTables();

        si.printTable();
        ci.printTable();
        cli.printTable();
        jt.printJoinTables();
        launch(args);
    }
}
