public interface INo<T> extends Comparable<T> {

    void setValor(T valor);
    void setPai(No no);
    void setFilhoEsquerdo(No no);
    void setFilhoDireito(No no);
    int getValor();
    No getPai();
    No getFilhoEsquerdo();
    No getFilhoDireito();
}
