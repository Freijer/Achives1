package freijer.app.taster;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Supports {

    protected int next_lvl = 1;

    ArrayList<String> Task = new ArrayList<>();

    public void TaskListing(){
        Task.add("Собрать слово из 3 букв 3 раза");
        Task.add("Собрать слово из 4 букв 3 раза");
    }


    protected int LVL_UP(int income){

        if (income >= 3 && income <= 20) {
            this.next_lvl = 2;
        } else if (income >= 21 && income <= 40) {
            this.next_lvl = 3;
        }
        return next_lvl;
    }  //увеличение уровня, подсчет


    public static int CountCorrectSeqLen(List<String> data) {
        double modifier_to_score = 1.5;
        int score = 0;
        int maxLength = 0;
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() + 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        score = (int) (maxLength*modifier_to_score);
        //return score;
         return  maxLength;
    }
    // последовательность +1 буква к следующему слову
    //Вводим число  =   длинна последовательности. И если правильная, то возвращаем количество очков в 1.5 раза больше нужной последовательности.



}
