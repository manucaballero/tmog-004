package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTestV1 {

    @Test
    void testSolutionExample1() {
        ListNode param1First = new ListNode(1);
        ListNode param1Second = new ListNode(2);
        ListNode param1Third = new ListNode(4);
        param1First.next = param1Second;
        param1Second.next = param1Third;

        ListNode param2First = new ListNode(1);
        ListNode param2Second = new ListNode(3);
        ListNode param2Third = new ListNode(4);
        param2First.next = param2Second;
        param2Second.next = param2Third;

        ListNode result = Solution.mergeTwoLists(param1First,param2First);

        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(4, result.next.next.next.next.next.val);
    }

    @Test
    void testSolutionExample2() {
        //Ojo a los que no hayan cambiado de int a Integer, que val no va a ser nulo va a ser 0
        ListNode result = Solution.mergeTwoLists(new ListNode(), new ListNode());

        assertNotNull(result);
        assertNull(result.val);
    }

    @Test
    void testSolutionExample3() {

        ListNode param2First = new ListNode(0);

        ListNode result = Solution.mergeTwoLists(new ListNode(), param2First);

        assertNotNull(result);
        assertEquals(0, result.val);
        assertNull(result.next);
    }

    @Test
    void testSolutionCustom1() {

        ListNode param1First = new ListNode(1);
        ListNode param1Second = new ListNode(1);
        ListNode param1Third = new ListNode(4);
        param1First.next = param1Second;
        param1Second.next = param1Third;

        ListNode param2First = new ListNode(1);
        ListNode param2Second = new ListNode(3);
        ListNode param2Third = new ListNode(3);
        param2First.next = param2Second;
        param2Second.next = param2Third;

        ListNode result = Solution.mergeTwoLists(param1First,param2First);

        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(3, result.next.next.next.next.val);
        assertEquals(4, result.next.next.next.next.next.val);

    }

    @Test
    void testSolutionCustom2() {

        ListNode param1First = new ListNode(3);

        ListNode param2First = new ListNode(1);
        param2First.next = new ListNode(2);

        ListNode result = Solution.mergeTwoLists(param1First,param2First);

        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);

    }

    @Test
    void testSolutionCustom3() {

        ListNode param1First = new ListNode(1);

        ListNode param2First = new ListNode(2);
        param2First.next = new ListNode(3);

        ListNode result = Solution.mergeTwoLists(param1First,param2First);

        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);

    }

}