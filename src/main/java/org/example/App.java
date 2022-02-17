package org.example;

import org.example.graph.Node;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PathFinder<String> pathFinder = new PathFinder<>();
        Node<String> a;
        String goal;

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

        pathFinder.exploreBFS(a, "H");

    }


}


