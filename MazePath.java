package Assign;

import java.util.ArrayList;
import java.util.List;

public class MazePath {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1}
        };

        int startX = 0;
        int startY = 0;
        int goalX = 4;
        int goalY = 4;

        List<String> path = findPath(maze, startX, startY, goalX, goalY);
        if (path != null) {
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found.");
        }
    }

    public static List<String> findPath(int[][] maze, int currentX, int currentY, int goalX, int goalY) {
        int rows = maze.length;
        int cols = maze[0].length;

    
        if (currentX < 0 || currentX >= rows || currentY < 0 || currentY >= cols || maze[currentX][currentY] == 0) {
            return null;
        }

        // Check if current position is the goal
        if (currentX == goalX && currentY == goalY) {
            List<String> path = new ArrayList<>();
            path.add("(" + currentX + ", " + currentY + ")");
            return path;
        }

        // Mark current position as visited
        maze[currentX][currentY] = 0;
        List<String> path;
        path = findPath(maze, currentX - 1, currentY, goalX, goalY); // Up
        if (path != null) {
            path.add(0, "(" + currentX + ", " + currentY + ")");
            return path;
        }
        path = findPath(maze, currentX, currentY + 1, goalX, goalY); // Right
        if (path != null) {
            path.add(0, "(" + currentX + ", " + currentY + ")");
            return path;
        }
        path = findPath(maze, currentX + 1, currentY, goalX, goalY); // Down
        if (path != null) {
            path.add(0, "(" + currentX + ", " + currentY + ")");
            return path;
        }
        path = findPath(maze, currentX, currentY - 1, goalX, goalY); // Left
        if (path != null) {
            path.add(0, "(" + currentX + ", " + currentY + ")");
            return path;
        }

        return null;
    }
}
