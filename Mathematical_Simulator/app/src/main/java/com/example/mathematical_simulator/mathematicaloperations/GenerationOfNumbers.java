package com.example.mathematical_simulator.mathematicaloperations;

public class GenerationOfNumbers extends DataToGenerate {

    public void creatingExampleForPositionsNum1() {

        int min = 1;
        int max = 9;

        for (int i = 0; i < 2; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            if (i == 0) {
                 setA(num);
            } else {
                setB(num);
            }
        }
        if (getActionsId() == 4) {
            setB(2);
        }
    }

    public void creatingExampleForPositionsNum2() {
        int min = 10;
        int max = 99;

        int minNum2 = 2;
        int maxNum2 = 10;

        for (int i = 0; i < 2; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            if (i == 0) {
                setA(num);
            } else {
                setB(num);
            }
        }

        if (getActionsId() == 4) {
            int numA = (int) (Math.random() * (max - min)) + min;
            int numB = (int) (Math.random() * (maxNum2 - minNum2)) + minNum2;
            setA(numA);
            setB(numB);
        }
    }

    public void creatingExampleForPositionsNum3() {
        int min = 100;
        int max = 999;

        int minNum3 = 2;
        int maxNum3 = 99;

        for (int i = 0; i < 2; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            if (i == 0) {
                setA(num);
            } else {
                setB(num);
            }
        }

        if (getActionsId() == 4) {
            int numA = (int) (Math.random() * (max - min)) + min;
            int numB = (int) (Math.random() * (maxNum3 - minNum3)) + minNum3;
            setA(numA);
            setB(numB);
        }
    }

    public void creatingExampleForPositionsNum4() {
        int min = 1000;
        int max = 9999;

        int minNum4 = 2;
        int maxNum4 = 150;

        for (int i = 0; i < 2; i++) {
            int numA = (int) (Math.random() * (max - min)) + min;
            if (i == 0) {
                setA(numA);
            } else {
                setB(numA);
            }
        }

        if (getActionsId() == 4) {
            int numA = (int) (Math.random() * (max - min)) + min;
            int numB = (int) (Math.random() * (maxNum4 - minNum4)) + minNum4;
            setA(numA);
            setB(numB);
        }
    }
}
