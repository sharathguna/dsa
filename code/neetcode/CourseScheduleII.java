package code.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;


public class CourseScheduleII {
  public static void main(String[] args) {
    //int[][] preReqs= {{0,1},{0,2},{1,3},{3,2},{5,0},{4,0}};
    int[][] preReqs = {{0,1}};
    System.out.println("The order for the course is : " + Arrays.toString(findOrder(2, preReqs)));
  }
  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> preMap = new HashMap<>(prerequisites.length);
    List<Integer> output = new ArrayList<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    for (int i = 0; i<numCourses;i++) {
      preMap.put(i,new ArrayList<>());
    }
    for (int[] preq : prerequisites) {
      int course = preq[0];
      int prereq = preq[1];
      List<Integer> existingList = preMap.get(course);
      existingList.add(prereq);
      preMap.put(course, existingList);
    }

    for (int i : IntStream.range(0,numCourses).toArray()) {
      if (!dfs(visit,cycle,i,output,preMap)) {
        return new int[0];
      }
    }
    return output.stream().mapToInt(a->Integer.parseInt(String.valueOf(a))).toArray();
  }
  static boolean dfs(Set<Integer> visit, Set<Integer> cycle, int course, List<Integer> output, Map<Integer,List<Integer>> preMap) {
    if (cycle.contains(course)) return false;
    if (visit.contains(course)) return true;

    cycle.add(course);
    for (Integer crs : preMap.get(course)) {
      if (!dfs(visit,cycle,crs,output,preMap)) {
        return false;
      }
    }

    cycle.remove(course);
    visit.add(course);
    output.add(course);
    return true;
  }
}
