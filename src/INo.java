public interface INo<T> extends Comparable<T> {

    void setValor(T valor);
    void setPai(No no);
    void setFilhoEsquerdo(No no);
    void setFilhoDireito(No no);
    Object getValor();
    No getPai();
    No getFilhoEsquerdo();
    No getFilhoDireito();
}
