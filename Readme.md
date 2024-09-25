PROJECT TITLE: Super Ghetto Brothers
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT: Crie um objeto da classe StartScreen
AUTHORS:
USER INSTRUCTIONS: O jogo possui 3 fases, cada fase precisa de 200 pontos
para passar

INFORMAÇÕES GERAIS
Nome do jogo: Super Ghetto Brothers 

GAMEPLAY 
Número de classes de atores com ação:
    3 classes e 4 subclasses

Número de classes de mundo: 
    7 classes de mundo

Qual classe que não é ator nem mundo? 
    Classe Pontuacao
 
Número de arquivos de áudio usados: 
    9 arquivos de áudio 


Permite várias partidas no próprio gameplay? 
    Sim, o usuário ao morrer pode começar novamente o jogo, ou ao vencer também.


Tem tela inicial?
    Sim, possui uma tela inicial, com as opções de mostrar como jogar e começar o jogo


Tem tela de histórico de pontuação? 
    Sim, possui uma tela onde é exibida todas as pontuações e a pontuação recorde


    
    
REQUISITOS DE OO 
Atende aos requisitos de OO da primeira entrega?
    Sim
 
Tem alta coesão?
    Sim, todas as classes e métodos possuem uma tarefa bem definida

Tem baixo acoplamento?
    Sim, as classes são bem independentes umas das outras.

Usa design baseado em responsabilidade?
    Sim, objetos e classes tem suas funções bem definidas, métodos bem definidos, não há replicação de código, possui uma fácil manutenibilidade.

Tem acoplamento implícito?
    Sim, algumas classes quando criadas recebem a classe Background e dependem de seus métodos

Tem replicação de código?
    Não

Tem duas superclasses com subclasses com implementação útil?
    Sim, temos as classes:
    Tiro(superclasse) e TiroInimigo e TiroJogador(subclasses):
    - servem para tratar os tiros de forma separada, do jogador e do inimigo
    Inimigo(supeclasse) e Inimigo1 e Inimigo2 (subclasses):
    - servem para tratar os 2 diferentes inimigos do jogo
