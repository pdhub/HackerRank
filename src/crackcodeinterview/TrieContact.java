package crackcodeinterview;

public class TrieContact {
    static class TrieNode {
        Character character;
        TrieNode[] nodes = new TrieNode[26];
        boolean isLeaf = false;
        int count = 0;

        public TrieNode(Character character) {
            this.character = character;
        }
    }

    public void trieOperation(String operation, String contact,  TrieNode root){
        if (operation.equalsIgnoreCase("add"))
            addToNode(contact, root);
        else if (operation.equalsIgnoreCase("find"))
            findContact(contact, root);
    }

    private void addToNode(String contact, TrieNode root) {
        for (int i = 0; i < contact.length(); i++) {
            Character c = contact.charAt(i);
            if (root.nodes[c - 'a']==null)
            {
                root.nodes[c - 'a'] = new TrieNode(c);
            }
            root = root.nodes[c - 'a'];
            root.count++;
        }
        root.isLeaf = true;
    }

    private void findContact(String contact, TrieNode root) {
        if (root == null){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < contact.length(); i++) {
            Character c = contact.charAt(i);
            if (root!= null && root.nodes[c - 'a'] == null){
                System.out.println(0);
                return;
            }
            else
                root = root.nodes[c - 'a'];
        }
        System.out.println(root.count);
    }

    public static void main(String[] args) {
        String input = "add hack\n" +
                "add hackerrank\n" +
                "find hac\n" +
                "find hak";
        String[] ops = input.split("\n");

        TrieContact tc = new TrieContact();

        TrieNode root = new TrieNode(' ');
        for (int i = 0; i < ops.length; i++) {
            String[] curr = ops[i].split(" ");
            String o = curr[0];
            String c = curr[1];
            tc.trieOperation(o, c, root);
        }
    }
}
