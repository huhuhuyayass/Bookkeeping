package com.example.jizhangben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class new_cost extends AppCompatActivity {
    private DBHelper helper;
    private EditText et_cost_title;
    private EditText et_cost_money;
    private DatePicker dp_cost_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cost);
        initView();
    }

    public void initView(){
        helper = new DBHelper(new_cost.this);
        et_cost_title = findViewById(R.id.et_cost_title);
        et_cost_money = findViewById(R.id.et_cost_money);
        dp_cost_date = findViewById(R.id.dp_cost_date);
    }

    public void okButton(View view){
        String titleStr = et_cost_title.getText().toString().trim();
        String moneyStr = et_cost_money.getText().toString().trim();
        String dateStr = dp_cost_date.getYear() + "-" + (dp_cost_date.getMonth() + 1) + "-"
                + dp_cost_date.getDayOfMonth();   //这里getMonth会比当前月份少一个月，所以要+1
        if("".equals(moneyStr)){    //可以不填写Title但是不能不能填金额
            Toast toast = Toast.makeText(this,"请填写金额",Toast.LENGTH_SHORT);
            //设置小提示框显示的位置，不设置默认会在底部
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else{
            SQLiteDatabase db = helper.getWritableDatabase();
            //ContentValues与Bundle类似
            ContentValues values = new ContentValues();
            values.put("Title",titleStr);
            values.put("Money",moneyStr);
            values.put("Date",dateStr);
            long account = db.insert("account",null,values);
            if(account > 0){
                Toast toast = Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                db.close();
            }
            setResult(1);
            finish();
        }
    }
}