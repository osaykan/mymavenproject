package gurbetriview;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day08JUnitAnnotations {
    @Before
    public void before(){
        System.out.println("Before methodu basariyla olusturuldu");

    }

    @Test
    public void test1(){
        System.out.println("test 1 basariyla olusturuldu");

    }
    @Test
    public void test2(){
        System.out.println("test 2 basariyla olusturuldu");

    }
    @Ignore
    @Test
    public void test3(){
        System.out.println("test 3 basariyla olusturuldu");

    }
    @After
    public void after(){
        System.out.println("After methodu basariyla olusturuldu");

    }

}
