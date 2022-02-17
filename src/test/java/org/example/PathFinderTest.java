package org.example;

import org.example.graph.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PathFinderTest {

    PathFinder<String> pathFinder = new PathFinder<>();
    Node<String> a;
    String goal;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void init(){
        pathFinder = new PathFinder<>();

        a = new Node<String>("A");
        var b = new Node<String>("B");
        var c = new Node<String>("C");
        var d = new Node<String>("D");
        var e = new Node<String>("E");
        var f = new Node<String>("F");
        var g = new Node<String>("G");
        var h = new Node<String>("H");
        var i = new Node<String>("I");

        a.connect(b);
        b.connect(c);
        c.connect(f);
        a.connect(d);
        a.connect(e);
        b.connect(e);
        d.connect(g);
        e.connect(g);
        g.connect(h);
        h.connect(i);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void start(){
        System.out.print("Al menos compila");
        assertEquals("Al menos compila", outContent.toString());
    }

    @Test
    void regularDFS(){

        var finalPath = pathFinder.exploreDFS(a, "H");
        assertEquals("A->B->E->G->H", finalPath);
    }

    @Test
    void closedSetDFS(){
        pathFinder.exploreDFS(a, "H");
        assertEquals("ABCFEGDH", outContent.toString());
    }

    @Test
    void regularBFS(){
        var finalPath = pathFinder.exploreBFS(a, "H");
        assertEquals("A->D->G->H", finalPath);
    }

    @Test
    void closedSetBFS(){
        pathFinder.exploreBFS(a, "H");
        assertEquals("ABDECGFH", outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.out.println(outContent.toString());
    }
}
