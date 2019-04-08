package com.killoran.Week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by 111618 on 4/4/2019.
 */
public class Store implements Comparator<List>,Iterable<List> {

    public static void add(ArrayList<List> objects, String taskTit, String description, Integer priority) {
        List task = new List(taskTit, description, priority);
        objects.add(task);
    }

    public static void delete(ArrayList<List> objects, Integer j, Integer choice) {
        try {
            for (List task : objects) {
                j++;
                if (j == choice) {
                    objects.remove(task);
                    objects.remove(objects.size() - 1);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void update(ArrayList<List> objects, String title, String desc, Integer priority, List object) {
        object.setTitle(title);
        object.setDecrip(desc);
        object.setPriority(priority);
    }

    public static void list(ArrayList<List> objects, Integer i) {
        for (List task : objects) {
            i++;
            System.out.println(i + ") " + task.toString());
        }
    }

    public static void priority(ArrayList<List> objects, Integer counter, Integer search) {
        for (List task : objects) {
            if (search == task.getPriority()) {
                System.out.println(task.toString());
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("There seems to be no task with that priority");
        }

    }
    public static void organize(ArrayList<List> objects){
        ArrayList<List> dummy = new ArrayList<>();
        ArrayList<List> dummy2 = new ArrayList<>();
        ArrayList<List> dummy3 = new ArrayList<>();
        ArrayList<List> dummy5 = new ArrayList<>();
        ArrayList<List> dummy4 = new ArrayList<>();
        Collections.sort(objects, new Store());//organizes by priority
        for (List task : objects) {
            if (task.getPriority() == 1) {
                dummy.add(task);
            }
            Collections.sort(dummy);//sorts individual elements with a priority of 1

        }
        for (List task : objects) {
            if (task.getPriority() == 2) {
                dummy2.add(task);
            }
            Collections.sort(dummy2);//sorts individual elements with a priority of 2

        }
        for (List task : objects) {
            if (task.getPriority() == 3) {
                dummy3.add(task);
            }
            Collections.sort(dummy3);//sorts individual elements with a priority of 3
        }
        for (List task : objects) {
            if (task.getPriority() == 4) {
                dummy4.add(task);
            }
            Collections.sort(dummy4);//sorts individual elements with a priority of 4
        }
        for (List task : objects) {
            if (task.getPriority() == 5) {
                dummy5.add(task);
            }
            Collections.sort(dummy5);//sorts individual elements with a priority of 5
        }
        objects.clear(); //clears original list
        objects.addAll(dummy5); //loads the newly organized items into cleared list
        objects.addAll(dummy4);
        objects.addAll(dummy3);
        objects.addAll(dummy2);
        objects.addAll(dummy);
        int i = 0;
        for(List task:objects){
            i++;
            System.out.println(i +")" + task);
        }
    }

    @Override
    public int compare(List o1, List o2) {
        return o1.getPriority() - o2.getPriority();
    }

    @Override
    public void forEach(Consumer<? super List> action) {

    }

    @Override
    public Iterator<List> iterator() {
        return null;
    }
}
