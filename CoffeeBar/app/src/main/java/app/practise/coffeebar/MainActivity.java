package app.practise.coffeebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int COFFEE_PRICE = 50;
    private final int TOPPING_WC = 15;
    private final int TOPPING_C = 10;

    private int amount;
    private int quantity = 1;

    private Button mButtonIncrement;
    private Button mButtonDecrement;
    private Button mButtonOrder;

    private CheckBox mCheckBoxToppingWC;
    private CheckBox mCheckBoxToppingC;

    private TextView mTextViewOrderSummary;
    private TextView mTextViewQuantity;

    private EditText mEditTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonIncrement = (Button) findViewById(R.id.button_increment);
        mButtonDecrement = (Button) findViewById(R.id.button_decrement);
        mButtonOrder = (Button) findViewById(R.id.button_order);

        mCheckBoxToppingWC = (CheckBox) findViewById(R.id.checkbox_toppingsWC);
        mCheckBoxToppingC = (CheckBox) findViewById(R.id.checkbox_toppingsC);

        mTextViewOrderSummary = (TextView) findViewById(R.id.textView_orderSummary);
        mTextViewQuantity = (TextView) findViewById(R.id.textView_quantity);

        mEditTextName = (EditText) findViewById(R.id.editText_name);

        mTextViewQuantity.setText("" + quantity);
        mTextViewOrderSummary.setText("");
    }

    public void onIncrementClick(View v) {
        if(quantity < 100) {
            quantity++;
            updateQuantityText(quantity);
        }
    }

    public void onDecrementClick(View v) {
        if(quantity > 1) {
            quantity--;
            updateQuantityText(quantity);
        }
    }

    public void onOrderClick(View v) {
        amount = calculateAmount(quantity);
        updateOrderSummaryText(amount);
    }

    private void updateQuantityText(int quantity) {
        mTextViewQuantity.setText("" + quantity);
    }

    private void updateOrderSummaryText(int amount) {
        String summary = "Name: " + mEditTextName.getText().toString() +
                "\nAdd Whipped cream: " + mCheckBoxToppingWC.isChecked() +
                "\nAdd Chocolate: " + mCheckBoxToppingC.isChecked() +
                "\nQuantity: " + quantity +
                "\nTotal amount: Rs. " + amount +
                "\nThank you!!!";

        mTextViewOrderSummary.setText(summary);
    }

    private int calculateAmount(int quantity) {
        int amount = COFFEE_PRICE * quantity;

        if(mCheckBoxToppingWC.isChecked()) {
            amount += TOPPING_WC;
        }
        if(mCheckBoxToppingC.isChecked()) {
            amount += TOPPING_C;
        }

        return amount;
    }
}
