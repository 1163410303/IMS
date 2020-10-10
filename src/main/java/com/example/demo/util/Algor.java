package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Component
public class Algor {
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void reverse(Node head){
        if(null == head || null == head.next){
            return;
        }
        Node pcur = head.next;
        Node prev = null;
        Node next;
        while (pcur != null){
            if (pcur.next == null){
                pcur.next = prev;
                break;
            }
            next = pcur.next;
            pcur.next = prev;
            prev = pcur;
            pcur = next;
        }
        head.next = pcur;
        Node temp = head.next;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void test(){
            ArrayList<Node> arr = new ArrayList<>();
            for (int i = 0; i < 100; i++ ){
                Node tmp = new Node(i);
                arr.add(tmp);
            }
        for (int i = 0; i < 99; i++){

            arr.get(i).next = arr.get(i+1);
        }
        arr.get(99).next = null;
        System.out.println("原始数据为");
        for (Node tmp: arr
             ) {
            if(tmp.next != null) {
                System.out.print(tmp.data + "-->");

            }else{
                System.out.println(tmp.data);
            }
        }
        reverse(arr.get(0));
    }

}
