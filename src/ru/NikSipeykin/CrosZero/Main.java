package ru.NikSipeykin.CrosZero;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char DOT_HUMAN = 'X';
    private static char DOT_AI = 'O';
    private static char DOT_EMPTY = '_';

    private static int gameFieldSizeX = 3;
    private static int gameFieldSizeY = 3;

    private static char[][] gameField = new char[gameFieldSizeX][gameFieldSizeY];

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static int playerNumber = 0;

    private static int lastXCoordinate = 1;
    private static int lastYCoordinate = 1;

    //создание игрового поля
    private static char[][] gameFieldCreator(){


        for(int i = 0; i < gameFieldSizeX; i++){
            for (int j = 0; j < gameFieldSizeY; j++){
                gameField[i][j] = DOT_EMPTY;
            }
        }
        return gameField;
    }

    //отрисовка игрового поля
    private static void printGameField(){

        for(int i = 0; i < gameFieldSizeX; i++){
            for (int j = 0; j < gameFieldSizeY; j++){
                System.out.print('|');
                System.out.print(gameField[i][j]);
            }
            System.out.println("|");
        }
    }

    //ход игрока
    private static void humanTurn(){

        int x;
        int y;

        do {
            System.out.println("Введите координаты 'X' и 'Y' в игровом поле 3 на 3.");
            x = (SCANNER.nextInt() - 1);
            y = (SCANNER.nextInt() - 1);
        }while (!isValidCell(x, y) || !isEmptyCell (x, y));
            gameField[x][y] = DOT_HUMAN;
            lastXCoordinate = x;
            lastYCoordinate = y;
    }

    //ход ии
    private static void aiTurn(){

        int x;
        int y;

        do {
            x = RANDOM.nextInt(3);
            y = RANDOM.nextInt(3);
        }while (!isEmptyCell (x, y));
        System.out.println("Ход ИИ ");
        gameField[x][y] = DOT_AI;
        lastXCoordinate = x;
        lastYCoordinate = y;
    }

    //проверка на пустоту
    private static boolean isEmptyCell(int x, int y) {
        return gameField[x][y] == DOT_EMPTY;
    }

    //проверка на попадание в игровое поле
    private static boolean isValidCell(int x, int y){
        return x < gameFieldSizeX && y < gameFieldSizeY && x >= 0 && y >=0;
    }

    //поверка на победу
    private static boolean isWin1(){
        if (gameField[1][1] != DOT_EMPTY){
            if(gameField[0][0] == gameField[1][1]){
                if(gameField[2][2] == gameField[0][0]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
            if(gameField[0][1] == gameField[1][1]){
                if(gameField[2][1] == gameField[0][1]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
            if(gameField[0][2] == gameField[1][1]){
                if(gameField[2][0] == gameField[0][2]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
            if(gameField[1][0] == gameField[1][1]){
                if(gameField[1][2] == gameField[1][0]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
        }
        if(gameField[0][0] != DOT_EMPTY){
            if(gameField[1][0] == gameField[0][0]){
                if (gameField[2][0] == gameField[1][0]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
            if(gameField[0][1] == gameField[0][0]){
                if (gameField[0][2] == gameField[0][1]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
        }
        if(gameField[2][2] != DOT_EMPTY){
            if(gameField[1][2] == gameField[0][0]){
                if (gameField[0][2] == gameField[1][2]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
            if(gameField[2][1] == gameField[0][0]){
                if (gameField[2][0] == gameField[2][1]){
                    System.out.println("Вы выйграли!");
                    return false;
                }
            }
        }
        return true;
    }
    //проверка на заполнение игрового поля

    //проверка на победу с последним координатом
    private static boolean isWin2() {
        //00
        if(gameField[lastXCoordinate][lastYCoordinate] != DOT_EMPTY){
            if (lastXCoordinate == 0 && lastYCoordinate == 0) {
                if (gameField[0][0] == gameField[1][0] && gameField[1][0] == gameField[2][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[0][0] == gameField[0][1] && gameField[0][1] == gameField[0][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //01
            if (lastXCoordinate == 0 && lastYCoordinate == 1) {
                if (gameField[0][1] == gameField[0][0] && gameField[0][0] == gameField[0][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[0][1] == gameField[1][1] && gameField[1][1] == gameField[2][1]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //02
            if (lastXCoordinate == 0 && lastYCoordinate == 2) {
                if (gameField[0][2] == gameField[1][2] && gameField[1][2] == gameField[2][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[0][2] == gameField[0][1] && gameField[0][1] == gameField[0][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //10
            if (lastXCoordinate == 1 && lastYCoordinate == 0) {
                if (gameField[1][0] == gameField[0][0] && gameField[0][0] == gameField[2][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[1][0] == gameField[1][1] && gameField[1][1] == gameField[1][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }

                return true;
            }
            //11
            if (lastXCoordinate == 1 && lastYCoordinate == 1) {
                if (gameField[1][1] == gameField[0][0] && gameField[0][0] == gameField[2][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[1][1] == gameField[0][2] && gameField[0][2] == gameField[2][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[1][1] == gameField[1][0] && gameField[1][0] == gameField[1][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[1][1] == gameField[0][1] && gameField[0][1] == gameField[2][1]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //12
            if (lastXCoordinate == 1 && lastYCoordinate == 2) {
                if (gameField[1][2] == gameField[0][2] && gameField[0][2] == gameField[2][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[1][2] == gameField[1][1] && gameField[1][1] == gameField[1][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //20
            if (lastXCoordinate == 2 && lastYCoordinate == 0) {
                if (gameField[2][0] == gameField[1][0] && gameField[1][0] == gameField[0][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[2][0] == gameField[2][1] && gameField[2][1] == gameField[2][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[2][0] == gameField[1][1] && gameField[1][1] == gameField[0][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //21
            if (lastXCoordinate == 2 && lastYCoordinate == 1) {
                if (gameField[2][1] == gameField[2][0] && gameField[2][0] == gameField[2][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[2][1] == gameField[1][1] && gameField[1][1] == gameField[0][1]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
            //22
            if (lastXCoordinate == 2 && lastYCoordinate == 2) {
                if (gameField[2][2] == gameField[1][2] && gameField[1][2] == gameField[0][2]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[2][2] == gameField[2][1] && gameField[2][1] == gameField[2][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                if (gameField[2][2] == gameField[1][1] && gameField[1][1] == gameField[0][0]) {
                    System.out.println("Победил игрок под номером " + playerNumber);
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        gameFieldCreator();
        while (isWin2()){
            if(playerNumber == 0){
            humanTurn();
            printGameField();
            playerNumber++;
            }else {
                aiTurn();
                printGameField();
                playerNumber = 0;
            }
        }
    }
}
