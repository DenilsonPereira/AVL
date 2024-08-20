package app;

public class AVL {
	private No raiz;
	
	public AVL(int info) {
		raiz = new No(info);
	}
	
	public void insere(int info) {
		raiz = insereNo(raiz, info);
	}
	
	private No insereNo(No aux, int info) {
		if(aux == null) {
			aux = new No(info);
		}else if(info < aux.info) {
			aux.esq = insereNo(aux.esq, info);
			if(altura(aux.esq) - altura(aux.dir) == 2) {
				if(info < aux.esq.info)
					aux = rotacaoDireita(aux);
				else
					aux = duplaRotacaoEsquerda(aux);
			}
		}else if(info > aux.info) {
			aux.dir = insereNo(aux.dir, info);
			if(altura(aux.dir) - altura(aux.esq) == 2) {
				if(info > aux.dir.info)
					aux = rotacaoEsquerda(aux);
				else
					aux = duplaRotacaoDireita(aux);
			}
		}
		aux.alte = Math.max(altura(aux.esq), altura(aux.dir))+1;
		aux.altd = Math.max(altura(aux.dir), altura(aux.esq))+1;
		return aux;
	}
	
	public void remove(int info) {
		raiz = removeNo(raiz, info);
	}
	
	private No removeNo(No aux, int info) {
		if(aux == null)
			return null;
		if(info < aux.info) {
			aux.esq = removeNo(aux.esq, info);
		}else if(info > aux.info) {
			aux.dir = removeNo(aux.dir, info);
		}else {
			if(aux.esq == null ||aux.dir == null) {
				if(aux.esq == null)
					aux = aux.dir;
				else
					aux = aux.esq;
			}else {
				No temp = minValor(aux.dir);
				aux.info = temp.info;
				aux.dir = removeNo(aux.dir, temp.info);
			}
		}
		if(aux == null)
			return null;
		aux.alte = Math.max(altura(aux.esq), altura(aux.dir))+1;
		aux.altd = Math.max(altura(aux.dir), altura(aux.esq))+1;
		
		int balanco = altura(aux.esq) - altura(aux.dir);
		if(balanco > 1) {
			if(altura(aux.esq.esq) >= altura(aux.esq.dir))
				aux = rotacaoDireita(aux);
			else
				aux = duplaRotacaoEsquerda(aux);
		}else if(balanco < -1) {
			if(altura(aux.dir.dir) >= altura(aux.dir.esq))
				aux = rotacaoEsquerda(aux);
			else
				aux = duplaRotacaoDireita(aux);
		}
		return aux;
	}
	
	private No minValor(No aux) {
		No atual = aux;
		while (atual.esq != null)
			atual = atual.esq;
		return atual;
	}
	
	private int altura(No aux) {
		if(aux==null)
			return -1;
		return Math.max(altura(aux.esq), altura(aux.dir))+1;
	}
	
	private No rotacaoEsquerda(No aux) {
		No aux1 = aux.dir;
		aux.dir = aux1.esq;
		aux1.esq = aux;
		aux.alte = Math.max(altura(aux.esq), altura(aux.dir))+1;
		aux1.altd = Math.max(altura(aux1.dir), aux.alte) +1;
		return aux1;
	}
	
	private No rotacaoDireita(No aux) {
		No aux1 = aux.esq;
		aux.esq = aux1.dir;
		aux1.dir = aux;
		aux.altd = Math.max(altura(aux.dir), altura(aux.esq))+1;
		aux1.alte = Math.max(altura(aux1.esq), aux.altd)+1;
		return aux1;
	}
	
	private No duplaRotacaoEsquerda(No aux) {
	    if (aux != null && aux.esq != null && aux.esq.dir != null) {
	        aux.esq = rotacaoEsquerda(aux.esq);
	        return rotacaoDireita(aux);
	    }
	    return aux;
	}
	
	private No duplaRotacaoDireita(No aux) {
	    if (aux != null && aux.dir != null && aux.dir.esq != null) {
	        aux.dir = rotacaoDireita(aux.dir);
	        return rotacaoEsquerda(aux);
	    }
	    return aux;
	}
	
	public String preOrdem() {
		StringBuilder msg = new StringBuilder();
		preOrdem(raiz, msg);
		return msg.toString();
	}
	
	private void preOrdem(No aux, StringBuilder msg) {
		if(aux != null) {
			msg.append(aux.info + "(" + (altura(aux.esq)-altura(aux.dir)) + ")" );
			preOrdem(aux.esq, msg);
			preOrdem(aux.dir, msg);
		}
	}
}
