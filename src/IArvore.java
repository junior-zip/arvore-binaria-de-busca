public interface IArvore<T> {

    void inserir(T valor) throws Exception;
    No remover(T valor) throws Exception;
    No buscar(No no, T valor) throws Exception;
    boolean estaVazia();
    boolean estaCompleta();
    int getAltura();
    // void imprimirArvore();
}
