package me.dawars.visualprogramming.tests;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.ConstantNode;
import me.dawars.visualprogramming.nodes.LerpNode;
import me.dawars.visualprogramming.nodes.MultiplyNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dawars on 11/28/16.
 */
public class LerpNodeTest {
    private LerpNode node;
    private ConstantNode a;
    private ConstantNode b;
    private ConstantNode t;

    @Before
    public void setUp() throws Exception {
        node = new LerpNode();
        a = new ConstantNode();
        b = new ConstantNode();

        t = new ConstantNode();

        Connection conn = new Connection(a.getOut(), node.getInA());
        a.setValue(2.);
        a.getOut().connect(conn);


        conn = new Connection(b.getOut(), node.getInB());
        b.setValue(5.);
        b.getOut().connect(conn);

        conn = new Connection(t.getOut(), node.getInT());
        t.getOut().connect(conn);

    }

    @Test
    public void execute() throws Exception {
        t.setValue(1.);
        node.execute();

        assertEquals(node.getOut().getValue(), b.getOut().getValue());

        t.setValue(0.);
        node.execute();

        assertEquals(node.getOut().getValue(), a.getOut().getValue());

        t.setValue(0.5);
        node.execute();

        Double a1 = (Double) a.getOut().getValue();
        Double b1 = (Double) b.getOut().getValue();
        assertEquals(node.getOut().getValue().doubleValue(), 0.5 * a1.doubleValue() + (0.5 *  b1.doubleValue()), 1e-5);

    }

    @After
    public void tearDown() throws Exception {

    }

}