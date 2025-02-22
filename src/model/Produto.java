package model;

import java.io.Serializable;

public class Produto implements Serializable {
        private String nome;

        public Produto(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Produto produto = (Produto) obj;
            return nome.equals(produto.nome);
        }

        @Override
        public int hashCode() {
            return nome.hashCode();
        }

        @Override
        public String toString() {
            return nome;
        }
    }

