
int pixelSize = 600; //also update size
int gridSize = 10;
int stepSize = pixelSize / gridSize;

Node[][] grid;

ArrayList<Node> closedSet = new ArrayList<Node>();
ArrayList<Node> openSet = new ArrayList<Node>();

Node start;
Node target;

ArrayList<Node> path;
boolean foundPath;

int stepsToPath = 0;

int maxCost = 1;

void setup() {

  frameRate(1);
  size(600, 600);
  background(255);

  makeGrid();



  start = grid[0][0];
  println("Start: " + start);
  target = grid[4][4];
  println("Target: " + target);

  setupPathFinding();
}

void draw() {

  background(255);

  strokeWeight(3);
  for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {
      int s = (int) map(grid[i][j].cost, 0, maxCost, 240, 10); 
      stroke(s);
      if (grid[i][j].start == true) {
        stroke(57, 200, 50);
      } else if (grid[i][j].target == true) {
        stroke(200, 57, 50);
      } else if (grid[i][j].wall == true) {
        stroke(255, 128, 128);
      } else if (path.contains(grid[i][j])) {
        stroke(200, 57, 178);
      } else if (openSet.contains(grid[i][j])) {
        stroke(57, 50, 200);
        fill(0);
        text("" + grid[i][j].fScore, ((i * stepSize) + stepSize / 2) + 9, ((j * stepSize) + stepSize / 2));
        fill(255);
      } else if (closedSet.contains(grid[i][j])) {
        stroke(50, 250, 250);
      }
      ellipse((i * stepSize) + stepSize / 2, (j * stepSize) + stepSize / 2, 10, 10);
      if (grid[i][j].gScore < 1000000) {
        fill(0);
        text("" + grid[i][j].gScore, ((i * stepSize) + stepSize / 2) + 9, ((j * stepSize) + stepSize / 2) + 12);
        fill(255);
      }
    }
  }



  if (foundPath) {
    println("Found a Path: " + printNodeList(path));
  }


  if (!openSet.isEmpty()) {
    iteratePathFinding();
  }
}


void makeGrid() {

  makeFullGrid();
  // makeVWall1Door();
  makeCustomWall();
}

void makeFullGrid() {

  grid = new Node[gridSize][gridSize];

  for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {
      grid[i][j] = new Node(i, j, j);
    }
  }

  for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {

      if (j > 0) {
        grid[i][j].upNeighbour = grid[i][j - 1];
        grid[i][j].neighbours.add(grid[i][j - 1]);
      }
      if (j + 1 < gridSize) {
        grid[i][j].upNeighbour = grid[i][j + 1];
        grid[i][j].neighbours.add(grid[i][j + 1]);
      }
      if (i > 0) {
        grid[i][j].upNeighbour = grid[i - 1][j];
        grid[i][j].neighbours.add(grid[i - 1][j]);
      }
      if (i + 1 < gridSize) {
        grid[i][j].upNeighbour = grid[i + 1][j];
        grid[i][j].neighbours.add(grid[i + 1][j]);
      }
    }
  }
}


void makeVWall1Door () {

  int wallx = (gridSize / 2);
  int doory = (gridSize / 2);

  for (int j = 0; j < gridSize; j++) {
    if (j != doory) {
      grid[wallx][j].wall = true;
    }
  }
}


void makeCustomWall() {


  //grid[3][3].wall = true;
  //grid[3][4].wall = true;
  //grid[3][5].wall = true;
  //grid[3][6].wall = true;
  //grid[3][7].wall = true;
  //grid[3][8].wall = true;
  //grid[4][3].wall = true;
  //grid[5][3].wall = true;
  //grid[6][3].wall = true;
  //grid[7][3].wall = true;
  //grid[5][3].wall = true;
}

void setupPathFinding() {

  start.start = true;
  start.gScore = 0;
  start.fScore = heuristic(start, target);
  openSet.add(start);

  target.target = true;

  path = new ArrayList<Node>();
  foundPath = false;

  for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {
      if (grid[i][j].cost > maxCost) {
        maxCost = grid[i][j].cost;
      }
    }
  }
}

void iteratePathFinding() {

  if (!foundPath) {
    stepsToPath++;
  }

  println("Step");

  println("Open Set: "+ printNodeList(openSet));
  //println("Closed Set: "+ printNodeList(closedSet));


  Node current = chooseNode();

  println("Current Node: " + current);

  openSet.remove(current);
  closedSet.add(current);

  for (Node n : current.neighbours) {

    if (n.wall == true) {
      closedSet.add(n);
    }

    if (closedSet.contains(n)) {
      continue;
    }

    int tentativeGScore = current.gScore + n.cost;

    if (!openSet.contains(n)) {
      openSet.add(n);
    } else if (tentativeGScore >= n.gScore) {
      continue;
    }

    // are we getting here properly

    n.cameFrom = current;
    n.gScore = tentativeGScore;
    n.fScore = n.gScore + (heuristic(n, target) - 1);

    if (n.equals(target)) {
      println("Target in " + stepsToPath + " steps.");
      path = findPath();
      foundPath = true;
    }
  }
}


Node chooseNode() {
  Node current = openSet.get(0);

  for (Node n : openSet) {

    //println("Evaluating Node: " + n.dataString());

    if (n.fScore < current.fScore) {
      current = n;
    } else {
      if (n.fScore == current.fScore) {
        if (heuristic(n, target) < heuristic(current, target)) {
          current = n;
        }
      }
    }
  }

  return current;
}

float heuristic(Node a, Node b) {

  return findManhattan(a, b) * maxCost;

  // return dist(a.i, a.j, b.i, b.j);
}

float findManhattan(Node a, Node b) {

  return abs(a.i - b.i) + abs(a.j - b.j);
}

ArrayList<Node> findPath() {

  ArrayList<Node> path = new ArrayList<Node>();
  Node pNode = target;
  path.add(target);
  while (pNode.cameFrom != null) {
    path.add(pNode);
    pNode = pNode.cameFrom;
  }
  ArrayList<Node> forwardPath = new ArrayList<Node>();
  for (Node n : path) {
    forwardPath.add(n);
  }

  return forwardPath;
}

public static String printNodeList(ArrayList<Node> list) {

  if (list.size() < 1) {
    return "";
  }

  StringBuilder b = new StringBuilder();

  for (Node n : list) {
    b.append(n + ", ");
  }

  return b.substring(0, b.length () - 2);
}