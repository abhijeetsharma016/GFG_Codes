package com.GFG.Hashing;

import java.util.ArrayList;

public class Q4_DoubleHashing {
    public static void main(String[] args) {
        DoubleHashing myhash = new DoubleHashing(7,5);
        myhash.insert(10);
        myhash.insert(20);
        myhash.insert(30);
        myhash.insert(40);
        myhash.insert(50);
        myhash.insert(60);
        myhash.insert(70);
        myhash.display();
        System.out.println(myhash.search(70));
        myhash.delete(70);
        myhash.insert(80);
        myhash.display();
        System.out.println(myhash.search(80));
        System.out.println(myhash.search(70));
    }
}
class DoubleHashing {
    ArrayList<Integer> myArrayList;
    int Bucket1;
    int Bucket2;
    int location;

    public DoubleHashing(int Bucket1,int Bucket2){
        myArrayList = new ArrayList<>();
        this.Bucket1 = Bucket1;
        this.Bucket2 = Bucket2;
        for (int i = 0; i < Bucket1; i++) {
            myArrayList.add(-1);
        }
    }

    public void insert(int element) {
        int index = element % Bucket1;
        if (myArrayList.get(index) == -1) {
            myArrayList.set(index, element);
        } else {
            int index2 =  Bucket2 - (element % Bucket2);
            int hash = (index + index2) % Bucket1;
            int i = 1;
            while (myArrayList.get(hash) != -1 && i <= Bucket1) {
                i++;
                hash = (index + i * index2) % Bucket1;
            }
            if (i > Bucket1) {
                System.out.println("Hash table is full. Unable to insert " + element);
            } else {
                myArrayList.set(hash, element);
            }
        }
    }


    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < Bucket1; i++) {
            System.out.println(i + ": " + myArrayList.get(i));
        }
    }

    public boolean search(int element) {
        int index1 = element%Bucket1;
        if (myArrayList.get(index1) == element) {
            location = index1;
            return true;
        } else {
            int original = index1;
            int index2 =  Bucket2 - (element % Bucket2);
            int hash = (index1 + index2) % Bucket1;
            int i = 1;
            while (myArrayList.get(hash)!= -1 && i<=Bucket1 && myArrayList.get(hash)!=element) {
                i++;
                hash = (index1 + i * index2) % Bucket1;
            }
            if (myArrayList.get(hash) == element) {
                location = hash;
                return true;
            } else {
                return false;
            }
        }
    }

    public void delete(int element) {
        if (search(element)) {
            myArrayList.set(location, -1);
        }
        else{
            System.out.println("Element not present");
        }
    }
}
