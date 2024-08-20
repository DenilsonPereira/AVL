package app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Teste {
	//1-inserções simples que não requeiram balanceamento (0,5)
	@Test
	void test() {
	@SuppressWarnings("rawtypes")
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(1);
	avl.insere(12);
	avl.insere(20);
	assertEquals("10(0)5(1)1(0)16(0)12(0)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	//2-remoção de nó sem filhos (0,5)
	@Test
	void test2() {
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(1);
	avl.insere(12);
	avl.insere(20);
	avl.remove(12);
	assertEquals("10(0)5(1)1(0)16(-1)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	//3-remoção de nó com 1 filho à direita (0,5)
	@Test
	void test3() {
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(7);
	avl.insere(12);
	avl.insere(20);
	avl.remove(5);
	assertEquals("10(-1)7(0)16(0)12(0)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	//4-remoção de nó com 1 filho à esquerda (0,5)
	@Test
	void test4() {
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(1);
	avl.insere(12);
	avl.insere(20);
	avl.remove(5);
	assertEquals("10(-1)1(0)16(0)12(0)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}

	//5-remoção de nó com 2 filhos, e que seja um filho à direita (0,5)
	@Test
	void test5() {
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(1);
	avl.insere(12);
	avl.insere(20);
	avl.remove(16);
	assertEquals("10(0)5(1)1(0)20(1)12(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test6() {
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(1);
	avl.insere(12);
	avl.insere(6);
	avl.remove(5);
	assertEquals("10(0)6(1)1(0)16(1)12(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test7() {
	AVL avl = new AVL(10);
	avl.insere(5);
	avl.insere(16);
	avl.insere(2);
	avl.insere(12);
	avl.insere(1);
	assertEquals("10(0)2(0)1(0)5(0)16(1)12(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test8() {
		AVL avl = new AVL(6);
		avl.insere(8);
		avl.insere(12);
		
		assertEquals("8(0)6(0)12(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test9() {
		AVL avl = new AVL(10);
		avl.insere(6);
		avl.insere(12);
		avl.insere(11);
		avl.insere(14);
		avl.remove(6);
		
		assertEquals("12(1)10(-1)11(0)14(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	
	}
	
	@Test
	void test10() {
		AVL avl = new AVL(6);
		avl.insere(8);
		avl.insere(7);
		
		assertEquals("7(0)6(0)8(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	
	}
	
	@Test
	void test11() {
		AVL avl = new AVL(6);
		avl.insere(3);
		avl.insere(5);
		
		assertEquals("5(0)3(0)6(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	
	}
	
	@Test
	void test12() {
		AVL avl = new AVL(10);
		avl.insere(6);
		avl.insere(14);
		avl.insere(2);
		avl.insere(8);
		avl.remove(14);
		
		assertEquals("6(-1)2(0)10(1)8(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test13() {
		AVL avl = new AVL(8);
		avl.insere(6);
		avl.insere(2);
		
		assertEquals("6(0)2(0)8(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test14() {
		AVL avl = new AVL(8);
		avl.insere(6);
		avl.insere(2);
		
		assertEquals("6(0)2(0)8(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test15() {
		AVL avl = new AVL(70);
		avl.insere(80);
		avl.insere(75);
		
		assertEquals("75(0)70(0)80(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test16() {
		AVL avl = new AVL(10);
		avl.insere(5);
		avl.insere(6);
		avl.remove(10);
		avl.remove(6);
		avl.remove(5);
		avl.insere(10);
		avl.insere(5);
		avl.insere(6);
		
		assertEquals("6(0)5(0)10(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test17() {
		AVL avl = new AVL(10);
		avl.insere(5);
		avl.insere(12);
		avl.insere(7);
		avl.insere(6);
		avl.remove(12);
		
		assertEquals("6(-1)5(0)10(1)7(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test18() {
		AVL avl = new AVL(10);
		avl.insere(5);
		avl.insere(16);
		avl.remove(10);
		avl.remove(5);
		avl.remove(16);
		avl.insere(100);
		avl.insere(50);
		avl.insere(150);
		assertEquals("100(0)50(0)150(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
	void test19() {
		AVL avl = new AVL(10);
		avl.insere(5);
		avl.insere(16);
		avl.insere(1);
		avl.insere(7);
		avl.insere(13);
		avl.insere(20);
		avl.insere(8);
		avl.insere(22);
		avl.insere(9);
		avl.remove(1);
		assertEquals("10(0)8(1)5(-1)7(0)9(0)16(-1)13(0)20(-1)22(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
	}
	
	@Test
    void test20() {
                    
            AVL avl = new AVL(10);
            avl.insere(5);
            avl.insere(16);
            avl.insere(1);
            avl.insere(8);
            avl.insere(20);
            avl.insere(22);
            assertEquals("10(0)5(0)1(0)8(0)20(0)16(0)22(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
    }
	
	@Test
    void test21() {
                    
            AVL avl = new AVL(10);
            avl.insere(5);
            avl.insere(16);
            avl.insere(1);
            avl.insere(12);
            avl.insere(20);
            avl.insere(0);
            assertEquals("10(0)1(0)0(0)5(0)16(0)12(0)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
    }

	@Test
    void test22() {
                    
            AVL avl = new AVL(10);
            avl.insere(5);
            avl.insere(16);
            avl.insere(1);
            avl.insere(7);
            avl.insere(12);
            avl.insere(20);
            avl.insere(6);
            avl.remove(5);
            assertEquals("10(0)6(0)1(0)7(0)16(0)12(0)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
    }

}