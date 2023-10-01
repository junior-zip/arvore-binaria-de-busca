public class Main {
    public static void main(String[] args) {

        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<>();

        try {
            arvoreBinariaBusca.inserir(5);
            arvoreBinariaBusca.inserir(8);
            arvoreBinariaBusca.inserir(4);
            arvoreBinariaBusca.inserir(6);
            arvoreBinariaBusca.inserir(1);

            System.out.println("pre");
            arvoreBinariaBusca.preOrdem(arvoreBinariaBusca.raiz);
            System.out.println();

            System.out.println("em");
            arvoreBinariaBusca.emOrdem(arvoreBinariaBusca.raiz);
            System.out.println();

            System.out.println("pos");
            arvoreBinariaBusca.posOrdem(arvoreBinariaBusca.raiz);
            System.out.println();

            System.out.println(arvoreBinariaBusca.remover(4).getValor());

            System.out.println("pre");
            arvoreBinariaBusca.preOrdem(arvoreBinariaBusca.raiz);
            System.out.println();

            System.out.println("em");
            arvoreBinariaBusca.emOrdem(arvoreBinariaBusca.raiz);
            System.out.println();

            System.out.println("pos");
            arvoreBinariaBusca.posOrdem(arvoreBinariaBusca.raiz);
            System.out.println();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
