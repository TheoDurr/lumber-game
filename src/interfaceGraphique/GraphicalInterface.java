package interfaceGraphique;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import initialisation.Initialisation;


public class GraphicalInterface extends JFrame implements Runnable{


    public Initialisation init;

    public GraphicalInterface(Initialisation init){
        this.init = init;
        createInterface();
    }

    JTextArea amountMoney;

    ArrayList<JTextArea> lumberJackEmployeeOverlay;
    ArrayList<JTextArea> planterEmployeeOverlay;
    ArrayList<JTextArea> driverEmployeeOverlay;

    ArrayList<JTextArea> marketEmployeeOverlay;

    ArrayList<JTextArea> truckVehicleOverlay ;
    ArrayList<JTextArea> forkliftVehicleOverlay;

    ArrayList<JTextArea> machineOverlay;

    ArrayList<JTextArea> earthStockOverlay;
    ArrayList<JTextArea> bfMachineStockOverlay;
    ArrayList<JTextArea> aftMachineStockOverlay;
    ArrayList<JTextArea> commandStockOverlay;


    JButton buyLumberJack;
    JButton buyPlanter;
    JButton buyDriver;


    JButton upgradeLumberJack;
    JButton upgradePlanter;
    JButton upgradeDriver;
    JButton upgradeMarket;

    JButton upgradeTruck;
    JButton upgradeForklift;

    JButton buyMachine;

    JButton upgradeMachine;

    JButton upgradeEarthStock;
    JButton upgradeBfMachineStock;
    JButton upgradeAftMachineStock;
    JButton upgradeCommandStock;


    public void createInterface() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#DDD168"));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);


        ImageIcon bigRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/BigRectangle.png"),0.75f);
        ImageIcon midRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/MidRectangle.png"),0.75f);
        ImageIcon littleRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/LittleRectangle.png"),0.75f);
        ImageIcon ScdLittleRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/ScdLittleRectangle.png"),0.75f);

        ImageIcon lumberJackIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/axe.png"),0.15f);
        ImageIcon planterIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/planter.png"),0.15f);
        ImageIcon driverIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/driver.png"),0.15f);
        ImageIcon marketIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/manager.png"),0.15f);

        ImageIcon employeeIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/employee.png"),0.80f);

        ImageIcon vehicleIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/vehicle.png"),0.60f);
        ImageIcon truckIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/vehicle.png"),0.60f);
        ImageIcon forkliftIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/elevator.png"),0.60f);

        ImageIcon addIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/plus.png"),0.60f);
        ImageIcon goldIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/money.png"),0.70f);
        ImageIcon upgradeIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/upgrade.png"),0.60f);



        //Player Part
        closeButton();
        amountMoney = newText(": " + company.Company.getCashFlow(),100 + company.Company.getName().length()*30,14,28);
        newImage(goldIcon,60 + company.Company.getName().length()*30,15);

        newText(company.Company.getName(),30,5,35);






        //Employee Part
        lumberJackEmployeeOverlay = newEmployeeOverlay(90,195);
        planterEmployeeOverlay = newEmployeeOverlay(90,345);
        driverEmployeeOverlay = newEmployeeOverlay(90,495);
        marketEmployeeOverlay = newEmployeeOverlay(90,645);

