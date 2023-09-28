public interface IArvore<T> {

    void inserir(T valor) throws Exception;
    void inserirRecursivo(No no, T valor);
    No remover(T valor) throws Exception;
    No removerRecursivo(No no, T valor) throws Exception;
    No buscar(No no) throws Exception;
    No visitar(No no) throws Exception;
    boolean estaVazia();
    boolean estaCompleta();
    int getAltura();
    // void imprimirArvore();
}
