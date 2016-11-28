package me.dawars.visualprogramming.tests;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.ConstantNode;
import me.dawars.visualprogramming.nodes.CosNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dawars on 11/28/16.
 */
public class CosMinusNodeTest {
    private CosNode node;
    private ConstantNode a;

    @Before
    public void setUp() throws Exception {
        node = new CosNode();
        a = new ConstantNode();
        Connection conn = new Connection(a.getOut(), node.getIn());
        a.getOut().connect(conn);
    }

    @Test
    public void testCos() throws Exception {
        a.setValue(-1.);

        node.execute();

        assertEquals(node.getOut().getValue(), (Double) Math.cos(-1));
    }


    @After
    public void tearDown() throws Exception {

    }

}