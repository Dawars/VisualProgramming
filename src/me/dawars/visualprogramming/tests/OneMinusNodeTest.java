package me.dawars.visualprogramming.tests;

import me.dawars.visualprogramming.nodes.AbsNode;
import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.ConstantNode;
import me.dawars.visualprogramming.nodes.OneMinusNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dawars on 11/28/16.
 */
public class OneMinusNodeTest {
    private OneMinusNode node;
    private ConstantNode a;

    @Before
    public void setUp() throws Exception {
        node = new OneMinusNode();
        a = new ConstantNode();
        Connection conn = new Connection(a.getOut(), node.getIn());
        a.getOut().connect(conn);
    }

    @Test
    public void testMinus() throws Exception {
        a.setValue(-1.);

        node.execute();

        assertEquals(node.getOut().getValue(), (Double) 2.);
    }

    @Test
    public void testPlus() throws Exception {
        a.setValue(2.);

        node.execute();

        assertEquals(node.getOut().getValue(), (Double) (-1.));
    }

    @Test
    public void testNull() throws Exception {
        a.setValue(0.);

        node.execute();

        assertEquals(node.getOut().getValue(), (Double) 0.);
    }

    @After
    public void tearDown() throws Exception {

    }

}