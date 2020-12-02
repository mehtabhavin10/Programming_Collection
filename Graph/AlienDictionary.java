// https://practice.geeksforgeeks.org/problems/alien-dictionary/1

//User function Template for Java

/*
dict : array of strings denoting the words in alien langauge
N : Size of the dictionary
K : Number of characters
*/
class Solution {
    public String findOrder(String [] dict, int N, int K) {
        // Write your code here

        Node[] node = new Node[K];
        int[] inDeg = new int[K];


        for (int i = 0; i < K; i++) node[i] = new Node((char)(i + 'a'));

        for (int i = 1; i < N; i++) {

            int len = Math.min(dict[i].length(), dict[i - 1].length());

            for (int j = 0; j < len; j++) {

                char a = dict[i].charAt(j);
                char b = dict[i - 1].charAt(j);

                if (a != b) {

                    node[a - 'a'].addAdj(node[b - 'a']);
                    inDeg[b - 'a']++;
                    break;
                }
            }
        }


        StringBuilder op = new StringBuilder();
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < K; i++) if (inDeg[i] == 0) q.add(node[i]);

        while (!q.isEmpty()) {

            Node curr = q.remove();
            op.append(curr.val);

            for (Node n : curr.adj)
                if (--inDeg[n.val - 'a'] == 0) q.add(n);
        }

        return op.toString();
    }
}

class Node {

    char val;
    List<Node> adj;

    Node(char v) {
        val = v;
        adj = new ArrayList<>();
    }

    void addAdj(Node n) {
        adj.add(n);
    }
}