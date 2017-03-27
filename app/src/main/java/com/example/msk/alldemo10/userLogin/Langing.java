package com.example.msk.alldemo10.userLogin;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.example.msk.alldemo10.MainActivity;
        import com.example.msk.alldemo10.R;
        import com.example.msk.alldemo10.showActivity;

public class Langing extends AppCompatActivity {
    private Button buttonback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langing);
        //寻找id
        buttonback = (Button) findViewById(R.id.backlanging);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(Langing.this, MainActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(it);
                //onKeyDown(KeyEvent.KEYCODE_BACK, null);

            }

        });
    }
}
