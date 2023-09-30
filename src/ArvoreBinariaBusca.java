public class ArvoreBinariaBusca<T extends Comparable<T>> implements IArvoreBinaria {

    No<T> raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void inserir(No no, Object valor) throws Exception {
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo.");
        }

        if (raiz == null) {
            raiz = new No((Comparable) valor);
        } else {
            inserirRecursivo(raiz, valor);
        }
    }


    public void inserirRecursivo(No atual, T valor) throws Exception {
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


    @Override
    public void inserir(Object valor) throws Exception {

    }

    @Override
    public void inserirRecursivo(No no, Object valor) {

    }

    public No remover(Object valor) throws Exception {
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


    @Override
    public No removerRecursivo(No no, Object valor) throws Exception {
        return null;
    }


    //---------------------------------


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






    @Override
    public No visitar(No no) throws Exception {
        return null;
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
        System.out.println(no.valor);
        if(no.filhoEsquerdo != null){
            preOrdem(no.filhoEsquerdo);
        }
        if(no.filhoDireito != null){
            preOrdem(no.filhoDireito);
        }
    }

    @Override
    public void emOrdem(No no) {

        if(no.filhoEsquerdo != null){
            emOrdem(no.filhoEsquerdo);
        }
        System.out.println(no.valor);
        if(no.filhoDireito != null){
            emOrdem(no.filhoDireito);
        }
    }

    @Override
    public void posOrdem(No no) {
        if(no.filhoEsquerdo != null){
            posOrdem(no.filhoEsquerdo);
        }
        if(no.filhoDireito != null){
            posOrdem(no.filhoDireito);
        }
        System.out.println(no.valor);
    }
}