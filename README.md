
# Árvore Binária de Busca





## Objetivo

- Repositório dedicado a realização da árvore binária de busca e seus métodos para a matéria de ED2 - IFS



## Introdução  
-   Uma árvore de busca criada a partir de um conjunto de valores não é única: o resultado
    depende da seqüência de inserção dos dados. A grande utilidade da árvore binária de busca é armazenar dados contra os quais outros dados são freqüentemente verificados. Uma árvore de busca binária é dinâmica e pode sofrer alterações (inserções e remoções de nós) após ter sido criada. 

    → operações básicas em uma Árvore Binária de Busca são:
    
    → inserção.
        
    → remoção.

    → busca. 

    ### Passos do algoritmo de inserção:    
    → 1 - Procure um “local” para inserir o novo nó, começando a procura a partir do nó-raiz.

    → 2 - Para cada nó-raiz de uma sub-árvore, compare; se o novo nó possui um valor menor do que o valor nó raiz (vai para sub-árvore esquerda), ou se o valor é maior que o valor no nó-raiz (vai para sub-árvore direita).
    
    → 3 - Se uma referência (filho esquerdo/direito de um nó raiz) nula é atingida, coloque o novo nó como sendo filho do nó-raiz.
    ### Exemplo
      ~~~JAVA
       public void inserir(Object valor) throws Exception {

        /***
         * Metodo publico para a insercao de um valor na arvore
         * @exception Exception caso valor inserido seja nulo
         * @param valor recebe o valor a ser inserido na arvore
         */

        if (valor == null) throw new RuntimeException("Nao ha como inserir um valor nulo");

        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private No inserirRecursivo(No no, Object valor) {

        /**
         * Um Metodo privado recursiva para inserir um novo valor na arvore
         * @param no recebe o no a ser analizado e comparado com o valor a inserir
         * @param valor recebe o valor que sera incluido na arvore
         * @return o no atualizado com seu pai e filhos
         */

        if (no == null) {
            /** Se o no for igual a nulo */
            return new No((Comparable) valor);
        }

        if (no.getValor().compareTo(valor) > 0) {
            /** Se o valor do no for maior do que o valor inserido, vai pra esquerda */
            no.setFilhoEsquerdo(inserirRecursivo(no.getFilhoEsquerdo(), valor));

        } else if (no.getValor().compareTo(valor) < 0) {
            /** Se o valor do no for menor do que o valor inserido, vai pra direita */
            no.setFilhoDireito(inserirRecursivo(no.getFilhoDireito(), valor));
        }

        return no;
    }

    ~~~

    ### Passos do algoritmo de Busca: 
    → 1 - Comece a busca a partir do nó-raiz.

    → 2 - Para cada nó-raiz de uma sub-árvore compare:

    → Se o valor procurado é menor que o valor no nó-raiz (continua pela sub-árvore esquerda), ou se o valor é maior que o valor no nó-raiz (sub-árvore direita);

    → Caso o nó contendo o valor pesquisado seja encontrado, retorne o nó; caso contrário retorne nulo.
    ### Exemplo    
    ~~~JAVA
     public No buscar(No no, Object valor) throws Exception {

        /**
         * Metodo para buscar se o valor e existente dentro da arvore
         * @param no recebe o no que sera comparado com o valor
         * @param valor recebe o valor que tentara ser encontrado dentro da arvore
         * @exception Exception caso o valor inserido seja nulo
         * @return o no caso seja achado, caso nao, retorna null
         */

        if (valor == null) throw new RuntimeException("Nao ha como buscar um valor nulo");

        /** Se o valor do no seja nulo ou o valor seja achado no nó */
        if (no == null || no.getValor() == valor) {
            return no;
        }

        if (no.getValor().compareTo(valor) > 0) {
            /** Se o valor do no for maior do que o valor inserido, vai pra esquerda */
            return buscar(no.getFilhoEsquerdo(), valor);
        }

        /** Se o valor do no for menor do que o valor inserido, vai pra direita */
        return buscar(no.getFilhoDireito(), valor);
    }
    ~~~~
    ### Passos do algoritmo de Remoção:
    
    → Para a remoção de um nó em uma árvore binária, devem ser considerados três casos: 

    → Caso 1: o nó é folha.
        
        → O nó pode ser retirado sem problemas.

    → Caso 2: o nó possui uma sub-árvore (esq./dir.).

        → O nó-raiz da sub-árvore (esq./dir.) “ocupa” o lugar do nó retirado.

    → Caso 3: o nó possui duas sub-árvores.

        → O nó contendo o menor valor da sub-árvore direita pode “ocupar” o lugar; ou o maior valor da sub-árvore esquerda pode “ocupar” o lugar. 

    
    ### Exemplo    
    ~~~JAVA

    public No remover(Object valor) throws Exception {

        /***
         * Metodo publico para a remocao de um valor na arvore
         * @param valor recebe o valor a ser removido na arvore
         * @exception Exception caso valor inserido seja nulo
         * @return no removido da arvore
         */

        if (valor == null) throw new RuntimeException("Nao ha como remover um valor nulo");

        return removerRecursivo(this.raiz, valor);
    }

    private No removerRecursivo(No no, Object valor) {

        /**
         * Uma função recursiva para remover um valor na arvore, considerando que ha 3 casos
         * @param no recebe o no a ser analizado e comparado com o valor a remover
         * @param valor recebe o valor que sera removido na arvore
         */

        /** Se o no for igual a nulo */
        if (no == null) return no;

        /** CASO 1: Se o nao houver nenhum nó filho */
        if (no.getValor().compareTo(valor) > 0) {
            no.setFilhoEsquerdo(removerRecursivo(no.getFilhoEsquerdo(), valor));
            return no;
        } else if (no.getValor().compareTo(valor) < 0) {
            no.setFilhoDireito(removerRecursivo(no.getFilhoDireito(), valor));
            return no;
        }

        /** CASO 2: Se houver um nó filho */
        if (no.getFilhoEsquerdo() == null) {
            No temp = no.getFilhoDireito();
            return temp;
        } else if (no.getFilhoDireito() == null) {
            No temp = no.getFilhoEsquerdo();
            return temp;
        }

        /** CASO 3: Se houver dois nós filho */
        else {
            No noAuxiliar = no;

            No noSucessor = no.getFilhoDireito();
            while (noSucessor.getFilhoEsquerdo() != null) {
                noAuxiliar = noSucessor;
                noSucessor = noSucessor.getFilhoEsquerdo();
            }
            if (noAuxiliar != no)
                noAuxiliar.setFilhoEsquerdo(noSucessor.getFilhoDireito());
            else
                noAuxiliar.setFilhoDireito(noSucessor.getFilhoDireito());

            no.valor = noSucessor.valor;
            
            return no;
        }
    }
    ~~~

## Nota

- Todo o conteúdo citado neste repositório é de objetivo acadêmico. Os códigos adicionados nesse readme estão commitados logo acima. Qualquer ajuda ou pedido de pull request é bem vindo e será analisado. 
#
 
## Referência
 - [UFPE - Árvore Binárias de Busca](https://www.cin.ufpe.br/~dmrac/aula%20de%20arvore%20binaria%20de%20busca.pdf)
 - [USP - Árvores Binárias de busca](https://www.ime.usp.br/~pf/algoritmos/aulas/binst.html)
 - [Estruturas de Dados 27 [ ÁRVORE BINÁRIA DE BUSCA ]](https://www.youtube.com/watch?v=qegzdaeYIAM&t=1s)

- [Estruturas de Dados: algoritmos, análise da complexidade e implementações em JAVA e C/C++](https://github.com/free-educa/books/blob/main/books/Estrutura%20de%20Dados%2C%20algoritmos%2C%20an%C3%A1lise%20da%20complexidade%20e%20implementa%C3%A7%C3%B5es%20em%20Java%20e%20C%2C%20C--.pdf)
## Suporte

Para ajuda, mande um email para junior26bmx@gmail.com ou para contato.albertosantana@gmail.com.

