package com.miqueias.quiz;

import java.util.List;

public final class BancoDeQuestoes {

    private BancoDeQuestoes() {
    }

    public static List<Questao> freakazoid() {
        return List.of(
                Questao.of(
                        "Qual é o verdadeiro nome do Freakazoid?",
                        "Dexter Douglas",
                        "Bruce Wayne",
                        "Clark Kent",
                        "Peter Parker",
                        "Wally West",
                        Alternativa.A
                ),
                Questao.of(
                        "Qual é a origem do poder do Freakazoid?",
                        "Um experimento científico",
                        "Um dispositivo alienígena",
                        "Um acidente de computador",
                        "Um feitiço mágico",
                        "Um legado familiar",
                        Alternativa.C
                ),
                Questao.of(
                        "Qual é o principal vilão que enfrenta o Freakazoid?",
                        "O Cérebro",
                        "Dr. Estranho",
                        "O Incrível Shapiro",
                        "O Camaleão",
                        "O Louva-a-Deus",
                        Alternativa.A
                ),
                Questao.of(
                        "Quem é o amigo e parceiro do Freakazoid?",
                        "Monk",
                        "Dexter",
                        "Joe Leal",
                        "Cosgrove",
                        "Ciber-Chefe",
                        Alternativa.D
                ),
                Questao.of(
                        "Qual é a característica mais notável do Freakazoid?",
                        "Super força",
                        "Velocidade sobre-humana",
                        "Ele é completamente maluco!",
                        "Invisibilidade",
                        "Telepatia",
                        Alternativa.C
                ),
                Questao.of(
                        "Qual é o animal de estimação do Freakazoid?",
                        "Um gato",
                        "Um cachorro",
                        "Um peixe",
                        "Um coelho",
                        "Um rato",
                        Alternativa.E
                ),
                Questao.of(
                        "Qual é o poder especial que o Freakazoid tem sobre os vilões?",
                        "Telepatia",
                        "Humor insensato",
                        "Manipulação do tempo",
                        "Voo",
                        "Força sobre-humana",
                        Alternativa.B
                ),
                Questao.of(
                        "O que o Freakazoid frequentemente grita quando aparece?",
                        "Hooray!",
                        "Uau!",
                        "Freakazoid!",
                        "Vamos nessa!",
                        "Eu sou o máximo!",
                        Alternativa.C
                ),
                Questao.of(
                        "Qual é a principal habilidade do Cérebro?",
                        "Telepatia",
                        "Controle mental",
                        "Super força",
                        "Gênio da tecnologia",
                        "Transformação em monstro",
                        Alternativa.D
                ),
                Questao.of(
                        "Qual é o tema principal da série Freakazoid?",
                        "Comédia de super-heróis",
                        "Mistério e suspense",
                        "Aventura espacial",
                        "Drama familiar",
                        "Fantasia épica",
                        Alternativa.A
                ),
                Questao.of(
                        "Qual é a frase famosa do Cosgrove?",
                        "Vamos lá, parceiro!",
                        "Não se preocupe, Freakazoid!",
                        "Ei, quer comer um cachorro-quente?",
                        "Não faça nada!",
                        "Olá, Freakazoid!",
                        Alternativa.C
                ),
                Questao.of(
                        "Quem é a namorada do Freakazoid?",
                        "Freakazette",
                        "Gwen",
                        "Jennifer",
                        "Lobe",
                        "Trixie",
                        Alternativa.A
                ),
                Questao.of(
                        "Qual é o lema do Freakazoid?",
                        "Poder e Justiça!",
                        "Ser maluco é divertido!",
                        "Justiça é feita!",
                        "Humor é a melhor arma!",
                        "O que é mais legal?",
                        Alternativa.C
                ),
                Questao.of(
                        "O que o Freakazoid faz quando não está combatendo o crime?",
                        "Estuda",
                        "Joga videogame",
                        "Viaja",
                        "Trabalha em um escritório",
                        "Faz piadas o tempo todo",
                        Alternativa.E
                ),
                Questao.of(
                        "Qual é o nome do assistente do Cérebro?",
                        "Bob",
                        "Roger",
                        "Dork",
                        "Larry",
                        "Dave",
                        Alternativa.C
                )
        );
    }
}
