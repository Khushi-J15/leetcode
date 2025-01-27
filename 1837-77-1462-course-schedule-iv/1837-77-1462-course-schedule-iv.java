class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        for(int[] edge : prerequisites){
            isPrerequisite[edge[0]][edge[1]] = true;
        }

        for(int intermediate=0; intermediate<numCourses; intermediate++){
            for(int src=0; src<numCourses; src++){
                for(int target=0; target<numCourses; target++){
                    isPrerequisite[src][target] = isPrerequisite[src][target]
                    || (isPrerequisite[src][intermediate] && isPrerequisite[intermediate][target]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries){
            ans.add(isPrerequisite[query[0]][query[1]]);
        }

        return ans;
    }
}