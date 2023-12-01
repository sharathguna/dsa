package code.blind75.utils;

import java.util.ArrayList;
import java.util.List;


public class Graph {
  public List<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<>();
  }

  public Graph(ArrayList<Node> nodes) {
    this.nodes = nodes;
  }
}
