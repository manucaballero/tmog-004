package org.tfoc;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static ListNode mergeTwoLists(
            ListNode list1,
            ListNode list2) {

        if(list1.val == null && list2.val == null){
            return new ListNode();
        }else if(list1.val == null){
            return list2;
        }else if(list2.val == null){
            return list1;
        }

        ListNode list2Pointer = list2;
        ListNode list1Pointer = list1;
        int listPos = 1;
        while (list2Pointer != null){
            ListNode nodeToInsert = new ListNode(list2Pointer.val);

            boolean inserted = false;
            while (!inserted && list1Pointer != null){

                if(list1Pointer.val >= nodeToInsert.val){
                    if(listPos == 1){

                        list1 = nodeToInsert;//Colocamos elemento al principio de la lista
                        list1.next = list1Pointer;
                    }else{

                        ListNode parent = obtainParent(list1, listPos);
                        nodeToInsert.next = parent.next;
                        parent.next = nodeToInsert;
                    }

                    inserted = true;
                    list1Pointer = obtainParent(list1, listPos); //El puntero pasa a ser el elemento recien insertado
                }

               if(!inserted){
                   list1Pointer = list1Pointer.next;
                   listPos++;
               }
            }

            //Colocamos el elemento al final de la lista
            if(!inserted) {

                ListNode lastElement = obtainParent(list1, listPos);
                lastElement.next = nodeToInsert;
                listPos++;
            }

            list2Pointer = list2Pointer.next;
        }

        return list1;
    }

    private static ListNode obtainParent(ListNode listNode, int childPos){

        ListNode result = listNode;
        for(int i = 0; i < childPos - 2; i++){
            result = result.next;
        }

        return result;
    }

}
