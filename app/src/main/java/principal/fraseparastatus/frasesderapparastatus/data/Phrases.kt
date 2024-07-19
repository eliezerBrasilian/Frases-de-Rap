package principal.fraseparastatus.frasesderapparastatus.data

import java.util.Random

enum class Singer(val s: String) {
    Haikaiss("Haikaiss"),
    Dfideliz("Dfideliz"),
    RaffaMoreira("Raffa Moreira"),
    Dalua("Dalua"),
    JeSantiago("Jé Santigado"),
    McIgu("MC Igu"),
    YunkVino("Yunk Vino"),
    RacionaisMcs("Racionais MCs"),
    Projota("Projota"),
    CostaGold("Costa Gold"),
    Kamau("Kamau"),
    Derek("Derek"),
    Emicida("Emicida"),
    FilipeRet("Filipe Ret"),
    Eminem("Eminem"),
    Rimatitude("Rimatitude"),
    Sabotage("Sabotage"),
    Dnasty("Dnasty"),
    Oriente("Oriente"),
    FaccaoCentral("Facção Central"),
    BondeDaStronda("Bonde da Stronda"),
    ManoBrown("Mano Brown"),
    RecaydMob("RecaydMob"),
    GabrielOpensador("Gabriel o pensador"),
    Rashid("Rashid"),
}

data class Phrase(val phrase: String, val singer: String, val category: Category = Category.Rap)

val phrases = listOf(
    Phrase("Outra vez a esperança na mochila eu ponho, quanto tempo a gente ainda tem pra realizar os nossos sonhos.",
        singer = Singer.Emicida.s),
    Phrase("Dançando com o caos, namorando com a paz",
        singer = Singer.FilipeRet.s),
    Phrase("É fácil falar, difícil é ser eu, se sua estrela não brilha, vai reclamar com Deus.",
        singer = Singer.Eminem.s),
    Phrase("Não fique remoendo o que está dentro de você. Chega de ficar sofrendo, diga o que tem pra dizer.",
        singer = Singer.Rimatitude.s),
    Phrase("Deus ajuda, é verdade, vai na fé, não na sorte.",
        singer = Singer.Sabotage.s),
    Phrase("Outra vez a esperança na mochila eu ponho, quanto tempo a gente ainda tem pra realizar os nossos sonhos.",
        singer = Singer.Emicida.s),
    Phrase("Botei meu pulso na Ice Box ⌚❄\uFE0F\uD83D\uDE0C",
        singer = Singer.JeSantiago.s, category = Category.Trap),
    Phrase("Tô brilhando tanto é impossível de ignorar",
        singer = Singer.Dnasty.s, category = Category.Trap),
    Phrase("Ela lidava com fatos, ele lidava com a sorteE o amor impossível só foi ficando mais forte",
        singer = Singer.Oriente.s),
    Phrase("Outra vez a esperança na mochila eu ponho, quanto tempo a gente ainda tem pra realizar os nossos sonhos.",
        singer = Singer.Emicida.s),
    Phrase("O nosso destino é uma caixa de surpresa",
        Singer.Haikaiss.s),
    Phrase("Eu mereci isso mano, nunca foi sorte",
        Singer.Derek.s, category = Category.Trap),
    Phrase("A alma guarda o que a mente tenta esquecer.",
        Singer.RacionaisMcs.s),
    Phrase("Ao invés de tentar mudar o mundo, mudar o impossível, mude a sua vida, mude o seu redor, mude a sua família, sempre pra melhor.",
        Singer.FaccaoCentral.s),
    Phrase("Enquanto buscam o sentido da vida, eu vivo ela.",
        Singer.Emicida.s),
    Phrase("Que seja eterno enquanto dure, que dure para sempre. Essas são palavras chaves, quero que você se lembre.",
        Singer.BondeDaStronda.s),
    Phrase("Eu queria terminar com uma rima mais pesada, mas se eu não posso dizer ‘eu te amo’, prefiro não dizer nada.",
        Singer.Projota.s),
    Phrase("Às vezes o caminho da cura pode ser a doença, e o caminho do perdão as vezes é a sentença.",
        Singer.ManoBrown.s),
    Phrase("Se depender de mim, cê vai tretar sozinho",
        Singer.Dnasty.s),
    Phrase("Foi, PLACTUDUM !!",
        Singer.RecaydMob.s),
    Phrase("todos me inveja e isso é uma bosta mas tenho um Deus que escreve certinho nessas linha torta",
        Singer.Dfideliz.s),
    Phrase("O que a gente tem é raro",
        Singer.Dalua.s),
    Phrase("Não é a espada que forma um guerreiro, meu pai me ensinou a ser usando enxada de pedreiro.",
        Singer.Projota.s),
    Phrase("Nem todos que sonharam conseguiram, mas pra conseguir é preciso sonhar",
        Singer.GabrielOpensador.s),
    Phrase("Não perdi nem uma chance, algumas delas que me perderam.",
        Singer.Rashid.s),
    Phrase("Quem nasceu pra vencer não desiste, quem tem Deus tem tudo não duvide! ✨♥\uFE0F\"\n",
        Singer.RaffaMoreira.s, Category.Trap),
    Phrase("Tô provando meu day dripping daqui", Singer.Dalua.s, Category.Trap),
    Phrase("Ela é minha boo, ela ama meu drip", Singer.JeSantiago.s, Category.Trap),
    Phrase("Se tem bloco a gente vai", Singer.McIgu.s, Category.Trap),
    Phrase("Não tem como nós fugir desse lifestyle \uD83D\uDD76\uFE0F", Singer.YunkVino.s, Category.Trap),
    Phrase("Não fica em shoque meu mano que é tanto progresso e nós nem começou", Singer.Dfideliz.s, Category.Trap),
    Phrase("Eles falam muito e eu só falo não", Singer.McIgu.s, Category.Trap),
    Phrase("Dinheiro no bolso, Deus no coração, família unida e champanhe pros irmãos.", Singer.RacionaisMcs.s),
    Phrase("Tudo que eu peço na vida é pra ser abençoado, que cada ano sem você me traga mais 10 anos do seu lado.",
        Singer.Projota.s),
    Phrase("Meu pai, minha mãe, eu escuto vocês. O estudo eu fechei, no estúdio eu vinguei", Singer.CostaGold.s),
    Phrase("Mão na massa, nada vem de graça, se eu não fizer por mim, não há quem faça!", Singer.Kamau.s),
    Phrase("Onde estiver, seja lá como for, tenha fé porque até no lixão nasce flor.", Singer.RacionaisMcs.s),
    Phrase("Eu queria terminar com uma rima mais pesada, mas se eu não posso dizer ‘eu te amo’, prefiro não dizer nada.", Singer.Projota.name),
    Phrase("Mantenho a fé que esse jogo vai virarSituação ruim que já vai melhorar", Singer.CostaGold.s),
    Phrase("Eu só deslizo \uD83D\uDE0E\uD83D\uDCAF", Singer.Derek.s, Category.Trap),
    Phrase("Se eu pulo no beat, explode igual bomba \uD83D\uDD25❤\uFE0F\u200D\uD83D\uDD25", Singer.Derek.s, Category.Trap),
)

fun getRandomPhrase():Phrase{
    val random = Random()
    val randomIndex = random.nextInt(phrases.size)
    val randomPhrase = phrases[randomIndex]

    return randomPhrase;
}

fun getPhrases(category: String): List<Phrase> {
   return phrases.filter { it.category.name == category }
}