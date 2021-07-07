package project2;

import java.awt.*;
import java.util.Random;

public class ZZZZZnake {

    Point   playerPosition;
    Point   snakePosition;
    Point   goldPosition;
    Point   doorPosition;
    boolean rich = false;

    public ZZZZZnake(Configuration configuration) {
        Random positionGenerator = new Random();
        this.playerPosition = new Point(positionGenerator.nextInt(configuration.getxLength()), positionGenerator.nextInt(configuration.getyLength()));
        this.snakePosition = new Point(positionGenerator.nextInt(configuration.getxLength()), positionGenerator.nextInt(configuration.getyLength()));
        this.goldPosition = new Point(positionGenerator.nextInt(configuration.getxLength()), positionGenerator.nextInt(configuration.getyLength()));
        this.doorPosition = new Point(positionGenerator.nextInt(configuration.getxLength()), positionGenerator.nextInt(configuration.getyLength()));
    }

    public void play() {
        while (true) {
            // Raster mit Figuren zeichnen

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (playerPosition.equals(p))
                        System.out.print('&');
                    else if (snakePosition.equals(p))
                        System.out.print('S');
                    else if (goldPosition.equals(p))
                        System.out.print('$');
                    else if (doorPosition.equals(p))
                        System.out.print('#');
                    else System.out.print('.');
                }
                System.out.println();
            }

            // Status feststellen

            if (rich && playerPosition.equals(doorPosition)) {
                System.out.println("Gewonnen!");
                return;
            }
            if (playerPosition.equals(snakePosition)) {
                System.out.println("ZZZZZZZ. Die Schlange hat dich!");
                return;
            }
            if (playerPosition.equals(goldPosition)) {
                rich = true;
                goldPosition.setLocation(-1, -1);
            }

            // Konsoleneingabe und Spielerposition verändern

            switch (new java.util.Scanner(System.in).next()) {
                // Spielfeld ist im Bereich 0/0 .. 39/9
                case "h":
                    playerPosition.y = Math.max(0, playerPosition.y - 1);
                    break;
                case "t":
                    playerPosition.y = Math.min(9, playerPosition.y + 1);
                    break;
                case "l":
                    playerPosition.x = Math.max(0, playerPosition.x - 1);
                    break;
                case "r":
                    playerPosition.x = Math.min(39, playerPosition.x + 1);
                    break;
            }

            // Schlange bewegt sich in Richtung Spieler

            if (playerPosition.x < snakePosition.x)
                snakePosition.x--;
            else if (playerPosition.x > snakePosition.x)
                snakePosition.x++;
            if (playerPosition.y < snakePosition.y)
                snakePosition.y--;
            else if (playerPosition.y > snakePosition.y)
                snakePosition.y++;
        } // end while
    }
}