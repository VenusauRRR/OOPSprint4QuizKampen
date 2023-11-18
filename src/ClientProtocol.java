public class ClientProtocol {
    static final int STARTNEWGAME = 0;
    static final int RANDOMPLAYER = 1;
    static final int PLAY = 2;

    int gameState = STARTNEWGAME;

//    ClientProtocol(){
//    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public void showRelevantPage(){
        if (this.gameState==STARTNEWGAME){

        }
    }


}
