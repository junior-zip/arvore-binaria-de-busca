public class ArvoreBinariaBusca<T> implements IArvoreBinaria {

    No<T> raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    @Override
    public void inserir(Object valor) throws Exception {
        System.out.println(valor);
    }

    @Override
    public void inserirRecursivo(No no, Object valor) {
        /**
         * Adiciona recursivamente dentro da arvore baseada no valor recebido por parametro
         * @param no recebe o no que sera comparado o valor
         * @param valor recebe o valor que sera incluido na arvore em um no
         */

        if (no.compareTo(valor) > 0) {
            //
        } else if (no.compareTo(valor) < 0){
            //
        }
    }

    @Override
    public No remover(Object valor) throws Exception {
        return null;
    }

    @Override
    public No removerRecursivo(No no, Object valor) throws Exception {
        return null;
    }

    @Override
    public No buscar(No no) throws Exception {
        return null;
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

    }

    @Override
    public void emOrdem(No no) {

    }

    @Override
    public void posOrdem(No no) {

    }

}
