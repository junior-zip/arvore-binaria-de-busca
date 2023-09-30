public class ArvoreBinariaBusca<T extends Comparable<T>> implements IArvoreBinaria {

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
        if(raiz == null){
            raiz = no;
        }else{
            if(no.valor.compareTo(raiz.valor) < 0){
                if(raiz.filhoEsquerdo == null){
                    raiz.filhoEsquerdo = no;
                }else{
                    inserirRecursivo(no, raiz.filhoEsquerdo);
                }
            }else{
                if (raiz.filhoDireito == null){
                    raiz.filhoDireito = no;
                }else{
                    inserirRecursivo(no, raiz.filhoDireito);
                }
            }
        }
    }





    @Override
    public No remover(Object valor) throws Exception {
        return null;
    }

    @Override
    public No removerRecursivo(No no, Object valor) throws Exception {
        if(no.valor == valor){
            no = null;

        }else if(no.valor.compareTo(valor) > 0){

            if(no.filhoEsquerdo.valor.equals(valor)){

            }else{
                removerRecursivo(no.filhoEsquerdo, valor);
            }

        }else{
            if(no.filhoDireito.valor.equals(valor)){


            }else{
                removerRecursivo(no.filhoDireito, valor);
            }
        }

        return null;
    }

    @Override
    public No buscar(No no) throws Exception {
        return null;
    }
    //--------------------------------------

    public boolean buscaNo(No<T> arvore, T valor){
        boolean ret = false;

        if(arvore == null){
            ret = false;

        }else if(arvore.valor == valor){
            ret = true;

        }else{
            if(arvore.valor.compareTo(valor) > 0){
                ret =  buscaNo(arvore.filhoEsquerdo, valor);

            }else{
                ret = buscaNo(arvore.filhoDireito, valor);
            }
        }

        return ret;
    }

    // -----
    //Auxiliar
    public int totalFilhos(No<T> no){
        // 0 sem filhos | 1 só filho esquerda | 2 só filho direita | 3 filhos nos dois
        int total = 0;

        if(no.filhoEsquerdo != null){
            total += 1;
        }
        if(no.filhoDireito != null){
            total += 2;

        }
        return total;
    }
    //----------------

    public void removerSemFilhos(No<T> no, T subArvore){
        if(subArvore.equals("E")){
            no.filhoEsquerdo = null;

        }else{
            no.filhoDireito = null;

        }
    }
    //----------
    public void removerNoDireita(No<T> noPai){
        int filhos = 0;
        No<T> noRemover = null;
        noRemover = noPai.filhoDireito;
        filhos = totalFilhos(noRemover);
        if(filhos == 0){
            removerSemFilhos(noPai, (T) "D");
        }else if(filhos == 1){
            removerFilhosDireita(noPai, "E");

        }else if(filhos ==1 ){
            removerFilhosDireita(noPai, "D");


        }else if(filhos == 3){

        }


    }

    //-------------
    public void removerFilhosDireita(No<T> noPai, String subarvore){
        if(subarvore.equals("E")){
            noPai.filhoDireito = noPai.filhoDireito.filhoEsquerdo;
        }else{
            noPai.filhoDireito = noPai.filhoDireito.filhoDireito;
        }

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
