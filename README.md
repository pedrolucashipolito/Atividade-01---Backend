```mermaid
erDiagram

    USUARIO {
        Long codigo PK
        String nome
        String email
        boolean ativo
        Date dataCadastro
        int idade
    }

    APARELHO {
        Long codigo PK
        String nome
        String tipo
        boolean disponivel
        Date dataManutencao
        double carga
    }

    AGENDAMENTO {
        Long codigo PK
        Date data
        String hora
        boolean ativo
        String observacao
        Long usuario_id FK
        Long aparelho_id FK
    }

    USUARIO ||--o{ AGENDAMENTO : realiza
    APARELHO ||--o{ AGENDAMENTO : possui
    ```
