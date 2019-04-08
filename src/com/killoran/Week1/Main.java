package com.killoran.Week1;

import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<List> objects = new ArrayList<>();
        Store store = new Store();
        choice(objects, store);
    }

    public static void choice(ArrayList<List> objects, Store store) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter 1: Add a task");
        System.out.println("Enter 2: Delete a task");
        System.out.println("Enter 3: Edit a task");
        System.out.println("Enter 4: List all task");
        System.out.println("Enter 5: List by priority");
        System.out.println("Enter 6: To organize your list");
        System.out.println("Enter 0: End program");
        boolean gate2 = false;
        int choice = -1;
        while (!gate2) {
            String userInput = Input.nextLine();
            try {
                choice = Integer.parseInt(userInput);
                if (choice <= 6 & choice > -1) {
                    gate2 = true;
                } else {
                    System.out.println("Please Enter a valid number (0-5)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid number (0-5)");
            }
        }

        if (choice == 1) {
            add(objects, store);
        }
        if (choice == 2) {
            delete(objects, store);
        }
        if (choice == 3) {
            update(objects, store);
        }
        if (choice == 4) {
            list(objects, store);
        }
        if (choice == 5) {
            priority(objects, store);
        }
        if (choice == 6) {
            listPri(objects, store);
        }
        if (choice == 0) {
            end();
        }
    }

    public static void add(ArrayList<List> objects, Store store) {
        Scanner Input = new Scanner(System.in);
        String decision = "";
        while (!decision.equals("END")) {
            System.out.println("What is the title of your task");
            double test = 0;
            String taskTit = "";
            boolean gate4 = false;
            while (!gate4) {
                taskTit = Input.nextLine();
                try {
                    test = Double.parseDouble(taskTit);
                    System.out.println("Please enter a valid String for title");

                } catch (NumberFormatException e) {
                    gate4 = true;
                }
            }
            System.out.println("What is the description of your task");
            String description = "";
            boolean gate5 = false;
            while (!gate5) {
                description = Input.nextLine();
                try {
                    test = Double.parseDouble(description);
                    System.out.println("Please enter a valid string for a description");
                } catch (NumberFormatException e) {
                    gate5 = true;
                }
            }
            System.out.println("What is the task priority 0-5, 5 being the highest priority");
            boolean gate6 = false;
            int priority = 0;
            while (!gate6) {
                String userInput = Input.nextLine();
                try {
                    priority = Integer.parseInt(userInput);
                    if (priority <= 5 & priority > -1) {
                        gate6 = true;
                    } else {
                        System.out.println("Please enter a valid priority value(0-5)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid priority value(0-5)");
                }
            }
            store.add(objects, taskTit, description, priority);

            System.out.println("Type END if you do not wish to create another task");
            decision = Input.nextLine();
        }
        choice(objects, store);
    }

    public static void delete(ArrayList<List> objects, Store store) {
        Scanner input = new Scanner(System.in);
        String decision = "";
        while (!decision.equals("END")) {
            if (objects.isEmpty() != true) {
                int i = 0;
                for (List task : objects) {
                    if (task == null) {
                        continue;
                    } else {
                        i++;
                        System.out.println(i + ")" + task.toString());
                    }
                }
                System.out.println("Enter the corresponding number to the task you wish to delete");
                String userInput;
                int choice = -1;
                boolean gate2 = false;
                while (gate2 == false) {
                    userInput = input.nextLine();
                    try {
                        choice = Integer.parseInt(userInput);
                        if (choice < objects.size() + 1 & choice > 0) {
                            gate2 = true;
                        } else {
                            System.out.println("Please enter a valid task assignment #");

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid task assignment #");
                    }
                }
                int j = 0;
                objects.add(null);
                store.delete(objects, j, choice);
                System.out.println("To Finish Removing Tasks Enter END");
                System.out.println("If you wish to continue Enter anything you like");
                decision = input.nextLine();
            } else {
                System.out.println("You cannot delete zero tasks press Enter to Continue");
                input.nextLine();
                choice(objects, store);
            }
        }
        choice(objects, store);
    }

    public static void update(ArrayList<List> objects, Store store) {
        Scanner Input = new Scanner(System.in);
        String decision = "";
        while (!decision.equals("END")) {
            if (!objects.isEmpty()) {
                int j = 0;
                for (List task : objects) {
                    j++;
                    System.out.println(j + ") " + task.toString());
                }
                System.out.println("Enter the corresponding number with the task you'd like to update");
                int i = 0;
                int choice = 0;
                boolean gate9 = false;
                while (!gate9) {
                    String test3 = Input.nextLine();
                    try {
                        choice = Integer.parseInt(test3);
                        if (choice < objects.size() + 1 & choice > 0) {
                            gate9 = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Enter a valid task assignment number");
                    }
                }
                for (List object : objects) {
                    i++;
                    if (choice == i) {
                        Scanner input = new Scanner(System.in);
                        System.out.println("What is your updated title");
                        boolean gate7 = false;
                        String title = "";
                        while (!gate7) {
                            title = input.nextLine();
                            try {
                                double test = Double.parseDouble(title);
                                System.out.println("Please enter a valid string for title");
                            } catch (NumberFormatException e) {
                                gate7 = true;
                            }
                        }

                        System.out.println("What is your updated description");
                        String desc = "";
                        boolean gate8 = false;
                        while (!gate8) {
                            desc = input.nextLine();
                            try {
                                double test2 = Double.parseDouble(desc);
                                System.out.println("Please enter a valid string for description.");
                            } catch (NumberFormatException e) {
                                gate8 = true;
                            }
                        }

                        System.out.println("What is your updated priority 0-5");
                        int priority = 0;
                        String pri;
                        boolean gate10 = false;
                        while (!gate10) {
                            try {
                                pri = input.nextLine();
                                priority = Integer.parseInt(pri);
                                if (priority <= 5 & priority > -1) {
                                    gate10 = true;
                                } else {
                                    System.out.println("Please enter a valid integer for priority (0-5)");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid integer for priority (0-5)");
                            }
                        }
                        store.update(objects, title, desc, priority, object);
                    }
                }
                Scanner uInput = new Scanner(System.in);
                System.out.println("Enter END to stop updating tasks. Press Enter to continue");
                decision = uInput.nextLine();
            } else {
                System.out.println("You can not update an empty list. Press enter to continue");
                Input.nextLine();
                choice(objects, store);
            }
        }
        choice(objects, store);
    }

    public static void list(ArrayList<List> objects, Store store) {
        Scanner Input = new Scanner(System.in);
        int i = 0;
        if (!objects.isEmpty()) {
            store.list(objects, i);
            System.out.println("Press Enter to continue with the program");
            Input.nextLine();
            choice(objects, store);
        } else {
            System.out.println("You can not display an empty list of tasks. Press Enter to continue the program");
            Input.nextLine();
            choice(objects, store);
        }
    }

    public static void priority(ArrayList<List> objects, Store store) {
        Scanner Input = new Scanner(System.in);
        String decision = "";
        while (!decision.equals("END")) {
            if (!objects.isEmpty()) {
                System.out.println("What priority 0-5 would you like to sort by");
                int search = -1;
                boolean gate3 = false;
                while (!gate3) {
                    String choice = Input.nextLine();
                    try {
                        search = Integer.parseInt(choice);
                        if (search <= 5 & search > -1) {
                            gate3 = true;
                        } else {
                            System.out.println("Please enter a valid priority value(0-5)");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid priority value(0-5)");
                    }
                }
                int counter = 0;
                store.priority(objects, counter, search);
                System.out.println("Enter END to stop sorting by priority. To continue press Enter");
                decision = Input.nextLine();
            } else {
                System.out.println("You cannot sort an empty list. Press Enter to continue with the program ");
                Input.nextLine();
                choice(objects, store);
            }
        }
        choice(objects, store);
    }

    public static void listPri(ArrayList<List> objects, Store store) {
        Scanner Input = new Scanner(System.in);
        if (!objects.isEmpty()) {
            store.organize(objects);
            System.out.println("Please press Enter to continue");
            Input.nextLine();
            choice(objects, store);
        } else {
            System.out.println("You can not sort an empty list press Enter to continue");
            Input.nextLine();
            choice(objects, store);
        }
    }

    public static void end() {
        System.exit(0);
    }
}