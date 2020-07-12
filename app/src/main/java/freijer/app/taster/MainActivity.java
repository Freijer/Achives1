package freijer.app.taster;


import androidx.appcompat.app.AppCompatActivity;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int asd = 0;
    int pos_asd = 0;
    private int TotalScore = 0;

    public int getTotalScore() {
        return TotalScore;
    }
    public void setTotalScore(int totalScore) {
        TotalScore = totalScore;
    }


    public int getNumber_word_3() {
        return number_word_3;
    }
    public void setNumber_word_3(int number_word_3) {
        this.number_word_3 = number_word_3;
    }
    int number_word_3 = 0;
    public int getNumber_word_4() {
        return number_word_4;
    }
    public void setNumber_word_4(int number_word_4) {
        this.number_word_4 = number_word_4;
    }
    int number_word_4 = 0;

    ArrayList<String> Words = new ArrayList<>();


    Supports taste = new Supports();

    ImageView img_nextlvl;
    TextView text, textTask;
    ListView taskDoneList;

    ArrayAdapter<String> adapterDone;

    List<String> taskList = new ArrayList<>();
    List<String> taskDone = new ArrayList<>();
    List<String> logQA = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_nextlvl = findViewById(R.id.img_nextlvl);
        text = findViewById(R.id.text);
        textTask = findViewById(R.id.textTask);
        taskDoneList = findViewById(R.id.taskDoneList);

        taste.TaskListing();
        gos();

    }


    @SuppressLint("SetTextI18n")
    public void Go(View v){



        adapterDone = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskDone);
        taskDoneList.setAdapter(adapterDone);
        taskDoneList.setBackgroundColor(Color.CYAN);



        ShowTaskWelDone();

//       textTask.setText(TextUtils.join(", ", taskDone));

        setNumber_word_3(getNumber_word_3()+1);
        setNumber_word_4(getNumber_word_4()+1);
        text.setText("Очков: "+ getTotalScore());

        Anim();

        taskList.add("Слово из 3 букв собранно " + getNumber_word_3() + " раза");
        taskList.add("Слово из 4 букв собранно " + getNumber_word_4() + " раза");
        taskList.add("Последовательность из +1 буква длинной в " + Supports.CountCorrectSeqLen(Words) + " слов");
        setTotalScore(asd+pos_asd);
    }



    public void Anim(){
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(img_nextlvl, "scaleX", 0.3f, 2.5f);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1900);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(img_nextlvl, "scaleY", 0.3f, 2.5f);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1900);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(img_nextlvl, "alpha", 1F, 0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(2500);


        AnimatorSet animationSet = new AnimatorSet();
        animationSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animationSet.start();
    }
