public interface INo<T> {

    void setValor(T valor);
    void setPai(No no);
    void setFilhoEsquerdo(No no);
    void setFilhoDireito(No no);
    void visitar();
    Object getValor();
    No getPai();
    No getFilhoEsquerdo();
    No getFilhoDireito();
}
