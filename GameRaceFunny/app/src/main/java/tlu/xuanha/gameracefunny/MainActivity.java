package tlu.xuanha.gameracefunny;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView textViewScore;
    CheckBox ckbOne,ckbTwo,ckbThree;
    SeekBar seekbarOne,seekbarTwo,seekbarThree;
    ImageButton imgPlay;
    int score=5000;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControls();
        AddEvents();
        textViewScore.setText(score + "");
        seekbarOne.setEnabled(false);
        seekbarTwo.setEnabled(false);
        seekbarThree.setEnabled(false);
        final CountDownTimer countDownTimer = new CountDownTimer(600000,200) {
            @Override
            public void onTick(long l) {
                int a=200;
                Random random = new Random();
                int x=random.nextInt(a);
                int y=random.nextInt(a);
                int z=random.nextInt(a);

                seekbarOne.setProgress(seekbarOne.getProgress() + x);
                seekbarTwo.setProgress(seekbarTwo.getProgress() + y);
                seekbarThree.setProgress(seekbarThree.getProgress() + z);
                // Set Winner ======================================================================
                if(seekbarOne.getProgress() >= seekbarOne.getMax()){
                    this.cancel();
                    imgPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"IE Winner",Toast.LENGTH_SHORT).show();
                    if(ckbOne.isChecked()){
                        score+=1500;
                    }
                    else{
                        score-=1000;
                    }
                    if(score < 1000){
                        Toast.makeText(MainActivity.this, "Đặt cược như cứt, đừng đi đâu cả - lại đây tao cho thêm tí tiền đặt cược nhé !", Toast.LENGTH_LONG).show();
                        score=10000;
                        count++;
                    }
                    if(count>=2){
                        Toast.makeText(MainActivity.this, count + " lần thua rồi mày, tao cho mày thêm tí tiền đặt cược nhé !", Toast.LENGTH_LONG).show();
                        score=20000;
                    }
                    textViewScore.setText(score + "");
                    EnableCheckBox();
                }
                if(seekbarTwo.getProgress() >= seekbarTwo.getMax()){
                    this.cancel();
                    imgPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Firefox Winner",Toast.LENGTH_SHORT).show();
                    if(ckbTwo.isChecked()){
                        score+=1500;
                    }
                    else{
                        score-=1000;
                    }
                    if(score < 1000){
                        Toast.makeText(MainActivity.this, "Đặt cược như cứt, đừng đi đâu cả - lại đây tao cho thêm tí tiền đặt cược nhé !", Toast.LENGTH_LONG).show();
                        score=10000;
                        count++;
                    }
                    if(count>=2){
                        Toast.makeText(MainActivity.this, count + " lần thua rồi mày, tao cho mày thêm tí tiền đặt cược nhé !", Toast.LENGTH_LONG).show();
                        score=20000;
                    }
                    textViewScore.setText(score + "");
                    EnableCheckBox();
                }
                if(seekbarThree.getProgress() >= seekbarThree.getMax()){
                    this.cancel();
                    imgPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Chrome Winner",Toast.LENGTH_SHORT).show();
                    if(ckbThree.isChecked()){
                        score+=1500;
                    }
                    else{
                        score-=1000;
                    }
                    if(score < 1000){
                        Toast.makeText(MainActivity.this, "Đặt cược như cứt, đừng đi đâu cả - lại đây tao cho thêm tí tiền đặt cược nhé !", Toast.LENGTH_LONG).show();
                        score=10000;
                        count++;
                    }
                    if(count>=2){
                        Toast.makeText(MainActivity.this, count + " lần thua rồi mày, tao cho mày thêm tí tiền đặt cược nhé !", Toast.LENGTH_LONG).show();
                        score=20000;
                    }
                    textViewScore.setText(score + "");
                    EnableCheckBox();
                }
                // =================================================================================
            }

            @Override
            public void onFinish() {
            }
        };
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ckbOne.isChecked() || ckbTwo.isChecked() || ckbThree.isChecked()){
                    seekbarOne.setProgress(0);
                    seekbarTwo.setProgress(0);
                    seekbarThree.setProgress(0);
                    imgPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }
                else{
                    Toast.makeText(MainActivity.this,"Vui lòng đặt cược trước khi bấm PLAY",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void AddEvents() {
        ckbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ckbTwo.setChecked(false);
                    ckbThree.setChecked(false);
                }
            }
        });
        ckbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ckbOne.setChecked(false);
                    ckbThree.setChecked(false);
                }
            }
        });
        ckbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ckbOne.setChecked(false);
                    ckbTwo.setChecked(false);
                }
            }
        });
    }
    private void AddControls() {
        textViewScore = (TextView) findViewById(R.id.Score);
        ckbOne = (CheckBox) findViewById(R.id.checkBoxOne);
        ckbTwo = (CheckBox) findViewById(R.id.checkBoxTwo);
        ckbThree = (CheckBox) findViewById(R.id.checkBoxThree);
        seekbarOne = (SeekBar) findViewById(R.id.seekbarOne);
        seekbarTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        seekbarThree = (SeekBar) findViewById(R.id.seekbarThree);
        imgPlay = (ImageButton) findViewById(R.id.btnPlay);
    }
    private void EnableCheckBox(){
        ckbOne.setEnabled(true);
        ckbTwo.setEnabled(true);
        ckbThree.setEnabled(true);
    }
    private void DisableCheckBox(){
        ckbOne.setEnabled(false);
        ckbTwo.setEnabled(false);
        ckbThree.setEnabled(false);
    }
}