        buyLumberJack = newAddButton(50,250);
        buyLumberJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.wcc.buy();
            }
        });
        buyPlanter = newAddButton(50,400);
        buyPlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.planters.buy();

            }
        });
        buyDriver = newAddButton(50,550);
        buyDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.truckDrivers.buy();
            }
        });

        upgradeLumberJack = newUpgradeButton(195,250);
        upgradeLumberJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.wcc.upgrade();
            }
        });
        upgradePlanter = newUpgradeButton(195,400);
        upgradePlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.planters.upgrade();
            }
        });
        upgradeDriver = newUpgradeButton(195,550);
        upgradeDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.truckDrivers.upgrade();
            }
        });
        upgradeMarket = newUpgradeButton(195,700);
        upgradeMarket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.marketingManager.upgrade();
            }
        });

        newText("Employee",130,85,30);
        newText("Lumberjack",140,155,20);
        newText("Planter",160,305,20);
        newText("Driver",165,455,20);
        newText("Marketing manager",115,605,20);

        newImage(employeeIcon,95,85);
        newImage(lumberJackIcon,100,155);
        newImage(planterIcon,125,305);
        newImage(driverIcon,130,455);
        newImage(marketIcon,80,605);

        newImage(littleRectangle,45,150);
        newImage(littleRectangle,45,300);
        newImage(littleRectangle,45,450);
        newImage(littleRectangle,45,600);

        newImage(bigRectangle,30,70);






        //Vehicle Part
        upgradeTruck = newUpgradeButton(565,250);
        upgradeTruck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.trucks.buy();
            }
        });
        upgradeForklift = newUpgradeButton(565,400);
        upgradeForklift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.forklifts.upgrade();
            }
        });

        truckVehicleOverlay = newMachineVehicleOverlay(460,195);
        forkliftVehicleOverlay = newMachineVehicleOverlay(460,345);

        newText("Vehicle",525,80,30);
        newText("Truck",520,155,20);
        newText("Forklift",515,305,20);

        newImage(littleRectangle,415,150);
        newImage(littleRectangle,415,300);

        newImage(midRectangle,400,70);




        //Machine Part
        newText("Machine",895,80,30);
        newText("Machine",895,155,20);

        machineOverlay =newMachineVehicleOverlay(830,195);

        buyMachine = newAddButton(790,250);
        buyMachine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.machines.buy();
            }
        });
        upgradeMachine = newUpgradeButton(935,250);
        upgradeMachine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.machines.upgrade();
            }
        });

        newImage(littleRectangle,785,150);

        newImage(ScdLittleRectangle,770,70);



        //Stock Part
        newText("Stock",1250,85,30);
        newText("Earth Stock",1245,155,20);
        newText("Stock before Machine",1210,305,20);
        newText("Stock after Machine",1213,455,20);
        newText("Command Stock",1235,605,20);

        earthStockOverlay =  newStockOverlay(1270,195);
        bfMachineStockOverlay = newStockOverlay(1270,345);
        aftMachineStockOverlay = newStockOverlay(1270,495);
        commandStockOverlay = newStockOverlay(1270,650);


        upgradeEarthStock = newUpgradeButton(1305,250);
        upgradeEarthStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.landStocks.upgrade();
            }
        });
        upgradeBfMachineStock = newUpgradeButton(1305,400);
        upgradeBfMachineStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.inputMachineStocks.upgrade();
            }
        });
        upgradeAftMachineStock = newUpgradeButton(1305,550);
        upgradeAftMachineStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.outputMachineStocks.upgrade();
            }
        });
        upgradeCommandStock = newUpgradeButton(1305,700);
        upgradeCommandStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.commandStocks.upgrade();
            }
        });


        newImage(littleRectangle,1155,150);
        newImage(littleRectangle,1155,300);
        newImage(littleRectangle,1155,450);
        newImage(littleRectangle,1155,600);

        newImage(bigRectangle,1140,70);



        this.pack();
        this.setSize(1920,1080);

        this.startDisplay();
        this.setVisible(true);

    }

    public ImageIcon resize(ImageIcon imageIcon,float ratio){   //function to resize ImageIcon

        Image image = imageIcon.getImage();
        Image result = image.getScaledInstance((int)((float)imageIcon.getIconWidth()*ratio), (int)((float)imageIcon.getIconHeight()*ratio),  Image.SCALE_SMOOTH);
        ImageIcon finalResult = new ImageIcon(result);
        return finalResult;
    }


    public JLabel newImage(ImageIcon image,int x,int y){
        JLabel picLabel = new JLabel();
        picLabel.setIcon(image);
        picLabel.setLocation(x, y);
        picLabel.setSize(image.getIconWidth(), image.getIconHeight());
        this.add(picLabel);
        return picLabel;
    }


    public JTextArea newText(String text,int x,int y,int size){
        JTextArea textArea = new JTextArea();
        textArea.setText(text);
        textArea.setEditable(false);
        textArea.setBounds(x,y, 10*size*text.length(), size*2);
        textArea.setFont(new Font("Inter",Font.ITALIC, size));
        textArea.setOpaque(false);
        this.add(textArea);
        return textArea;
    }



    public JButton newAddButton(int x,int y){
        JButton button = new JButton("Buy");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(y);
            }
        });
        button.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/plus.png"),0.70f));
        //button.setRolloverIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/money.png"),0.70f));
        button.setBounds(x, y, 140, 30);
        button.setBackground(Color.decode("#E8DF96"));
        button.setFocusable(false);
        this.add(button);
        return button;
    }


    public JButton newUpgradeButton(int x,int y){
        JButton button = new JButton("Upgrade");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/upgrade.png"),0.70f));
        button.setBounds(x, y, 140, 30);
        button.setBackground(Color.decode("#E8DF96"));
        button.setFocusable(false);

        this.add(button);
        return button;
    }

    public void closeButton(){
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        button.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/closeButton.png"),0.04818f));
        button.setBounds(1480, 15, 37, 37);
        button.setBackground(Color.decode("#E8DF96"));
        button.setFocusable(false);

        this.add(button);
    }



    public ArrayList<JTextArea> newEmployeeOverlay(int x, int y){
        ArrayList<JTextArea> resultList = new ArrayList<JTextArea>();
        JTextArea number = newText("Number: ",x,y,15);
        JTextArea level = newText("Level: ",x+140,y,15);
        JTextArea salary = newText("Salary: ",x,y+25,15);

        resultList.add(number);
        resultList.add(level);
        resultList.add(salary);

        return resultList;
    }


    public ArrayList<JTextArea> newMachineVehicleOverlay(int x, int y){
        ArrayList<JTextArea> resultList = new ArrayList<JTextArea>();
        JTextArea number = newText("Number: ",x,y,15);
        JTextArea level = newText("Level: ",x+140,y,15);

        resultList.add(number);
        resultList.add(level);

        return resultList;
    }

    public ArrayList<JTextArea> newStockOverlay(int x, int y){
        ArrayList<JTextArea> resultList = new ArrayList<JTextArea>();
        JTextArea number = newText("23 / 230 ",x,y,18);

        resultList.add(number);

        return resultList;
    }



    public JTextArea partOverlay(int index,ArrayList<JTextArea> listOverlay){    // index: 0 = number
        return listOverlay.get(index);                                           //        1 = level
                                                                                 //        2 = salary
    }


    @Override
    public void run() {
        while (true){

            amountMoney.setText(": " + company.Company.getCashFlow());

            // ---  Employee  ---  ______________________________________________________________________!!!!!!!!!!!!!!
            partOverlay(0,lumberJackEmployeeOverlay).setText("Number : " + init.wcc.getNumber());
            partOverlay(1,lumberJackEmployeeOverlay).setText("Level : " + init.wcc.getLevel());
            partOverlay(2,lumberJackEmployeeOverlay).setText("Salary : " + init.wcc.getSalary() + " / month");

            partOverlay(0,driverEmployeeOverlay).setText("Number : " + init.truckDrivers.getNumber() + init.forkliftDrivers.getNumber());
            partOverlay(1,driverEmployeeOverlay).setText("Level : " + "A voir !!!");
            partOverlay(2,driverEmployeeOverlay).setText("Salary : " + init.truckDrivers.getSalary() + " / month");

            partOverlay(0,planterEmployeeOverlay).setText("Number :" + init.planters.getNumber());
            partOverlay(1,planterEmployeeOverlay).setText("Level : " + init.planters.getLevel());
            partOverlay(2,planterEmployeeOverlay).setText("Salary : " + init.planters.getSalary()+ " / month");

            partOverlay(0,marketEmployeeOverlay).setText("Number : 1" );
            partOverlay(1,marketEmployeeOverlay).setText("Level : " + init.marketingManager.getLevel());
            partOverlay(2,marketEmployeeOverlay).setText("Salary : " + init.marketingManager.getSalary() + " / month");

            buyLumberJack.setText("100 G");
            buyPlanter.setText("100 G");
            buyDriver.setText("100 G");

            upgradeLumberJack.setText(init.wcc.estimatePrice() + " G");
            upgradePlanter.setText(init.planters.estimatePrice() + " G");
            upgradeDriver.setText(init.truckDrivers.estimatePrice() + " G");
            upgradeMarket.setText(init.marketingManager.estimatePrice() + " G");


            // ---  Vehicle  ---
            partOverlay(0,truckVehicleOverlay).setText("Number : " + init.trucks.getNumber());
            partOverlay(1,truckVehicleOverlay).setText("Level : " + init.trucks.getLevel());

            partOverlay(0,forkliftVehicleOverlay).setText("Number :" + init.forklifts.getNumber());
            partOverlay(1,forkliftVehicleOverlay).setText("Level :" + init.trucks.getLevel());

            upgradeTruck.setText(init.trucks.estimatePrice() + " G");
            upgradeForklift.setText(init.forklifts.estimatePrice() + " G");



            // --- Machine ---
            partOverlay(0,machineOverlay).setText("Number :" + init.machines.getNumber());
            partOverlay(1,machineOverlay).setText("Level :" + init.machines.getLevel());

            buyMachine.setText( "100 G");
            upgradeMachine.setText(init.machines.estimatePrice() + " G");




            //Stock   ______________________________________________________________________!!!!!!!!!!!!!!
            partOverlay(0,earthStockOverlay).setText( " A voir  !!!!! / ");

            partOverlay(0,bfMachineStockOverlay).setText("34 / 435");

            partOverlay(0,aftMachineStockOverlay).setText( "34 / 435");

            partOverlay(0,commandStockOverlay).setText("34 / 435");


            upgradeEarthStock.setText(init.landStocks.estimatePrice() + " G");
            upgradeBfMachineStock.setText(init.inputMachineStocks.estimatePrice() + " G");
            upgradeAftMachineStock.setText(init.outputMachineStocks.estimatePrice() + " G");
            upgradeCommandStock.setText(init.commandStocks.estimatePrice() + " G");


        }

    }


    public void startDisplay(){
        Thread t = new Thread(this);
        //this will call the method run
        t.start();
    }
}
