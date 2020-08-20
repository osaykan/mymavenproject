package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day08JUnitAnnotations {    //Buradan run yapinca alttaki her test'i yazdirir.
    //Bir JUnit projesinde testi calistirmak icin @Test annotation'i kullanilir.

    @Before     //Her testten önce calisir
    public void runBeforeTest(){
        System.out.println("@Before=> run before test");
    }




    @Test                      //Kirmizi durumunu kaldirmak icin mvnrepository.com git ve JUnit yaz.Al getir poma
                            //@Test test caseleri main method olmadan calistirmamizi saglar.
    public void test1(){     //Buradaki run'a basilirsa sadece test1 calisir
        System.out.println("Test1'i yazdir");//Test1'i yazdir ve sol yanda #test1 yesil renkli tik var.Basarili anlami var

    }

       //@Before         //Hepsinden önce(her testin önünde) test2 calisir=>test2 test1, test2 test2, test2 test3 gibi
      @Test        //@Test olmasaydi test2 test1, test2 test3  yazilirdi.  test2 test2 olmazdi
    public void test2(){
        System.out.println("Test2'yi yazdir");
    }
        @Ignore   //test3 okunmayacak
    @Test
    public void test3(){
        System.out.println("Test3'ü yazdir");
    }
    @After      //Her testen sonra yazar
    public void runAfterTest(){
        System.out.println("@After => run after test");
    }

}
