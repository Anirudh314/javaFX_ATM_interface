package sample;
import java.util.Date;
import java.lang.Math;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;


public class Main extends Application {
    Stage window1;
    Scene scene1, scene2, scene0;
    int count = 0;
    int amount = 1000;
    int savings = 1000, current = 1000, credit = 1000;
    boolean fl = true;


    @Override
    public void start(Stage primaryStage) {
        window1 = primaryStage;

        primaryStage.setTitle("WELCOME TO OUR ATM");
            GridPane grid0 = new GridPane();
            grid0.setPadding(new Insets(10, 10, 10, 10));
            grid0.setVgap(8);
            grid0.setHgap(10);

            //value input

            TextField pass0 = new TextField("enter account number ");
            GridPane.setConstraints(pass0, 1, 0);

            Button submit0 = new Button("submit");
            GridPane.setConstraints(submit0, 1, 2);


            grid0.getChildren().addAll(pass0, submit0);
            scene0 = new Scene(grid0, 600, 600);
            window1.setScene(scene0);

            //scene2 = new Scene(grid,100,500);
            window1.show();

            submit0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if (Integer.parseInt(pass0.getText()) == 123456789) {

                        window1.close();



                        GridPane grid = new GridPane();
                        grid.setPadding(new Insets(10, 10, 10, 10));
                        grid.setVgap(8);
                        grid.setHgap(10);

                        //value input

                        TextField pass = new TextField("atm pin ");
                        GridPane.setConstraints(pass, 1, 0);

                        Button submit = new Button("submit");
                        GridPane.setConstraints(submit, 1, 2);


                        grid.getChildren().addAll(pass, submit);
                        scene1 = new Scene(grid, 600, 600);
                        window1.setScene(scene1);

                        //scene2 = new Scene(grid,100,500);
                        window1.show();

                        submit.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                if (Integer.parseInt(pass.getText()) == 9999) {

                                    window1.close();


                                    VBox layout1 = new VBox(20);
                                    final ToggleGroup group = new ToggleGroup();

                                    RadioButton rb1 = new RadioButton("balance");
                                    RadioButton rb2 = new RadioButton("deposit");
                                    RadioButton rb3 = new RadioButton("withdrawal");

                                    rb1.setToggleGroup(group);
                                    rb1.setSelected(true);
                                    rb2.setToggleGroup(group);
                                    rb2.setSelected(true);
                                    rb3.setToggleGroup(group);
                                    rb3.setSelected(true);
                                    Button submitr = new Button("submit");
                                    layout1.getChildren().addAll(rb1, rb2, rb3, submitr);
                                    scene2 = new Scene(layout1, 600, 600);
                                    window1.setScene(scene2);
                                    window1.show();


                                    submitr.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            if (rb1.isSelected()) {
                                                System.out.println("balance");
                                                window1.close();


                                                balance(window1);

                                            }

                                            if (rb2.isSelected()) {


                                                System.out.println("deposit");
                                                window1.close();
                                                deposit_withdraw(window1, 0);

                                            }

                                            if (rb3.isSelected()) {


                                                System.out.println("withdrawal");
                                                window1.close();

                                                deposit_withdraw(window1, 1);


                                            }

                                        }


                                    });
                                } else {
                                    count++;
                                    if (count == 3) {


                                        window1.close();
                                        VBox layoutb = new VBox(20);
                                        Label l = new Label("Invlid ATM card it will be retained");
                                        scene2 = new Scene(layoutb, 600, 600);
                                        layoutb.getChildren().addAll(l);
                                        window1.setScene(scene2);
                                        window1.show();


                                    }


                                }
                            }
                        });


                    } else {



                        window1.close();
                        VBox layoutb = new VBox(20);
                        Label l = new Label("Unable to read the card");
                        scene2 = new Scene(layoutb, 600, 600);
                        layoutb.getChildren().addAll(l);
                        window1.setScene(scene2);
                        window1.show();


                    }
                }
            });

    }


    public void unable(Stage window1)
    {


        VBox layoutb = new VBox(20);
        Label l= new Label("insufficient balance");
        scene2 = new Scene(layoutb, 600, 600);
        layoutb.getChildren().addAll(l);
        window1.setScene(scene2);
        window1.show();


    }



    public void fail(Stage window1)
    {

        VBox layoutb = new VBox(20);
        Label l= new Label("Temporarily unable to process please try again later");
        scene2 = new Scene(layoutb, 600, 600);
        layoutb.getChildren().addAll(l);
        window1.setScene(scene2);
        window1.show();


    }


    public void insert(Stage window1)
    {
        window1.close();

        VBox layoutb = new VBox(20);
        Label l= new Label("Please insert your card again");
        scene2 = new Scene(layoutb, 600, 600);
        layoutb.getChildren().addAll(l);
        window1.setScene(scene2);
        window1.show();


    }


    public void balance(Stage window1)
    {

        //Date date = new Date();
        //String s = date.toString();

        VBox layoutb = new VBox(20);
        Label l= new Label("Savings is " +savings+ " \n"+ "Credit is "+ credit + "\n Current is" + current);
        Label x = new Label("Another transaction ?");
        final ToggleGroup group = new ToggleGroup();

        RadioButton r1 = new RadioButton("YES");
        RadioButton r2 = new RadioButton("NO");


        r1.setToggleGroup(group);
        r1.setSelected(false);
        r2.setToggleGroup(group);
        r2.setSelected(false);

        Button submitr = new Button("submit");


       // Label m = new Label(s);
        scene2 = new Scene(layoutb, 600, 600);
        layoutb.getChildren().addAll(l,x,r1,r2,submitr);
        window1.setScene(scene2);
        window1.show();

        submitr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                if (r1.isSelected()) {

                 insert(window1);



                }

        if(r2.isSelected())
        {
            window1.close();


        }

    } } );}


    public void credit(Stage window1,int val)
    {
        GridPane grid0 = new GridPane();
        grid0.setPadding(new Insets(10, 10, 10, 10));
        grid0.setVgap(8);
        grid0.setHgap(10);

        //value input

        TextField text = new TextField("enter amount  ");
        GridPane.setConstraints(text, 1, 0);

        Button submit0 = new Button("submit");
        GridPane.setConstraints(submit0, 1, 2);


        grid0.getChildren().addAll(text, submit0);
        scene0 = new Scene(grid0, 600, 600);
        window1.setScene(scene0);

        //scene2 = new Scene(grid,100,500);
        window1.show();

        submit0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window1.close();
                if(val ==0) {
                    savings = savings + Integer.parseInt(text.getText());

                    balance(window1);
                }
                else if(val ==1)
                {
                    savings =savings - Integer.parseInt(text.getText());
                    if(savings>0) {
                        balance(window1);
                    }
                    else
                        unable(window1);


                }

            }


        });


    }

    public void current(Stage window1,int val)
    {
        GridPane grid0 = new GridPane();
        grid0.setPadding(new Insets(10, 10, 10, 10));
        grid0.setVgap(8);
        grid0.setHgap(10);

        //value input

        TextField text = new TextField("enter amount  ");
        GridPane.setConstraints(text, 1, 0);

        Button submit0 = new Button("submit");
        GridPane.setConstraints(submit0, 1, 2);


        grid0.getChildren().addAll(text, submit0);
        scene0 = new Scene(grid0, 600, 600);
        window1.setScene(scene0);

        //scene2 = new Scene(grid,100,500);
        window1.show();

        submit0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window1.close();

                if(val ==0) {
                    savings = savings + Integer.parseInt(text.getText());

                    balance(window1);
                }
                else if(val ==1)
                {
                    savings =savings - Integer.parseInt(text.getText());
                    if(savings>0) {
                        balance(window1);
                    }
                    else
                        unable(window1);


                }



            }


        });


    }

     public void savings(Stage window1,int val)
    {
        GridPane grid0 = new GridPane();
        grid0.setPadding(new Insets(10, 10, 10, 10));
        grid0.setVgap(8);
        grid0.setHgap(10);

        //value input

        TextField text = new TextField("enter amount ");
        GridPane.setConstraints(text, 1, 0);

        Button submit0 = new Button("submit");
        GridPane.setConstraints(submit0, 1, 2);


        Label text1 = new Label("Note : withdrawal amount must be in multiple of 10 ");
        GridPane.setConstraints(text, 0, 2);


        grid0.getChildren().addAll(text, submit0,text1);
        scene0 = new Scene(grid0, 600, 600);
        window1.setScene(scene0);

        //scene2 = new Scene(grid,100,500);
        window1.show();

        submit0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window1.close();
                if(val ==0) {
                    savings = savings + Integer.parseInt(text.getText());

                    balance(window1);
                }
                else if(val ==1)
                {
                    savings =savings - Integer.parseInt(text.getText());
                    if(savings>0) {
                        balance(window1);
                    }
                    else
                        unable(window1);


                }

            }


        });




    }


    public void deposit_withdraw(Stage window1, int val)
    {

        window1.close();



        double x =Math.random();
        long aa=Math.round(x);

        if(aa%5==0)
        {



            fail(window1);

        }





        VBox layout1 = new VBox(20);
        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("savings");
        RadioButton rb2 = new RadioButton("current");
        RadioButton rb3 = new RadioButton("credit");

        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb2.setToggleGroup(group);
        rb2.setSelected(true);
        rb3.setToggleGroup(group);
        rb3.setSelected(true);
        Button submitr = new Button("submit");
        layout1.getChildren().addAll(rb1, rb2, rb3, submitr);
        scene2 = new Scene(layout1, 600, 600);
        window1.setScene(scene2);
        window1.show();


        submitr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (rb1.isSelected()) {
                    System.out.println("savings");
                    window1.close();
                    savings(window1,val);

                }

                if (rb2.isSelected()) {
                    System.out.println("current");
                    window1.close();
                    current(window1,val);

                }

                if (rb3.isSelected()) {
                    System.out.println("credit");
                    window1.close();
                    credit(window1,val);
                }

            }


        });
    }






    public static void main(String[] args)
    {
        launch(args);
    }


}
