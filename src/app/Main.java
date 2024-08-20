package app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL arvore = new AVL(5);
		
		arvore.insere(3);
		arvore.insere(7);
		arvore.insere(2);
		arvore.insere(4);
		arvore.insere(6);
		arvore.insere(8);
		
		System.out.println("Árvore em pré-ordem: " + arvore.preOrdem());
		
		arvore.remove(7);
		
		System.out.println("Árvore em pré-ordem: " + arvore.preOrdem());
		
	}

}
