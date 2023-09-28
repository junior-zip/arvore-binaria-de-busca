public class Main {
    public static void main(String[] args) {

        ArvoreBinariaBusca<String> arvoreBinariaBusca = new ArvoreBinariaBusca<>();

        try {
            arvoreBinariaBusca.inserir("iae");

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
