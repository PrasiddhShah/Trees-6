// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approch
we are using BFS to solve this one, we use 2 queues one for the BFS and second one for the level of the node inserted in the
bfs queue, right node decrease by one level each time left nodes increase
*/

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qlvl = new LinkedList<>();
        map.put(0,new ArrayList<>());
        map.get(0).add(root.val);
        q.add(root);
        qlvl.add(0);
        int min = 0;
        int max =0;
        while(!q.isEmpty()){
                TreeNode cur = q.poll();
                int curlvl = qlvl.poll();
                if(cur.left !=null){
                    if(!map.containsKey(curlvl-1)){
                        map.put(curlvl-1,new ArrayList<>());
                    }
                    map.get(curlvl-1).add(cur.left.val);
                    min = Math.min(min,curlvl-1);
                    q.add(cur.left);
                    qlvl.add(curlvl-1);
                }
                if(cur.right !=null){
                    if(!map.containsKey(curlvl+1)){
                        map.put(curlvl+1,new ArrayList<>());
                    }
                    map.get(curlvl+1).add(cur.right.val);
                    max = Math.max(max,curlvl+1);
                    q.add(cur.right);
                    qlvl.add(curlvl+1);
                }
        
        }
        while(min<=max){
            List<Integer> temp = map.get(min);
            result.add(temp);
            min++;
        }
        return result;
        
    }