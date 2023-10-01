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

    @Override
    public No buscar(No no, Object valor) throws Exception {

        /**
         * Metodo para buscar se o valor e existente dentro da arvore
         * @param no recebe o no que sera comparado com o valor
         * @param valor recebe o valor que tentara ser encontrado dentro da arvore
         * @exception Exception caso o valor inserido seja nulo
         * @return o no caso seja achado, caso nao, retorna null
         */

        if (valor == null) throw new RuntimeException("Nao ha como buscar um valor nulo");

        /** Se o valor do no seja nulo ou o valor seja achado no nó */
        if (no == null || no.getValor() == valor) {
            return no;
        }

        if (no.getValor().compareTo(valor) > 0) {
            /** Se o valor do no for maior do que o valor inserido, vai pra esquerda */
            return buscar(no.getFilhoEsquerdo(), valor);
        }

        /** Se o valor do no for menor do que o valor inserido, vai pra direita */
        return buscar(no.getFilhoDireito(), valor);
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

        /** Se o no for igual a nulo */
        if (no == null) return no;

        /** CASO 1: Se o nao houver nenhum nó filho */
        if (no.getValor().compareTo(valor) > 0) {
            no.setFilhoEsquerdo(removerRecursivo(no.getFilhoEsquerdo(), valor));
            return no;
        } else if (no.getValor().compareTo(valor) < 0) {
            no.setFilhoDireito(removerRecursivo(no.getFilhoDireito(), valor));
            return no;
        }

        /** CASO 2: Se houver um nó filho */
        if (no.getFilhoEsquerdo() == null) {
            No temp = no.getFilhoDireito();
            return temp;
        } else if (no.getFilhoDireito() == null) {
            No temp = no.getFilhoEsquerdo();
            return temp;
        }

        /** CASO 3: Se houver dois nós filho */
        else {
            No noAuxiliar = no;

            No noSucessor = no.getFilhoDireito();
            while (noSucessor.getFilhoEsquerdo() != null) {
                noAuxiliar = noSucessor;
                noSucessor = noSucessor.getFilhoEsquerdo();
            }
            if (noAuxiliar != no)
                noAuxiliar.setFilhoEsquerdo(noSucessor.getFilhoDireito());
            else
                noAuxiliar.setFilhoDireito(noSucessor.getFilhoDireito());

            no.valor = noSucessor.valor;
            
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
}