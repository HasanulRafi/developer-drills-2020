// leet 100

//ITERATIVE 100% faster and 100% less memory on leet
public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pOrder = postOrder(p);
        Stack<TreeNode> qOrder = postOrder(q);

         if(pOrder.size() != qOrder.size()) return false;

         Iterator<TreeNode> iterator = pOrder.iterator();
         Iterator<TreeNode> iterator2 = qOrder.iterator();
         while(iterator.hasNext()){
             TreeNode pn = iterator.next();
             TreeNode qn = iterator2.next();
             if((pn == null && qn != null) ||
                (qn == null && pn != null) ||
                ((pn != null && qn != null) &&
                pn.val != qn.val))
                 return false;
         }
         return true;
     }

     public Stack<TreeNode> postOrder(TreeNode root){
         Stack<TreeNode> stack1 = new Stack<>(),
         stack2 = new Stack<>();
         stack1.push(root);

         while(!stack1.isEmpty()){
             TreeNode curr = stack1.pop();
             stack2.push(curr);

             if(curr != null) {
             stack1.push(curr.right);
              stack1.push(curr.left);
             }
         }
         return stack2;
     }
