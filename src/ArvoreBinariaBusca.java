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
            if(no.valor.compareTo(raiz.getValor()) < 0){
                if(raiz.getFilhoEsquerdo() == null){
                    raiz.setFilhoEsquerdo(no);
                }else{
                    inserirRecursivo(no, raiz.getFilhoEsquerdo());
                }
            }else{
                if (raiz.getFilhoDireito() == null){
                     raiz.setFilhoDireito(no);
                }else{
                    inserirRecursivo(no, raiz.getFilhoDireito());
                }
            }
        }
    }


    // inacabado
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
                removerNoDireita(no);

            }else{
                removerRecursivo(no.filhoDireito, valor);
            }
        }
        return null;
    }

    @Override
    public No remover(Object v) throws Exception{

        if(raiz == null){
            throw new Exception("Sem valor para acessar!");
        }
        No atual = raiz;
        No pai = raiz;
        boolean filho_esq = true;

        while(atual.getValor() != v) {
            pai = atual;

            if (atual.getValor().compareTo(v) < 0) {

                atual = atual.getFilhoEsquerdo();
                filho_esq = true;

            } else {
                atual = atual.getFilhoDireito();
                filho_esq = false;
            }
            if (atual == null) {
                return null;
            }
        }
        if(atual.filhoEsquerdo == null && atual.filhoDireito == null){
            if(atual == raiz){
                raiz = null;

            }else if(filho_esq){
                pai.setFilhoEsquerdo(null);
            }else{
                pai.setFilhoDireito(null);
            }
        }else if(atual.getFilhoDireito() == null){
            if(atual == raiz){
                raiz = atual.getFilhoEsquerdo();

            }else if(filho_esq){
                pai.setFilhoEsquerdo(atual.getFilhoEsquerdo());

            }else{
                pai.setFilhoDireito(atual.getFilhoEsquerdo());
            }

        }else if(atual.getFilhoEsquerdo() == null){
            if(atual == raiz){
                raiz = atual.getFilhoDireito();

            }else if(filho_esq){
                pai.setFilhoEsquerdo( atual.getFilhoDireito());

            }else{
                pai.setFilhoDireito(atual.getFilhoDireito());
            }
        }else{
            No sucessor = no_sucessor(atual);

            if(atual == raiz){
                raiz = sucessor;
            }else if(filho_esq){
                pai.setFilhoEsquerdo(sucessor);
            }else{
                pai.setFilhoDireito(sucessor);
            }
            sucessor.setFilhoEsquerdo( atual.getFilhoEsquerdo());
        }
        return atual;
    }

    public No no_sucessor(No apaga){

        No paiDoSucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.getFilhoDireito();
        while(atual != null){

            paiDoSucessor = sucessor;
            sucessor = atual;
            atual = atual.getFilhoEsquerdo();
        }
        if(sucessor != apaga.getFilhoDireito()){
            paiDoSucessor.setFilhoEsquerdo(sucessor.getFilhoDireito());
            sucessor.setFilhoDireito(apaga.getFilhoDireito());
        }
        return sucessor;
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
    //inacabado
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
            //removerFilhosEsqDir();
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