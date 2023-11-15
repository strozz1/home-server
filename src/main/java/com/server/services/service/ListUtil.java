package com.server.services.service;

import com.server.entitties.SpeedRecord;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public enum Order {ASC, DESC};
    public static Order parseOrder(String order){
        if(order.equalsIgnoreCase("ASC")) return Order.ASC;

        return Order.DESC;

    }
    public static Order swap(Order order){
        if(order == Order.DESC) return Order.ASC;
        return Order.DESC;

    }

    public static List<SpeedRecord> order(List<SpeedRecord> list,Order Order) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;

        List<SpeedRecord> left = order(list.subList(0, mid),Order);
        List<SpeedRecord> right = order(list.subList(mid, list.size()),Order);
        return merge(left, right,Order);

    }

    private static List<SpeedRecord> merge(List<SpeedRecord> left, List<SpeedRecord> right, Order order) {
        List<SpeedRecord> list = new ArrayList<>();
        int i=0;
        int j=0;
        while(i< left.size() && j < right.size()){
            boolean condition = left.get(i).getTime().isBefore(right.get(j).getTime());
            if(Order.DESC == order) condition =  left.get(i).getTime().isAfter(right.get(j).getTime());
            if(condition){
                list.add(left.get(i));
                i++;

            }else{
                list.add(right.get(j));
                j++;

            }

        }
        while (i < left.size()) {
            list.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            list.add(right.get(j));
            j++;
        }
        return list;
    }
}
