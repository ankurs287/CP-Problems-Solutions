
    public static void printTree(Node tmpRoot) {

        Queue<Node> current = new LinkedList<Node>();
        Queue<Node> next = new LinkedList<Node>();

        current.add(tmpRoot);

        while (!current.isEmpty()) {
            Iterator<Node> iter = current.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.left != null) {
                    next.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    next.add(currentNode.right);
                }
                System.out.print(currentNode.data + " ");
            }
            System.out.println();
            current = next;
            next = new LinkedList<Node>();

        }

    }