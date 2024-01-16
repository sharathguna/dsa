package code.blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;


public class CourseSchedule {
  public static void main(String[] args){
    int[][] preReq = {{0,1},{0,2},{1,3},{1,4},{3,4}};
    System.out.println("The mentioned courses can be completed ? " + canFinish(5,preReq));
  }
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    for (int i = 0; i<numCourses;i++) {
      preMap.put(i,new ArrayList<>());
    }
    for (int[] ints : prerequisites) {
      int prerequisite = ints[1];
      int course = ints[0];
      List<Integer> existingList = preMap.getOrDefault(course, new ArrayList<>());
      existingList.add(prerequisite);
      preMap.putIfAbsent(course, existingList);
    }
    Set<Integer> visited = new HashSet<>();
    for (int course : IntStream.range(0,numCourses).toArray()) {
      if (!dfs(course, visited, preMap))
          return false;
    }
    return true;
  }
  static boolean dfs(int course, Set<Integer> visited, Map<Integer,List<Integer>> preMap) {
    if (visited.contains(course)) return false;
    if (preMap.get(course).isEmpty()) return true;

    visited.add(course);
    for (int crs : preMap.get(course)) {
      if (!dfs(crs, visited, preMap)) {
        return false;
      }
    }
      visited.remove(course);
      preMap.put(course, new ArrayList<>());
      return true;
  }
}