//    public void PrintShow(){
//       if (LogQA.contains(task_1)){
//           TaskDone.add(task_1);
//           this.asd += 3;
//           LogQA.remove(task_1);
//       } else if(LogQA.contains(task_2)){
//           TaskDone.add(task_2);
//           this.asd += 4;
//           LogQA.remove(task_2);
//       } else{
//            textTask.setText("Уже выполненно");
//        }
//    }
    public void ShowTaskWelDone(){
        for (String eachString : taskList) {
            if (logQA.contains(eachString)) {
                taskDone.add(eachString);
                if (eachString.contains("Последовательность")){ // за послекдовательность 5 очков
                    this.asd+= 5;
                }
                this.asd += 2; //за обычный квест 2 очка
                logQA.remove(eachString);
            }
        }

//        this.pos_asd = Supports.CountCorrectSeqLen(Words)*2; //очки за последовательность увеличиваются
//        setTotalScore((Supports.CountCorrectSeqLen(Words)*2) + asd); //в два раза больше очков за последовательность

    }
    protected void gos(){


        Words.add("Так");
        Words.add("Понг");
        Words.add("Пятак");
        Words.add("Заплыв");
        Words.add("Заплывh");

        logQA.add("Слово из 3 букв собранно 3 раза");
        logQA.add("Слово из 3 букв собранно 4 раза");
        logQA.add("Слово из 3 букв собранно 5 раза");
        logQA.add("Слово из 3 букв собранно 6 раза");
        logQA.add("Слово из 3 букв собранно 7 раза");
        //
        logQA.add("Слово из 4 букв собранно 3 раза");
        logQA.add("Слово из 4 букв собранно 4 раза");
        logQA.add("Слово из 4 букв собранно 5 раза");
        logQA.add("Слово из 4 букв собранно 6 раза");
        logQA.add("Слово из 4 букв собранно 7 раза");
        //
        logQA.add("Последовательность из +1 буква длинной в 3 слов");
        logQA.add("Последовательность из +1 буква длинной в 4 слов");
        logQA.add("Последовательность из +1 буква длинной в 5 слов");





//        LogQA.add("Слово из 3 букв собранно 3 раза");
//        LogQA.add("Слово из 3 букв собранно 4 раза");
//        LogQA.add("Слово из 3 букв собранно 5 раза");
//        LogQA.add("Слово из 3 букв собранно 10 раза");
//        LogQA.add("Слово из 3 букв собранно 30 раза");
//        LogQA.add("Слово из 3 букв собранно 50 раза");
//        LogQA.add("Слово из 3 букв собранно 75 раза");
//        LogQA.add("Слово из 3 букв собранно 100 раза");
//        LogQA.add("Слово из 3 букв собранно 150 раза");
//        LogQA.add("Слово из 3 букв собранно 200 раза");
//        //
//        LogQA.add("Слово из 4 букв собранно 3 раза");
//        LogQA.add("Слово из 4 букв собранно 4 раза");
//        LogQA.add("Слово из 4 букв собранно 5 раза");
//        LogQA.add("Слово из 4 букв собранно 10 раза");
//        LogQA.add("Слово из 4 букв собранно 30 раза");
//        LogQA.add("Слово из 4 букв собранно 50 раза");
//        LogQA.add("Слово из 4 букв собранно 75 раза");
//        LogQA.add("Слово из 4 букв собранно 100 раза");
//        LogQA.add("Слово из 4 букв собранно 150 раза");
//        LogQA.add("Слово из 4 букв собранно 200 раза");
//        //
//        LogQA.add("Слово из 5 букв собранно 3 раза");
//        LogQA.add("Слово из 5 букв собранно 4 раза");
//        LogQA.add("Слово из 5 букв собранно 5 раза");
//        LogQA.add("Слово из 5 букв собранно 10 раза");
//        LogQA.add("Слово из 5 букв собранно 30 раза");
//        LogQA.add("Слово из 5 букв собранно 50 раза");
//        LogQA.add("Слово из 5 букв собранно 75 раза");
//        LogQA.add("Слово из 5 букв собранно 100 раза");
//        LogQA.add("Слово из 5 букв собранно 150 раза");
//        LogQA.add("Слово из 5 букв собранно 200 раза");
//        //
//        LogQA.add("Слово из 6 букв собранно 3 раза");
//        LogQA.add("Слово из 6 букв собранно 4 раза");
//        LogQA.add("Слово из 6 букв собранно 5 раза");
//        LogQA.add("Слово из 6 букв собранно 10 раза");
//        LogQA.add("Слово из 6 букв собранно 30 раза");
//        LogQA.add("Слово из 6 букв собранно 50 раза");
//        LogQA.add("Слово из 6 букв собранно 75 раза");
//        LogQA.add("Слово из 6 букв собранно 100 раза");
//        LogQA.add("Слово из 6 букв собранно 150 раза");
//        LogQA.add("Слово из 6 букв собранно 200 раза");
//        //
//        LogQA.add("Слово из 7 букв собранно 3 раза");
//        LogQA.add("Слово из 7 букв собранно 4 раза");
//        LogQA.add("Слово из 7 букв собранно 5 раза");
//        LogQA.add("Слово из 7 букв собранно 10 раза");
//        LogQA.add("Слово из 7 букв собранно 30 раза");
//        LogQA.add("Слово из 7 букв собранно 50 раза");
//        LogQA.add("Слово из 7 букв собранно 75 раза");
//        LogQA.add("Слово из 7 букв собранно 100 раза");
//        LogQA.add("Слово из 7 букв собранно 150 раза");
//        LogQA.add("Слово из 7 букв собранно 200 раза");
//        //
//        LogQA.add("Последвательность слов +1 буква из 3 слов");
//        LogQA.add("Последвательность слов +1 буква из 4 слов");
//        LogQA.add("Последвательность слов +1 буква из 5 слов");
//        LogQA.add("Последвательность слов +1 буква из 6 слов");
//        LogQA.add("Последвательность слов +1 буква из 7 слов");
//        //
//        LogQA.add("Собрано 5 раз слова одинаковой длинны за одну игру");
//        LogQA.add("Собрано 10 раз слова одинаковой длинны за одну игру");
//        LogQA.add("Собрано 25 раз слова одинаковой длинны за одну игру");
//        LogQA.add("Собрано 30 раз слова одинаковой длинны за одну игру");
//        LogQA.add("Собрано 50 раз слова одинаковой длинны за одну игру");
//        //
//        LogQA.add("Последвательность слов -1 буква из 3 слов");
//        LogQA.add("Последвательность слов -1 буква из 4 слов");
//        LogQA.add("Последвательность слов -1 буква из 5 слов");
//        LogQA.add("Последвательность слов -1 буква из 6 слов");
//        LogQA.add("Последвательность слов -1 буква из 7 слов");

    }





}

