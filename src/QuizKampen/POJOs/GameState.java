package QuizKampen.POJOs;

public enum GameState {
    STARTNEWGAME ("StartNewGame"),
    RANDOMPLAYER ("RandomPlayer"),
    PLAY ("Play");
    final String state;
    GameState(String state){
        this.state = state;
    }
}
