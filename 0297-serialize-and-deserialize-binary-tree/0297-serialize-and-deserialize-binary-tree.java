public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }
    int idx;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;
        return build(arr);
    }
    private TreeNode build(String[] arr){
        if(arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = build(arr);
        root.right = build(arr);
        return root;
    }
}