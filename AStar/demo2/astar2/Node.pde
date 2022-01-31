

public class Node {

  int i;
  int j;

  int cost;

  boolean start;
  boolean target;
  
  boolean wall = false;

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

  Node (int i, int j, int c) {
    this.i = i;
    this.j = j;
    this.cost = c;
  }

  public String toString() {
    return "(" + i + "," + j + ")";
  }

  public String dataString() {
    return "(" + i + "," + j + ")"  + " g: " + gScore + ", f: " + fScore;
  }




}