package code.blind75;

import code.utils.Graph;
import code.utils.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CloneGraph {
  public static void main(String[] args) {

    ArrayList<Node> neighbourOne = new ArrayList<>();
    neighbourOne.add(new Node(2));
    neighbourOne.add(new Node(4));
    Node one = new Node(1,neighbourOne);

    ArrayList<Node> neighbourTwo = new ArrayList<>();
    neighbourTwo.add(new Node(1));
    neighbourOne.add(new Node(3));
    Node two = new Node(2,neighbourTwo);

    ArrayList<Node> neighbourThree = new ArrayList<>();
    neighbourThree.add(new Node(2));
    neighbourThree.add(new Node(4));
    Node three = new Node(3,neighbourThree);

    ArrayList<Node> neighbourFour = new ArrayList<>();
    neighbourFour.add(new Node(1));
    neighbourFour.add(new Node(3));
    Node four = new Node(4,neighbourFour);

    ArrayList<Node> nodes = new ArrayList<>();
    nodes.add(0,one);
    nodes.add(two);
    nodes.add(three);
    nodes.add(four);
    Graph graph = new Graph(nodes);
    cloneGraph(graph);
  }
  public static Node cloneGraph(Graph graph) {
    Node start = graph.nodes.get(0);
    if (start == null) return null;
    Map<Node,Node> nodeMap = new HashMap<>();
    return clone(start,nodeMap);
  }

  private static Node clone(Node start, Map<Node, Node> nodeMap) {
    if (nodeMap.containsKey(start)) {
      return nodeMap.get(start);
    }
    Node copy = new Node(start.val);
    nodeMap.put(start,copy);
    for (Node neighbour : start.neighbors) {
      copy.neighbors.add(clone(neighbour,nodeMap));
    }
    return copy;
  }
}
