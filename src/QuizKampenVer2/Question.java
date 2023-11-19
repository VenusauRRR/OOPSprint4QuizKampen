package QuizKampenVer2;

public class Question {
    String category;
    String question;
    String correctAns;
    String ans2;
    String ans3;
    String ans4;

    public Question(String category, String question, String correctAns, String ans2, String ans3, String ans4) {
        this.category = category;
        this.question = question;
        this.correctAns = correctAns;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }
    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns4() {
        return ans4;
    }
}
