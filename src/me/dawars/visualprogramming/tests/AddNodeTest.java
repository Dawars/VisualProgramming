package me.dawars.visualprogramming.tests;

import me.dawars.visualprogramming.nodes.AddNode;
import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.ConstantNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dawars on 11/28/16.
 */
public class AddNodeTest {
    private AddNode node;
    private ConstantNode a;
    private ConstantNode b;

    @Before
    public void setUp() throws Exception {
        node = new AddNode();
        a = new ConstantNode();
        b = new ConstantNode();

        a.setValue(1.);

        Connection conn = new Connection(a.getOut(), node.getInA());
        a.getOut().connect(conn);


        conn = new Connection(b.getOut(), node.getInB());
        b.setValue(5.);
        b.getOut().connect(conn);

    }

    @Test
    public void execute() throws Exception {
        node.execute();

        assertEquals(node.getOut().getValue(), (Double) 6.);
    }

    @After
    public void tearDown() throws Exception {

    }

}