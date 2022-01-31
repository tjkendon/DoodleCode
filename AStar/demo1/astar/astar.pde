
int pixelSize = 600; //also update size
int gridSize = 7;
int stepSize = pixelSize / gridSize;

Node[][] grid;

ArrayList<Node> closedSet = new ArrayList<Node>();
ArrayList<Node> openSet = new ArrayList<Node>();

Node start;
Node target;

ArrayList<Node> path;


void setup() {

  size(600, 600);
  background(255);

  grid = new Node[gridSize][gridSize];

  for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {
      grid[i][j] = new Node(i, j);
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

  start = grid[0][0];
  target = grid[6][3];

  pathfind();

  path = findPath();
  for (Node n : path) {
    println(n.i + ", " + n.j);
  }
}

void draw() {

  strokeWeight(4);
  for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {
      stroke(57);
      if (openSet.contains(grid[i][j])) {
        stroke(57, 50, 200);
      }
      if (grid[i][j].start == true) {
        stroke(57, 200, 50);
      } else if (grid[i][j].target == true) {
        stroke(200, 57, 50);
      } else if (path.contains(grid[i][j])) {
        stroke(200, 57, 178);
      }

      ellipse((i * stepSize) + stepSize / 2, (j * stepSize) + stepSize / 2, 10, 10);
    }
  }
}

void pathfind() {

  start.start = true;
  start.gScore = 0;
  start.fScore = heuristic(start, target);
  openSet.add(start);

  target.target = true;

  while (!openSet.isEmpty()) {

    Node current = openSet.get(0);
    for (Node n : openSet) {
      if (n.fScore < current.fScore) {
        current = n;
      }
    }

    openSet.remove(current);
    closedSet.add(current);

    for (Node n : current.neighbours) {
      if (closedSet.contains(n)) {
        continue;
      }

      int tentativeGScore = current.gScore + 1;

      if (!openSet.contains(n)) {
        openSet.add(n);
      } else if (tentativeGScore >= n.gScore) {
        continue;
      }

      n.cameFrom = current;
      n.gScore = tentativeGScore;
      n.fScore = n.gScore + heuristic(n, target);
    }
  }
}

float heuristic(Node a, Node b) {

  return dist(a.i, a.j, b.i, b.j);
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