package interfaceGraphique;


import demand.Demand;
import demand.DemandState;
import demand.MobileApp;
import initialisation.Initialisation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class GraphicalInterface extends JFrame implements Runnable {

    public Initialisation init;

    public GraphicalInterface(Initialisation init) {
        this.init = init;
        createInterface();
    }


    JTextArea amountMoney;

    ArrayList<JTextArea> lumberJackEmployeeOverlay;
    ArrayList<JTextArea> planterEmployeeOverlay;
    ArrayList<JTextArea> driverEmployeeOverlay;

    ArrayList<JTextArea> marketEmployeeOverlay;

    ArrayList<JTextArea> truckVehicleOverlay;
    ArrayList<JTextArea> forkliftVehicleOverlay;

    ArrayList<JTextArea> machineOverlay;

    ArrayList<JTextArea> earthStockOverlay;
    ArrayList<JTextArea> bfMachineStockOverlay;
    ArrayList<JTextArea> aftMachineStockOverlay;
    ArrayList<JTextArea> commandStockOverlay;


    JButton buyLumberJack;
    JButton buyPlanter;


    JButton upgradeLumberJack;
    JButton upgradePlanter;
    JButton upgradeDriver;
    JButton upgradeMarket;

    JButton upgradeTruck;
    JButton upgradeForklift;
    JButton buyTruck;
    JButton buyFoklift;

    JButton buyMachine;

    JButton upgradeMachine;

    JButton upgradeEarthStock;
    JButton upgradeBfMachineStock;
    JButton upgradeAftMachineStock;
    JButton upgradeCommandStock;


    JDialog commandWindow;

    JButton seeTerminal;
    JButton hideTerminal;

    JScrollPane paneDemand;

    JLabel scrollView;


    public void createInterface() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#DDD168"));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        createTerminal();
        updateTerminal(MobileApp.getInstance().getDemandList());


        ImageIcon bigRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/BigRectangle.png"), 0.75f);
        ImageIcon midRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/MidRectangle.png"), 0.75f);
        ImageIcon littleRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/LittleRectangle.png"), 0.75f);
        ImageIcon ScdLittleRectangle = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/ScdLittleRectangle.png"), 0.75f);

        ImageIcon lumberJackIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/axe.png"), 0.15f);
        ImageIcon planterIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/planter.png"), 0.15f);
        ImageIcon driverIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/driver.png"), 0.15f);
        ImageIcon marketIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/manager.png"), 0.15f);

        ImageIcon employeeIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/employee.png"), 0.80f);

        ImageIcon vehicleIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/vehicle.png"), 0.60f);
        ImageIcon truckIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/vehicle.png"), 0.60f);
        ImageIcon forkliftIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/elevator.png"), 0.60f);

        ImageIcon addIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/plus.png"), 0.60f);
        ImageIcon goldIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/money.png"), 0.70f);
        ImageIcon upgradeIcon = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/upgrade.png"), 0.60f);

        ImageIcon terminalUnShow = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/terminalUnShow.png"), 0.10f);
        ImageIcon terminalShow = resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/terminalShow.png"), 0.10f);

        Thread threadAffiche = new Thread(this);


        //Player Part
        closeButton();

        newImage(goldIcon, 60 + company.Company.getName().length() * 30, 15);


        seeTerminal = new JButton();

        seeTerminal.setIcon(terminalUnShow);
        seeTerminal.setBounds(1280, 15, 40, 50);
        seeTerminal.setBackground(Color.decode("#E8DF96"));
        seeTerminal.setFocusable(false);
        seeTerminal.setRolloverIcon(terminalShow);

        this.add(seeTerminal);


        hideTerminal = new JButton();

        seeTerminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTerminal();
                hideTerminal.setVisible(true);
                seeTerminal.setVisible(false);

            }
        });

        hideTerminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unShowTerminal();
                seeTerminal.setVisible(true);
                hideTerminal.setVisible(false);

            }
        });
        hideTerminal.setIcon(terminalShow);
        hideTerminal.setBounds(1280, 15, 40, 50);
        hideTerminal.setBackground(Color.decode("#E8DF96"));
        hideTerminal.setFocusable(false);
        hideTerminal.setRolloverIcon(terminalUnShow);
        hideTerminal.setVisible(false);
        this.add(hideTerminal);


        amountMoney = newText(": " + company.Company.getCashFlow(), 100 + company.Company.getName().length() * 30, 14, 28);
        newText(company.Company.getName(), 30, 5, 35);

        newText("Access to command : ", 950, 20, 30);


        //Employee Part
        lumberJackEmployeeOverlay = newEmployeeOverlay(90, 195);
        planterEmployeeOverlay = newEmployeeOverlay(90, 345);
        driverEmployeeOverlay = newEmployeeOverlay(90, 495);
        marketEmployeeOverlay = newEmployeeOverlay(90, 645);

        buyLumberJack = newAddButton(50, 250);
        buyLumberJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.wcc.buy();
            }
        });
        buyPlanter = newAddButton(50, 400);
        buyPlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.planters.buy();

            }
        });


        upgradeLumberJack = newUpgradeButton(195, 250);
        upgradeLumberJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.wcc.upgrade();
            }
        });
        upgradePlanter = newUpgradeButton(195, 400);
        upgradePlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.planters.upgrade();
            }
        });
        upgradeDriver = newUpgradeButton(195, 550);
        upgradeDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.truckDrivers.upgrade();
                init.forkliftDrivers.upgrade();
            }
        });
        upgradeMarket = newUpgradeButton(195, 700);
        upgradeMarket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.marketingManager.upgrade();
            }
        });

        newText("Employee", 130, 85, 30);
        newText("Lumberjack", 140, 155, 20);
        newText("Planter", 160, 305, 20);
        newText("Driver", 165, 455, 20);
        newText("Marketing manager", 115, 605, 20);

        newImage(employeeIcon, 95, 85);
        newImage(lumberJackIcon, 100, 155);
        newImage(planterIcon, 125, 305);
        newImage(driverIcon, 130, 455);
        newImage(marketIcon, 80, 605);

        newImage(littleRectangle, 45, 150);
        newImage(littleRectangle, 45, 300);
        newImage(littleRectangle, 45, 450);
        newImage(littleRectangle, 45, 600);

        newImage(bigRectangle, 30, 70);


        //Vehicle Part

        buyTruck = newAddButton(420, 250);
        buyTruck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.truckDrivers.buy();
            }
        });

        upgradeTruck = newUpgradeButton(565, 250);
        upgradeTruck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.trucks.buy();
            }
        });

        buyFoklift = newAddButton(420, 400);
        buyFoklift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.truckDrivers.buy();
            }
        });
        upgradeForklift = newUpgradeButton(565, 400);
        upgradeForklift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.forklifts.upgrade();
            }
        });

        truckVehicleOverlay = newMachineVehicleOverlay(460, 195);
        forkliftVehicleOverlay = newMachineVehicleOverlay(460, 345);

        newText("Vehicle", 525, 80, 30);
        newText("Truck", 520, 155, 20);
        newText("Forklift", 515, 305, 20);

        newImage(littleRectangle, 415, 150);
        newImage(littleRectangle, 415, 300);

        newImage(midRectangle, 400, 70);


        //Machine Part
        newText("Machine", 895, 80, 30);
        newText("Machine", 895, 155, 20);

        machineOverlay = newMachineVehicleOverlay(830, 195);

        buyMachine = newAddButton(790, 250);
        buyMachine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.machines.buy(init.inputMachineStocks, init.outputMachineStocks);
            }
        });
        upgradeMachine = newUpgradeButton(935, 250);
        upgradeMachine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.machines.upgrade();
            }
        });

        newImage(littleRectangle, 785, 150);

        newImage(ScdLittleRectangle, 770, 70);


        //Stock Part
        newText("Stock", 1250, 85, 30);
        newText("Forest Stock", 1245, 155, 20);
        newText("Input Stock Machine", 1210, 305, 20);
        newText("Output Stock Machine", 1213, 455, 20);
        newText("Command Stock", 1235, 605, 20);

        earthStockOverlay = newStockOverlay(1270, 195);
        bfMachineStockOverlay = newStockOverlay(1270, 345);
        aftMachineStockOverlay = newStockOverlay(1270, 495);
        commandStockOverlay = newStockOverlay(1270, 650);


        upgradeEarthStock = newUpgradeButton(1305, 250);
        upgradeEarthStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.landStocks.upgrade();
            }
        });
        upgradeBfMachineStock = newUpgradeButton(1305, 400);
        upgradeBfMachineStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.inputMachineStocks.upgrade();
            }
        });
        upgradeAftMachineStock = newUpgradeButton(1305, 550);
        upgradeAftMachineStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.outputMachineStocks.upgrade();
            }
        });
        upgradeCommandStock = newUpgradeButton(1305, 700);
        upgradeCommandStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.commandStocks.upgrade();
            }
        });


        newImage(littleRectangle, 1155, 150);
        newImage(littleRectangle, 1155, 300);
        newImage(littleRectangle, 1155, 450);
        newImage(littleRectangle, 1155, 600);

        newImage(bigRectangle, 1140, 70);


        this.pack();
        this.setSize(1920, 1080);

        this.startDisplay();
        this.setVisible(true);

    }

    public ImageIcon resize(ImageIcon imageIcon, float ratio) {   //function to resize ImageIcon

        Image image = imageIcon.getImage();
        Image result = image.getScaledInstance((int) ((float) imageIcon.getIconWidth() * ratio), (int) ((float) imageIcon.getIconHeight() * ratio), Image.SCALE_SMOOTH);
        ImageIcon finalResult = new ImageIcon(result);
        return finalResult;
    }


    public JLabel newImage(ImageIcon image, int x, int y) {
        JLabel picLabel = new JLabel();
        picLabel.setIcon(image);
        picLabel.setLocation(x, y);
        picLabel.setSize(image.getIconWidth(), image.getIconHeight());
        this.add(picLabel);
        return picLabel;
    }

    public JLabel newImage(ImageIcon image, int x, int y, JLabel target) {
        JLabel picLabel = new JLabel();
        picLabel.setIcon(image);
        picLabel.setLocation(x, y);
        picLabel.setSize(image.getIconWidth(), image.getIconHeight());
        target.add(picLabel);
        return picLabel;
    }


    public JTextArea newText(String text, int x, int y, int size) {
        JTextArea textArea = new JTextArea();
        textArea.setText(text);
        textArea.setEditable(false);
        textArea.setBounds(x, y, 10 * size * text.length(), size * 2);
        textArea.setFont(new Font("Inter", Font.ITALIC, size));
        textArea.setOpaque(false);
        this.add(textArea);
        return textArea;
    }

    public JTextArea newText(String text, int x, int y, int size, JLabel target) {
        JTextArea textArea = new JTextArea();
        textArea.setText(text);
        textArea.setEditable(false);
        textArea.setBounds(x, y, 10 * size * text.length(), size * 2);
        textArea.setFont(new Font("Inter", Font.ITALIC, size));
        textArea.setOpaque(false);
        target.add(textArea);
        return textArea;
    }


    public JButton newAddButton(int x, int y) {
        JButton button = new JButton("Buy");
        button.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/plus.png"), 0.70f));
        button.setBounds(x, y, 140, 30);
        button.setBackground(Color.decode("#E8DF96"));
        button.setFocusable(false);
        this.add(button);
        return button;
    }


    public JButton newUpgradeButton(int x, int y) {
        JButton button = new JButton("Upgrade");
        button.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/upgrade.png"), 0.70f));
        button.setBounds(x, y, 140, 30);
        button.setBackground(Color.decode("#E8DF96"));
        button.setFocusable(false);

        this.add(button);
        return button;
    }

    public void closeButton() {
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        button.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/closeButton.png"), 0.04818f));
        button.setBounds(1480, 15, 37, 37);
        button.setBackground(Color.decode("#E8DF96"));
        button.setFocusable(false);

        this.add(button);
    }


    public ArrayList<JTextArea> newEmployeeOverlay(int x, int y) {
        ArrayList<JTextArea> resultList = new ArrayList<JTextArea>();
        JTextArea number = newText("Number: ", x, y, 15);
        JTextArea level = newText("Level: ", x + 140, y, 15);
        JTextArea salary = newText("Salary: ", x, y + 25, 15);

        resultList.add(number);
        resultList.add(level);
        resultList.add(salary);

        return resultList;
    }


    public ArrayList<JTextArea> newMachineVehicleOverlay(int x, int y) {
        ArrayList<JTextArea> resultList = new ArrayList<JTextArea>();
        JTextArea number = newText("Number: ", x, y, 15);
        JTextArea level = newText("Level: ", x + 140, y, 15);

        resultList.add(number);
        resultList.add(level);

        return resultList;
    }

    public ArrayList<JTextArea> newStockOverlay(int x, int y) {
        ArrayList<JTextArea> resultList = new ArrayList<JTextArea>();
        JTextArea number = newText("23 / 230 ", x, y, 18);

        resultList.add(number);

        return resultList;
    }


    public JTextArea partOverlay(int index, ArrayList<JTextArea> listOverlay) {    // index: 0 = number
        return listOverlay.get(index);                                           //        1 = level
        //        2 = salary
    }

    public void newDemand(Demand demand, int x, int y, JLabel fenDemand) {
        String customer = demand.getCustomer().getName();
        float price = demand.getPrice();
        int quantity = demand.getQuantity();


        if (demand.getState() != DemandState.ACCEPTED) {
            JButton validButton = new JButton();
            JButton denyButton = new JButton();


            validButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            demand.setState(DemandState.ACCEPTED);
                            validButton.setVisible(false);
                            denyButton.setVisible(false);

                        }
                    }
            );


            validButton.setBounds(x + 190, y + 90, 37, 37);
            validButton.setBackground(Color.decode("#E8DF96"));
            validButton.setFocusable(false);

            fenDemand.add(validButton);
            validButton.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/validIcon.png"), 0.226f));


            denyButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            demand.setState(DemandState.DECLINED);
                            updateTerminal(MobileApp.getInstance().getDemandList());
                        }
                    }
            );
            denyButton.setBounds(x + 245, y + 90, 37, 37);
            denyButton.setBackground(Color.decode("#E8DF96"));
            denyButton.setFocusable(false);

            fenDemand.add(denyButton);
            denyButton.setIcon(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/denyIcon.png"), 0.226f));
        } else {

            JButton validButton = new JButton();

            validButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                        }
                    }
            );


            validButton.setBounds(x + 245, y + 90, 42, 37);
            validButton.setBackground(Color.decode("#E8DF96"));
            validButton.setFocusable(false);

            fenDemand.add(validButton);
            validButton.setText("OK");


        }
        newText(customer, x + 30, y + 20, 16, fenDemand);
        newText("Price : " + price, x + 30, y + 60, 16, fenDemand);
        newText("Quantity : " + quantity, x + 30, y + 100, 16, fenDemand);

        newImage(resize(new ImageIcon("src/interfaceGraphique/IconHolzmann/LittleRectangle.png"), 0.75f), x, y, fenDemand);

    }


    @Override
    public void run() {
        while (true) {

            amountMoney.setText(": " + company.Company.getCashFlow());

            // ---  Employee  ---  ______________________________________________________________________!!!!!!!!!!!!!!
            partOverlay(0, lumberJackEmployeeOverlay).setText("Number : " + init.wcc.getNumber());
            partOverlay(1, lumberJackEmployeeOverlay).setText("Level : " + init.wcc.getLevel());
            partOverlay(2, lumberJackEmployeeOverlay).setText("Salary : " + init.wcc.getSalary() + " / month");

            partOverlay(0, driverEmployeeOverlay).setText("Number : " + init.truckDrivers.getNumber() + init.forkliftDrivers.getNumber());
            partOverlay(1, driverEmployeeOverlay).setText("Level : " +  init.truckDrivers.getLevel());
            partOverlay(2, driverEmployeeOverlay).setText("Salary : " + init.truckDrivers.getSalary() + " / month");

            partOverlay(0, planterEmployeeOverlay).setText("Number :" + init.planters.getNumber());
            partOverlay(1, planterEmployeeOverlay).setText("Level : " + init.planters.getLevel());
            partOverlay(2, planterEmployeeOverlay).setText("Salary : " + init.planters.getSalary() + " / month");

            partOverlay(0, marketEmployeeOverlay).setText("Number : 1");
            partOverlay(1, marketEmployeeOverlay).setText("Level : " + init.marketingManager.getLevel());
            partOverlay(2, marketEmployeeOverlay).setText("Salary : " + init.marketingManager.getSalary() + " / month");

            buyLumberJack.setText("100 G");
            buyPlanter.setText("100 G");
            buyTruck.setText("100 G");
            buyFoklift.setText("100 G");

            upgradeLumberJack.setText(init.wcc.estimatePrice() + " G");
            upgradePlanter.setText(init.planters.estimatePrice() + " G");
            upgradeDriver.setText(init.truckDrivers.estimatePrice() + " G");
            upgradeMarket.setText(init.marketingManager.estimatePrice() + " G");


            // ---  Vehicle  ---
            partOverlay(0, truckVehicleOverlay).setText("Number : " + init.trucks.getNumber());
            partOverlay(1, truckVehicleOverlay).setText("Level : " + init.trucks.getLevel());

            partOverlay(0, forkliftVehicleOverlay).setText("Number :" + init.forklifts.getNumber());
            partOverlay(1, forkliftVehicleOverlay).setText("Level :" + init.trucks.getLevel());

            upgradeTruck.setText(init.trucks.estimatePrice() + " G");
            upgradeForklift.setText(init.forklifts.estimatePrice() + " G");


            // --- Machine ---
            partOverlay(0, machineOverlay).setText("Number :" + init.machines.getNumber());
            partOverlay(1, machineOverlay).setText("Level :" + init.machines.getLevel());

            buyMachine.setText("100 G");
            upgradeMachine.setText(init.machines.estimatePrice() + " G");


            //Stock
            partOverlay(0, earthStockOverlay).setText(init.landStocks.getCurrentCapacity() + " / " + init.landStocks.getMaxCapacity());

            partOverlay(0, bfMachineStockOverlay).setText(init.inputMachineStocks.getCurrentCapacity() + " / " + init.inputMachineStocks.getMaxCapacity());

            partOverlay(0, aftMachineStockOverlay).setText(init.outputMachineStocks.getCurrentCapacity() + " / " + init.outputMachineStocks.getMaxCapacity());

            partOverlay(0, commandStockOverlay).setText(init.commandStocks.getCurrentCapacity() + " / " + init.commandStocks.getMaxCapacity());


            upgradeEarthStock.setText(init.landStocks.estimatePrice() + " G");
            upgradeBfMachineStock.setText(init.inputMachineStocks.estimatePrice() + " G");
            upgradeAftMachineStock.setText(init.outputMachineStocks.estimatePrice() + " G");
            upgradeCommandStock.setText(init.commandStocks.estimatePrice() + " G");


            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                // ...
            }

        }

    }

    public void createTerminal() {


        commandWindow = new JDialog(new JFrame(), "Command Terminal");
        commandWindow.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                unShowTerminal();

                seeTerminal.setVisible(true);
                hideTerminal.setVisible(false);
            }
        });


        paneDemand = new JScrollPane();

        scrollView = new JLabel();

        scrollView.setPreferredSize(new Dimension(335, 500));
        scrollView.setLayout(null);
        paneDemand.setBackground(Color.BLACK);
        scrollView.setBackground(Color.BLACK);
        scrollView.setOpaque(true);


        paneDemand.setViewportView(scrollView);
        paneDemand.setSize(355, 500);

        paneDemand.setVisible(true);
        paneDemand.getVerticalScrollBar().setUnitIncrement(8);

        commandWindow.add(paneDemand);

        commandWindow.getContentPane().setBackground(Color.black);
        commandWindow.setAlwaysOnTop(true);
        commandWindow.getContentPane().setLayout(null);
        commandWindow.setSize(350, 500);
        commandWindow.setLocation(700, 20);
        commandWindow.setResizable(false);

    }

    public void updateTerminal(ArrayList<Demand> listDemand) {

        scrollView.removeAll();

        int j = 0;
        for (int i = 0; i < listDemand.size(); i++) {

            if (listDemand.get(i).getState() != DemandState.DECLINED) {
                newDemand(listDemand.get(i), 20, 20 + j * 150, scrollView);
                j++;
            }
        }

        //commandWindow.setVisible(false);
        //commandWindow.setVisible(true);

        SwingUtilities.updateComponentTreeUI(commandWindow);
        scrollView.setPreferredSize(new Dimension(335, j * 160));

    }


    public void showTerminal() {
        commandWindow.setVisible(true);
    }

    public void unShowTerminal() {
        commandWindow.setVisible(false);
    }


    public void startDisplay() {
        Thread threadAffiche = new Thread(this);

        //this will call the method run
        threadAffiche.start();
    }
}
