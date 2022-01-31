

public class Node {

  int i;
  int j;
  
  boolean start;
  boolean target;
  
  Node cameFrom;
  
  Node upNeighbour;
  Node downNeighbour;
  Node leftNeighbour;
  Node rightNeighbour;
  
  ArrayList<Node> neighbours = new ArrayList<Node>();
  
  int gScore = Integer.MAX_VALUE;
  float fScore = Float.MAX_VALUE;
  
  Node() {
  }
  
  Node (int i, int j) {
    this.i = i;
    this.j = j;
  }
  
}