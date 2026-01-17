// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch
we are suing DFS preorder to seralise the tree, where ever we encounter a "null" we put is "#" 
that will be used in deserialization
*/
public class problem2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializationHelper(root, sb);
        return sb.toString();
    }

    private void serializationHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }

        sb.append(root.val).append(",");
        serializationHelper(root.left, sb);
        serializationHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int idx;

    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] arr = data.split(",");
        return deserializehelper(arr);
    }

    private TreeNode deserializehelper(String[] arr) {
        if (arr[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        root.left = deserializehelper(arr);
        root.right = deserializehelper(arr);
        return root;
    }
}