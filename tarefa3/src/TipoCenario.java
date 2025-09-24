public enum TipoCenario {

    FLORESTA_PROIBIDA("A misteriosa e perigosa Floresta Proibida em Hogwarts") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Sombras e criaturas estranhas enfraquecem o herói.");
            heroi.receberDano(10);
        }
    },

    SALAO_PRINCIPAL("O grande Salão Principal, cheio de magia e energia dos alunos") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O herói sente-se energizado e recupera forças.");
            heroi.receberCura(15);
        }
    },

    CABANA_DO_HAGRID("A cabana do guardião Hagrid, cercada por criaturas mágicas") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O encontro com criaturas mágicas deixa o herói alerta.");
            // efeito neutro, apenas mensagem
        }
    },

    CAMPO_DE_QUADRIBOL("O Campo de Quadribol, onde o vento e o esforço físico desafiam o herói") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O herói se cansa ao correr atrás da bala dourada.");
            heroi.receberDano(5);
        }
    },

    SALA_PRECISA("A misteriosa Sala Precisa, que se adapta às necessidades do herói") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O herói encontra suprimentos e proteção temporária.");
            heroi.receberCura(10);
        }
    };

    private String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}
