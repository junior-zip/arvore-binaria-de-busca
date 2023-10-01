public class No<T extends Comparable<T>> implements INo<T> {

    T valor;
    No<T> filhoEsquerdo;
    No<T> filhoDireito;
    No<T> pai;

    public No(T valor){
        this.valor = valor;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

    @Override
    public void setValor(T valor) {
        this.valor = valor;
    }
    @Override
    public void setPai(No no) {
        this.pai = no;
    }

    @Override
    public void setFilhoEsquerdo(No no) {
        this.filhoEsquerdo = no;
    }

    @Override
    public void setFilhoDireito(No no) {
        this.filhoDireito = no;
    }

    @Override
    public T getValor() {
        return this.valor;
    }

    @Override
    public No getPai() {
        return this.pai;
    }

    @Override
    public No getFilhoEsquerdo() {
        return this.filhoEsquerdo;
    }

    @Override
    public No getFilhoDireito() {
        return filhoDireito;
    }
    public void visitar() {
        System.out.print(this.getValor() + " - ");
    }
}
