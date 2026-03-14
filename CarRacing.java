package com.Medium;

import java.util.Random;
import java.util.Scanner;

public class CarRacing {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int roadWidth = 5;
        int carPosition = 2;
        int obstaclePosition = random.nextInt(roadWidth);

        boolean gameRunning = true;
        int score = 0;

        System.out.println("🚗 Car Racing Console Game");
        System.out.println("Controls: A = Left, D = Right");

        while (gameRunning) {

            // Draw Road
            for (int i = 0; i < roadWidth; i++) {
                if (i == carPosition) {
                    System.out.print("C ");
                } else if (i == obstaclePosition) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();

            // Input
            System.out.print("Move (A/D): ");
            char move = sc.next().toUpperCase().charAt(0);

            if (move == 'A' && carPosition > 0) {
                carPosition--;
            }
            if (move == 'D' && carPosition < roadWidth - 1) {
                carPosition++;
            }

            // Collision check
            if (carPosition == obstaclePosition) {
                System.out.println("💥 Crash! Game Over");
                gameRunning = false;
                break;
            }

            obstaclePosition = random.nextInt(roadWidth);

            score++;
            System.out.println("Score: " + score);
            System.out.println("------------------");

            Thread.sleep(500);
        }

        sc.close();
    }
}