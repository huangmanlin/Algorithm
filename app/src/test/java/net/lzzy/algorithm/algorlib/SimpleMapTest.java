package net.lzzy.algorithm.algorlib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */


import static org.junit.Assert.*;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class SimpleMapTest {


    @Test
    public void iterateRangrFirst() {
        SimpleMap map=new SimpleMap(6);
        map.addEdge(0,1,1);
        map.addEdge(1,5,1);
        map.addEdge(0,2,1);
        map.addEdge(0,3,1);
        map.addEdge(3,4,1);
        String expected="015234";
        assertEquals(expected,map.iterateDEpthFirst());
    }
    @Test
    public void TextIterateDepthFirst() {
        SimpleMap map=new SimpleMap(6);
        map.addEdge(0,1,1);
        map.addEdge(1,5,1);
        map.addEdge(0,2,1);
        map.addEdge(0,3,1);
        map.addEdge(3,4,1);
        String Expected="015234";
        assertEquals(Expected,map.iterateDEpthFirst());
    }
}

