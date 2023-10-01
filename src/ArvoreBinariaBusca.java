public class ArvoreBinariaBusca<T extends Comparable<T>> implements IArvoreBinaria {

    No<T> raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    @Override
    public void inserir(Object valor) throws Exception {

        /***
         * Metodo publico para a insercao de um valor na arvore
         * @exception Exception caso valor inserido seja nulo
         * @param valor recebe o valor a ser inserido na arvore
         */

        if (valor == null) throw new RuntimeException("Nao ha como inserir um valor nulo");

        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private No inserirRecursivo(No no, Object valor) {

        /**
         * Um Metodo privado recursiva para inserir um novo valor na arvore
         * @param no recebe o no a ser analizado e comparado com o valor a inserir
         * @param valor recebe o valor que sera incluido na arvore
         * @return o no atualizado com seu pai e filhos
         */

        if (no == null) {
            /** Se o no for igual a nulo */
            return new No((Comparable) valor);
        }

        if (no.getValor().compareTo(valor) > 0) {
            /** Se o valor do no for maior do que o valor inserido, vai pra esquerda */
            no.setFilhoEsquerdo(inserirRecursivo(no.getFilhoEsquerdo(), valor));

        } else if (no.getValor().compareTo(valor) < 0) {
            /** Se o valor do no for menor do que o valor inserido, vai pra direita */
            no.setFilhoDireito(inserirRecursivo(no.getFilhoDireito(), valor));
        }

        return no;
    }

    public No remover(Object valor) throws Exception {

        /***
         * Metodo publico para a remocao de um valor na arvore
         * @param valor recebe o valor a ser removido na arvore
         * @exception Exception caso valor inserido seja nulo
         * @return no removido da arvore
         */

        if (valor == null) throw new RuntimeException("Nao ha como remover um valor nulo");

        return removerRecursivo(this.raiz, valor);
    }

    private No removerRecursivo(No no, Object valor) {

        /**
         * Uma função recursiva para remover um valor na arvore, considerando que ha 3 casos
         * @param no recebe o no a ser analizado e comparado com o valor a remover
         * @param valor recebe o valor que sera removido na arvore
         */

        // Base case
        if (no == null)
            return no;

        // Recursive calls for ancestors of
        // No to be deleted
        if (no.getValor().compareTo(valor) > 0) {
            no.setFilhoEsquerdo(removerRecursivo(no.getFilhoEsquerdo(), valor));
            return no;
        } else if (no.getValor().compareTo(valor) < 0) {
            no.setFilhoDireito(removerRecursivo(no.getFilhoDireito(), valor));
            return no;
        }

        // We reach here when no is the No
        // to be deleted.

        // If one of the children is empty
        if (no.getFilhoEsquerdo() == null) {
            No temp = no.getFilhoDireito();
            return temp;
        } else if (no.getFilhoDireito() == null) {
            No temp = no.getFilhoEsquerdo();
            return temp;
        }

        // If both children exist
        else {

            No noAuxiliar = no;

            // Find successor
            No succ = no.getFilhoDireito();
            while (succ.getFilhoEsquerdo() != null) {
                noAuxiliar = succ;
                succ = succ.getFilhoEsquerdo();
            }

            // Delete successor.  Since successor
            // is always getFilhoEsquerdo() child of its parent
            // we can safely make successor's getFilhoDireito()
            // getFilhoDireito() child as getFilhoEsquerdo() of its parent.
            // If there is no succ, then assign
            // succ.getFilhoDireito() to noAuxiliar.getFilhoDireito()
            if (noAuxiliar != no)
                noAuxiliar.setFilhoEsquerdo(succ.getFilhoDireito());
            else
                noAuxiliar.setFilhoDireito(succ.getFilhoDireito());

            // Copy Successor Data to no
            no.valor = succ.valor;

            // Delete Successor and return no
            return no;
        }
    }

    @Override
    public boolean estaVazia() {
        /**
         * Retorna se a arvore esta vazia
         * @return true se houver um ou mais nos na arvore
         * @return false se nao houver elementos na arvore
         */
        return this.raiz == null;
    }

    @Override
    public boolean estaCompleta() {
        return false;
    }

    @Override
    public int getAltura() {
        return 0;
    }

    @Override
    public void preOrdem(No no) {

        /**
         * Metodo para percorrer a arvore em forma de pre-ordem (visitacao, esquerda, direita)
         * @param no recebe o no que sera analisado em pre-ordem
         */

        if (no == null) return;

        no.visitar();
        preOrdem(no.getFilhoEsquerdo());
        preOrdem(no.getFilhoDireito());
    }

    @Override
    public void emOrdem(No no) {

        /**
         * Metodo para percorrer a arvore em forma de em-ordem (esquerda, visitacao, direita)
         * @param no recebe o no que sera analisado em em-ordem
         */

        if (no == null) return;

        preOrdem(no.getFilhoEsquerdo());
        no.visitar();
        preOrdem(no.getFilhoDireito());
    }

    @Override
    public void posOrdem(No no) {

        /**
         * Metodo para percorrer a arvore em forma de pos-ordem (esquerda, direita, visitacao)
         * @param no recebe o no que sera analisado em pos-ordem
         */

        if (no == null) return;

        preOrdem(no.getFilhoEsquerdo());
        preOrdem(no.getFilhoDireito());
        no.visitar();
    }

    ////////////////////////////////////////////////////////
    public void preOrdem_(No no) {
        System.out.println(no.getValor());
        if(no.getFilhoEsquerdo() != null){
            preOrdem(no.getFilhoEsquerdo());
        }
        if(no.getFilhoDireito() != null){
            preOrdem(no.getFilhoDireito());
        }
    }

    public void emOrdem_(No no) {

        if(no.getFilhoEsquerdo() != null){
            emOrdem(no.getFilhoEsquerdo());
        }
        System.out.println(no.getValor());
        if(no.getFilhoDireito() != null){
            emOrdem(no.getFilhoDireito());
        }
    }

    public void posOrdem_(No no) {
        if(no.getFilhoDireito() != null){
            posOrdem(no.getFilhoEsquerdo());
        }
        if(no.getFilhoDireito() != null){
            posOrdem(no.getFilhoDireito());
        }
        System.out.println(no.getValor());
    }

    public void inserir_(No no, Object valor) throws Exception {
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo.");
        }

        if (raiz == null) {
            raiz = new No((Comparable) valor);
        } else {
            inserirRecursivo(raiz, valor);
        }
    }

    public void inserir_Recursivo(No atual, T valor) throws Exception {
        if (valor.compareTo((T) atual.getValor()) < 0) {
            if (atual.getFilhoEsquerdo() == null) {
                atual.setFilhoEsquerdo(new No(valor));
            } else {
                inserirRecursivo(atual.getFilhoEsquerdo(), valor);
            }
        } else {
            if (atual.getFilhoDireito() == null) {
                atual.setFilhoDireito(new No(valor));
            } else {
                inserirRecursivo(atual.getFilhoDireito(), valor);
            }
        }
    }

    public No buscar(No no, Object valor) throws Exception{
        No<T> ret;

        if(no == null){
            throw new Exception("Operação incapaz de ser realizada!");

        }else if(no.getValor() == valor){
            ret = (No<T>) no.getValor();

        }else{

            if(no.getValor().compareTo(valor) > 0){
                ret =  buscar(no.getFilhoEsquerdo(), valor);

            }else{
                ret = buscar(no.getFilhoDireito(), valor);
            }
        }
        return ret;
    }

    public No remover_(Object valor) throws Exception {
        if (raiz == null) {
            throw new Exception("Árvore vazia. Não é possível remover.");
        }

        raiz = removerRecursivo(raiz, valor);
        return raiz;
    }

    public No removerRecursivo(No<T> atual, T valor) throws Exception {
        if (atual == null) {
            throw new Exception("Expressão incapaz de ser realizada");
        }

        if (valor.compareTo(atual.getValor()) < 0) {
            atual.setFilhoEsquerdo(removerRecursivo(atual.getFilhoEsquerdo(), valor));
        } else if (valor.compareTo(atual.getValor()) > 0) {
            atual.setFilhoDireito(removerRecursivo(atual.getFilhoDireito(), valor));
        } else {
            if (atual.getFilhoEsquerdo() == null) {
                return atual.getFilhoDireito();
            } else if (atual.getFilhoDireito() == null) {
                return atual.getFilhoEsquerdo();
            }

            atual.setValor((T) encontrarMenorValor(atual.getFilhoDireito()));
            atual.setFilhoDireito(removerRecursivo(atual.getFilhoDireito(), atual.getValor()));
        }

        return atual;
    }

    private T encontrarMenorValor(No<T> atual) {
        T menorValor = atual.getValor();
        while (atual.getFilhoEsquerdo() != null) {
            menorValor = (T) atual.getFilhoEsquerdo().getValor();
            atual = atual.getFilhoEsquerdo();
        }
        return menorValor;
    }
}