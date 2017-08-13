package tlu.xuanha.appmultilanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtThongTin,txtChiTiet;
    EditText txtName,txtEmail,txtPhone;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControls();
        AddEvents();
    }

    private void AddControls() {
        txtThongTin = (TextView) findViewById(R.id.txtThongTin);
        txtChiTiet = (TextView) findViewById(R.id.txtChiTiet);
        txtName= (EditText) findViewById(R.id.txtName);
        txtEmail= (EditText) findViewById(R.id.txtEmail);
        txtPhone= (EditText) findViewById(R.id.txtPhone);
        btnConfirm= (Button) findViewById(R.id.btnConfirm);
    }

    private void AddEvents() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Hello = getResources().getString(R.string.txt_Hello);
                String Email = getResources().getString(R.string.txt_Email);
                String Phone = getResources().getString(R.string.txt_Phone);
                String x=Hello +": "+ txtName.getText().toString() +"\n" +
                        Email +": "+ txtEmail.getText().toString() +"\n" +
                        Phone+": "+ txtPhone.getText().toString();
                txtChiTiet.setText(x);
            }
        });
    }
}
