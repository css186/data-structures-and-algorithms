package cse41321.Homework8;

import cse41321.containers.Graph;
import cse41321.containers.Queue;

public class Homework8 {
    public static boolean isExitReachable(Graph<Character, Void> maze, char entrance, char exit) {
        // Create a queue for BFS traversal
        Queue<Graph<Character, Void>.Vertex> queue = new Queue<>();

        // Mark the entrance vertex as visited and enqueue it
        Graph<Character, Void>.Vertex entranceVertex = maze.getVertex(entrance);
        queue.enqueue(entranceVertex);

        // Create an array for visited vertex
        boolean[] visited = new boolean[maze.getNumVertices()];

        // Find the index of the entrance vertex in the visited queue
        int entranceIndex = -1;
        int index = 0;
        for (Graph<Character, Void>.Vertex vertex : maze.getVertices()) {
            if (vertex.equals(entranceVertex)) {
                entranceIndex = index;
                break;
            }
            index++;
        }

        // If entrance is not found, throw exception
        if (entranceIndex == -1) {
            throw new IllegalArgumentException("Entrance vertex not found in the graph");
        }

        visited[entranceIndex] = true;

        while (!queue.isEmpty()) {
            Graph<Character, Void>.Vertex currentVertex = queue.dequeue();

            // Check if we have reached the exit vertex
            if (currentVertex.getData().equals(exit)) {
                return true; // Exit is reachable
            }

            // Explore adjacent vertices
            for (Graph<Character, Void>.Edge edge : currentVertex.getEdgesIncidentFrom()) {

                Graph<Character, Void>.Vertex neighbor = edge.getTo();

                // Find the index of neighbor in the visited array
                int neighborIndex = 0;
                for (Graph<Character, Void>.Vertex vertex : maze.getVertices()) {
                    if (vertex.equals(neighbor)) {
                        break;
                    }
                    neighborIndex++;
                }

                if (neighborIndex < visited.length && !visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    queue.enqueue(neighbor);
                }
            }
        }

        // There is no path to the exit -> return false
        return false;
    }

    public static void main(String[] args) {
        // Maze #1
        Graph<Character, Void> mazeOne = new Graph<>();

        // Add vertices for A, B, C, D, E, F, G
        mazeOne.insertVertex('A');
        mazeOne.insertVertex('B');
        mazeOne.insertVertex('C');
        mazeOne.insertVertex('D');
        mazeOne.insertVertex('E');
        mazeOne.insertVertex('F');
        mazeOne.insertVertex('G');

        // Add edges to connect the vertices
        mazeOne.insertEdge('A', 'C', null);
        mazeOne.insertEdge('A', 'D', null);
        mazeOne.insertEdge('B', 'D', null);
        mazeOne.insertEdge('C', 'F', null);
        mazeOne.insertEdge('F', 'G', null);
        mazeOne.insertEdge('D', 'E', null);
        mazeOne.insertEdge('D', 'G', null);
        mazeOne.insertEdge('E', 'G', null);

        boolean mazeOneResult = isExitReachable(mazeOne, 'A', 'G');
        System.out.println("Is Maze#1 exit reachable? " + mazeOneResult);

        // Maze #2
        Graph<Character, Void> mazeTwo = new Graph<>();

        // Add vertices for A, B, C, D, E, F, G
        mazeTwo.insertVertex('A');
        mazeTwo.insertVertex('B');
        mazeTwo.insertVertex('C');
        mazeTwo.insertVertex('D');
        mazeTwo.insertVertex('E');
        mazeTwo.insertVertex('F');
        mazeTwo.insertVertex('G');

        // Add edges to connect the vertices
        mazeTwo.insertEdge('A', 'C', null);
        mazeTwo.insertEdge('A', 'D', null);
        mazeTwo.insertEdge('B', 'D', null);
        mazeTwo.insertEdge('C', 'F', null);
        mazeTwo.insertEdge('E', 'G', null);

        boolean mazeTwoResult = isExitReachable(mazeTwo, 'A', 'G');
        System.out.println("Is Maze#2 exit reachable? " + mazeTwoResult);


    }
}
